package extra

import org.springframework.dao.DataIntegrityViolationException 
import dominio.*

class EmailController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	String msg = ""
	
    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [emailInstanceList: Email.list(params), emailInstanceTotal: Email.count()]
    }

    def create() {
        [emailInstance: new Email(params)]
    }

    def save() {
        def emailInstance = new Email(params)
        if (!emailInstance.save(flush: true)) {
            render(view: "create", model: [emailInstance: emailInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'email.label', default: 'Email'), emailInstance.id])
        redirect(action: "show", id: emailInstance.id)
    }

    def show() {
        def emailInstance = Email.get(params.id)
        if (!emailInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'email.label', default: 'Email'), params.id])
            redirect(action: "list")
            return
        }

        [emailInstance: emailInstance]
    }

    def edit() {
        def emailInstance = Email.get(params.id)
        if (!emailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'email.label', default: 'Email'), params.id])
            redirect(action: "list")
            return
        }

        [emailInstance: emailInstance]
    }

    def update() {
        def emailInstance = Email.get(params.id)
        if (!emailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'email.label', default: 'Email'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (emailInstance.version > version) {
                emailInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'email.label', default: 'Email')] as Object[],
                          "Another user has updated this Email while you were editing")
                render(view: "edit", model: [emailInstance: emailInstance])
                return
            }
        }

        emailInstance.properties = params

        if (!emailInstance.save(flush: true)) {
            render(view: "edit", model: [emailInstance: emailInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'email.label', default: 'Email'), emailInstance.id])
        redirect(action: "show", id: emailInstance.id)
    }

    def delete() {
        def emailInstance = Email.get(params.id)
        if (!emailInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'email.label', default: 'Email'), params.id])
            redirect(action: "list")
            return
        }

        try {
            emailInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'email.label', default: 'Email'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'email.label', default: 'Email'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
	
	
	def _enviarEmail()
	{
		int    vez                               = 0
		Date   dataHoje                          = new Date()
		SupervisorDoVarejista supervisorInstance = null
		GerenteDoVarejista    gerenteInstance    = null
		
												   
															   
		for( int i = 0 ; i < Pedido.list( params ).size() ; i++ )
		{
			
			if( ( ( ( Pedido.list( params ).get( i ).entrega.getDataEntrega() ) - dataHoje ) <= 7 ) && vez == 0 )
			{
				supervisorInstance = SupervisorDoVarejista.list( params ).get( 0 )
				_setMsg( Pedido.list( params ).get( i ) )
				
					
				println "===================================================="
				println "EMAIL:" 
				println "PARA: "   + supervisorInstance.getEmail()
				println "TITULO: " + "ALERTA DATA DE ENTREGA DO PEDIDO PROXIMA DO VENCIMENTO!!!"
				println "===================================================="
				println msg
				
				
			     vez = 1
			}
			
			else if( ( ( ( Pedido.list( params ).get( i ).entrega.getDataEntrega() ) - dataHoje ) <= 3 ) && vez == 1 )
			{
				gerenteInstance = GerenteDoVarejista.list( params ).get( 0 )
				_setMsg( Pedido.list( params ).get( i ) )
				
				 
                println "===================================================="
				println "EMAIL:" 
				println "PARA: "   + gerenteInstance.getEmail()
				println "TITULO: " + "ALERTA DATA DE ENTREGA DO PEDIDO PROXIMA DO VENCIMENTO!!!"
				println "===================================================="
				println msg
				
				 
				vez = 2
			}
			
			if( vez == 2 )
				 vez = 0
		}
		
		redirect( action: "index" , controller: "home" )
	}

	
	
	def enviarEmail()
	{
		int    vez                               = 0 
		Date   dataHoje                          = new Date()
		SupervisorDoVarejista supervisorInstance = null
		GerenteDoVarejista    gerenteInstance    = null
		
												   
												   			
		for( int i = 0 ; i < Pedido.list( params ).size() ; i++ )
		{
			
			if( ( ( ( Pedido.list( params ).get( i ).entrega.getDataEntrega() ) - dataHoje ) <= 7 ) && vez == 0 )
			{
			    supervisorInstance = SupervisorDoVarejista.list( params ).get( 0 )
                setMsg( Pedido.list( params ).get( i ) ) 		
				
				 sendMail{
					
					to      supervisorInstance.getEmail()
					subject "ALERTA DATA DE ENTREGA DO PEDIDO PROXIMA DO VENCIMENTO!!!"
					body    msg
				 }
				 
				 vez = 1
			}
			
			else if( ( ( ( Pedido.list( params ).get( i ).entrega.getDataEntrega() ) - dataHoje ) <= 3 ) && vez == 1 )
			{
			    gerenteInstance = GerenteDoVarejista.list( params ).get( 0 )
				setMsg( Pedido.list( params ).get( i ) )
				
				
				 sendMail{
					
					to      gerenteInstance.getEmail()
					subject "ALERTA DATA DE ENTREGA DO PEDIDO PROXIMA DO VENCIMENTO!!!"
					body    msg
				 }
				 
				vez = 2
			}
			
			if( vez == 2 )
		 	    vez = 0
		}
	}
	
	def setMsg( Pedido pedido )
	{
		
		Date dataHoje = new Date()
		
	  msg =	"\n\n\n\n\n\n"                                                      +
			" ATENCAO DATA DE ENTREGA DO PEDIDO PROXIMA DO VENCIMENTO" + "\n\n" +
			"=========================================="               + "\n"   +
			"Numero do Pedido: " +  pedido.getNumPedido()              + "\n"   +
			"Data de Hoje: "     +  dataHoje                           + "\n"   +
			"Data de Entrega: "  +  pedido.entrega.getDataEntrega()    + "\n"   +
			"=========================================="               +
			"\n\n\n\n\n\n\n"
	}
	

	def _setMsg( Pedido pedido )
	{
		
		Date dataHoje = new Date()
		
	  msg = "\n"                                                       +
	        "MENSAGEM DO EMAIL:"                                       + "\n\n" +	
	        "ATENCAO DATA DE ENTREGA DO PEDIDO PROXIMA DO VENCIMENTO"  + "\n\n" +
			"=========================================="               + "\n"   +
			"Numero do Pedido: " +  pedido.getNumPedido()              + "\n"   +
			"Data de Hoje: "     +  dataHoje                           + "\n"   +
			"Data de Entrega: "  +  pedido.entrega.getDataEntrega()    + "\n"   +
			"=========================================="               +
			"\n\n"
	}
	
		
}
