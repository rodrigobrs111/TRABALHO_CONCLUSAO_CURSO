package teste_11

import org.springframework.dao.DataIntegrityViolationException

class DependenteController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    static scaffold       = true	

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [dependenteInstanceList: Dependente.list(params), dependenteInstanceTotal: Dependente.count()]
    }

    def create() {
        [dependenteInstance: new Dependente(params)]
    }

    def save() {
        def dependenteInstance = new Dependente(params)
        if (!dependenteInstance.save(flush: true)) {
            render(view: "create", model: [dependenteInstance: dependenteInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'dependente.label', default: 'Dependente'), dependenteInstance.id])
        redirect(action: "show", id: dependenteInstance.id)
    }

    def show(Long id) {
        def dependenteInstance = Dependente.get(id)
        if (!dependenteInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'dependente.label', default: 'Dependente'), id])
            redirect(action: "list")
            return
        }

        [dependenteInstance: dependenteInstance]
    }

    def edit(Long id) {
        def dependenteInstance = Dependente.get(id)
        if (!dependenteInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'dependente.label', default: 'Dependente'), id])
            redirect(action: "list")
            return
        }

        [dependenteInstance: dependenteInstance]
    }

    def update(Long id, Long version) {
        def dependenteInstance = Dependente.get(id)
        if (!dependenteInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'dependente.label', default: 'Dependente'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (dependenteInstance.version > version) {
                dependenteInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'dependente.label', default: 'Dependente')] as Object[],
                          "Another user has updated this Dependente while you were editing")
                render(view: "edit", model: [dependenteInstance: dependenteInstance])
                return
            }
        }

        dependenteInstance.properties = params

        if (!dependenteInstance.save(flush: true)) {
            render(view: "edit", model: [dependenteInstance: dependenteInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'dependente.label', default: 'Dependente'), dependenteInstance.id])
        redirect(action: "show", id: dependenteInstance.id)
    }

    def delete(Long id) {
        def dependenteInstance = Dependente.get(id)
        if (!dependenteInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'dependente.label', default: 'Dependente'), id])
            redirect(action: "list")
            return
        }

        try {
            dependenteInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'dependente.label', default: 'Dependente'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'dependente.label', default: 'Dependente'), id])
            redirect(action: "show", id: id)
        }
    }
}
