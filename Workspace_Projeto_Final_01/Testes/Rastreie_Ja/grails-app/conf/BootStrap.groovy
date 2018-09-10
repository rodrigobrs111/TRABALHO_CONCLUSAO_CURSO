import dominio.*    
/*
import javax.management.ObjectName
import javax.management.remote.JMXConnectorFactory as JmxFactory
import javax.management.remote.JMXServiceURL as JmxUrl
import org.jfree.chart.ChartFactory
import org.jfree.data.category.DefaultCategoryDataset as Dataset
import org.jfree.chart.plot.PlotOrientation as Orientation
import groovy.swing.SwingBuilder
import javax.swing.WindowConstants as WC
*/
class BootStrap 
{

  
	def init = 
	{ 
		servletContext ->
	
		List< Produto > lstProdutos     = new ArrayList< Produto >()
		def             produto 	     = null
		def             pedido          = null 
		def             entrega         = null
		def             reclamcao       = null
		def             sugestao        = null
        def             consumidor      = null
		def             distribuidor    = null
		def             transportadora  = null
		def             funcDaTransp    = null  
 		def             funcDoVarejista = null
		def             gerenDoVarej    = null
 		def             supervDoVarej   = null 
		def             troca           = null
		def             devolucao       = null 
		Date            data           = new Date()
		Date            c              = new Date()
	    int             cont            = 1
		int             cont2           = 1
		int             cont3           = 1
		int             cont4           = 1
		int             cont5           = 1 
		int             contPedido      = 1    
		
		  for( int i = 0; i < 10 ; i ++ )
		  {
		      for( int j = 0; j < 1 ; j ++ )
			  {
				  
				  for( int k = 0 ; k < 1 ; k++ )
				  {
	
				     supervDoVarej  = new SupervisorDoVarejista( matricula: "5000" + cont2 , nomeSupervisorVarej: "SUPERVIDOR_VAREJ_" + cont2 , senha: "123" , confirmaSenha: "123", email: "rodrigobrs123@gmail.com", sexo: "MASCULINO" , nasc: ( c -18000 ), tel: "2547-1155", end: "Praca das xxxyyyyzzz 1005" , comp:"660" , cep: "220-31-000", cidade: "Rio de Janeiro", estado: "RJ", bairro: "Catete" ).save( failOnError: true )
					 cont2++
 					 
					 transportadora  = new Transportadora( numTransp: cont2 , nomeTransp: "TRANSPORTADORA_" + cont2 ).save( failOnError: true )
					 funcDaTransp    = new FuncionarioDaTransportadora( matricula: "3000" + cont5 , nomeFuncTransp: "FUNC_DA_TRANSP_" + cont5 , senha: "123" , confirmaSenha: "123", email: "rodrigobrs123@gmail.com", sexo: "MASCULINO" , nasc: ( c -20000) , tel: "2547-1155", end: "Praca das xxxyyyyzzz 1005" , comp:"660" , cep: "220-31-000", cidade: "Rio de Janeiro", estado: "RJ", bairro: "Catete" ).save( failOnError: true )
					 funcDoVarejista = new  FuncionarioDoVarejista( matricula: "4000" + cont5 , nomeFuncVarej: "FUNC_DO_VAREJ_" + cont5 , senha: "123" , confirmaSenha: "123", email: "rodrigobrs123@gmail.com", sexo: "MASCULINO" , nasc: ( c - 15000 ) , tel: "2547-1155", end: "Praca das xxxyyyyzzz 1005" , comp:"660" , cep: "220-31-000", cidade: "Rio de Janeiro", estado: "RJ", bairro: "Catete" , supervisorDoVarejista: supervDoVarej ).save( failOnError: true )
					 cont5++
					 
					 gerenDoVarej    = new GerenteDoVarejista( matricula: "6000" + cont3 , nomeGerenteVarej: "GERENTE_VAREJ_" + cont3 , senha: "123" , confirmaSenha: "123", email: "rodrigobrs123@gmail.com", sexo: "MASCULINO" , nasc: ( c - 30000 ), tel: "2547-1155", end: "Praca das xxxyyyyzzz 1005" , comp:"660" , cep: "220-31-000", cidade: "Rio de Janeiro", estado: "RJ", bairro: "Catete" ).save( failOnError: true )
					 cont3++
					 
					   for( int l = 0 ; l < 10 ; l++ )
					   {
					     produto  = new Produto(    numProduto: cont++  , nomeProduto: "PRODUTO_" + cont ).save( failOnError: true )
						 println "NUM PRODUTO: " + produto.getNumProduto() + "    NOME PRODUTO: " + produto.getNomeProduto() 
						 
                     	 lstProdutos.add( produto )
					   }
					   
					   

					     
					 consumidor      = new Consumidor( matricula: "2000" + cont3 , nomeConsum: "CONSUMIDOR_" + cont3 , senha: "123" , confirmaSenha: "123", email: "rodrigobrs123@gmail.com", sexo: "MASCULINO" , nasc: ( c - 20000) , tel: "2547-1155", end: "Praca das xxxyyyyzzz 1005" , comp:"660" , cep: "220-31-000", cidade: "Rio de Janeiro", estado: "RJ", bairro: "Catete" ).save( failOnError: true )
					 
					 entrega = new Entrega(dataSolicitacao: data , dataEntrega: ( data -50 ) , dataRecebimento: ( data - 50 ), dataEncerramento: data , status: "AUTORIZADO" , classificacao: "MUITO_RUIM" , valorEntrega: ( 10 * 10 ) , consumidor: consumidor , gerenteDoVarejista: gerenDoVarej ).save( failOnError: true )
					 pedido  = new Pedido( numPedido: contPedido++ , qtdProdutos: 10     , valorPedido: 10.00 ,   lstProdutos: lstProdutos , entrega: entrega , transportadora: transportadora , funcionarioDaTransportadora: funcDaTransp ).save( failOnError: true )
					 entrega = new Entrega(dataSolicitacao: data , dataEntrega: ( data - 20 ) , dataRecebimento: ( data - 20 ) , dataEncerramento: data , status: "AUTORIZADO" , classificacao: "RUIM" , valorEntrega: ( 10 * 10 ) , consumidor: consumidor , gerenteDoVarejista: gerenDoVarej ).save( failOnError: true )
					 pedido  = new Pedido( numPedido: contPedido++ , qtdProdutos: 10     , valorPedido: 10.00 ,   lstProdutos: lstProdutos , entrega: entrega , transportadora: transportadora , funcionarioDaTransportadora: funcDaTransp ).save( failOnError: true )
					 entrega = new Entrega(dataSolicitacao: data , dataEntrega: ( data      ) , dataRecebimento: ( data    ) , dataEncerramento: data , status: "AUTORIZADO" , classificacao: "REGULAR" , valorEntrega: ( 10 * 10 ) , consumidor: consumidor , gerenteDoVarejista: gerenDoVarej ).save( failOnError: true )
					 pedido  = new Pedido( numPedido: contPedido++ , qtdProdutos: 10     , valorPedido: 10.00 ,   lstProdutos: lstProdutos , entrega: entrega , transportadora: transportadora , funcionarioDaTransportadora: funcDaTransp ).save( failOnError: true )
					 entrega = new Entrega(dataSolicitacao: data , dataEntrega: ( data + 40 ), dataRecebimento: ( data + 40 ) , dataEncerramento: data , status: "AUTORIZADO" , classificacao: "BOM" , valorEntrega: ( 10 * 10 ) , consumidor: consumidor , gerenteDoVarejista: gerenDoVarej ).save( failOnError: true )
					 pedido  = new Pedido( numPedido: contPedido++ , qtdProdutos: 10     , valorPedido: 10.00 ,   lstProdutos: lstProdutos , entrega: entrega , transportadora: transportadora , funcionarioDaTransportadora: funcDaTransp ).save( failOnError: true )
					 entrega = new Entrega(dataSolicitacao: data , dataEntrega: ( data + 70 ) , dataRecebimento: ( data + 70 ) , dataEncerramento: data , status: "AUTORIZADO" , classificacao: "MUITO_BOM" , valorEntrega: ( 10 * 10 ) , consumidor: consumidor , gerenteDoVarejista: gerenDoVarej ).save( failOnError: true )
					 pedido  = new Pedido( numPedido: contPedido++ , qtdProdutos: 10     , valorPedido: 10.00 ,   lstProdutos: lstProdutos , entrega: entrega , transportadora: transportadora , funcionarioDaTransportadora: funcDaTransp ).save( failOnError: true )
					 entrega = new Entrega(dataSolicitacao: data , dataEntrega: ( data + 100 ) , dataRecebimento: ( data + 100 ) , dataEncerramento: data , status: "AUTORIZADO" , classificacao: "EXCELENTE" , valorEntrega: ( 10 * 10 ) , consumidor: consumidor , gerenteDoVarejista: gerenDoVarej ).save( failOnError: true )
					 pedido  = new Pedido( numPedido: contPedido++ , qtdProdutos: 10     , valorPedido: 10.00 ,   lstProdutos: lstProdutos , entrega: entrega , transportadora: transportadora , funcionarioDaTransportadora: funcDaTransp ).save( failOnError: true )
					 entrega = new Entrega(dataSolicitacao: data , dataEntrega: ( data + 130 ) , dataRecebimento: ( data + 130 ), dataEncerramento: data , status: "AUTORIZADO" , classificacao: "MUITO_RUIM" , valorEntrega: ( 10 * 10 ) , consumidor: consumidor , gerenteDoVarejista: gerenDoVarej ).save( failOnError: true )
					 pedido  = new Pedido( numPedido: contPedido++ , qtdProdutos: 10     , valorPedido: 10.00 ,   lstProdutos: lstProdutos , entrega: entrega , transportadora: transportadora , funcionarioDaTransportadora: funcDaTransp ).save( failOnError: true )
					 entrega = new Entrega(dataSolicitacao: data , dataEntrega: ( data + 160 ) , dataRecebimento: ( data + 160 ) , dataEncerramento: data , status: "AUTORIZADO" , classificacao: "RUIM" , valorEntrega: ( 10 * 10 ) , consumidor: consumidor , gerenteDoVarejista: gerenDoVarej ).save( failOnError: true )
					 pedido  = new Pedido( numPedido: contPedido++ , qtdProdutos: 10     , valorPedido: 10.00 ,   lstProdutos: lstProdutos , entrega: entrega , transportadora: transportadora , funcionarioDaTransportadora: funcDaTransp ).save( failOnError: true )
					 entrega = new Entrega(dataSolicitacao: data , dataEntrega: ( data + 190 ) , dataRecebimento: ( data + 190 ) , dataEncerramento: data , status: "AUTORIZADO" , classificacao: "REGULAR" , valorEntrega: ( 10 * 10 ) , consumidor: consumidor , gerenteDoVarejista: gerenDoVarej ).save( failOnError: true )
					 pedido  = new Pedido( numPedido: contPedido++ , qtdProdutos: 10     , valorPedido: 10.00 ,   lstProdutos: lstProdutos , entrega: entrega , transportadora: transportadora , funcionarioDaTransportadora: funcDaTransp ).save( failOnError: true )
					 entrega = new Entrega(dataSolicitacao: data , dataEntrega: ( data + 220 ), dataRecebimento: ( data + 220 ) , dataEncerramento: data , status: "AUTORIZADO" , classificacao: "BOM" , valorEntrega: ( 10 * 10 ) , consumidor: consumidor , gerenteDoVarejista: gerenDoVarej ).save( failOnError: true )
					 pedido  = new Pedido( numPedido: contPedido++ , qtdProdutos: 10     , valorPedido: 10.00 ,   lstProdutos: lstProdutos , entrega: entrega , transportadora: transportadora , funcionarioDaTransportadora: funcDaTransp ).save( failOnError: true )
					 entrega = new Entrega(dataSolicitacao: data , dataEntrega: ( data + 250 ) , dataRecebimento: ( data + 250 ) , dataEncerramento: data , status: "AUTORIZADO" , classificacao: "MUITO_BOM" , valorEntrega: ( 10 * 10 ) , consumidor: consumidor , gerenteDoVarejista: gerenDoVarej ).save( failOnError: true )
					 pedido  = new Pedido( numPedido: contPedido++ , qtdProdutos: 10     , valorPedido: 10.00 ,   lstProdutos: lstProdutos , entrega: entrega , transportadora: transportadora , funcionarioDaTransportadora: funcDaTransp ).save( failOnError: true )
					 entrega = new Entrega(dataSolicitacao: data , dataEntrega: ( data + 300 ) , dataRecebimento: ( data + 300 ) , dataEncerramento: data , status: "AUTORIZADO" , classificacao: "EXCELENTE" , valorEntrega: ( 10 * 10 ) , consumidor: consumidor , gerenteDoVarejista: gerenDoVarej ).save( failOnError: true )
					 pedido  = new Pedido( numPedido: contPedido++ , qtdProdutos: 10     , valorPedido: 10.00 ,   lstProdutos: lstProdutos , entrega: entrega , transportadora: transportadora , funcionarioDaTransportadora: funcDaTransp ).save( failOnError: true )
					 
					 
					 cont++
					 				 
					 reclamcao       = new Reclamacao( numReclamacao: cont4++  ,  dataAbertura: data , dataResposta: ( data + 10 ) , dataSolucaoProblema: ( data - 50 )  , status: "ATENDIDA" , comentario: "Tive um problema com o produto xpto que nao chegou ate agora!!!" , pedido: pedido , supervisorDoVarejista: supervDoVarej ).save( failOnError: true )
					 reclamcao       = new Reclamacao( numReclamacao: cont4++  ,  dataAbertura: data , dataResposta: ( data + 10 ) , dataSolucaoProblema: ( data - 20 )  , status: "ATENDIDA" , comentario: "Tive um problema com o produto xpto que nao chegou ate agora!!!" , pedido: pedido , supervisorDoVarejista: supervDoVarej ).save( failOnError: true )
					 reclamcao       = new Reclamacao( numReclamacao: cont4++  ,  dataAbertura: data , dataResposta: ( data + 10 ) , dataSolucaoProblema: ( data      )  , status: "ATENDIDA" , comentario: "Tive um problema com o produto xpto que nao chegou ate agora!!!" , pedido: pedido , supervisorDoVarejista: supervDoVarej ).save( failOnError: true )
					 reclamcao       = new Reclamacao( numReclamacao: cont4++  ,  dataAbertura: data , dataResposta: ( data + 10 ) , dataSolucaoProblema: ( data + 40 )  , status: "ATENDIDA" , comentario: "Tive um problema com o produto xpto que nao chegou ate agora!!!" , pedido: pedido , supervisorDoVarejista: supervDoVarej ).save( failOnError: true )
					 reclamcao       = new Reclamacao( numReclamacao: cont4++  ,  dataAbertura: data , dataResposta: ( data + 10 ) , dataSolucaoProblema: ( data + 70 )  , status: "ATENDIDA" , comentario: "Tive um problema com o produto xpto que nao chegou ate agora!!!" , pedido: pedido , supervisorDoVarejista: supervDoVarej ).save( failOnError: true )
					 reclamcao       = new Reclamacao( numReclamacao: cont4++  ,  dataAbertura: data , dataResposta: ( data + 10 ) , dataSolucaoProblema: ( data + 100 ) , status: "ATENDIDA" , comentario: "Tive um problema com o produto xpto que nao chegou ate agora!!!" , pedido: pedido , supervisorDoVarejista: supervDoVarej ).save( failOnError: true )
					 reclamcao       = new Reclamacao( numReclamacao: cont4++  ,  dataAbertura: data , dataResposta: ( data + 10 ) , dataSolucaoProblema: ( data + 130 ) , status: "ATENDIDA" , comentario: "Tive um problema com o produto xpto que nao chegou ate agora!!!" , pedido: pedido , supervisorDoVarejista: supervDoVarej ).save( failOnError: true )
					 reclamcao       = new Reclamacao( numReclamacao: cont4++  ,  dataAbertura: data , dataResposta: ( data + 10 ) , dataSolucaoProblema: ( data + 170 ) , status: "ATENDIDA" , comentario: "Tive um problema com o produto xpto que nao chegou ate agora!!!" , pedido: pedido , supervisorDoVarejista: supervDoVarej ).save( failOnError: true )
					 reclamcao       = new Reclamacao( numReclamacao: cont4++  ,  dataAbertura: data , dataResposta: ( data + 10 ) , dataSolucaoProblema: ( data + 200 ) , status: "ATENDIDA" , comentario: "Tive um problema com o produto xpto que nao chegou ate agora!!!" , pedido: pedido , supervisorDoVarejista: supervDoVarej ).save( failOnError: true )
					 reclamcao       = new Reclamacao( numReclamacao: cont4++  ,  dataAbertura: data , dataResposta: ( data + 10 ) , dataSolucaoProblema: ( data + 230 ) , status: "ATENDIDA" , comentario: "Tive um problema com o produto xpto que nao chegou ate agora!!!" , pedido: pedido , supervisorDoVarejista: supervDoVarej ).save( failOnError: true )
					 reclamcao       = new Reclamacao( numReclamacao: cont4++  ,  dataAbertura: data , dataResposta: ( data + 10 ) , dataSolucaoProblema: ( data + 260 ) , status: "ATENDIDA" , comentario: "Tive um problema com o produto xpto que nao chegou ate agora!!!" , pedido: pedido , supervisorDoVarejista: supervDoVarej ).save( failOnError: true )
					 reclamcao       = new Reclamacao( numReclamacao: cont4++  ,  dataAbertura: data , dataResposta: ( data + 10 ) , dataSolucaoProblema: ( data + 290 ) , status: "ATENDIDA" , comentario: "Tive um problema com o produto xpto que nao chegou ate agora!!!" , pedido: pedido , supervisorDoVarejista: supervDoVarej ).save( failOnError: true )
					 distribuidor    = new Distribuidor( numDist: "1000" + cont5 , nomeDist: "DISTRIBUIDOR_" + cont5 , senha: "123" , confirmaSenha: "123" , supervisorDoVarejista: supervDoVarej ).save( failOnError: true )
					 sugestao        = new Sugestao(   numSugestao:   cont++  , descSugestao: "OLA GOSTARIA QUE TIVESSE UM DETERMINADO PRODUTO CHAMADO BLABLALBLA........................." , consumidor: consumidor ).save( failOnError: true )
				 }

				 devolucao = new Devolucao( numDevol: cont , numPedido: ( cont + 10 ) , valorDevol: 50 , funcionarioDoVarejista: funcDoVarejista , transportadora: transportadora ).save( failOnError: true )
				 troca     = new Troca( numTroca: cont , numPedidoAnt: ( cont -1 ), numPedidoNovo: ( cont + 1 ) , dataSolicit: data , dataColeta: (data +  7) , dataEntregaVarej: (  data + 14 ) , dataEntregaConsumidor: (  data + 21 ) , valorTroca: 100 , pedido: pedido , consumidor: consumidor , devolucao: devolucao ).save( failOnError: true )
				  
				  
			  }
		}

		  entrega = new Entrega(dataSolicitacao: data , dataEntrega: ( data + 7 ) , dataRecebimento: ( data + 300 ) , dataEncerramento: data , status: "AUTORIZADO" , classificacao: "EXCELENTE" , valorEntrega: ( 10 * 10 ) , consumidor: consumidor , gerenteDoVarejista: gerenDoVarej ).save( failOnError: true )
		  pedido  = new Pedido( numPedido: contPedido++ , qtdProdutos: 10     , valorPedido: 10.00 ,   lstProdutos: lstProdutos , entrega: entrega , transportadora: transportadora , funcionarioDaTransportadora: funcDaTransp ).save( failOnError: true )
		  entrega = new Entrega(dataSolicitacao: data , dataEntrega: ( data + 3 ) , dataRecebimento: ( data + 300 ) , dataEncerramento: data , status: "AUTORIZADO" , classificacao: "EXCELENTE" , valorEntrega: ( 10 * 10 ) , consumidor: consumidor , gerenteDoVarejista: gerenDoVarej ).save( failOnError: true )
		  pedido  = new Pedido( numPedido: contPedido++ , qtdProdutos: 10     , valorPedido: 10.00 ,   lstProdutos: lstProdutos , entrega: entrega , transportadora: transportadora , funcionarioDaTransportadora: funcDaTransp ).save( failOnError: true )

	/*	  
		  def serverUrl = 'service:jmx:rmi:///jndi/rmi://localhost:9004/jmxrmi'
		  def server = JmxFactory.connect(new JmxUrl(serverUrl)).MBeanServerConnection
		  def serverInfo = new GroovyMBean(server, 'Catalina:type=Server').serverInfo
		  println "Connected to: $serverInfo"
		  
		  def query = new ObjectName('Catalina:*')
		  String[] allNames = server.queryNames(query, null)
		  def modules = allNames.findAll{ name ->
			  name.contains('j2eeType=WebModule')
		  }.collect{ new GroovyMBean(server, it) }
		  
		  println "Found ${modules.size()} web modules. Processing ..."
		  def dataset = new Dataset()
		  
		  modules.each{ m ->
			  println m.name()
			  dataset.addValue m.processingTime, 0, m.path
		  }
		  
		  def labels = ['Time per Module', 'Module', 'Time']
		  def options = [false, true, true]
		  def chart = ChartFactory.createBarChart(*labels, dataset,
						  Orientation.VERTICAL, *options)
		  def swing = new SwingBuilder()
		  def frame = swing.frame(title:'Catalina Module Processing Time',
				  defaultCloseOperation:WC.EXIT_ON_CLOSE) {
			  panel(id:'canvas') { rigidArea(width:600, height:250) }
		  }
		  frame.pack()
		  frame.show()
		  chart.draw(swing.canvas.graphics, swing.canvas.bounds)*/
		  	  
    }
    def destroy = {}

	 
	
}
