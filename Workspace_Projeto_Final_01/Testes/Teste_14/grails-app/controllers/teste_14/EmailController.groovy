package teste_14

import javax.mail.internet.*; 
import javax.mail.*
import javax.activation.*
import org.springframework.dao.DataIntegrityViolationException

class EmailController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
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

    def show(Long id) {
        def emailInstance = Email.get(id)
        if (!emailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'email.label', default: 'Email'), id])
            redirect(action: "list")
            return
        }

        [emailInstance: emailInstance]
    }

    def edit(Long id) {
        def emailInstance = Email.get(id)
        if (!emailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'email.label', default: 'Email'), id])
            redirect(action: "list")
            return
        }

        [emailInstance: emailInstance]
    }

    def update(Long id, Long version) {
        def emailInstance = Email.get(id)
        if (!emailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'email.label', default: 'Email'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
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

    def delete(Long id) {
        def emailInstance = Email.get(id)
        if (!emailInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'email.label', default: 'Email'), id])
            redirect(action: "list")
            return
        }

        try {
            emailInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'email.label', default: 'Email'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'email.label', default: 'Email'), id])
            redirect(action: "show", id: id)
        }
    }
	
	
	def email()
	{}
	
	def enviarEmail()
	{
		int i = 0 
		String msg =  "\n\n\n\n\n\n"                                                      +
		              " ATENCAO DATA DE ENTREGA DO PEDIDO PROXIMA DO VENCIMENTO" + "\n\n" + 
		              "==========================================" + "\n" +
				      "Numero do Pedido: " + "656565"      + "\n"  +
				      "Data de Hoje: "     + "14/03/2014"  + "\n"  +
				      "Data de Entrega: "  + "20/04/2013"  + "\n"  +
    		   	     "=========================================="  +
					 "\n\n\n\n\n\n\n"	
		
		while( i < 1 )
		{
		
		     sendMail{
				
				to      "rodrigobrs123@gmail.com"
				subject "ALERTA DATA DE ENTREGA DO PEDIDO PROXIMA DO VENCIMENTO!!!"
				body    msg	 
					 
			//	html g.render( template: "enviarEmail" )
		 		 i++
			  }
			
		}
	}
	
	
	
}
