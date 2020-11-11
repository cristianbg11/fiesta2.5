package webapp

import grails.converters.JSON
//import grails.plugin.springsecurity.annotation.Secured
import grails.plugins.rest.client.RestBuilder
import grails.transaction.Transactional

class ApplicationController {
    static layout = 'layout'

    //@Secured('IS_AUTHENTICATED_ANONYMOUSLY')
    def index() {
        
        //def getBatch(String id) {
            String url = "http://localhost:8765/evento/evento"

            def resp = new RestBuilder().get(url) {
                header 'Authorization', 'Basic base64EncodedUsername&Password'
            }
        List<Evento> eventos= JSON.parse(resp.body.toString());
        //}
        
        //List<Evento> eventos = Evento.findAll()
        ["eventos":eventos]
     }
}
