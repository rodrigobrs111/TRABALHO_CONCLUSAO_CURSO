package dominio

import org.springframework.dao.DataIntegrityViolationException

/**
 * SupervisorDoVarejistaController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class SupervisorDoVarejistaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [supervisorDoVarejistaInstanceList: SupervisorDoVarejista.list(params), supervisorDoVarejistaInstanceTotal: SupervisorDoVarejista.count()]
    }

    def create() {
        [supervisorDoVarejistaInstance: new SupervisorDoVarejista(params)]
    }

    def save() {
        def supervisorDoVarejistaInstance = new SupervisorDoVarejista(params)
        if (!supervisorDoVarejistaInstance.save(flush: true)) {
            render(view: "create", model: [supervisorDoVarejistaInstance: supervisorDoVarejistaInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'supervisorDoVarejista.label', default: 'SupervisorDoVarejista'), supervisorDoVarejistaInstance.id])
        redirect(action: "show", id: supervisorDoVarejistaInstance.id)
    }

    def show() {
        def supervisorDoVarejistaInstance = SupervisorDoVarejista.get(params.id)
        if (!supervisorDoVarejistaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'supervisorDoVarejista.label', default: 'SupervisorDoVarejista'), params.id])
            redirect(action: "list")
            return
        }

        [supervisorDoVarejistaInstance: supervisorDoVarejistaInstance]
    }

    def edit() {
        def supervisorDoVarejistaInstance = SupervisorDoVarejista.get(params.id)
        if (!supervisorDoVarejistaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'supervisorDoVarejista.label', default: 'SupervisorDoVarejista'), params.id])
            redirect(action: "list")
            return
        }

        [supervisorDoVarejistaInstance: supervisorDoVarejistaInstance]
    }

    def update() {
        def supervisorDoVarejistaInstance = SupervisorDoVarejista.get(params.id)
        if (!supervisorDoVarejistaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'supervisorDoVarejista.label', default: 'SupervisorDoVarejista'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (supervisorDoVarejistaInstance.version > version) {
                supervisorDoVarejistaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'supervisorDoVarejista.label', default: 'SupervisorDoVarejista')] as Object[],
                          "Another user has updated this SupervisorDoVarejista while you were editing")
                render(view: "edit", model: [supervisorDoVarejistaInstance: supervisorDoVarejistaInstance])
                return
            }
        }

        supervisorDoVarejistaInstance.properties = params

        if (!supervisorDoVarejistaInstance.save(flush: true)) {
            render(view: "edit", model: [supervisorDoVarejistaInstance: supervisorDoVarejistaInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'supervisorDoVarejista.label', default: 'SupervisorDoVarejista'), supervisorDoVarejistaInstance.id])
        redirect(action: "show", id: supervisorDoVarejistaInstance.id)
    }

    def delete() {
        def supervisorDoVarejistaInstance = SupervisorDoVarejista.get(params.id)
        if (!supervisorDoVarejistaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'supervisorDoVarejista.label', default: 'SupervisorDoVarejista'), params.id])
            redirect(action: "list")
            return
        }

        try {
            supervisorDoVarejistaInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'supervisorDoVarejista.label', default: 'SupervisorDoVarejista'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'supervisorDoVarejista.label', default: 'SupervisorDoVarejista'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
