package evento

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.plugins.rest.client.RestBuilder
import net.sf.jasperreports.engine.*
import net.sf.jasperreports.engine.export.JRPdfExporter
import org.apache.commons.io.FileUtils
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import java.time.LocalDate

class ServicioController {
    static responseFormats = ['json', 'xml']
    def reportService
    def dataSource
    def mailService

    def index() {

    }
    //@Secured("ROLE_CLIENTE")
    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def mispedidos() {
        //List<Pedido> pedidos = Pedido.findAllByUsuario(springSecurityService.currentUser as User)
        //User usuario = springSecurityService.currentUser as User
        //def pedidos = Pedido.findAll()
        //def evento = Evento.findAll()
        //["listpedidos":pedidos]
        List<Pedido> pedidos = Pedido.findAllByIduser(params.id.toLong())
        render pedidos as JSON
    }
    //@Secured("ROLE_CLIENTE")
    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def payment() {
        def evento = Evento.get(params.idEvento);
        def monto = evento.costo;

        def pedido = new Pedido();
        pedido.monto = monto;
        pedido.fecha = new Date();
        pedido.evento = evento;
        pedido.estado = "Pendiente";
        pedido.iduser = params.idUsuario.toLong()
        //pedido.usuario=springSecurityService.currentUser as User
        pedido.save();
        System.out.println(pedido.estado)

        render pedido as JSON

    }
    //@Secured("ROLE_CLIENTE")
    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def checkout() {
        def evento = Evento.get(params.id);
        //def monto=evento.costo;

        respond evento
    }
    //@Secured("ROLE_CLIENTE")
    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def crearfactura() {
        def pedido = Pedido.get(params.id.toLong());
        def cliente = params.nombre
        def email = params.email
        //crea factura
        def factura = new Factura();
        factura.monto = pedido.evento.costo;
        factura.pedido = pedido;
        factura.estado = 0;
        pedido.estado = "Pagado"
        factura.save();
        pedido.save();

        ByteArrayOutputStream pdfStream = new ByteArrayOutputStream()
        try {
            String reportName, jrxmlFileName, dotJasperFileName
            jrxmlFileName = "as_sala_mu_alai_kum"
            reportName = grailsApplication.mainContext.getResource('reports/' + jrxmlFileName + '.jrxml').file.getAbsoluteFile()
            dotJasperFileName = grailsApplication.mainContext.getResource('reports/' + jrxmlFileName + '.jasper').file.getAbsoluteFile()

            // Report parameter
            Map<String, String> reportParam = new HashMap<String, String>()
            reportParam.put("detailsData", "Evento: "+pedido.evento.nombre+ "\n\n monto: "+pedido.evento.costo.toString()+" \n\n Cliente: "+cliente +" \n\n\n Fecha: "+pedido.fecha.toString())
            /*
            reportParam.put("monto", pedido.evento.costo.toString())
            reportParam.put("evento", pedido.evento.nombre)
            reportParam.put("cliente", params.nombre)
            reportParam.put("fecha", pedido.fecha.toString())
            */
            // compiles jrxml
            JasperCompileManager.compileReportToFile(reportName);
            // fills compiled report with parameters and a connection
            JasperPrint print = JasperFillManager.fillReport(dotJasperFileName, reportParam, dataSource.getConnection());


            // exports report to pdf
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, pdfStream); // your output goes here

            exporter.exportReport();
            //println 'pdfStream = '+pdfStream.size()

        } catch (Exception e) {

            throw new RuntimeException("It's not possible to generate the pdf report.", e);
        } finally {
            File Ruta = new File("Clientes/${params.nombre}/${params.id}");
            Ruta.mkdirs();
            File archivo = new File("Clientes/${params.nombre}/${params.id}/${pedido.evento.nombre}.pdf")
            if(archivo.exists()) archivo.delete();
            def bytesPdf = pdfStream.toByteArray()
            FileUtils.writeByteArrayToFile(
                    archivo,
                    bytesPdf
            )
            //post a notificacion de servicio
            /*
            MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>()
            form.add("mensaje", "Pedido Nuevo Pagado")
            form.add("id", pedido.id+"")
            form.add("correo", params.email)
            */
            mailService.sendMail {
                multipart true
                to params.email
                subject "Pedido Nuevo Pagado"
                body ("Su pedido ha sido satisfactoriamente pagado")
                attachBytes "Recibo"+pedido.id+".pdf","application/pdf",pdfStream.toByteArray()
            }
            render "Ok"
            //render(file: pdfStream.toByteArray(), contentType: 'application/pdf')
            //render(file: pdfStream.toByteArray(), fileName: 'DownloadReport.pdf', contentType: 'application/pdf')
        }
        //reportService.testReport(false, "Boda", "5000", "Cristian")

    }
    //@Secured("ROLE_EMPLEADO")
    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def pedidosempleado (){
        List<Pedido> pedidos = Pedido.findAll()
        render pedidos as JSON
    }
    //@Secured("ROLE_EMPLEADO")
    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def asignar (){

        def pedido = Pedido.get(params.idPedido.toLong())
        pedido.iduser = params.idUsuario.toLong()
        pedido.estado = "Finalizado"

        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>()
        form.add("mensaje", "Pedido Procesado")
        form.add("id", pedido.id+"")
        form.add("correo", params.email)

        def resp = new RestBuilder().post("http://localhost:8765/notificacion/notificacion"){

            contentType("application/x-www-form-urlencoded")
            body(form)
        }
        pedido.save();
        System.out.println(pedido.estado)
        List<Pedido> pedidos = Pedido.findAll()
        render pedidos as JSON
    }
    //@Secured("ROLE_ADMIN")
    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def pedidoshoy(){
        //List<Pedido> pedidoshoy = Pedido.findAllByFechaBetween(LocalDate.toDateTimeAtStartOfDay(), LocalDate.plusDays(1).toDateTimeAtStartOfDay())
        List<Pedido> pedidoshoy = Pedido.findAll()
        render pedidoshoy as JSON
    }
}
