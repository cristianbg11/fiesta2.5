package evento

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class AsignacionController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Asignacion.list(params), model: [asignacionCount: Asignacion.count()]
    }

    def show(Asignacion asignacion) {
        respond asignacion
    }

    @Transactional
    def save(Asignacion asignacion) {
        if (asignacion == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (asignacion.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond asignacion.errors, view: 'create'
            return
        }

        asignacion.save flush: true

        respond asignacion, [status: CREATED, view: "show"]
    }

    @Transactional
    def update(Asignacion asignacion) {
        if (asignacion == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (asignacion.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond asignacion.errors, view: 'edit'
            return
        }

        asignacion.save flush: true

        respond asignacion, [status: OK, view: "show"]
    }

    @Transactional
    def delete(Asignacion asignacion) {

        if (asignacion == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        asignacion.delete flush: true

        render status: NO_CONTENT
    }
}
