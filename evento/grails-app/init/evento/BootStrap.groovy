package evento

import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->
        def evento = new Evento()
        evento.nombre = "Pre-Boda"
        evento.costo = 1000
        evento.imagen = "https://vamonosdebodorrio.com/wp-content/uploads/2019/04/PREBODA-EN-GRANADA-20.jpg"
        evento.save(flush: true)

        evento = new Evento()
        evento.nombre = "Boda"
        evento.costo = 5000
        evento.imagen = "https://asset4.zankyou.com/images/mag-card-c/0ea/1ad2/878/623/-/es/wp-content/uploads/2019/03/1579693063.jpg"
        evento.save(flush: true)

        evento = new Evento()
        evento.nombre = "Cumpleanos"
        evento.costo = 3000
        evento.imagen = "https://ep01.epimg.net/verne/imagenes/2019/01/19/articulo/1547919673_116880_1548081888_noticia_normal.jpg"
        evento.save(flush: true)

        evento = new Evento()
        evento.nombre = "Video Evento"
        evento.costo = 4000
        evento.imagen = "https://www.marketeroslatam.com/wp-content/uploads/2017/09/live-stream-evento.jpg"
        evento.save(flush: true)

        JSON.registerObjectMarshaller(Evento)
                {
                    def returnArray = [:]
                    returnArray['id'] = it.id
                    returnArray['nombre'] = it.nombre
                    returnArray['costo'] = it.costo
                    returnArray['imagen'] = it.imagen
                    return returnArray
                }

        JSON.registerObjectMarshaller(Pedido)
                {
                    def returnArray = [:]
                    returnArray['id'] = it.id
                    returnArray['fecha'] = it.fecha
                    returnArray['monto'] = it.monto
                    returnArray['evento'] = it.evento
                    returnArray['estado'] = it.estado
                    returnArray['iduser'] = it.iduser
                    return returnArray
                }
    }
    def destroy = {
    }
}
