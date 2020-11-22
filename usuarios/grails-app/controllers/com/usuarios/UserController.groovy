package usuarios

import com.usuarios.Role
import com.usuarios.User
import com.usuarios.UserRole
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

class UserController {

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def registrar(User user)
    {
        def cliente = new User(username: user.username, enabled: true, password: user.password)
        cliente.email = user.email
        cliente.nombre = user.nombre
        cliente.save(flush: true)

        def clienteRole = new UserRole()
        clienteRole.user = cliente
        clienteRole.role = Role.get(2);
        clienteRole.save(flush: true)
    }
    @Secured(["ROLE_ADMIN", "ROLE_EMPLEADO"])
    def usuarios()
    {
        if(params.id == null)
            render User.findAll() as JSON
        else
            render User.findById(params.id.toLong()) as JSON;
    }
}
