package webapp

import webapp.User

class BootStrap {

    def init = { servletContext ->

    def admin = new User(username: 'admin', enabled: true, password: 'admin')
        admin.email = "cristianbg011@gmail.com"
        admin.nombre = "Cristian"
        //admin.save(flush: true)
    }
    def destroy = {
    }
}
