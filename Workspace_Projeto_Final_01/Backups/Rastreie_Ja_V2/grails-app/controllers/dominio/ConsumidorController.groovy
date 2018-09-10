package dominio

import org.springframework.dao.DataIntegrityViolationException

/**
 * ConsumidorController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class ConsumidorController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [consumidorInstanceList: Consumidor.list(params), consumidorInstanceTotal: Consumidor.count()]
    }

    def create() {
        [consumidorInstance: new Consumidor(params)]
    }

    def save() {
        def consumidorInstance = new Consumidor(params)
        if (!consumidorInstance.save(flush: true)) {
            render(view: "create", model: [consumidorInstance: consumidorInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'consumidor.label', default: 'Consumidor'), consumidorInstance.id])
        redirect(action: "show", id: consumidorInstance.id)
    }

    def show() {
        def consumidorInstance = Consumidor.get(params.id)
        if (!consumidorInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'consumidor.label', default: 'Consumidor'), params.id])
            redirect(action: "list")
            return
        }

        [consumidorInstance: consumidorInstance]
    }

    def edit() {
        def consumidorInstance = Consumidor.get(params.id)
        if (!consumidorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'consumidor.label', default: 'Consumidor'), params.id])
            redirect(action: "list")
            return
        }

        [consumidorInstance: consumidorInstance]
    }

    def update() {
        def consumidorInstance = Consumidor.get(params.id)
        if (!consumidorInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'consumidor.label', default: 'Consumidor'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (consumidorInstance.version > version) {
                consumidorInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'consumidor.label', default: 'Consumidor')] as Object[],
                          "Another user has updated this Consumidor while you were editing")
                render(view: "edit", model: [consumidorInstance: consumidorInstance])
                return
            }
        }

        consumidorInstance.properties = params

        if (!consumidorInstance.save(flush: true)) {
            render(view: "edit", model: [consumidorInstance: consumidorInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'consumidor.label', default: 'Consumidor'), consumidorInstance.id])
        redirect(action: "show", id: consumidorInstance.id)
    }

    def delete() {
        def consumidorInstance = Consumidor.get(params.id)
        if (!consumidorInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'consumidor.label', default: 'Consumidor'), params.id])
            redirect(action: "list")
            return
        }

        try {
            consumidorInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'consumidor.label', default: 'Consumidor'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'consumidor.label', default: 'Consumidor'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
