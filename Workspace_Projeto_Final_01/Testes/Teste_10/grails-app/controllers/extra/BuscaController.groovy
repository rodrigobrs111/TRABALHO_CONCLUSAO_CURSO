package extra

import org.springframework.dao.DataIntegrityViolationException    
import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.URLENC
 

class BuscaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	static scafoold       = true

				
    def index()
	{
       redirect(action: "list", params: params)
		
		// initialze a new builder and give a default URL
	/*	def http = new HTTPBuilder( 'http://www.google.com/search' )
		 
		http.request(GET,TEXT) { req ->
		  uri.path = '/mail/help/tasks/' // overrides any path in the default URL
		  headers.'User-Agent' = 'Mozilla/5.0'
		 
		    response.success = { resp, reader ->
			assert resp.status == 200
			println "My response handler got response: ${resp.statusLine}"
			println "Response length: ${resp.headers.'Content-Length'}"
			System.out << reader // print response reader
		  }
		 
		   // called only for a 404 (not found) status code:
		    response.'404' = { resp ->
			println 'Not found'
		  }
		}*/
	/*	
		def http = new HTTPBuilder( 'http://twitter.com/statuses/' )
		// auth omitted...
		def postBody = [status:'update!',source:'httpbuilder'] // will be url-encoded
		 
		http.post( path: 'update.xml', body: postBody,
				   requestContentType: URLENC )
		{ resp ->
		 
		  println "Tweet response status: ${resp.statusLine}"
		  assert resp.statusLine.statusCode == 200
		}
		*/
	 }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [buscaInstanceList: Busca.list(params), buscaInstanceTotal: Busca.count()]
    }

    def create() {
        [buscaInstance: new Busca(params)]
    }

    def save() {
        def buscaInstance = new Busca(params)
        if (!buscaInstance.save(flush: true)) {
            render(view: "create", model: [buscaInstance: buscaInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'busca.label', default: 'Busca'), buscaInstance.id])
        redirect(action: "show", id: buscaInstance.id)
    }

    def show() {
        def buscaInstance = Busca.get(params.id)
        if (!buscaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'busca.label', default: 'Busca'), params.id])
            redirect(action: "list")
            return
        }

        [buscaInstance: buscaInstance]
    }

    def edit() {
        def buscaInstance = Busca.get(params.id)
        if (!buscaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'busca.label', default: 'Busca'), params.id])
            redirect(action: "list")
            return
        }

        [buscaInstance: buscaInstance]
    }

    def update() {
        def buscaInstance = Busca.get(params.id)
        if (!buscaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'busca.label', default: 'Busca'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (buscaInstance.version > version) {
                buscaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'busca.label', default: 'Busca')] as Object[],
                          "Another user has updated this Busca while you were editing")
                render(view: "edit", model: [buscaInstance: buscaInstance])
                return
            }
        }

        buscaInstance.properties = params

        if (!buscaInstance.save(flush: true)) {
            render(view: "edit", model: [buscaInstance: buscaInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'busca.label', default: 'Busca'), buscaInstance.id])
        redirect(action: "show", id: buscaInstance.id)
    }

    def delete() {
        def buscaInstance = Busca.get(params.id)
        if (!buscaInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'busca.label', default: 'Busca'), params.id])
            redirect(action: "list")
            return
        }

        try {
            buscaInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'busca.label', default: 'Busca'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'busca.label', default: 'Busca'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
	
	
	
		
}
