package dominio

import org.springframework.dao.DataIntegrityViolationException

/**
 * FuncionarioDoVarejistaController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class FuncionarioDoVarejistaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [funcionarioDoVarejistaInstanceList: FuncionarioDoVarejista.list(params), funcionarioDoVarejistaInstanceTotal: FuncionarioDoVarejista.count()]
    }

    def create() {
        [funcionarioDoVarejistaInstance: new FuncionarioDoVarejista(params)]
    }

    def save() {
        def funcionarioDoVarejistaInstance = new FuncionarioDoVarejista(params)
        if (!funcionarioDoVarejistaInstance.save(flush: true)) {
            render(view: "create", model: [funcionarioDoVarejistaInstance: funcionarioDoVarejistaInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'funcionarioDoVarejista.label', default: 'FuncionarioDoVarejista'), funcionarioDoVarejistaInstance.id])
        redirect(action: "show", id: funcionarioDoVarejistaInstance.id)
    }

    def show() {
        def funcionarioDoVarejistaInstance = FuncionarioDoVarejista.get(params.id)
        if (!funcionarioDoVarejistaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'funcionarioDoVarejista.label', default: 'FuncionarioDoVarejista'), params.id])
            redirect(action: "list")
            return
        }

        [funcionarioDoVarejistaInstance: funcionarioDoVarejistaInstance]
    }

    def edit() {
        def funcionarioDoVarejistaInstance = FuncionarioDoVarejista.get(params.id)
        if (!funcionarioDoVarejistaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'funcionarioDoVarejista.label', default: 'FuncionarioDoVarejista'), params.id])
            redirect(action: "list")
            return
        }

        [funcionarioDoVarejistaInstance: funcionarioDoVarejistaInstance]
    }

    def update() {
        def funcionarioDoVarejistaInstance = FuncionarioDoVarejista.get(params.id)
        if (!funcionarioDoVarejistaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'funcionarioDoVarejista.label', default: 'FuncionarioDoVarejista'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (funcionarioDoVarejistaInstance.version > version) {
                funcionarioDoVarejistaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'funcionarioDoVarejista.label', default: 'FuncionarioDoVarejista')] as Object[],
                          "Another user has updated this FuncionarioDoVarejista while you were editing")
                render(view: "edit", model: [funcionarioDoVarejistaInstance: funcionarioDoVarejistaInstance])
                return
            }
        }

        funcionarioDoVarejistaInstance.properties = params

        if (!funcionarioDoVarejistaInstance.save(flush: true)) {
            render(view: "edit", model: [funcionarioDoVarejistaInstance: funcionarioDoVarejistaInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'funcionarioDoVarejista.label', default: 'FuncionarioDoVarejista'), funcionarioDoVarejistaInstance.id])
        redirect(action: "show", id: funcionarioDoVarejistaInstance.id)
    }

    def delete() {
        def funcionarioDoVarejistaInstance = FuncionarioDoVarejista.get(params.id)
        if (!funcionarioDoVarejistaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'funcionarioDoVarejista.label', default: 'FuncionarioDoVarejista'), params.id])
            redirect(action: "list")
            return
        }

        try {
            funcionarioDoVarejistaInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'funcionarioDoVarejista.label', default: 'FuncionarioDoVarejista'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'funcionarioDoVarejista.label', default: 'FuncionarioDoVarejista'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
