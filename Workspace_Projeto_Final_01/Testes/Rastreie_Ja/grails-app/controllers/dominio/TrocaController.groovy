package dominio

import org.springframework.dao.DataIntegrityViolationException

/**
 * TrocaController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class TrocaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [trocaInstanceList: Troca.list(params), trocaInstanceTotal: Troca.count()]
    }

    def create() {
        [trocaInstance: new Troca(params)]
    }

    def save() {
        def trocaInstance = new Troca(params)
        if (!trocaInstance.save(flush: true)) {
            render(view: "create", model: [trocaInstance: trocaInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'troca.label', default: 'Troca'), trocaInstance.id])
        redirect(action: "show", id: trocaInstance.id)
    }

    def show() {
        def trocaInstance = Troca.get(params.id)
        if (!trocaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'troca.label', default: 'Troca'), params.id])
            redirect(action: "list")
            return
        }

        [trocaInstance: trocaInstance]
    }

    def edit() {
        def trocaInstance = Troca.get(params.id)
        if (!trocaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'troca.label', default: 'Troca'), params.id])
            redirect(action: "list")
            return
        }

        [trocaInstance: trocaInstance]
    }

    def update() {
        def trocaInstance = Troca.get(params.id)
        if (!trocaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'troca.label', default: 'Troca'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (trocaInstance.version > version) {
                trocaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'troca.label', default: 'Troca')] as Object[],
                          "Another user has updated this Troca while you were editing")
                render(view: "edit", model: [trocaInstance: trocaInstance])
                return
            }
        }

        trocaInstance.properties = params

        if (!trocaInstance.save(flush: true)) {
            render(view: "edit", model: [trocaInstance: trocaInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'troca.label', default: 'Troca'), trocaInstance.id])
        redirect(action: "show", id: trocaInstance.id)
    }

    def delete() {
        def trocaInstance = Troca.get(params.id)
        if (!trocaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'troca.label', default: 'Troca'), params.id])
            redirect(action: "list")
            return
        }

        try {
            trocaInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'troca.label', default: 'Troca'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'troca.label', default: 'Troca'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
	
	def buscarTroca( Integer numTroca )
	{
		def trocaInstance = null
		
		for( int i = 0 ; i < Troca.list( params ).size() ; i++ )
			if( Troca.list( params ).get( i ).getNumTroca() == numTroca  )
			     trocaInstance = Troca.list( params ).get( i )

			
		[trocaInstanceList: trocaInstance , trocaInstanceTotal: 0 ]
	}
	
}
