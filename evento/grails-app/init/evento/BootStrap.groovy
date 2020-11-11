package evento

class BootStrap {

    def init = { servletContext ->
    def evento = new Evento()
        evento.nombre = "Pre-Boda"
        evento.costo = 1000
        evento.save(flush: true)

        evento = new Evento()
        evento.nombre = "Boda"
        evento.costo = 5000
        evento.save(flush: true)

        evento = new Evento()
        evento.nombre = "Cumpleanos"
        evento.costo = 3000
        evento.save(flush: true)

        evento = new Evento()
        evento.nombre = "Video Evento"
        evento.costo = 4000
        evento.save(flush: true)
    }
    def destroy = {
    }
}
