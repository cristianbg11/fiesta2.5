package webapp


import grails.plugins.rest.client.RestBuilder
import grails.validation.ValidationException
import webapp.InfoUsuario

class LoginController {
    static layout = 'layout'
    def index() { 

    }

    def auth() {
        String usuario = params.username
        String clave = params.password
            try {
                def resp = new RestBuilder().post("http://localhost:8765/usuarios/api/login"){
                    //auth System.getProperty("artifactory.user"), System.getProperty("artifactory.pass")
                    contentType "application/json"
                    json {
                        username = usuario
                        password = clave
                    }
                    //contentType("application/x-www-form-urlencoded")
                    //body(form)
                }
                if(resp.status == 200)
                {
                    InfoUsuario infoUsuario = new InfoUsuario();
                    infoUsuario = resp.json;
                    session["infoUsuario"] = infoUsuario;
                    redirect(controller: 'evento', action: 'index');
                }
                else
                {
                    flash.error = "Usuario y/o contraseña incorrecta";
                    redirect action: 'index'
                }

            } catch (ValidationException e) {
                flash.message = "Login Failed"
                redirect action: "index"
                return
            }
    }
    def registro(){

    }
    def registrar(){
        def usuario = params.usuario
        def nombreU = params.nombre
        def contrasena = params.contrasena
        def emailU = params.email
        def resp = new RestBuilder().post("http://localhost:9002/registrar"){
            contentType "application/json"
            json {
                username = usuario
                nombre = nombreU
                password = contrasena
                email = emailU
            }
        }
        if(resp.status == 200)
        {
            redirect action: 'index'
        }
        else
        {
            flash.error = "Registro fallido";
            redirect action: 'registrar'
        }
    }
    def logout(){
        session.invalidate();
        redirect controller: 'evento', action: 'index'
    }
}
