package webapp

import grails.plugins.rest.client.RestBuilder


class EstadisticaController {
    static layout = 'layout'
    def index() {
        String url = "http://localhost:8765/evento/api/evento/estadistica"

        def resp = new RestBuilder().get(url) {
            header 'content-type', 'application/json'
            header 'Authorization', 'Bearer '+session["infoUsuario"].access_token
        }
println resp.json
        def pendientes=0
        def pagados=0
        def finalizado=0
        List<Object> pedidos= resp.json
       // println pedidos
        
        pedidos.each {
            if(it.estado=='Pendiente')
                pendientes++;
            if(it.estado =='Pagado')
                pagados++
            if(it.estado =='Finalizado')
                finalizado++
        }

        
        System.out.println(pedidos)
        ["pendientes": pendientes, "realizadas": finalizado, "Compras": pagados]
        //["eventos": eventos]
    }
}
