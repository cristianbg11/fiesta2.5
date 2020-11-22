package webapp

import grails.plugins.rest.client.RestBuilder

class UsuarioController {
    static layout = 'layout'
    def index() {
        if(session["infoUsuario"]!=null)
        {
            if(session["infoUsuario"].rol == "ROLE_ADMIN")
            {
                def resp = new RestBuilder().get("http://localhost:9002/api/usuario"){
                    header 'content-type', 'application/json'
                    header 'Authorization', 'Bearer '+session["infoUsuario"].access_token
                }
                def usuarios = resp.json
                [usuarios: usuarios]
            }
        }
        else
            redirect controller: 'login'
    }
    def editar()
    {
        if(session["infoUsuario"]!=null)
        {
            if(session["infoUsuario"].rol == "ROLE_ADMIN")
            {
                def resp = new RestBuilder().get("http://localhost:9002/api/usuario/"+params.id){
                    header 'content-type', 'application/json'
                    header 'Authorization', 'Bearer '+session["infoUsuario"].access_token
                }
                def usuario = resp.json
                [usuario: usuario]
            }
        }
        else
            redirect controller: 'login'
    }
}
