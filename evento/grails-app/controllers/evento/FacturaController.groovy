package evento

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class FacturaController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Factura.list(params), model: [facturaCount: Factura.count()]
    }

    def show(Factura factura) {
        respond factura
    }

    @Transactional
    def save(Factura factura) {
        if (factura == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (factura.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond factura.errors, view: 'create'
            return
        }

        factura.save flush: true

        respond factura, [status: CREATED, view: "show"]
    }

    @Transactional
    def update(Factura factura) {
        if (factura == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (factura.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond factura.errors, view: 'edit'
            return
        }

        factura.save flush: true

        respond factura, [status: OK, view: "show"]
    }

    @Transactional
    def delete(Factura factura) {

        if (factura == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        factura.delete flush: true

        render status: NO_CONTENT
    }
}
