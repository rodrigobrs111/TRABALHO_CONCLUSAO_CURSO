package extra



import org.apache.tools.ant.taskdefs.condition.Http   
import org.springframework.dao.DataIntegrityViolationException        

import com.sun.org.apache.bcel.internal.generic.FSTORE;
import com.sun.org.apache.bcel.internal.generic.LSTORE;

import groovyx.net.http.HTTPBuilder 
import static groovyx.net.http.ContentType.URLENC
import static groovyx.net.http.Method.GET
import static groovyx.net.http.Method.POST
import static groovyx.net.http.ContentType.JSON

import java.util.StringTokenizer
import java.util.List

 //import groovyx.net.http.* 
//import static groovyx.net.http.ContentType.*
//import static groovyx.net.http.Method.*

//@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.8' )


class BuscaController  {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST" , rastrearPedido: ["GET" , "POST"] ]

	File file = new File( "resources/LOCALIZACAO_PEDIDO.txt" )
	

    def index() {
        redirect(action: "list", params: params)
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
	
	def rastrearPedido(String numPedido)
	{
		  
		def        http      = new HTTPBuilder( 'http://www.dhl.com.br/' )
		def        http2     = new HTTPBuilder( 'http://www.dhl.com.br/express/rastreamento.html/' )
		def        http3     = new HTTPBuilder( 'http://www.correios.com.br/sistemas/rastreamento/default.cfm/' )
		def        http4     = new HTTPBuilder( 'http://www.correios.com.br/sistemas/rastreamento/resultado.cfm')
		def        http5     = new HTTPBuilder( 'http://websro.correios.com.br/sro_bin/txect01$.Inexistente?P_LINGUA=001&P_TIPO=002&P_COD_LIS=' + numPedido )
        def        http6	  = new HTTPBuilder() 
		def        http7     = new HTTPBuilder('http://www.google.com/')
		def        postBody  = [name: '${numPedido}' , title: 'trackingIndex_fast_crossrefpar1_taskcenter_taskcentertabs_item1229046233349_par_expandablelink_insideparsys_fasttrack']
		def        postBody2 = [name: '${numPedido}' , title: 'formbusca']
		def        postBody3 = [name: '${numPedido}' , title: 'trackingIndex']
		def        postBody4 = [name: numPedido , title: 'formbusca']
		def        msg1      = "RESULTADO DO POST: NENHUMA MENSAGEM!!!"
		def        msg2      = "RESULTADO DO POST: NENHUMA MENSAGEM!!!"
		def        msg3      = "RESULTADO DO POST: NENHUMA MENSAGEM!!!"
		def        msg4      = "RESULTADO DO POST: NENHUMA MENSAGEM!!!"
		def        msg5      = "RESULTADO DO POST: NENHUMA MENSAGEM!!!"
		def        ret       = null
	//	def        POST      = groovyx.net.http.Method.POST
	//	def        GET       = groovyx.net.http.Method.GET
	    def        TEXT      = groovyx.net.http.ContentType.TEXT
		String     linhasArq  = ""
		FileWriter writer = new FileWriter( file , false )
		
	// TESTE 1	ERRO
		
		
	/*	http5.request( GET, TEXT ) { req ->
			uri.path = 'http://localhost:8080/Rastreie_Ja/busca/rastrearPedido' 
			uri.query = [ v:'1.0', q: 'Calvin and Hobbes' ]
						
			headers.'User-Agent' = "Mozilla/5.0 Firefox/3.0.4"
			headers.Accept = 'application/json'
		   
			response.success = { resp, reader ->
			//  assert resp.statusLine.statusCode == 200
			  msg1    = "RESULTADO DO POST: ${resp.statusLine}"
			  msg2    = "RESULTADO DO POST: ${resp.status}"
			  msg3    = "RESULTADO DO POST: ${reader.text}"
			  msg4    = "RESULTADO DO POST: ${reader}"
			  println   "======================================="
			  println   "RESULTADO DO POST: ${resp.statusLine}"
			  System.out << reader
			  println "Got response: ${resp.statusLine}"
			  println "Content-Type: ${resp.headers.'Content-Type'}"
			  println reader.text
			  println   "======================================="
			  
			}
		   
		  } */
		
	//	 TESTE 2 ERRO
		
/*		http4.request( GET , TEXT ) { req ->
		 
		 uri.path = 'http://localhost:8080/Rastreie_Ja/busca/rastrearPedido'
		 requestContentType = URLENC
		// postBody = [ name: '${numPedido}' , title: 'frm1' ]
		 
		 response.success = { resp , reader ->

			 msg1    = "RESULTADO DO POST: ${resp.statusLine}"
			 msg2    = "RESULTADO DO POST: ${resp.status}"
			 msg3    = "RESULTADO DO POST: ${reader.text}"
			 msg4    = "RESULTADO DO POST: ${reader}"
	   	     println   "RESULTADO DO POST: ${resp.statusLine}"
		  	 println   "======================================="
			 System.out << reader
			 println   "======================================="
		//	 assert resp.statusLine.statusCode == 201
		 }
		 

	 } */
		
		

		
		// TESTE 3 MAIS OU MENOS

	/*	http5.post( path: 'http://localhost:8080/Rastreie_Ja/busca/rastrearPedido' , body: postBody4 , requestContentType: URLENC ) { resp , reader ->
		 
             msg1    = "RESULTADO DO POST: ${resp.statusLine}"
			 msg2    = "RESULTADO DO POST: ${resp.status}"
			 msg3    = "RESULTADO DO POST: ${reader.text}"
			 msg4    = "RESULTADO DO POST: ${reader}"
	   	     println   "RESULTADO DO POST: ${resp.statusLine}"
		  	 println   "======================================="
			 System.out << reader
			 println   "======================================="
		  //   assert resp.statusLine.statusCode == 201
		 
	 }*/
	 
			
		// TESTE 4 OK
		/*http2.post( path: 'http://localhost:8080/Rastreie_Ja/busca/rastrearPedido' , body: postBody3 , requestContentType: JSON ) { resp , reader ->
				 
				 msg1    = "RESULTADO DO POST: ${resp.statusLine}"
			     msg2    = "RESULTADO DO POST: ${resp.status}"
				 msg3    = "RESULTADO DO POST: ${reader.text}"
				 msg4    = "RESULTADO DO POST: ${reader}"
				 
				 println "======================================="
				 System.out << reader
				 println "======================================="
				 println   "RESULTADO DO POST: ${resp.statusLine}"
				// assert resp.statusLine.statusCode == 201
		
				// http.shutdown()
			 }*/
			 
				
		
		
		// TESTE 5 OK
		
		/*http4.post( path: 'http://localhost:8080/Rastreie_Ja/busca/rastrearPedido' , body: postBody4 , requestContentType: URLENC ) { resp , reader ->
				 
			  			
	      		 msg1    = "RESULTADO DO POST 1: ${resp.statusLine}"
			     msg2    = "RESULTADO DO POST 2: ${resp.status}"
				 msg3    = "RESULTADO DO POST 3: ${reader.text}"
				 msg4    = "RESULTADO DO POST: ${reader}"
				 println "======================================="
				 System.out << reader
				 println "======================================="
				 println   "RESULTADO DO POST: ${resp.statusLine}"
				// assert resp.statusLine.statusCode == 201
	
		
				// http.shutdown()
			 }*/
		

	      // TESTE 6
		
/*		http.request( GET , TEXT ) { req ->
		 
//			 uri.path = 'http://localhost:8080/Rastreie_Ja/busca/rastrearPedido'
//			 send  URLENC , [name: numPedido , title: 'trackingIndex']

			
			 response.success = { resp , reader  ->
				                            
				 msg1    = "RESULTADO DO POST 1: ${resp.statusLine}"
			     msg2    = "RESULTADO DO POST 2: ${resp.status}"
				 msg3    = "RESULTADO DO POST 3: ${reader.text}"
				 msg4    = "RESULTADO DO POST: ${reader}"
				 msg5    = "Content-Type: ${resp.headers.'Content-Type'}"
				 
				 println "======================================="
				 System.out << reader
				 println "======================================="
				 println   "RESULTADO DO POST: ${resp.statusLine}"
	
				 println "RESULTADO DO POST: ${resp.statusLine}"
				// assert resp.statusLine.statusCode == 201
				 }
						 
			  
		//		 resp.headers.each { h ->
		//		  message = "RESULTADO DO POST ${h.name} : ${h.value}"
		//	 }
				 
 
		    
		}*/
		
		
		
		

		// TESTE 7

		
		/*	http.request( POST ) { req ->
			
			uri.path = '/sistemas/rastreamento'
			requestContentType = URLENC
			postBody = [ name: 'frm1' , title: 'Rastrear Pedido' ]
			
			response.success = { resp ->
	
				println "RESULTADO DO POST: ${resp.statusLine}"
				assert resp.statusLine.statusCode == 201
			}
			
			response.'404' = { resp ->
			   
				println 'Not found'
			}
				
		} */
					

		
		
		// TESTE 8
		
		/*
		http.request( POST )
		{ req ->
		
        	
			
			uri.path = '/sistemas/rastreamento'
			requestContentType = URLENC
			postBody = [ name: numPedido , title: 'Rastrear Pedido' ]
			
				response.success =
				{ resp, reader ->
					assert resp.status == 200
					println "Resposta obtida: ${resp.statusLine}"
					println "Tamanho da resposta: ${resp.headers.'Content-Length'}"
					message = "Resposta obtida: ${resp.statusLine}"
					System.out << reader // print response reader
				 
				}
			 
				response.'404' =
				{ resp ->
				  
				   message = "Não encontrado!!!"
				   println 'Not found'
				}
				
	   }*/
		
		
		
		// TESTE 9
			 
		/*	http.request( POST )
			{ req ->
			
				  uri.path = '/sistemas/rastreamento/' 
				  uri.query = [ v:'1.0', q: numPedido ]
				 // headers.'User-Agent' = 'Mozilla/5.0'
				 
				    response.success = 
					{ resp, reader ->
						assert resp.status == 200
						println "Resposta obtida: ${resp.statusLine}"
						println "Tamanho da resposta: ${resp.headers.'Content-Length'}"
					    message = "Resposta obtida: ${resp.statusLine}"
						System.out << reader // print response reader
					 
				    }
				 
				   // called only for a 404 (not found) status code:
					response.'404' = 
					{ resp ->
					  
					   message = "Não encontrado!!!"
					   println 'Not found'
				    }
					
		   } 
			*/
		
		
		// TESTE 10 
		
		/*try {
			http2.request(POST,JSON) {
				body =  [
					PARTNER:'PayPal',
					VENDOR:'yyy',
					USER:'yyy',
					PWD:'xxx',
					TRXTYPE:'S',
					MODE:'TEST',
					AMT:'40',
					CREATESECURETOKEN:'Y',
					SECURETOKENID:'xxx'
				]
				requestContentType = URLENC
				println "Issued the post waiting for the response"

				response.success = { resp, any ->
					println "in success code"
					msg1 = "My response handler got response: ${resp.statusLine}"
					println "Response length: ${resp.headers.'Content-Length'}"
					assert resp.status == 200

					def result = any.results;

					render(view: "rastrearPedido", model: [message: "Request sent", result: result]);
				}
				println "past the success code"
			}//end of request
		} catch (groovyx.net.http.HttpResponseException ex) {
			println "Had response exception ...."
			ex.printStackTrace()
			return null
		} catch (java.net.ConnectException ex) {
			println "Had connection exception ...."
			ex.printStackTrace()
			return null
		}

		finally {
			http.shutdown()
		}*/
		
		
		// TESTE 11
			
			
		/*
			def http = new HTTPBuilder( 'http://twitter.com/statuses/' )
			// auth omitted...
			def postBody = [status:'update!',source:'httpbuilder'] // will be url-encoded
			 
			http.post( path: 'update.xml', body: postBody,
					   requestContentType: URLENC )
			{ resp ->
			 se status: ${resp.statusLine}"
			  assert resp.statusLine.statusCode == 200
			}
			*/
			
		
	//	TESTE 12
		
		/*http4.get( path : '/search',	contentType : TEXT,	query : [q:'sbt'] ) { resp, reader ->
	   
		//message = "response status: ${resp.statusLine}"	
		println   "response status: ${resp.statusLine}"
		println   'Headers: -----------'
		resp.headers.each { h ->
			
		  message =	"RESULTADO ${h.name} : ${h.value}"
		  println   " ${h.name} : ${h.value}"
		}
		println 'Response data: -----'
		System.out << reader
		println '\n--------------------'
  }*/
		
		
	// TESTE 13	
		
	/*	def rest = "http://www.dhl.com.br/pt/express/rastreamento.html/"
		def response= rest.post("content",[header:'trackingIndex'],[query:'${numPedido}'])
		response= rest.get([header:'trackingIndex'],[query:'${numPedido}'])
		message = "RESULTADO: ${response}"
		
		*/
		
		
		// TESTE 14 OK DEU CERTO !!!

	   http5.request( GET, TEXT ) { req ->
	   
		   
		 // executed for all successful responses:
		 response.success = { resp, reader   ->
		
		   println 'my response handler!'
		   assert resp.statusLine.statusCode == 200
           println resp.statusLine
		  
		    file << reader 
		   //   System.out << reader // print response stream
		 
			
			file.eachLine { line ->
				
			   linhasArq = linhasArq + line + "\n"
			}
		
			writer.write( linhasArq )
			writer.close()
			
		    leLocalizaoPedido() 
			
		 }
		 
		 // executed only if the response status code is 401:
		 response.'404' = { resp ->
		   println 'not found!'
		 }
	   }
		
	   

				
		
		// TESTE 15 OK
		
			
		
		/*   http6.request( 'http://www.correios.com.br', GET, JSON ) {
			     uri.path = '/sistemas/rastreamento/default.cfm'
			     uri.query = [ v:'1.0', q: 'SS123456789BR' ]
			
			     response.success = { resp, json ->
			       assert json.size() == 3
			       println "Query response: "
			       json.responseData.results.each {
			         println "  ${it.titleNoFormatting} : ${it.visibleUrl}"
			       }
			     }
			   }*/
		
		
		
	/*	render msg1 + "<br/>"  // Entrega a mensagem para a View
		render msg2 + "<br/>"
		render msg3 + "<br/>"
		render msg4 + "<br/>"
		render msg5 
		*/	
	}

	
	/*def rastrearPedido(Integer numPedido)
	{
		def message = "NENHUMA RESPOSTA!!!"
	    println new Http().get("http://code.google.com/p/groovy-http").text
		println new Http().get("http://search.yahoo.com").getForm().submit(p: 'Groovy HTTP').text
			
		
		render message	
			
	}*/
	
	def _rastrearPedido( String numPedido )
	{
		String data        = null
		String local       = null
		String situacao    = null
		String descricao   = null
	    String num         = null
		
	   new File( "resources/PEDIDOS.txt" ).eachLine { line ->
	 	  
		    String delimitador =  "|"
		    StringTokenizer st = new StringTokenizer( line , delimitador )
			
			
			 while ( st.hasMoreTokens() )
				{
						
				   if( numPedido.equals( st.nextToken() ) )
				   {
					   num       = numPedido
					   data      = st.nextToken()
					   local     = st.nextToken()
					   situacao  = st.nextToken()
					   descricao = st.nextToken()
					
					  println "\n\n\n\n============================================="    
				      println "NUM PEDIDO RASTREADO:" + num  
					  println "DATA:"                 + data 
					  println "LOCAL:"                + local
					  println "SITUACAO:"             + situacao
					  println "DESCRICAO: "           + descricao
					  println "=============================================\n\n\n\n"
					  
				   }
				   
				   println ""
				}
	   }
	   
	   if( num == null )
	     render( view: "pedidoNaoEncontrado" )
	   
	   
	   [ numPedido: num , data: data , local: local , situacao: situacao , descricao: descricao ]
	   
	}
		
	def leLocalizaoPedido()
	{
		List< String > lstDatas           = new ArrayList< String >()
		List< String > lstLocais          = new ArrayList< String >()
		List< String > lstSituacoes       = new ArrayList< String >()
		List< String > lstDescricoes      = new ArrayList< String >()
		List< String > lstLinhasLidas     = new ArrayList< String >()
		String         linhasArq          = "" 
		String         linha              = "" 
		Integer        qtdLinhasLst       = 0
		Integer        qtdLinhasLidas     = 0
		Integer        qtdcaracteresMaior = 0
		Integer[]      qtdcaracteresMenor = new Integer[ 4 ] 
		Integer        tamLista           = 0
		Integer        indice             = 0
		Integer        j                  = 0
		Integer        k                  = 0
		Integer        l                  = 0
		Integer        m                  = 0
		
		lstDatas.add( "" )
		lstLocais.add( "" )
		lstSituacoes.add( "" )
		lstDescricoes.add( "" )
		qtdcaracteresMenor[ 0 ] = 0 
		qtdcaracteresMenor[ 1 ] = 0
		qtdcaracteresMenor[ 2 ] = 0
		qtdcaracteresMenor[ 3 ] = 0
		
			
			
			try
			{
				
				FileInputStream fstream = new FileInputStream( file )                         
				BufferedReader  br      = new BufferedReader( new InputStreamReader( fstream ) ) 
				String          strLine = null                                                  
	
												
					while ( (  ( strLine = br.readLine() ) != null ) && ( !  ( strLine.equals( "</TABLE>" ) ) ) )
					{
					 	qtdLinhasLidas++
								
					   if( qtdLinhasLidas >= 69 )
					   {
						      lstLinhasLidas.add( strLine )
							  qtdLinhasLst++
					   }
					}
				
				 fstream.close()
				 br.close()	
				
			}
			catch( FileNotFoundException e )
			{
			   e.printStackTrace()
			}
			catch( IOException e )
			{
			  e.printStackTrace()
			}
			
				
				 while( qtdLinhasLst != 0 )
				 {
					 linha = lstLinhasLidas.get( indice ) 
					 
					 for( int i = 0 ; i < linha.size() ; i++ )
					 {
					    if( linha.charAt( i ) == '>' )
						    qtdcaracteresMaior++
						 	   					 
					    if( ( qtdcaracteresMaior == 2 ) && ( linha.charAt( i ) != '>' ) && ( ( qtdLinhasLst % 2 ) == 0 ) )
						{
							if( linha.charAt( i ) == '<' )
							    qtdcaracteresMenor[ 0 ] = 1
							
								if( qtdcaracteresMenor[ 0 ] == 0 )						
						           lstDatas.set( j ,  lstDatas.get( j ) + linha.charAt( i ) )
						}
							
						else if( ( qtdcaracteresMaior == 4 ) && ( linha.charAt( i ) != '>' ) )
						{
							if( linha.charAt( i ) == '<' )
							    qtdcaracteresMenor[ 1 ] = 1
						
							if( qtdcaracteresMenor[ 1 ] == 0 )
						        lstLocais.set( k ,  lstLocais.get( k ) + linha.charAt( i ) )
						}
						
					   else if( ( qtdcaracteresMaior == 7 )  && ( linha.charAt( i ) != '>' ) )
					   {
						   if( linha.charAt( i ) == '<' )
						       qtdcaracteresMenor[ 2 ] = 1
					   
						   if( qtdcaracteresMenor[ 2 ] == 0 )
					           lstSituacoes.set( l ,  lstSituacoes.get( l ) + linha.charAt( i ) )
					   }
					   
					   else if( ( qtdcaracteresMaior == 2 ) && ( linha.charAt( i ) != '>' ) && ( ( qtdLinhasLst % 2 ) != 0 ) )
					   {
						   if( linha.charAt( i ) == '<' )
						       qtdcaracteresMenor[ 3 ] = 1
					   
						   if( qtdcaracteresMenor[ 3 ] == 0 )
					           lstDescricoes.set( ( m - 1 ) ,  lstDescricoes.get( ( m - 1 ) ) + linha.charAt( i ) )
					   }
					      
					 }
		              					 
			 		 qtdcaracteresMenor[ 0 ] = 0
					 qtdcaracteresMenor[ 1 ] = 0
					 qtdcaracteresMenor[ 2 ] = 0
					 qtdcaracteresMenor[ 3 ] = 0
					 qtdcaracteresMaior      = 0
			 		 qtdLinhasLst--
					 indice++
					 j++
					 k++
					 l++
					 m++
					 
					 if( qtdLinhasLst > 1 )
					 {
						 lstDatas.add( "" )
						 lstLocais.add( "" )
						 lstSituacoes.add( "" )
						 lstDescricoes.add( "" )
					 }
						  
				 }
					 
				tamLista = lstDatas.size()
				
				if( lstLocais.size() > tamLista )
					tamLista = lstLocais.size()
		 
				else if( lstSituacoes.size() > tamLista )
					tamLista = lstSituacoes.size()

			/*	lstDatas      = removerElemVazio( lstDatas ,  lstDatas.size() )
				lstDescricoes = removerElemVazio( lstDescricoes , lstDescricoes.size() )
				lstLocais     = removerElemVazio( lstLocais ,  lstLocais.size() )
				lstSituacoes - removerElemVazio( lstSituacoes  , lstSituacoes.size() )	
			*/

			   for( int i = 0 ; i < tamLista ; i++ )
			   {
				   
				   if(  i % 2 == 0 )
				   {
					   println "==================================="
					   println "INDICE: " + i
					   
					 					  println "DATA                              LOCAL                        SITUACAO         DESCRICAO"
						  println "|" + lstDatas.get( i )         + "|    |" +
						                lstLocais.get( i )        + "|    |" +
								        lstSituacoes.get( i )     + "|    |" +
								        lstDescricoes.get( i )    + "|"
					 		
						 println "==================================="
				   }
					 
			  }
			
		[lstDatas: lstDatas , lstLocais: lstLocais , lstSituacoes: lstSituacoes , lstDescricoes: lstDescricoes]				
	}
	
	
	def pedidoNaoEncontrado()
	{}
	
	
/*	def removerElemVazio( List< String > lst ,  Integer tam )
	{
		for( int i = 0 ; i < lst.size() ; i++ )
		   if( lst.get( i ).equals( "" ) )
		      lst.remove( i )
			  
		   return lst	  
		
	}*/
	
}
