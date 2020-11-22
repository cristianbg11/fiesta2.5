package webapp

import grails.converters.JSON
import grails.plugins.rest.client.RestBuilder
import org.apache.tomcat.util.http.parser.AcceptLanguage
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import webapp.InfoUsuario

class EventoController {
    static layout = 'layout'
    def index() {
        String url = "http://localhost:8765/evento/evento"

        def resp = new RestBuilder().get(url) {
            header 'content-type', 'application/json'
        }


        List<Object> eventos= resp.json
        ["eventos": eventos]
    }
    def mispedidos(){
        if(session["infoUsuario"]!=null) {
            String url = "http://localhost:8765/evento/evento/mispedidos/" + session["infoUsuario"].id

            def resp = new RestBuilder().get(url) {
                header 'content-type', 'application/json'
            }
            def pedidos = resp.json
            def total = pedidos.monto.sum();
            [listpedidos: pedidos, total: total]
        }
        else
            redirect controller: 'login'
    }
    def checkout()
    {
        if(session["infoUsuario"]!=null) {
            String url = "http://localhost:8765/evento/evento/checkout/" + params.id

            def resp = new RestBuilder().get(url) {
                header 'content-type', 'application/json'
            }
            def evento = resp.json
            [evento: evento]
        }
        else
            redirect controller: 'login'
    }
    def payment()
    {
        if(session["infoUsuario"]!=null) {
            String url = "http://localhost:8765/evento/evento/payment"
            RestBuilder rest = new RestBuilder()
            MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>()
            form.add("idEvento", params.id)
            form.add("idUsuario", session["infoUsuario"].id.toString())
            def resp = rest.post(url) {
                accept("application/json")
                contentType("application/x-www-form-urlencoded")
                body(form)
            }
            def pedido = resp.json
            println pedido
            [pedido: pedido]
        }
        else
            redirect controller: 'login'
    }
    def paypal(){
        if(session["infoUsuario"]!=null) {
            String url = "http://localhost:8765/evento/evento/crearfactura"
            RestBuilder rest = new RestBuilder()
            MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>()
            form.add("id", params.id)
            form.add("nombre", session["infoUsuario"].nombre)
            form.add("email", session["infoUsuario"].email)
            def resp = rest.post(url) {
                accept("application/json")
                contentType("application/x-www-form-urlencoded")
                body(form)
            }
        }
        else
            redirect controller: 'login'
    }
    def pedidosempleado(){

        if(session["infoUsuario"]!=null) {
            String url = "http://localhost:8765/evento/evento/pedidosempleado"

            def resp = new RestBuilder().get(url) {
                header 'content-type', 'application/json'
            }
            def pedidos = resp.json
            [pedidosempleado: pedidos]
        }
        else
            redirect controller: 'login'
    }
    def asignar(){
        if(session["infoUsuario"]!=null) {
            def idPedido = params.id.toString().split("f")[0]
            def iduser = params.id.toString().split("f")[1]
            def respUsuario = new RestBuilder().get("http://localhost:9002/api/usuario/"+iduser){
                header 'content-type', 'application/json'
                header 'Authorization', 'Bearer '+session["infoUsuario"].access_token
            }
            def cliente = respUsuario.json;
            String url = "http://localhost:8765/evento/evento/asignar"
            RestBuilder rest = new RestBuilder()
            MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>()
            form.add("idPedido", idPedido)
            form.add("idUsuario", session["infoUsuario"].id.toString())
            form.add("email", cliente.email)
            def resp = rest.post(url) {
                accept("application/json")
                contentType("application/x-www-form-urlencoded")
                body(form)
            }
            def pedidos = resp.json

            redirect action: 'pedidosempleado', pedidosempleado:  pedidos
        }
        else
            redirect controller: 'login'
    }
}
