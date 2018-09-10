package teste_09

import org.springframework.dao.DataIntegrityViolationException 

/**
 * PessoaController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class PessoaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }
	
	def index_02(){
	}

	
    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [pessoaInstanceList: Pessoa.list(params), pessoaInstanceTotal: Pessoa.count()]
    }

    def create() {
        [pessoaInstance: new Pessoa(params)]
    }

    def save() {
        def pessoaInstance = new Pessoa(params)
        if (!pessoaInstance.save(flush: true)) {
            render(view: "create", model: [pessoaInstance: pessoaInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'pessoa.label', default: 'Pessoa'), pessoaInstance.id])
        redirect(action: "show", id: pessoaInstance.id)
    }

    def show() {
        def pessoaInstance = Pessoa.get(params.id)
        if (!pessoaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'pessoa.label', default: 'Pessoa'), params.id])
            redirect(action: "list")
            return
        }

        [pessoaInstance: pessoaInstance]
    }

    def edit() {
        def pessoaInstance = Pessoa.get(params.id)
        if (!pessoaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pessoa.label', default: 'Pessoa'), params.id])
            redirect(action: "list")
            return
        }

        [pessoaInstance: pessoaInstance]
    }

    def update() {
        def pessoaInstance = Pessoa.get(params.id)
        if (!pessoaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pessoa.label', default: 'Pessoa'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (pessoaInstance.version > version) {
                pessoaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'pessoa.label', default: 'Pessoa')] as Object[],
                          "Another user has updated this Pessoa while you were editing")
                render(view: "edit", model: [pessoaInstance: pessoaInstance])
                return
            }
        }

        pessoaInstance.properties = params

        if (!pessoaInstance.save(flush: true)) {
            render(view: "edit", model: [pessoaInstance: pessoaInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'pessoa.label', default: 'Pessoa'), pessoaInstance.id])
        redirect(action: "show", id: pessoaInstance.id)
    }

    def delete() {
        def pessoaInstance = Pessoa.get(params.id)
        if (!pessoaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'pessoa.label', default: 'Pessoa'), params.id])
            redirect(action: "list")
            return
        }

        try {
            pessoaInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'pessoa.label', default: 'Pessoa'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'pessoa.label', default: 'Pessoa'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
