package evento

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PedidoController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Pedido.list(params), model: [pedidoCount: Pedido.count()]
    }

    def show(Pedido pedido) {
        respond pedido
    }

    @Transactional
    def save(Pedido pedido) {
        if (pedido == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (pedido.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pedido.errors, view: 'create'
            return
        }

        pedido.save flush: true

        respond pedido, [status: CREATED, view: "show"]
    }

    @Transactional
    def update(Pedido pedido) {
        if (pedido == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (pedido.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond pedido.errors, view: 'edit'
            return
        }

        pedido.save flush: true

        respond pedido, [status: OK, view: "show"]
    }

    @Transactional
    def delete(Pedido pedido) {

        if (pedido == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        pedido.delete flush: true

        render status: NO_CONTENT
    }
}
