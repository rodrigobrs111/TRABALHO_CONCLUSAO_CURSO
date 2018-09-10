package dominio

import org.springframework.dao.DataIntegrityViolationException


class ReclamacaoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    static scafoold       = true   
	
    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
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

    def show() {
        def reclamacaoInstance = Reclamacao.get(params.id)
        if (!reclamacaoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'reclamacao.label', default: 'Reclamacao'), params.id])
            redirect(action: "list")
            return
        }

        [reclamacaoInstance: reclamacaoInstance]
    }

    def edit() {
        def reclamacaoInstance = Reclamacao.get(params.id)
        if (!reclamacaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reclamacao.label', default: 'Reclamacao'), params.id])
            redirect(action: "list")
            return
        }

        [reclamacaoInstance: reclamacaoInstance]
    }

    def update() {
        def reclamacaoInstance = Reclamacao.get(params.id)
        if (!reclamacaoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'reclamacao.label', default: 'Reclamacao'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
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

    def delete() {
        def reclamacaoInstance = Reclamacao.get(params.id)
        if (!reclamacaoInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'reclamacao.label', default: 'Reclamacao'), params.id])
            redirect(action: "list")
            return
        }

        try {
            reclamacaoInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'reclamacao.label', default: 'Reclamacao'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'reclamacao.label', default: 'Reclamacao'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
	
	
	def visualizarSugestoes()
	{}
	
	def registrarReclamacao()
	{}
	
	def registrarSugestao()
	{}

	}
