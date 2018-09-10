package dominio

import org.springframework.dao.DataIntegrityViolationException

/**
 * DevolucaoController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class DevolucaoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [devolucaoInstanceList: Devolucao.list(params), devolucaoInstanceTotal: Devolucao.count()]
    }

    def create() {
        [devolucaoInstance: new Devolucao(params)]
    }

    def save() {
        def devolucaoInstance = new Devolucao(params)
        if (!devolucaoInstance.save(flush: true)) {
            render(view: "create", model: [devolucaoInstance: devolucaoInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'devolucao.label', default: 'Devolucao'), devolucaoInstance.id])
        redirect(action: "show", id: devolucaoInstance.id)
    }

    def show() {
        def devolucaoInstance = Devolucao.get(params.id)
        if (!devolucaoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'devolucao.label', default: 'Devolucao'), params.id])
            redirect(action: "list")
            return
        }

        [devolucaoInstance: devolucaoInstance]
    }

    def edit() {
        def devolucaoInstance = Devolucao.get(params.id)
        if (!devolucaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'devolucao.label', default: 'Devolucao'), params.id])
            redirect(action: "list")
            return
        }

        [devolucaoInstance: devolucaoInstance]
    }

    def update() {
        def devolucaoInstance = Devolucao.get(params.id)
        if (!devolucaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'devolucao.label', default: 'Devolucao'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (devolucaoInstance.version > version) {
                devolucaoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'devolucao.label', default: 'Devolucao')] as Object[],
                          "Another user has updated this Devolucao while you were editing")
                render(view: "edit", model: [devolucaoInstance: devolucaoInstance])
                return
            }
        }

        devolucaoInstance.properties = params

        if (!devolucaoInstance.save(flush: true)) {
            render(view: "edit", model: [devolucaoInstance: devolucaoInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'devolucao.label', default: 'Devolucao'), devolucaoInstance.id])
        redirect(action: "show", id: devolucaoInstance.id)
    }

    def delete() {
        def devolucaoInstance = Devolucao.get(params.id)
        if (!devolucaoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'devolucao.label', default: 'Devolucao'), params.id])
            redirect(action: "list")
            return
        }

        try {
            devolucaoInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'devolucao.label', default: 'Devolucao'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'devolucao.label', default: 'Devolucao'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
