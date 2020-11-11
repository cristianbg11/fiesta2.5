package usuarios

import com.Usuarios.Book
import com.Usuarios.Role
import com.Usuarios.User
import com.Usuarios.UserRole

class BootStrap {

    def init = { servletContext ->
        Book.withTransaction {
            Book book = new Book(name: "Grails in action", isbn: "12345", price: 30.00).save(failOnError:true)
        }
        Role role = new Role(authority: "ROLE_USER").save(failOnError:true)
        User user = new User(username: "me", password: "password").save(failOnError:true)
        UserRole.create(user, role)
    }
    def destroy = {
    }
}
