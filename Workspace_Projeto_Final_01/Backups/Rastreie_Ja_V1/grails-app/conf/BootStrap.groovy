import dominio.* 

class BootStrap 
{

    def init = 
	{ 
		servletContext ->
	
		def  prod	
		def  pedido
		def  reclamcao
		def sugestao
		Date data      = new Date()
	    int  cont      = 0
		int  cont2     = 1

		  for( int i = 0; i < 10 ; i ++ )
		  {
		      for( int j = 0; j < 10 ; j ++ )
			  {
		         prod      = new Produto(    numProduto:    cont++ , nomeProduto: "PRODUTO_" + cont ).save( failOnError: true )
				 pedido    = new Pedido(     numPedido:     cont2  , qtdProdutos: 10     , valorPedido: 10.00 , status: "NAO_AUTORIZADO" , produto: prod ).save( failOnError: true )
				 reclamcao = new Reclamacao( numReclamacao: cont   , numPedido:   cont   , dataAbertura: data , dataResposta: ( data + 10 ) , dataSolucaoProblema: ( data + 20 ) ).save( failOnError: true )		
				 sugestao  = new Sugestao(   numSugestao:   cont   , descSugestao: "OLA GOSTARIA QUE TIVESSE UM DETERMINADO PRODUTO CHAMADO BLABLALBLA........................."  ).save( failOnError: true )		 
				 
			  }
			  cont2++
		  }
		  
		  
		   
    }
    def destroy = {}
}
