package dominio

import org.springframework.dao.DataIntegrityViolationException

/**
 * FuncionarioDaTransportadoraController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class FuncionarioDaTransportadoraController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [funcionarioDaTransportadoraInstanceList: FuncionarioDaTransportadora.list(params), funcionarioDaTransportadoraInstanceTotal: FuncionarioDaTransportadora.count()]
    }

    def create() {
        [funcionarioDaTransportadoraInstance: new FuncionarioDaTransportadora(params)]
    }

    def save() {
        def funcionarioDaTransportadoraInstance = new FuncionarioDaTransportadora(params)
        if (!funcionarioDaTransportadoraInstance.save(flush: true)) {
            render(view: "create", model: [funcionarioDaTransportadoraInstance: funcionarioDaTransportadoraInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'funcionarioDaTransportadora.label', default: 'FuncionarioDaTransportadora'), funcionarioDaTransportadoraInstance.id])
        redirect(action: "show", id: funcionarioDaTransportadoraInstance.id)
    }

    def show() {
        def funcionarioDaTransportadoraInstance = FuncionarioDaTransportadora.get(params.id)
        if (!funcionarioDaTransportadoraInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'funcionarioDaTransportadora.label', default: 'FuncionarioDaTransportadora'), params.id])
            redirect(action: "list")
            return
        }

        [funcionarioDaTransportadoraInstance: funcionarioDaTransportadoraInstance]
    }

    def edit() {
        def funcionarioDaTransportadoraInstance = FuncionarioDaTransportadora.get(params.id)
        if (!funcionarioDaTransportadoraInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'funcionarioDaTransportadora.label', default: 'FuncionarioDaTransportadora'), params.id])
            redirect(action: "list")
            return
        }

        [funcionarioDaTransportadoraInstance: funcionarioDaTransportadoraInstance]
    }

    def update() {
        def funcionarioDaTransportadoraInstance = FuncionarioDaTransportadora.get(params.id)
        if (!funcionarioDaTransportadoraInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'funcionarioDaTransportadora.label', default: 'FuncionarioDaTransportadora'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (funcionarioDaTransportadoraInstance.version > version) {
                funcionarioDaTransportadoraInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'funcionarioDaTransportadora.label', default: 'FuncionarioDaTransportadora')] as Object[],
                          "Another user has updated this FuncionarioDaTransportadora while you were editing")
                render(view: "edit", model: [funcionarioDaTransportadoraInstance: funcionarioDaTransportadoraInstance])
                return
            }
        }

        funcionarioDaTransportadoraInstance.properties = params

        if (!funcionarioDaTransportadoraInstance.save(flush: true)) {
            render(view: "edit", model: [funcionarioDaTransportadoraInstance: funcionarioDaTransportadoraInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'funcionarioDaTransportadora.label', default: 'FuncionarioDaTransportadora'), funcionarioDaTransportadoraInstance.id])
        redirect(action: "show", id: funcionarioDaTransportadoraInstance.id)
    }

    def delete() {
        def funcionarioDaTransportadoraInstance = FuncionarioDaTransportadora.get(params.id)
        if (!funcionarioDaTransportadoraInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'funcionarioDaTransportadora.label', default: 'FuncionarioDaTransportadora'), params.id])
            redirect(action: "list")
            return
        }

        try {
            funcionarioDaTransportadoraInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'funcionarioDaTransportadora.label', default: 'FuncionarioDaTransportadora'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'funcionarioDaTransportadora.label', default: 'FuncionarioDaTransportadora'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
