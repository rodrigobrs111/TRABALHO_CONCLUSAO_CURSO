package teste_11

import org.springframework.dao.DataIntegrityViolationException

class DonoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	static scaffold       = true
	
    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [donoInstanceList: Dono.list(params), donoInstanceTotal: Dono.count()]
    }

    def create() {
        [donoInstance: new Dono(params)]
    }

    def save() {
        def donoInstance = new Dono(params)
        if (!donoInstance.save(flush: true)) {
            render(view: "create", model: [donoInstance: donoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'dono.label', default: 'Dono'), donoInstance.id])
        redirect(action: "show", id: donoInstance.id)
    }

    def show(Long id) {
        def donoInstance = Dono.get(id)
        if (!donoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'dono.label', default: 'Dono'), id])
            redirect(action: "list")
            return
        }

        [donoInstance: donoInstance]
    }

    def edit(Long id) {
        def donoInstance = Dono.get(id)
        if (!donoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'dono.label', default: 'Dono'), id])
            redirect(action: "list")
            return
        }

        [donoInstance: donoInstance]
    }

    def update(Long id, Long version) {
        def donoInstance = Dono.get(id)
        if (!donoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'dono.label', default: 'Dono'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (donoInstance.version > version) {
                donoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'dono.label', default: 'Dono')] as Object[],
                          "Another user has updated this Dono while you were editing")
                render(view: "edit", model: [donoInstance: donoInstance])
                return
            }
        }

        donoInstance.properties = params

        if (!donoInstance.save(flush: true)) {
            render(view: "edit", model: [donoInstance: donoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'dono.label', default: 'Dono'), donoInstance.id])
        redirect(action: "show", id: donoInstance.id)
    }

    def delete(Long id) {
        def donoInstance = Dono.get(id)
        if (!donoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'dono.label', default: 'Dono'), id])
            redirect(action: "list")
            return
        }

        try {
            donoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'dono.label', default: 'Dono'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'dono.label', default: 'Dono'), id])
            redirect(action: "show", id: id)
        }
    }
}
