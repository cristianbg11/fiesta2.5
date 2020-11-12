package webapp

import grails.plugins.rest.client.RestBuilder
import webapp.Usuario
import grails.validation.ValidationException


class LoginController {

    def index() { 

    }

    def save(Usuario user) {
            try {
                def resp = new RestBuilder().post("http://localhost:8082/user/api/login"){
                    //auth System.getProperty("artifactory.user"), System.getProperty("artifactory.pass")
                    contentType "application/json"
                    json {
                        username = user.username
                        password = user.password
                    }
                    //contentType("application/x-www-form-urlencoded")
                    //body(form)
                }
                render resp.json


            } catch (ValidationException e) {
                flash.message = "Register Failed"
                redirect action: "index"
                return
            }
    }
}
