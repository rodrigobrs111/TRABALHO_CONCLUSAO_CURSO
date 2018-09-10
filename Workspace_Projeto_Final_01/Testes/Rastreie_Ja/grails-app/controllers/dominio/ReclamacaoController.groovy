package dominio

import org.springframework.dao.DataIntegrityViolationException 
import dominio.Reclamacao

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
			
			println "========================================="
			println "========================================="
			println "ENTROU NO METODO EDIT!!!"
			println "========================================="
			println "========================================="
            
			return
        }

        [reclamacaoInstance: reclamacaoInstance]
    }

    def update(Long id, Long version, String necessidadeTroca ) {
        
		def  reclamacaoInstance = Reclamacao.get(id)
        Date data               = new Date()
		
		
		if( necessidadeTroca.equals( "Sim" ) )
		{
			

			def devolucao   = new Devolucao( numDevol: 1 , numPedido: 10 , valorDevol: 100 ,
				                             funcionarioDoVarejista: FuncionarioDoVarejista.list( params ).get( 0 ) , 
											 transportadora: Transportadora.list( params ).get( 0 ) ).save( failOnError: true )
			
			  new Troca( numTroca: 1000 , numPedidoAnt: 1 , numPedidoNovo: reclamacaoInstance.pedido.getNumPedido() ,
				         dataSolicit: data , dataColeta: data , dataEntregaVarej: data , dataEntregaConsumidor: data ,
						 valorTroca: 100.00 , pedido: reclamacaoInstance.getPedido() , consumidor: reclamacaoInstance.pedido.entrega.getConsumidor() ,
						 devolucao: devolucao ).save( failOnError: true )
						 
		}
		
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
		
		
		
		println "========================================="
		println "========================================="
		println "ENTROU NO METODO UPDATE!!!"
		println "========================================="
		println "========================================="
		

        if (!reclamacaoInstance.save(flush: true)) {
            render(view: "edit", model: [reclamacaoInstance: reclamacaoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'reclamacao.label', default: 'Reclamacao'), reclamacaoInstance.id])
        redirect(action: "show", id: reclamacaoInstance.id)
    }

    def delete(Long id) {
        def reclamacaoInstance = Reclamacao.get(id)
		
		
		
		
		println "========================================="
		println "========================================="
		println "ENTROU NO METODO DELETE!!!"
		println "========================================="
		println "========================================="
		
		
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

	def buscarReclamacao(Integer numReclamacao)
	{
		def reclamacaoInstance
		
		for( int i = 0 ; i < Reclamacao.list(params).size() ; i++ )
		  if( Reclamacao.list(params).get( i ).getNumReclamacao() == numReclamacao )
		     reclamacaoInstance = Reclamacao.list(params).get( i )
			 
			 [reclamacaoInstanceList: reclamacaoInstance , reclamacaoInstanceTotal: 0]
	}
	
	def BuscarReclamacaoResp( Integer numReclamacao )
	{
		def reclamacaoInstance
		
		for( int i = 0 ; i < Reclamacao.list(params).size() ; i++ )
		  if( Reclamacao.list(params).get( i ).getNumReclamacao() == numReclamacao )
		  {
			 new File( "resources/RECLAMCAOES.txt" ).append( numReclamacao + " " )
			 reclamacaoInstance = Reclamacao.list(params).get( i )
			 
		  }
			 [reclamacaoInstanceList: reclamacaoInstance , reclamacaoInstanceTotal: 0]
	}
	
	def encerrarReclamacao(Integer max) 
	{
		params.max = Math.min(max ?: 10, 100)
		[reclamacaoInstanceList: Reclamacao.list(params), reclamacaoInstanceTotal: Reclamacao.count()]
	}
	
	def _encerrarReclamacao(Integer numReclamacao)
	{
		def reclamacaoInstance
		
		for( int i = 0 ; i < Reclamacao.list(params).size() ; i++ )
		  if( Reclamacao.list(params).get( i ).getNumReclamacao() == numReclamacao )
		  {
			 Reclamacao.list(params).get( i ).setStatus( "ATENDIDA" )
		     reclamacaoInstance = Reclamacao.list(params).get( i )
			 
		  } 
			 [reclamacaoInstanceList: reclamacaoInstance , reclamacaoInstanceTotal: 0]
	}
	
	
	def responderReclamacao(Integer max)
	{
		params.max = Math.min(max ?: 10, 100)
		[reclamacaoInstanceList: Reclamacao.list(params), reclamacaoInstanceTotal: Reclamacao.count()]
	}
	
	
	def registrarResposta( String comentario )
	{
	    new File( "resources/RECLAMACAOES.txt" ).append( comentario + "\n" )
		redirect( action: "BuscarReclamacaoResp" )
	}

	
		
}
