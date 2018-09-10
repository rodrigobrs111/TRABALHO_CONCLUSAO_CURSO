package teste_15

import org.springframework.dao.DataIntegrityViolationException

class Teste2Controller {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [teste2InstanceList: Teste2.list(params), teste2InstanceTotal: Teste2.count()]
    }

    def create() {
        [teste2Instance: new Teste2(params)]
    }

    def save() {
        def teste2Instance = new Teste2(params)
        if (!teste2Instance.save(flush: true)) {
            render(view: "create", model: [teste2Instance: teste2Instance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'teste2.label', default: 'Teste2'), teste2Instance.id])
        redirect(action: "show", id: teste2Instance.id)
    }

    def show(Long id) {
        def teste2Instance = Teste2.get(id)
        if (!teste2Instance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'teste2.label', default: 'Teste2'), id])
            redirect(action: "list")
            return
        }

        [teste2Instance: teste2Instance]
    }

    def edit(Long id) {
        def teste2Instance = Teste2.get(id)
        if (!teste2Instance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'teste2.label', default: 'Teste2'), id])
            redirect(action: "list")
            return
        }

        [teste2Instance: teste2Instance]
    }

    def update(Long id, Long version) {
        def teste2Instance = Teste2.get(id)
        if (!teste2Instance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'teste2.label', default: 'Teste2'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (teste2Instance.version > version) {
                teste2Instance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'teste2.label', default: 'Teste2')] as Object[],
                          "Another user has updated this Teste2 while you were editing")
                render(view: "edit", model: [teste2Instance: teste2Instance])
                return
            }
        }

        teste2Instance.properties = params

        if (!teste2Instance.save(flush: true)) {
            render(view: "edit", model: [teste2Instance: teste2Instance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'teste2.label', default: 'Teste2'), teste2Instance.id])
        redirect(action: "show", id: teste2Instance.id)
    }

    def delete(Long id) {
        def teste2Instance = Teste2.get(id)
        if (!teste2Instance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'teste2.label', default: 'Teste2'), id])
            redirect(action: "list")
            return
        }

        try {
            teste2Instance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'teste2.label', default: 'Teste2'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'teste2.label', default: 'Teste2'), id])
            redirect(action: "show", id: id)
        }
    }
}
