package extra

import org.springframework.dao.DataIntegrityViolationException  

import com.sun.org.apache.bcel.internal.generic.LSTORE;

import dominio.*;

class RelatorioController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	static scafoold       = true
	
    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [relatorioInstanceList: Relatorio.list(params), relatorioInstanceTotal: Relatorio.count()]
    }

    def create() {
        [relatorioInstance: new Relatorio(params)]
    }

    def save() {
        def relatorioInstance = new Relatorio(params)
        if (!relatorioInstance.save(flush: true)) {
            render(view: "create", model: [relatorioInstance: relatorioInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'relatorio.label', default: 'Relatorio'), relatorioInstance.id])
        redirect(action: "show", id: relatorioInstance.id)
    }

    def show(Long id) {
        def relatorioInstance = Relatorio.get(id)
        if (!relatorioInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'relatorio.label', default: 'Relatorio'), id])
            redirect(action: "list")
            return
        }

        [relatorioInstance: relatorioInstance]
    }

    def edit(Long id) {
        def relatorioInstance = Relatorio.get(id)
        if (!relatorioInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'relatorio.label', default: 'Relatorio'), id])
            redirect(action: "list")
            return
        }

        [relatorioInstance: relatorioInstance]
    }

    def update(Long id, Long version) {
        def relatorioInstance = Relatorio.get(id)
        if (!relatorioInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'relatorio.label', default: 'Relatorio'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (relatorioInstance.version > version) {
                relatorioInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'relatorio.label', default: 'Relatorio')] as Object[],
                          "Another user has updated this Relatorio while you were editing")
                render(view: "edit", model: [relatorioInstance: relatorioInstance])
                return
            }
        }

        relatorioInstance.properties = params

        if (!relatorioInstance.save(flush: true)) {
            render(view: "edit", model: [relatorioInstance: relatorioInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'relatorio.label', default: 'Relatorio'), relatorioInstance.id])
        redirect(action: "show", id: relatorioInstance.id)
    }

    def delete(Long id) {
        def relatorioInstance = Relatorio.get(id)
        if (!relatorioInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'relatorio.label', default: 'Relatorio'), id])
            redirect(action: "list")
            return
        }

        try {
            relatorioInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'relatorio.label', default: 'Relatorio'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'relatorio.label', default: 'Relatorio'), id])
            redirect(action: "show", id: id)
        }
    }
	
	
	/* Assumindo que a lista de pedidos está ordenada */
	
	def visualizarRelatorios()
	{
		int                    anoPedido     = 0
	//	List< List< String > > lstAnos       = new ArrayList< ArrayList< String > >()

		anoPedido = ( Reclamacao.list( params ).get( 0 ).getDataSolucaoProblema().year.toInteger() + 1900 )
	   
		 [anoPedido: anoPedido]  
		
	}
	
	def geraRelReclamacoesAtendidas(Integer trimestre)
	{
		
		String                 mes1                     = 0
		String                 mes2                     = 0
		String                 mes3                     = 0
		String[]               nomeMeses                = new String[ 12 ]
		int                    valor1                   = 0
		int                    valor2                   = 0
		int                    valor3                   = 0
		int[]                  meses                    = new int[ 12 ]
		int[]                  contReclamacoesAtendidas = new int[ 12 ]
		int                    anoPedido                = 0
	//	List< List< String > > lstAnos                 = new ArrayList< ArrayList< String > >()
		
		
		
		nomeMeses[ 0 ]  = "JANEIRO"
		nomeMeses[ 1 ]  = "FEVEREIRO"
		nomeMeses[ 2 ]  = "MARCO"
		nomeMeses[ 3 ]  = "ABRIL"
		nomeMeses[ 4 ]  = "MAIO"
		nomeMeses[ 5 ]  = "JUNHO"
		nomeMeses[ 6 ]  = "JULHO"
		nomeMeses[ 7 ]  = "AGOSTO"
		nomeMeses[ 8 ]  = "SETEMBRO"
		nomeMeses[ 9 ]  = "OUTUBRO"
		nomeMeses[ 10 ] = "NOVEMBRO"
		nomeMeses[ 11 ] = "DEZEMBRO"
		
		anoPedido = ( Reclamacao.list( params ).get( 0 ).getDataSolucaoProblema().year.toInteger() + 1900 )
		

		for( int j = 0 ; j < meses.size() ; j++ )
		 {
			  meses[ j ]                    = 0
			  contReclamacoesAtendidas[ j ] = 0
			  System.out.println( "INICIA MESES: " + meses[ j ] + "      " +  j )
			  System.out.println( "CONT RECLAMACOES ATENDIDAS: " + contReclamacoesAtendidas[ j ] + "      " +  j )
		 }
		

		 for( int i = 0 ; i < Reclamacao.list( params ).size() ; i++ )
		 {
				 
				 if( ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema() != null ) &&
					 ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 )   == 1  && 
					 ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().year.toInteger() + 1900 ) == anoPedido )
				 {
					   meses[ 0 ] = ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 )
					   
					      if( Reclamacao.list( params ).get( i ).getStatus().equals( "ATENDIDA" ) )
					 	      contReclamacoesAtendidas[ 0 ]++   
							 println "RECLAMACAO MES1: " + contReclamacoesAtendidas[ 0 ]  
				 }	 
				 
				else if( ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema() != null ) &&
						 ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 )   == ( meses[ 0 ] + 1 ) && 
					     ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().year.toInteger() + 1900 ) == anoPedido )
				{
						   meses[ 1 ] = ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 )
						   
						   if( Reclamacao.list( params ).get( i ).getStatus().equals( "ATENDIDA" ) )
					 	      contReclamacoesAtendidas[ 1 ]++   
							  println "RECLAMACAO MES2: " + contReclamacoesAtendidas[ 1 ]
							   
				}		 
										 
				else if( ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema() != null ) &&
						 ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 )   == ( meses[ 1 ] + 1 ) && 
					     ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().year.toInteger() + 1900 ) == anoPedido )
						 {
							 meses[ 2 ] = ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 )
							 						 
							 if( Reclamacao.list( params ).get( i ).getStatus().equals( "ATENDIDA" ) )
					 	      contReclamacoesAtendidas[ 2 ]++   
							   println "RECLAMACAO MES3: " + contReclamacoesAtendidas[ 2 ]
							   
						 }
						 
			
				else if( ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema() != null ) &&
						 ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 )   == 4 && 
					     ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().year.toInteger() + 1900 ) == anoPedido )
				{
						   meses[ 3 ] = ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 )
						   
					        if( Reclamacao.list( params ).get( i ).getStatus().equals( "ATENDIDA" ) )
							 	 contReclamacoesAtendidas[ 3 ]++   
	
				}			 
				else if( ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema() != null ) &&
						 ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 )   == ( meses[ 3 ] + 1 ) && 
					     ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().year.toInteger() + 1900 ) == anoPedido )
				{
							  meses[ 4 ] = ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 )
							  
							  if( Reclamacao.list( params ).get( i ).getStatus().equals( "ATENDIDA" ) )
							       contReclamacoesAtendidas[ 4 ]++   
	
				}				 
												 
				else if( ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema() != null ) &&
						 ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 ) == ( meses[ 4 ] + 1 ) && 
				     	 ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().year.toInteger() + 1900 ) == anoPedido ) 
			   {
							 meses[ 5 ] = ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 )
							 
							 if( Reclamacao.list( params ).get( i ).getStatus().equals( "ATENDIDA" ) )
								 contReclamacoesAtendidas[ 5 ]++   
	
			  }
									
					
			  else if( ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema() != null ) &&
					   ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 )  == 7  && 
				       ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().year.toInteger() + 1900 ) == anoPedido ) 
			  {
						 meses[ 6 ] = ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 )
						 
						 if( Reclamacao.list( params ).get( i ).getStatus().equals( "ATENDIDA" ) )
						 contReclamacoesAtendidas[ 6 ]++
						 
			  }		 
										 
			  else if( ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema() != null ) &&
				       ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 )   == ( meses[ 6 ] + 1 )  && 
				       ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().year.toInteger() + 1900 ) == anoPedido ) 
			  {
						meses[ 7 ] = ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 )
							
						if( Reclamacao.list( params ).get( i ).getStatus().equals( "ATENDIDA" ) )
						contReclamacoesAtendidas[ 7 ]++
						
			  }							 
															 
			  else if( ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema() != null ) &&
					   ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 )   == ( meses[ 7 ] + 1 )  && 
				       ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().year.toInteger() + 1900 ) == anoPedido )  
					   {
						  meses[ 8 ] = ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 )
	
						  if( Reclamacao.list( params ).get( i ).getStatus().equals( "ATENDIDA" ) )
						  contReclamacoesAtendidas[ 8 ]++
						  
					   }
			
														 
			 else  if( ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema() != null ) &&
					   ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 )   == 10 && 
				       ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().year.toInteger() + 1900 ) == anoPedido )     
			{
						 meses[ 9 ] = ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 )
						 
						 if( Reclamacao.list( params ).get( i ).getStatus().equals( "ATENDIDA" ) )
						  contReclamacoesAtendidas[ 9 ]++
						 
			}	
			 							 
			 else if( ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema() != null ) &&
					  ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 )   == ( meses[ 9 ] + 1 ) && 
				      ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().year.toInteger() + 1900 ) == anoPedido ) 					
			 {
						 meses[ 10 ] = ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 )
						 
						 if( Reclamacao.list( params ).get( i ).getStatus().equals( "ATENDIDA" ) )
						      contReclamacoesAtendidas[ 10 ]++
	
		
			 }											 
			 else if( ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema() != null ) &&
					  ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 )   == ( meses[ 10 ] + 1 ) && 
				      ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().year.toInteger() + 1900 ) == anoPedido ) 			
					  {
						meses[ 11 ] = ( Reclamacao.list( params ).get( i ).getDataSolucaoProblema().month.toInteger() + 1 )
						
						if( Reclamacao.list( params ).get( i ).getStatus().equals( "ATENDIDA" ) )
						  contReclamacoesAtendidas[ 11 ]++
						
					  }
										
														  
		 }
		 
		     println "MES ARGUMENTO: " + trimestre	 
		 
			 println "============================================"
		 for( int k = 0 ; k < meses.size() ; k++ )
		 {
			  println "MESES: " + meses[ k ] + "     " + k
			  println "CONT RECLAMACOES ATENDIDAS: " + contReclamacoesAtendidas[ k ] + "      " +  k
		 }
			   println "============================================"
 

			   if( trimestre == 1 )
			   {
				   mes1   = nomeMeses[ 0 ]
				   mes2   = nomeMeses[ 1 ]
				   mes3   = nomeMeses[ 2 ]
				   valor1 = contReclamacoesAtendidas[ 0 ]
				   valor2 = contReclamacoesAtendidas[ 1 ]
				   valor3 = contReclamacoesAtendidas[ 2 ]
				   
				   println "TESTANDO RECLAMACOES ATENDIDAS: " + contReclamacoesAtendidas[ 0 ] + "    " + valor1
				   println "TESTANDO RECLAMACOES ATENDIDAS: " + contReclamacoesAtendidas[ 1 ] + "    " + valor2
				   println "TESTANDO RECLAMACOES ATENDIDAS: " + contReclamacoesAtendidas[ 2 ] + "    " + valor3
			   }
				
				 else if( trimestre == 4 )
			   {
				   mes1   = nomeMeses[ 3 ]
				   mes2   = nomeMeses[ 4 ]
				   mes3   = nomeMeses[ 5 ]
				   valor1 = contReclamacoesAtendidas[ 3 ]
				   valor2 = contReclamacoesAtendidas[ 4 ]
				   valor3 = contReclamacoesAtendidas[ 5 ]
			   }
	
			   else if( trimestre == 7 )
			   {
				   
				   mes1   = nomeMeses[ 6 ]
				   mes2   = nomeMeses[ 7 ]
				   mes3   = nomeMeses[ 8 ]
				   valor1 = contReclamacoesAtendidas[ 6 ]
				   valor2 = contReclamacoesAtendidas[ 7 ]
				   valor3 = contReclamacoesAtendidas[ 8 ]
			   }
			   
			   else if( trimestre == 10 )
			   {
				   mes1   = nomeMeses[ 9 ]
				   mes2   = nomeMeses[ 10 ]
				   mes3   = nomeMeses[ 11 ]
				   valor1 = contReclamacoesAtendidas[ 9 ]
				   valor2 = contReclamacoesAtendidas[ 10 ]
				   valor3 = contReclamacoesAtendidas[ 11 ]
			   }
			   
			   
			   println "=================="
			   println mes1 + " " +  mes2 + " " + mes3
			   println valor1 + " " +  valor2 + " " + valor3
			   println "=================="
	
		
			   [mes1: mes1 , mes2: mes2 , mes3: mes3 , , valor1: valor1 , valor2: valor2 , valor3: valor3]
			   
		   
		   
	}
	
		
	
	
	def geraRelNivelSatisfacaoConsumidor( Integer trimestre )
	{
		String                 mes1                     = 0
		String                 mes2                     = 0
		String                 mes3                     = 0
		String[]               nomeMeses                = new String[ 12 ]
		int                    anoPedido                = 0
		int                    muitoRuim1               = 0
		int                    ruim1                    = 0
		int                    regular1                 = 0
		int                    bom1                     = 0
		int                    muitoBom1                = 0
		int                    excelente1               = 0
		int                    muitoRuim2               = 0
		int                    ruim2                    = 0
		int                    regular2                 = 0
		int                    bom2                     = 0
		int                    muitoBom2                = 0
		int                    excelente2               = 0
		int                    muitoRuim3               = 0
		int                    ruim3                    = 0
		int                    regular3                 = 0
		int                    bom3                     = 0
		int                    muitoBom3                = 0
		int                    excelente3               = 0
		int[]                  contMuitoRuim            = new int[ 12 ] 
		int[]                  contRuim                 = new int[ 12 ]
		int[]                  contRegular              = new int[ 12 ]
		int[]                  contBom                  = new int[ 12 ]
		int[]                  contMuitoBom             = new int[ 12 ]
		int[]                  contExcelente            = new int[ 12 ]
		int[]                  meses                    = new int[ 12 ]
	//	List< List< String > > lstAnos                  = new ArrayList< ArrayList< String > >()
		
		
		
		nomeMeses[ 0 ]  = "JANEIRO"
		nomeMeses[ 1 ]  = "FEVEREIRO"
		nomeMeses[ 2 ]  = "MARCO"
		nomeMeses[ 3 ]  = "ABRIL"
		nomeMeses[ 4 ]  = "MAIO"
		nomeMeses[ 5 ]  = "JUNHO"
		nomeMeses[ 6 ]  = "JULHO"
		nomeMeses[ 7 ]  = "AGOSTO"
		nomeMeses[ 8 ]  = "SETEMBRO"
		nomeMeses[ 9 ]  = "OUTUBRO"
		nomeMeses[ 10 ] = "NOVEMBRO"
		nomeMeses[ 11 ] = "DEZEMBRO"
		
	
		anoPedido = ( Pedido.list( params ).get( 0 ).entrega.getDataEntrega().year.toInteger() + 1900 )
		
		for( int j = 0 ; j < meses.size() ; j++ )
		 {
			  meses[ j ]     = 0
			  contMuitoRuim[ j ] = 0
			  contRuim[ j ]      = 0
			  contRegular[ j ]   = 0
			  contBom[ j ]       = 0
			  contMuitoBom[ j ]  = 0 
			  contExcelente[ j ] = 0
		 }
		
		 
				  for( int i = 0 ; i < Pedido.list( params ).size() ; i++ )
				  {
						  
   		                  if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
							  ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )   == 1  &&
							  ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
						  {
								meses[ 0 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 ) // PENSAR NESSE PONTO UM DOS DOIS PODE SER NULL
								
								   if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_RUIM" ) )
								        contMuitoRuim[ 0 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "RUIM" ) )
								            contRuim[ 0 ]++
		
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "REGULAR" ) )
											contRegular[ 0 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "BOM" ) )
											 contBom[ 0 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_BOM" ) )
											contMuitoBom[ 0 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "EXCELENTE" ) )
											contExcelente[ 0 ]++
											
						  }
						  
   		                 else if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
								  ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )   == ( meses[ 0 ] + 1 ) &&
								  ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
						 {
									meses[ 1 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )
									
							   if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_RUIM" ) )
									contMuitoRuim[ 1 ]++
										
								else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "RUIM" ) )
										contRuim[ 1 ]++
	
								else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "REGULAR" ) )
										contRegular[ 1 ]++
										
								else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "BOM" ) )
										 contBom[ 1 ]++
										
								else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_BOM" ) )
										contMuitoBom[ 1 ]++
										
								else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "EXCELENTE" ) )
										contExcelente[ 1 ]++

										
						 }
												  
   		                 else if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
								  ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )   == ( meses[ 1 ] + 1 ) &&
								  ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
								  {
									  meses[ 2 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )
															   
								   if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_RUIM" ) )
								        contMuitoRuim[ 2 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "RUIM" ) )
								            contRuim[ 2 ]++
		
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "REGULAR" ) )
											contRegular[ 2 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "BOM" ) )
											 contBom[ 2 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_BOM" ) )
											contMuitoBom[ 2 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "EXCELENTE" ) )
											contExcelente[ 2 ]++

										
								  }
								  
					 
   		                 else if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
								  ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )   == 4 &&
								  ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
						 {
									meses[ 3 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )
									
								  if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_RUIM" ) )
								        contMuitoRuim[ 3 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "RUIM" ) )
								            contRuim[ 3 ]++
		
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "REGULAR" ) )
											contRegular[ 3 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "BOM" ) )
											 contBom[ 3 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_BOM" ) )
											contMuitoBom[ 3 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "EXCELENTE" ) )
											contExcelente[ 3 ]++

			 
						 }
   		                 else if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
								  ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )   == ( meses[ 3 ] + 1 ) &&
								  ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
						 {
									   meses[ 4 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )
									   
									   
								  if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_RUIM" ) )
								        contMuitoRuim[ 4 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "RUIM" ) )
								            contRuim[ 4 ]++
		
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "REGULAR" ) )
											contRegular[ 4 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "BOM" ) )
											 contBom[ 4 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_BOM" ) )
											contMuitoBom[ 4 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "EXCELENTE" ) )
											contExcelente[ 4 ]++
			 
						 }
														  
   		                 else if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
								  ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 ) == ( meses[ 4 ] + 1 ) &&
							      ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
						{
									  meses[ 5 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )
									  
								  if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_RUIM" ) )
									  contMuitoRuim[ 5 ]++
										  
								  else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "RUIM" ) )
										  contRuim[ 5 ]++
	  
								  else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "REGULAR" ) )
										  contRegular[ 5 ]++
										  
								  else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "BOM" ) )
										   contBom[ 5 ]++
										  
								  else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_BOM" ) )
										  contMuitoBom[ 5 ]++
										  
								  else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "EXCELENTE" ) )
										  contExcelente[ 5 ]++
			 
					   }
											 
							 
   		               else if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
								( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )  == 7  &&
								( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
					   {
								  meses[ 6 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )

							 if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_RUIM" ) )
								  contMuitoRuim[ 6 ]++
									  
							  else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "RUIM" ) )
									  contRuim[ 6 ]++
  
							  else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "REGULAR" ) )
									  contRegular[ 6 ]++
									  
							  else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "BOM" ) )
									   contBom[ 6 ]++
									  
							  else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_BOM" ) )
									  contMuitoBom[ 6 ]++
									  
							  else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "EXCELENTE" ) )
									  contExcelente[ 6 ]++
								
					   }
												  
   		               else if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
								( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )   == ( meses[ 6 ] + 1 )  &&
								( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
					   {
								 meses[ 7 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )
									 
								  if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_RUIM" ) )
								        contMuitoRuim[ 7 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "RUIM" ) )
								            contRuim[ 7 ]++
		
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "REGULAR" ) )
											contRegular[ 7 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "BOM" ) )
											 contBom[ 7 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_BOM" ) )
											contMuitoBom[ 7 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "EXCELENTE" ) )
											contExcelente[ 7 ]++
								 
					   }
																	  
   		               else if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
								( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )   == ( meses[ 7 ] + 1 )  &&
								( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
								{
								   meses[ 8 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )
			 
								  if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_RUIM" ) )
								        contMuitoRuim[ 8 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "RUIM" ) )
								            contRuim[ 8 ]++
		
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "REGULAR" ) )
											contRegular[ 8 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "BOM" ) )
											 contBom[ 8 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_BOM" ) )
											contMuitoBom[ 8 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "EXCELENTE" ) )
											contExcelente[ 8 ]++
								   
								}
					 
																  
   		               else if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
								( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )   == 10 &&
								( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
					 {
								  meses[ 9 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )
								  
								  if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_RUIM" ) )
								        contMuitoRuim[ 9 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "RUIM" ) )
								            contRuim[ 9 ]++
		
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "REGULAR" ) )
											contRegular[ 9 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "BOM" ) )
											 contBom[ 9 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_BOM" ) )
											contMuitoBom[ 9 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "EXCELENTE" ) )
											contExcelente[ 9 ]++
								  
					 }
												   
   		              else if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
							   ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )   == ( meses[ 9 ] + 1 ) &&
							   ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
					  {
								  meses[ 10 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )
								  
								  if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_RUIM" ) )
								        contMuitoRuim[ 10 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "RUIM" ) )
								            contRuim[ 10 ]++
		
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "REGULAR" ) )
											contRegular[ 10 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "BOM" ) )
											 contBom[ 10 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_BOM" ) )
											contMuitoBom[ 10 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "EXCELENTE" ) )
											contExcelente[ 10 ]++
									   
									   
			 
				 
					  }
   		              else if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
							   ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )   == ( meses[ 10 ] + 1 ) &&
							   ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
							   {
								 meses[ 11 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )
								 
								  if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_RUIM" ) )
								        contMuitoRuim[ 11 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "RUIM" ) )
								            contRuim[ 11 ]++
		
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "REGULAR" ) )
											contRegular[ 11 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "BOM" ) )
											 contBom[ 11 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "MUITO_BOIM" ) )
											contMuitoBom[ 11 ]++
											
									else if( Pedido.list( params ).get( i ).entrega.getClassificacao().equals( "EXCELENTE" ) )
											contExcelente[ 11 ]++
								 
							   }
												 
																   
				  }
		 
	//		 println "MES ARGUMENTO: " + mes
		 
			 println "============================================"
		 for( int k = 0 ; k < meses.size() ; k++ )
		 {
			  println "MESES: " + meses[ k ] + "     " + k
			 
		 }
			   println "============================================"
 
			   
			   if( trimestre == 1 )
			   {
				   mes1       = nomeMeses[ 0 ]
				   mes2       = nomeMeses[ 1 ]
				   mes3       = nomeMeses[ 2 ]
				   muitoRuim1 = contMuitoRuim[ 0 ] ;  ruim1 = contRuim[ 0 ] ;  regular1 = contRegular[ 0 ] ;  bom1 = contBom[ 0 ] ;  muitoBom1 = contMuitoBom[ 0 ] ;  excelente1 = contExcelente[ 0 ] ;
				   muitoRuim2 = contMuitoRuim[ 1 ] ;  ruim2 = contRuim[ 1 ] ;  regular2 = contRegular[ 1 ] ;  bom2 = contBom[ 1 ] ;  muitoBom2 = contMuitoBom[ 1 ] ;  excelente2 = contExcelente[ 1 ] ;
				   muitoRuim3 = contMuitoRuim[ 2 ] ;  ruim3 = contRuim[ 2 ] ;  regular3 = contRegular[ 2 ] ;  bom3 = contBom[ 2 ] ;  muitoBom3 = contMuitoBom[ 2 ] ;  excelente3 = contExcelente[ 2 ] ;
				   
				   
			   }
				
			 else if( trimestre == 4 )
			   {
				   mes1   = nomeMeses[ 3 ]
				   mes2   = nomeMeses[ 4 ]
				   mes3   = nomeMeses[ 5 ]
				   muitoRuim1 = contMuitoRuim[ 3 ] ;  ruim1 = contRuim[ 3 ] ;  regular1 = contRegular[ 3 ] ;  bom1 = contBom[ 3 ] ;  muitoBom1 = contMuitoBom[ 3 ] ;  excelente1 = contExcelente[ 3 ] ;
				   muitoRuim2 = contMuitoRuim[ 4 ] ;  ruim2 = contRuim[ 4 ] ;  regular2 = contRegular[ 4 ] ;  bom2 = contBom[ 4 ] ;  muitoBom2 = contMuitoBom[ 4 ] ;  excelente2 = contExcelente[ 4 ] ;
				   muitoRuim3 = contMuitoRuim[ 5 ] ;  ruim3 = contRuim[ 5 ] ;  regular3 = contRegular[ 5 ] ;  bom3 = contBom[ 5 ] ;  muitoBom3 = contMuitoBom[ 5 ] ;  excelente3 = contExcelente[ 5 ] ;

			   }
	
			   else if( trimestre == 7 )
			   {
				   
				   mes1   = nomeMeses[ 6 ]
				   mes2   = nomeMeses[ 7 ]
				   mes3   = nomeMeses[ 8 ]
				   muitoRuim1 = contMuitoRuim[ 6 ] ;  ruim1 = contRuim[ 6 ] ;  regular1 = contRegular[ 6 ] ;  bom1 = contBom[ 6 ] ;  muitoBom1 = contMuitoBom[ 6 ] ;  excelente1 = contExcelente[ 6 ] ;
				   muitoRuim2 = contMuitoRuim[ 7 ] ;  ruim2 = contRuim[ 7 ] ;  regular2 = contRegular[ 7 ] ;  bom2 = contBom[ 7 ] ;  muitoBom2 = contMuitoBom[ 7 ] ;  excelente2 = contExcelente[ 7 ] ;
				   muitoRuim3 = contMuitoRuim[ 8 ] ;  ruim3 = contRuim[ 8 ] ;  regular3 = contRegular[ 8 ] ;  bom3 = contBom[ 8 ] ;  muitoBom3 = contMuitoBom[ 8 ] ;  excelente3 = contExcelente[ 8 ] ;

	
			   }
			   
			   else if( trimestre == 10 )
			   {
				   mes1   = nomeMeses[ 9 ]
				   mes2   = nomeMeses[ 10 ]
				   mes3   = nomeMeses[ 11 ]
				   muitoRuim1 = contMuitoRuim[ 9 ]  ;  ruim1 = contRuim[ 9 ]  ;   regular1 = contRegular[ 9 ] ;  bom1 = contBom[ 9 ]  ;  muitoBom1 = contMuitoBom[ 9 ]  ;  excelente1 = contExcelente[ 9 ]  ;
				   muitoRuim2 = contMuitoRuim[ 10 ] ;  ruim2 = contRuim[ 10 ] ;  regular2 = contRegular[ 10 ] ;  bom2 = contBom[ 10 ] ;  muitoBom2 = contMuitoBom[ 10 ] ;  excelente2 = contExcelente[ 10 ] ;
				   muitoRuim3 = contMuitoRuim[ 11 ] ;  ruim3 = contRuim[ 11 ] ;  regular3 = contRegular[ 11 ] ;  bom3 = contBom[ 11 ] ;  muitoBom3 = contMuitoBom[ 11 ] ;  excelente3 = contExcelente[ 11 ] ;

			   }
			   
	        for( int i = 0 ; i < 12 ; i++ )
			{	
			   println "=================="
			   println "MUITO RUIM: " + contMuitoRuim[ i ]
			   println "RUIM: "       + contRuim[ i ]
			   println "REGULAR: "    + contRegular[ i ] 
			   println "BOM: "        + contBom[ i ]
			   println "MUITO BOM: "  + contMuitoBom[ i ]
			   println "EXCELENTE: "  + contExcelente[ i ]
			   println "=================="
			}
			
		   [mes1: mes1 , mes2: mes2 , mes3: mes3 ,
			muitoRuim1: muitoRuim1 , ruim1: ruim1 , regular1: regular1 , bom1: bom1 , muitoBom1: muitoBom1 , excelente1: excelente1  ,
			muitoRuim2: muitoRuim2 , ruim2: ruim2 , regular2: regular2 , bom2: bom2 , muitoBom2: muitoBom2 , excelente2: excelente2  ,
			muitoRuim3: muitoRuim3 , ruim3: ruim3 , regular3: regular3 , bom3: bom3 , muitoBom3: muitoBom3 , excelente3: excelente3 ]
		   
	}
	
	def geraRelPedidosEntreguesPrazo( Integer trimestre )
	{
		String                 mes1                     = 0
		String                 mes2                     = 0
		String                 mes3                     = 0
		int                    numPedidosMes1           = 0
		int                    numPedidosMes2           = 0
		int                    numPedidosMes3           = 0
		String[]               nomeMeses                = new String[ 12 ]
		int[]                  contPedidos              = new int[ 12 ]
		int[]                  meses                    = new int[ 12 ]
		int                    anoPedido                = 0
	//	List< List< String > > lstAnos                  = new ArrayList< ArrayList< String > >()
		
		
		
		nomeMeses[ 0 ]  = "JANEIRO"
		nomeMeses[ 1 ]  = "FEVEREIRO"
		nomeMeses[ 2 ]  = "MARCO"
		nomeMeses[ 3 ]  = "ABRIL"
		nomeMeses[ 4 ]  = "MAIO"
		nomeMeses[ 5 ]  = "JUNHO"
		nomeMeses[ 6 ]  = "JULHO"
		nomeMeses[ 7 ]  = "AGOSTO"
		nomeMeses[ 8 ]  = "SETEMBRO"
		nomeMeses[ 9 ]  = "OUTUBRO"
		nomeMeses[ 10 ] = "NOVEMBRO"
		nomeMeses[ 11 ] = "DEZEMBRO"
		
		anoPedido = ( Pedido.list( params ).get( 0 ).entrega.getDataEntrega().year.toInteger() + 1900 )
		
		for( int j = 0 ; j < meses.size() ; j++ )
		 {
			  meses[ j ]       = 0
			  contPedidos[ j ] = 0 
		 }
		
		 
		 for( int i = 0 ; i < Pedido.list( params ).size() ; i++ )
		 {
				 
				 if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
					 ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )   == 1  &&
					 ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
				 {
					   meses[ 0 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 ) // PENSAR NESSE PONTO UM DOS DOIS PODE SER NULL
					   
						  if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega() ) <= ( Pedido.list( params ).get( i ).entrega.getDataRecebimento() )  )
							  contPedidos[ 0 ]++
							  
						println "MES 1: " + meses[ 0 ]	  
   							   
				 }
				 
	            else if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
						 ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )   == ( meses[ 0 ] + 1 ) &&
						 ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
				{
						   meses[ 1 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )
						   
						  if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega() ) <= ( Pedido.list( params ).get( i ).entrega.getDataRecebimento() ) )
							    contPedidos[ 1 ]++
   							   
				}
										 
                 else if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
						 ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )   == ( meses[ 1 ] + 1 ) &&
						 ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
				{
							 meses[ 2 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )
													  
							 if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega() ) <= ( Pedido.list( params ).get( i ).entrega.getDataRecebimento() ) )
							       contPedidos[ 2 ]++
	
				}
						 
			
                else if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
						 ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )   == 4 &&
						 ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
				{
						   meses[ 3 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )
						   
						   if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega() ) <= ( Pedido.list( params ).get( i ).entrega.getDataRecebimento() ) )
						         contPedidos[ 3 ]++

	
				}
                else if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
						 ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )   == ( meses[ 3 ] + 1 ) &&
						 ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
				{
							  meses[ 4 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )
							  
							  
						   if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega() ) <= ( Pedido.list( params ).get( i ).entrega.getDataRecebimento() ) )
						         contPedidos[ 4 ]++	
				}
												 
                else if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
						 ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 ) == ( meses[ 4 ] + 1 ) &&
						  ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
			   {
							 meses[ 5 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )
							 
						   if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega() ) <= ( Pedido.list( params ).get( i ).entrega.getDataRecebimento() ) )
						         contPedidos[ 5 ]++
	
			  }
									
					
                else if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
					   ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )  == 7  &&
					   ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
			  {
						 meses[ 6 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )

						   if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega() ) <= ( Pedido.list( params ).get( i ).entrega.getDataRecebimento() ) )
						   contPedidos[ 6 ]++
					   
			  }
										 
               else if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
					   ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )   == ( meses[ 6 ] + 1 )  &&
					   ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
			  {
						meses[ 7 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )
							
						   if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega() ) <= ( Pedido.list( params ).get( i ).entrega.getDataRecebimento() ) )
						         contPedidos[ 7 ]++
			  }
															 
              else if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
					   ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )   == ( meses[ 7 ] + 1 )  &&
					   ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
					   {
						  meses[ 8 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )
	
						   if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega() ) <= ( Pedido.list( params ).get( i ).entrega.getDataRecebimento() ) )
						         contPedidos[ 8 ]++
						  
					   }
			
														 
              else if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
					   ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )   == 10 &&
					   ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
			{
						 meses[ 9 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )
						 
						 if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega() ) <= ( Pedido.list( params ).get( i ).entrega.getDataRecebimento() ) )
						       contPedidos[ 9 ]++
						 
			}
										  
			else if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
				     ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )   == ( meses[ 9 ] + 1 ) &&
					 ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
			 {
						 meses[ 10 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )
						 
						   if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega() ) <= ( Pedido.list( params ).get( i ).entrega.getDataRecebimento() ) )
						          contPedidos[ 10 ]++
							  
							  
	
		
			 }
		else if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega()     != null ) &&
		  	     ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )   == ( meses[ 10 ] + 1 ) &&
				 ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().year.toInteger() + 1900 ) == anoPedido )
					  {
						meses[ 11 ] = ( Pedido.list( params ).get( i ).entrega.getDataRecebimento().month.toInteger() + 1 )
						
						   if( ( Pedido.list( params ).get( i ).entrega.getDataEntrega() ) <= ( Pedido.list( params ).get( i ).entrega.getDataRecebimento() ) )
						         contPedidos[ 11 ]++
						
					  }
										
														  
		 }
		 		 
		 
		 
			 println "============================================"
		 for( int k = 0 ; k < meses.size() ; k++ )
		 {
			  println "MESES: " + meses[ k ] + "     " + k
			 
		 }
			   println "============================================"
 
			   
			   if( trimestre == 1 )
			   {
				   mes1           = nomeMeses[ 0 ]
				   mes2           = nomeMeses[ 1 ]
				   mes3           = nomeMeses[ 2 ]
				   numPedidosMes1 = contPedidos[ 0 ]
				   numPedidosMes2 = contPedidos[ 1 ]
				   numPedidosMes3 = contPedidos[ 2 ]
			   }
				
			 else if( trimestre == 4 )
			   {
				   mes1           = nomeMeses[ 3 ]
				   mes2           = nomeMeses[ 4 ]
				   mes3           = nomeMeses[ 5 ]
				   numPedidosMes1 = contPedidos[ 3 ]
				   numPedidosMes2 = contPedidos[ 4 ]
				   numPedidosMes3 = contPedidos[ 5 ]
		
			   }
	
			   else if( trimestre == 7 )
			   {
				   
			       mes1           = nomeMeses[ 6 ]
				   mes2           = nomeMeses[ 7 ]
				   mes3           = nomeMeses[ 8 ]
				   numPedidosMes1 = contPedidos[ 6 ]
				   numPedidosMes2 = contPedidos[ 7 ]
				   numPedidosMes3 = contPedidos[ 8 ]
		
			   }
			   
			   else if( trimestre == 10 )
			   {
			       mes1           = nomeMeses[ 9 ]
				   mes2           = nomeMeses[ 10 ]
				   mes3           = nomeMeses[ 11 ]
				   numPedidosMes1 = contPedidos[ 9 ]
				   numPedidosMes2 = contPedidos[ 10 ]
				   numPedidosMes3 = contPedidos[ 11 ]
	
			   }
			   
			   
			   println "=================="
			   println mes1 + " " + " " +  mes2 + " " + mes3
			   println "=================="
			   
			for( int i = 0 ; i < 12 ; i++ )
			{
			   println "=================="
			   println "CONTADOR DE PEDIDOS: " + contPedidos[ i ]
			   println "=================="
			}
			
		  	[mes1: mes1 , mes2: mes2 , mes3: mes3, numPedidosMes1: numPedidosMes1 , numPedidosMes2: numPedidosMes2 , numPedidosMes3: numPedidosMes3]
		
		   
		
	}
	
	
}
