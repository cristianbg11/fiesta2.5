package webapp

import grails.plugins.rest.client.RestBuilder

class EstadisticaController {
    static layout = 'layout'
    def index() {
        String url = "http://localhost:8765/evento/evento/estadistica"

        def resp = new RestBuilder().get(url) {
            header 'content-type', 'application/json'
        }
println resp.json
        def pendientes=0
        def pagados=0
        List<Object> pedidos= resp.json
       // println pedidos
        
        pedidos.each {
            if(it.estado=='Pendiente')
                pendientes++;
            if(it.estado =='Pagado')
                pagados++
        }

        
        System.out.println(pedidos)
        ["pendientes": pendientes, "realizadas": pagados]
        //["eventos": eventos]
    }
}
