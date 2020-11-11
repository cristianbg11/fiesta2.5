package webapp
import webapp.Usuario
import grails.validation.ValidationException


class LoginController {

    def index() { 

    }

    def save(Usuario user) {
            try {
                //def role = Role.get(params.role.id)
                println user.password
                render "kk" + params.password

                //redirect(action: 'index', controller: 'application')


            } catch (ValidationException e) {
                flash.message = "Register Failed"
                redirect action: "index"
                return
            }
    }
}
