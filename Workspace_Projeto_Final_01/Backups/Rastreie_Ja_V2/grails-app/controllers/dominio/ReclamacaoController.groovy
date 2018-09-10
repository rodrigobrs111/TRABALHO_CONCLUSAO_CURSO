package dominio

import org.springframework.dao.DataIntegrityViolationException

class ReclamacaoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	static scaffold       = true 

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [reclamacaoInstanceList: Reclamacao.list(params), reclamacaoInstanceTotal: Reclamacao.count()]
    }

    def create() {
        [reclamacaoInstance: new Reclamacao(params)]
    }

    def save() {
        def reclamacaoInstance = new Reclamacao(params)
        if (!reclamacaoInstance.save(flush: true)) {
            render(view: "create", model: [reclamacaoInstance: reclamacaoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'reclamacao.label', default: 'Reclamacao'), reclamacaoInstance.id])
        redirect(action: "show", id: reclamacaoInstance.id)
    }

    def show(Long id) {
        def reclamacaoInstance = Reclamacao.get(id)
        if (!reclamacaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reclamacao.label', default: 'Reclamacao'), id])
            redirect(action: "list")
            return
        }

        [reclamacaoInstance: reclamacaoInstance]
    }

    def edit(Long id) {
        def reclamacaoInstance = Reclamacao.get(id)
        if (!reclamacaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reclamacao.label', default: 'Reclamacao'), id])
            redirect(action: "list")
            return
        }

        [reclamacaoInstance: reclamacaoInstance]
    }

    def update(Long id, Long version) {
        def reclamacaoInstance = Reclamacao.get(id)
        if (!reclamacaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reclamacao.label', default: 'Reclamacao'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (reclamacaoInstance.version > version) {
                reclamacaoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'reclamacao.label', default: 'Reclamacao')] as Object[],
                          "Another user has updated this Reclamacao while you were editing")
                render(view: "edit", model: [reclamacaoInstance: reclamacaoInstance])
                return
            }
        }

        reclamacaoInstance.properties = params

        if (!reclamacaoInstance.save(flush: true)) {
            render(view: "edit", model: [reclamacaoInstance: reclamacaoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'reclamacao.label', default: 'Reclamacao'), reclamacaoInstance.id])
        redirect(action: "show", id: reclamacaoInstance.id)
    }

    def delete(Long id) {
        def reclamacaoInstance = Reclamacao.get(id)
        if (!reclamacaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reclamacao.label', default: 'Reclamacao'), id])
            redirect(action: "list")
            return
        }

        try {
            reclamacaoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'reclamacao.label', default: 'Reclamacao'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'reclamacao.label', default: 'Reclamacao'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def visualizarSugestoes()
	{}
	
	def registrarReclamacao()
	{}
	
	def registrarSugestao()
	{}

	
}
