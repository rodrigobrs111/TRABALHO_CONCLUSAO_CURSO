package dominio

import org.springframework.dao.DataIntegrityViolationException

/**
 * EntregaController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class EntregaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [entregaInstanceList: Entrega.list(params), entregaInstanceTotal: Entrega.count()]
    }

    def create() {
        [entregaInstance: new Entrega(params)]
    }

    def save() {
        def entregaInstance = new Entrega(params)
        if (!entregaInstance.save(flush: true)) {
            render(view: "create", model: [entregaInstance: entregaInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'entrega.label', default: 'Entrega'), entregaInstance.id])
        redirect(action: "show", id: entregaInstance.id)
    }

    def show() {
        def entregaInstance = Entrega.get(params.id)
        if (!entregaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'entrega.label', default: 'Entrega'), params.id])
            redirect(action: "list")
            return
        }

        [entregaInstance: entregaInstance]
    }

    def edit() {
        def entregaInstance = Entrega.get(params.id)
        if (!entregaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'entrega.label', default: 'Entrega'), params.id])
            redirect(action: "list")
            return
        }

        [entregaInstance: entregaInstance]
    }

    def update() {
        def entregaInstance = Entrega.get(params.id)
        if (!entregaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'entrega.label', default: 'Entrega'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (entregaInstance.version > version) {
                entregaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'entrega.label', default: 'Entrega')] as Object[],
                          "Another user has updated this Entrega while you were editing")
                render(view: "edit", model: [entregaInstance: entregaInstance])
                return
            }
        }

        entregaInstance.properties = params

        if (!entregaInstance.save(flush: true)) {
            render(view: "edit", model: [entregaInstance: entregaInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'entrega.label', default: 'Entrega'), entregaInstance.id])
        redirect(action: "show", id: entregaInstance.id)
    }

    def delete() {
        def entregaInstance = Entrega.get(params.id)
        if (!entregaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'entrega.label', default: 'Entrega'), params.id])
            redirect(action: "list")
            return
        }

        try {
            entregaInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'entrega.label', default: 'Entrega'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'entrega.label', default: 'Entrega'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
