import dominio.*  

class BootStrap 
{

  
	def init = 
	{ 
		servletContext ->
	
		List< Produto > lstProdutos	= new ArrayList< Produto >()
		def pedido
		def reclamcao
		def sugestao
        def consumidor
		def distribuidor
		def funcDaTransp
		def funcDoVarejista
		def gerenDoVarej
		def supervDoVarej
		Date data           = new Date()
		Date c              = new Date()
	    int cont            = 0
		int cont2           = 1
		int cont3           = 1

		
		  for( int i = 0; i < 10 ; i ++ )
		  {
		      for( int j = 0; j < 10 ; j ++ )
			  {
				  
				  for( int k = 0 ; k < 10 ; k++ )
				  {
					 cont++ 
					 
			         lstProdutos.add(  new Produto(    numProduto:    cont  , nomeProduto: "PRODUTO_" + cont ).save( failOnError: true ) )
					 reclamcao       = new Reclamacao( numReclamacao: cont  , numPedido:   cont   , dataAbertura: data , dataResposta: ( data + 10 ) , dataSolucaoProblema: ( data + 20 ) ).save( failOnError: true )		
					 sugestao        = new Sugestao(   numSugestao:   cont  , descSugestao: "OLA GOSTARIA QUE TIVESSE UM DETERMINADO PRODUTO CHAMADO BLABLALBLA........................."  ).save( failOnError: true )		 
					 distribuidor    = new Distribuidor( numDist: "1000" + cont , nomeDist: "USUARIO_" + cont , senha: "123" , confirmaSenha: "123" ).save( failOnError: true )
					 consumidor      = new Consumidor( matricula: "2000" + cont , nomeConsum: "USUARIO_" + cont , senha: "123" , confirmaSenha: "123", email: "usuario1321@gmail.com", sexo: "MASCULINO" , nasc: ( c - 20000) , tel: "2547-1155", end: "Praca das xxxyyyyzzz 1005" , comp:"660" , cep: "220-31-000", cidade: "Rio de Janeiro", estado: "RJ", bairro: "Catete" ).save( failOnError: true )
					 funcDaTransp    = new FuncionarioDaTransportadora( matricula: "3000" + cont , nomeFuncTransp: "USUARIO_" + cont , senha: "123" , confirmaSenha: "123", email: "usuario1321@gmail.com", sexo: "MASCULINO" , nasc: ( c -20000) , tel: "2547-1155", end: "Praca das xxxyyyyzzz 1005" , comp:"660" , cep: "220-31-000", cidade: "Rio de Janeiro", estado: "RJ", bairro: "Catete" ).save( failOnError: true )
					 funcDoVarejista = new  FuncionarioDoVarejista( matricula: "4000" + cont , nomeFuncVarej: "USUARIO_" + cont , senha: "123" , confirmaSenha: "123", email: "usuario1321@gmail.com", sexo: "MASCULINO" , nasc: ( c - 15000 ) , tel: "2547-1155", end: "Praca das xxxyyyyzzz 1005" , comp:"660" , cep: "220-31-000", cidade: "Rio de Janeiro", estado: "RJ", bairro: "Catete" ).save( failOnError: true )
				  }
				  pedido          = new Pedido( numPedido: cont2 , qtdProdutos: 10     , valorPedido: 10.00 , status: "NAO_AUTORIZADO" , lstProdutos: lstProdutos ).save( failOnError: true )
				  supervDoVarej   = new SupervisorDoVarejista( matricula: "5000" + cont2 , nomeSupervisorVarej: "USUARIO_" + cont2 , senha: "123" , confirmaSenha: "123", email: "usuario1321@gmail.com", sexo: "MASCULINO" , nasc: ( c -18000 ), tel: "2547-1155", end: "Praca das xxxyyyyzzz 1005" , comp:"660" , cep: "220-31-000", cidade: "Rio de Janeiro", estado: "RJ", bairro: "Catete" ).save( failOnError: true )
				  cont2++
			  }
			  gerenDoVarej    = new GerenteDoVarejista( matricula: "6000" + cont3 , nomeGerenteVarej: "USUARIO_" + cont3 , senha: "123" , confirmaSenha: "123", email: "usuario1321@gmail.com", sexo: "MASCULINO" , nasc: ( c - 30000 ), tel: "2547-1155", end: "Praca das xxxyyyyzzz 1005" , comp:"660" , cep: "220-31-000", cidade: "Rio de Janeiro", estado: "RJ", bairro: "Catete" ).save( failOnError: true )
			  cont3++
		  }
		  
    }
    def destroy = {}

	
	
}
