package usuarios

import com.usuarios.Role
import com.usuarios.User
import com.usuarios.UserRole
import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def clienteRole = new Role(authority: 'ROLE_CLIENTE').save(flush: true)
        def empleladoRole = new Role(authority: 'ROLE_EMPLEADO').save(flush: true)

        def admin = new User(username: 'admin', enabled: true, password: 'admin')
        admin.email = "cristianbg011@gmail.com"
        admin.nombre = "Cristian"
        admin.save(flush: true)

        def usuarioRol = new UserRole()
        usuarioRol.user = admin
        usuarioRol.role =adminRole
        usuarioRol.save(flush: true)

        def cliente = new User(username: 'cliente', enabled: true, password: 'cliente')
        cliente.email = "cristianbg011@gmail.com"
        cliente.nombre = "Cristian"
        cliente.save(flush: true)

        def clienteRol = new UserRole()
        clienteRol.user = cliente
        clienteRol.role =clienteRole
        clienteRol.save(flush: true)

        def empleado = new User(username: 'empleado', enabled: true, password: 'empleado')
        empleado.email = "afomillow@gmail.com"
        empleado.nombre = "empleado1"
        empleado.save(flush: true)

        def empleadoRol = new UserRole()
        empleadoRol.user = empleado
        empleadoRol.role = empleladoRole
        empleadoRol.save(flush: true)

        JSON.registerObjectMarshaller(User){
            def arrayJson = [:]
            arrayJson['id'] = it.id
            arrayJson['nombre'] = it.nombre
            arrayJson['email'] = it.email
            arrayJson['username'] = it.username
            arrayJson['rol'] = it.authorities.first().authority
            return arrayJson
        }
    }
    def destroy = {

    }
}
