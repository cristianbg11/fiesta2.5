package evento

import grails.converters.JSON

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

@Transactional(readOnly = true)
class EventoController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    def index() {
        render Evento.findAll() as JSON
    }

    def show(Evento evento) {
        respond evento
    }

    @Transactional
    def save(Evento evento) {
        if (evento == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (evento.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond evento.errors, view: 'create'
            return
        }

        evento.save flush: true

        respond evento, [status: CREATED, view: "show"]
    }

    @Transactional
    def update(Evento evento) {
        if (evento == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (evento.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond evento.errors, view: 'edit'
            return
        }

        evento.save flush: true

        respond evento, [status: OK, view: "show"]
    }

    @Transactional
    def delete(Evento evento) {

        if (evento == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        evento.delete flush: true

        render status: NO_CONTENT
    }
}
