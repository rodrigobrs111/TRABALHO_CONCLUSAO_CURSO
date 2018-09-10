package extra

import groovy.xml.streamingmarkupsupport.BaseMarkupBuilder.Document;  
import java.text.AttributedCharacterIterator.Attribute;
import org.springframework.dao.DataIntegrityViolationException
import dominio.*
//import com.sun.xml.internal.txw2.Document
//import com.googlecode.jsu.util.WorkflowUtils
//import com.atlassian.jira.ComponentManager


class CadastroController  
{

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [cadastroInstanceList: Cadastro.list(params), cadastroInstanceTotal: Cadastro.count()]
    }

    def create() {
        [cadastroInstance: new Cadastro(params)]
    }

    def save() {
        def cadastroInstance = new Cadastro(params)
        if (!cadastroInstance.save(flush: true)) {
            render(view: "create", model: [cadastroInstance: cadastroInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'cadastro.label', default: 'Cadastro'), cadastroInstance.id])
        redirect(action: "show", id: cadastroInstance.id)
    }

    def show() {
        def cadastroInstance = Cadastro.get(params.id)
        if (!cadastroInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'cadastro.label', default: 'Cadastro'), params.id])
            redirect(action: "list")
            return
        }

        [cadastroInstance: cadastroInstance]
    }

    def edit() {
        def cadastroInstance = Cadastro.get(params.id)
        if (!cadastroInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'cadastro.label', default: 'Cadastro'), params.id])
            redirect(action: "list")
            return
        }

        [cadastroInstance: cadastroInstance]
    }

    def update() {
        def cadastroInstance = Cadastro.get(params.id)
        if (!cadastroInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'cadastro.label', default: 'Cadastro'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (cadastroInstance.version > version) {
                cadastroInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'cadastro.label', default: 'Cadastro')] as Object[],
                          "Another user has updated this Cadastro while you were editing")
                render(view: "edit", model: [cadastroInstance: cadastroInstance])
                return
            }
        }

        cadastroInstance.properties = params

        if (!cadastroInstance.save(flush: true)) {
            render(view: "edit", model: [cadastroInstance: cadastroInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'cadastro.label', default: 'Cadastro'), cadastroInstance.id])
        redirect(action: "show", id: cadastroInstance.id)
    }

    def delete() {
        def cadastroInstance = Cadastro.get(params.id)
        if (!cadastroInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'cadastro.label', default: 'Cadastro'), params.id])
            redirect(action: "list")
            return
        }

        try {
            cadastroInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'cadastro.label', default: 'Cadastro'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'cadastro.label', default: 'Cadastro'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
	
	def escolherFormulario()
	{}
	
	
	def validarEscolha(Integer id)
	{
		 //Attribute attribute  = new Attribute()
		 // MetaClassImpl attr = new MetaClassImpl( Cadastro )
		 // def testCaseProperty = id.getPropertyValue( "MyProp" )
		//if ( ruim.isSelected()) {
		//def teste = WorkflowUtils.g 
	     
/*		
			  
		def cfManager = ComponentManager.instance.customFieldManager
		def cfRadioButton = cfManager.getCustomFieldObjects(issue).find {it.name == 'Name of RadioButton CF'}
		String cfValue = issue.getCustomFieldValue(cfRadioButton).getValue()
		
		
		  
		if(  attr.getAttribute( Cadastro , "ruim" ) )
		   redirect(action: "list")
		
			
   	   else if( Cadastro.get(id).toString().equals("ruim" ) )
		 redirect(action: "list")
		  
		 else 
		 redirect(action: "create")*/
		 
	}
	
	def validarCadastro( int matricula , String senha )
	{
		int numUsuarios = Consumidor.list( params ).size()
		
		
		if( FuncionarioDaTransportadora.list( params ).size() > numUsuarios )
		   numUsuarios = FuncionarioDaTransportadora.list( params ).size() 

		else if( FuncionarioDoVarejista.list( params ).size() > numUsuarios )
		   numUsuarios = FuncionarioDoVarejista.list( params ).size()

		else  if( GerenteDoVarejista.list( params ).size() > numUsuarios )
		   numUsuarios = GerenteDoVarejista.list( params ).size()

		else  if( SupervisorDoVarejista.list( params ).size() > numUsuarios )
		   numUsuarios = SupervisorDoVarejista.list( params ).size()

		else if( Distribuidor.list( params ).size() > numUsuarios )
		   numUsuarios = Distribuidor.list( params ).size()

		
		
		for( int i = 0 ; i < numUsuarios ; i++ )
		{
			
			  if( Consumidor.list( params ).size() > i )
		      if( Consumidor.list( params ).get( i ).getMatricula() == matricula &&
			      Consumidor.list( params ).get( i ).getSenha().equals( senha ) ) 
		 	        redirect(action:"list" , controller: "produto")

		    else if( FuncionarioDaTransportadora.list( params ).size() > i )
			     if( FuncionarioDaTransportadora.list( params ).get( i ).getMatricula() == matricula &&
			         FuncionarioDaTransportadora.list( params ).get( i ).getSenha().equals( senha ) )
				        redirect(action:"list" , controller: "produto")
	
						
			else if( FuncionarioDoVarejista.list( params ).size() > i )
			     if( FuncionarioDoVarejista.list( params ).get( i ).getMatricula() == matricula &&
				     FuncionarioDoVarejista.list( params ).get( i ).getSenha().equals( senha ) )
			           redirect(action:"list" , controller: "produto")
		
		    else if( GerenteDoVarejista.list( params ).size() > i )
			     if( GerenteDoVarejista.list( params ).get( i ).getMatricula() == matricula &&
				     GerenteDoVarejista.list( params ).get( i ).getSenha().equals( senha ) )
				       redirect(action:"list" , controller: "produto")
				  
		    else if( SupervisorDoVarejista.list( params ).size() > i )
			     if( SupervisorDoVarejista.list( params ).get( i ).getMatricula() == matricula &&
			         SupervisorDoVarejista.list( params ).get( i ).getSenha().equals( senha ) )
				      redirect(action:"list" , controller: "produto")
						
		   else if( Distribuidor.list( params ).size() > i )
			    if( Distribuidor.list( params ).get( i ).getNumDist() == matricula &&
				     Distribuidor.list( params ).get( i ).getSenha().equals( senha ) )
			          redirect(action:"list" , controller: "produto")
				
			else 
			return 	
							  
		}
	}
	
	
	
}
