package dominio

import org.springframework.dao.DataIntegrityViolationException

/**
 * GerenteDoVarejistaController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class GerenteDoVarejistaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [gerenteDoVarejistaInstanceList: GerenteDoVarejista.list(params), gerenteDoVarejistaInstanceTotal: GerenteDoVarejista.count()]
    }

    def create() {
        [gerenteDoVarejistaInstance: new GerenteDoVarejista(params)]
    }

    def save() {
        def gerenteDoVarejistaInstance = new GerenteDoVarejista(params)
        if (!gerenteDoVarejistaInstance.save(flush: true)) {
            render(view: "create", model: [gerenteDoVarejistaInstance: gerenteDoVarejistaInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'gerenteDoVarejista.label', default: 'GerenteDoVarejista'), gerenteDoVarejistaInstance.id])
        redirect(action: "show", id: gerenteDoVarejistaInstance.id)
    }

    def show() {
        def gerenteDoVarejistaInstance = GerenteDoVarejista.get(params.id)
        if (!gerenteDoVarejistaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'gerenteDoVarejista.label', default: 'GerenteDoVarejista'), params.id])
            redirect(action: "list")
            return
        }

        [gerenteDoVarejistaInstance: gerenteDoVarejistaInstance]
    }

    def edit() {
        def gerenteDoVarejistaInstance = GerenteDoVarejista.get(params.id)
        if (!gerenteDoVarejistaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'gerenteDoVarejista.label', default: 'GerenteDoVarejista'), params.id])
            redirect(action: "list")
            return
        }

        [gerenteDoVarejistaInstance: gerenteDoVarejistaInstance]
    }

    def update() {
        def gerenteDoVarejistaInstance = GerenteDoVarejista.get(params.id)
        if (!gerenteDoVarejistaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'gerenteDoVarejista.label', default: 'GerenteDoVarejista'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (gerenteDoVarejistaInstance.version > version) {
                gerenteDoVarejistaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'gerenteDoVarejista.label', default: 'GerenteDoVarejista')] as Object[],
                          "Another user has updated this GerenteDoVarejista while you were editing")
                render(view: "edit", model: [gerenteDoVarejistaInstance: gerenteDoVarejistaInstance])
                return
            }
        }

        gerenteDoVarejistaInstance.properties = params

        if (!gerenteDoVarejistaInstance.save(flush: true)) {
            render(view: "edit", model: [gerenteDoVarejistaInstance: gerenteDoVarejistaInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'gerenteDoVarejista.label', default: 'GerenteDoVarejista'), gerenteDoVarejistaInstance.id])
        redirect(action: "show", id: gerenteDoVarejistaInstance.id)
    }

    def delete() {
        def gerenteDoVarejistaInstance = GerenteDoVarejista.get(params.id)
        if (!gerenteDoVarejistaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'gerenteDoVarejista.label', default: 'GerenteDoVarejista'), params.id])
            redirect(action: "list")
            return
        }

        try {
            gerenteDoVarejistaInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'gerenteDoVarejista.label', default: 'GerenteDoVarejista'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'gerenteDoVarejista.label', default: 'GerenteDoVarejista'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
