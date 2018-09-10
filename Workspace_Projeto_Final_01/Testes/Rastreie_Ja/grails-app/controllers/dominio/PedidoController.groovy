package dominio

import org.springframework.dao.DataIntegrityViolationException  
import dominio.Pedido

class PedidoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	static scafoold       = true
	
	File file = new File( "resources/NUM_PEDIDO.txt" )
	
	
    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
		
		
		println "======================================"
		for( int i = 0 ; i < Pedido.list(params).size() ; i++ )
		 {
			 List< Produto > lst =  Pedido.list( params ).get( i ).getLstProdutos()
			 
		//	 println "PRODUTO:" + lst.size()
			 
			  
			/* for( int j = 0 ; j < Pedido.list( params ).get( i ).getLstProdutos().size() ; j++ )
			 {
		     	 println "PRODUTO:" + lst.get( j ).getNomeProduto()
			 }*/
	     }
		
		
        params.max = Math.min(max ?: 10, 100)
        [pedidoInstanceList: Pedido.list(params), pedidoInstanceTotal: Pedido.count()]
    }

    def create() {
        [pedidoInstance: new Pedido(params)]
    }

    def save() {
        def pedidoInstance = new Pedido(params)
        if (!pedidoInstance.save(flush: true)) {
            render(view: "create", model: [pedidoInstance: pedidoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'pedido.label', default: 'Pedido'), pedidoInstance.id])
        redirect(action: "show", id: pedidoInstance.id)
    }

    def show(Long id) {
        def pedidoInstance = Pedido.get(id)
        if (!pedidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pedido.label', default: 'Pedido'), id])
            redirect(action: "list")
            return
        }

        [pedidoInstance: pedidoInstance]
    }

    def edit(Long id) {
        def pedidoInstance = Pedido.get(id)
        if (!pedidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pedido.label', default: 'Pedido'), id])
            redirect(action: "list")
            return
        }

        [pedidoInstance: pedidoInstance]
    }

    def update(Long id, Long version) {
        def pedidoInstance = Pedido.get(id)
        if (!pedidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pedido.label', default: 'Pedido'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (pedidoInstance.version > version) {
                pedidoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'pedido.label', default: 'Pedido')] as Object[],
                          "Another user has updated this Pedido while you were editing")
                render(view: "edit", model: [pedidoInstance: pedidoInstance])
                return
            }
        }

        pedidoInstance.properties = params


        if (!pedidoInstance.save(flush: true)) {
            render(view: "edit", model: [pedidoInstance: pedidoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'pedido.label', default: 'Pedido'), pedidoInstance.id])
        redirect(action: "show", id: pedidoInstance.id)
    }

    def delete(Long id) {
        def pedidoInstance = Pedido.get(id)
        if (!pedidoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'pedido.label', default: 'Pedido'), id])
            redirect(action: "list")
            return
        }

        try {
            pedidoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'pedido.label', default: 'Pedido'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'pedido.label', default: 'Pedido'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def confirmarRecebimento(Integer max)
	{
		params.max = Math.min(max ?: 10, 100)
		[pedidoInstanceList: Pedido.list(params), pedidoInstanceTotal: Pedido.count()]
	}
	
	
	def _confirmarRecebimento(String classificacao)
	{
		String numPedido = ""
		def pedidoInstance 
		
		file.eachLine { line -> 
		
		println "=============================="
		println "NUMERO DO PEDIDO: " + line
		println "CLASSIFICACAO: "    + classificacao
		println "=============================="
		numPedido = line
		
		}
	   	
	 		
		for( int i = 0 ; i < Pedido.list(params).size() ; i++ )
		if( Pedido.list(params).get(i).getNumPedido() == numPedido.toInteger() )
			{ 
				pedidoInstance = Pedido.list(params).get( i )
				
				pedidoInstance.entrega.setStatus( "CONFIRMADO" )
				pedidoInstance.entrega.setClassificacao( classificacao )
			}
		
		render(view: "buscarPedido" , model:[pedidoInstanceList: pedidoInstance , pedidoInstanceTotal: 0] )
		
	}
	
	
	def buscarPedido(Integer numPedido)
	{
		def pedidoInstance
		
		for( int i = 0 ; i < Pedido.list(params).size() ; i++ )
		  if( Pedido.list(params).get(i).getNumPedido() == numPedido )
			  pedidoInstance = Pedido.list(params).get(i)
	
		 [pedidoInstanceList: pedidoInstance , pedidoInstanceTotal: 0]
	}
	
	
	def buscarPedidoCancel(Integer numPedido)
	{
		def pedidoInstance
		
		for( int i = 0 ; i < Pedido.list(params).size() ; i++ )
		  if( Pedido.list(params).get(i).getNumPedido() == numPedido )
		  {
			
			  pedidoInstance = Pedido.list(params).get(i)
		  }  
		 [pedidoInstanceList: pedidoInstance , pedidoInstanceTotal: 0]
	}
	
	
	def buscarPedidoConfirReceb(Integer numPedido)
	{
		def pedidoInstance
		 
		file.write( numPedido.toString() )
		
		for( int i = 0 ; i < Pedido.list(params).size() ; i++ )
		  if( Pedido.list(params).get(i).getNumPedido() == numPedido )
			  pedidoInstance = Pedido.list(params).get(i)
			  
		 [pedidoInstanceList: pedidoInstance , pedidoInstanceTotal: 0]
	}	

	
	def buscarPedidoEncerr(Integer numPedido)
	{
		def pedidoInstance
		
		for( int i = 0 ; i < Pedido.list(params).size() ; i++ )
		  if( Pedido.list(params).get(i).getNumPedido() == numPedido )
		  {
			  pedidoInstance = Pedido.list(params).get(i)
		  }
			  
		 [pedidoInstanceList: pedidoInstance , pedidoInstanceTotal: 0]
	}

	
	def buscarPedidoAvisarConsumidor(Integer numPedido)
	{
		def pedidoInstance
		
		for( int i = 0 ; i < Pedido.list(params).size() ; i++ )
		  if( Pedido.list(params).get(i).getNumPedido() == numPedido )
		  {
			  new File( "resources/MOTIVO_CANCELAMENTO.txt" ).append( numPedido + " " )
			  pedidoInstance = Pedido.list(params).get(i)
		  }
			  
		 [pedidoInstanceList: pedidoInstance , pedidoInstanceTotal: 0]
	}
	
	def autorizarColeta( Integer max )
	{
		params.max = Math.min(max ?: 10, 100)
		[pedidoInstanceList: Pedido.list(params), pedidoInstanceTotal: Pedido.count()] 
	}
	
	def _autorizarColeta()
	{
		for( int i = 0 ; i < Pedido.list(params).size() ; i++ )
		   Pedido.list(params).get(i).entrega.setStatus("AUTORIZADO")
		   
		redirect(action: "autorizarColeta")
	}
	
		
	def cancelarEntrega(Integer max)
	{
		params.max = Math.min(max ?: 10, 100)
		[pedidoInstanceList: Pedido.list(params), pedidoInstanceTotal: Pedido.count()]
	}
	
	def _cancelarEntrega(Integer numPedido)
	{
	   def pedidoInstance
		
		for( int i = 0 ; i < Pedido.list(params).size() ; i++ )
		{
		  if( ( Pedido.list(params).get(i).getNumPedido() == numPedido ) &&
			  ( Pedido.list(params).get(i).entrega.getStatus().equals( "AUTORIZADO" ) ) )
		  {
			  Pedido.list(params).get(i).entrega.setStatus( "CANCELADO" )
			  pedidoInstance = Pedido.list(params).get(i)
		  }
		}
		[pedidoInstanceList: pedidoInstance , pedidoInstanceTotal: 0] 
		
	}

	def cancelarTudo()
	{
		for( int i = 0 ; i < Pedido.list(params).size() ; i++ )
		   Pedido.list(params).get(i).entrega.setStatus("CANCELADO")
		   
		redirect(action: "cancelarEntrega")
	}

	
	
	def encerrarEntrega(Integer max)
	{
		params.max = Math.min(max ?: 10, 100)
		[pedidoInstanceList: Pedido.list(params), pedidoInstanceTotal: Pedido.count()]
	}
	
	def _encerrarEntrega(Integer numPedido)
	{
		def pedidoInstance
		
		for( int i = 0 ; i < Pedido.list(params).size() ; i++ )
		  if( ( Pedido.list(params).get(i).getNumPedido() == numPedido ) &&
		    ! ( Pedido.list(params).get(i).entrega.getStatus().equals( "CONFIRMADO" ) ) ||
			  ( Pedido.list(params).get(i).entrega.getStatus().equals( "AUTORIZADO" ) ) ||
			  ( Pedido.list(params).get(i).entrega.getStatus().equals( "CANCELADO" ) ) )
		  {
			  Pedido.list(params).get(i).entrega.setStatus("ENCERRADO")
			  pedidoInstance = Pedido.list(params).get(i)  
		  }

		 [pedidoInstanceList: pedidoInstance , pedidoInstanceTotal: 0 ]
	}
	
	def encerrarTudo()
	{
		for( int i = 0 ; i < Pedido.list(params).size() ; i++ )
		   Pedido.list(params).get(i).entrega.setStatus("ENCERRADO")
		   
		redirect(action: "encerrarEntrega")
	}
	
	def exibeListaProdutos( Long id )
	{
		def pedidoInstance = Pedido.get( id )
		
		println "======================================"
		println  "ID: " + id 
		for( int i = 0 ; i < Pedido.list(params).size() ; i++ )
		println "ID:" + Pedido.get( id )
     	println "======================================"
	
		   
		   
		[produtoInstanceList: pedidoInstance.getLstProdutos() , produtoInstanceTotal: 0 ]
		
	}
    
	
	def avisarConsumidor(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		[pedidoInstanceList: Pedido.list(params), pedidoInstanceTotal: Pedido.count()]
	}

	
	def registrarMotivo( String motivoCancel )
	{
	    new File( "resources/MOTIVO_CANCELAMENTO.txt" ).append( motivoCancel + "\n" )
		redirect( action: "avisarConsumidor" )
	}
		
}
