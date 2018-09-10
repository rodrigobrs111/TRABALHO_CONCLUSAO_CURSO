package dominio

import org.springframework.dao.DataIntegrityViolationException

/**
 * SugestaoController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class SugestaoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [sugestaoInstanceList: Sugestao.list(params), sugestaoInstanceTotal: Sugestao.count()]
    }

    def create() {
        [sugestaoInstance: new Sugestao(params)]
    }

    def save() {
        def sugestaoInstance = new Sugestao(params)
        if (!sugestaoInstance.save(flush: true)) {
            render(view: "create", model: [sugestaoInstance: sugestaoInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'sugestao.label', default: 'Sugestao'), sugestaoInstance.id])
        redirect(action: "show", id: sugestaoInstance.id)
    }

    def show() {
        def sugestaoInstance = Sugestao.get(params.id)
        if (!sugestaoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'sugestao.label', default: 'Sugestao'), params.id])
            redirect(action: "list")
            return
        }

        [sugestaoInstance: sugestaoInstance]
    }

    def edit() {
        def sugestaoInstance = Sugestao.get(params.id)
        if (!sugestaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'sugestao.label', default: 'Sugestao'), params.id])
            redirect(action: "list")
            return
        }

        [sugestaoInstance: sugestaoInstance]
    }

    def update() {
        def sugestaoInstance = Sugestao.get(params.id)
        if (!sugestaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'sugestao.label', default: 'Sugestao'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (sugestaoInstance.version > version) {
                sugestaoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'sugestao.label', default: 'Sugestao')] as Object[],
                          "Another user has updated this Sugestao while you were editing")
                render(view: "edit", model: [sugestaoInstance: sugestaoInstance])
                return
            }
        }

        sugestaoInstance.properties = params

        if (!sugestaoInstance.save(flush: true)) {
            render(view: "edit", model: [sugestaoInstance: sugestaoInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'sugestao.label', default: 'Sugestao'), sugestaoInstance.id])
        redirect(action: "show", id: sugestaoInstance.id)
    }

    def delete() {
        def sugestaoInstance = Sugestao.get(params.id)
        if (!sugestaoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'sugestao.label', default: 'Sugestao'), params.id])
            redirect(action: "list")
            return
        }

        try {
            sugestaoInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'sugestao.label', default: 'Sugestao'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'sugestao.label', default: 'Sugestao'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
