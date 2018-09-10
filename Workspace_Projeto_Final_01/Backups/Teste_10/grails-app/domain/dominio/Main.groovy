package dominio


class Main 
{
	
	public static void main( String[] args )
	{
		
		List< Produto > lst = new ArrayList< Produto >()
		Produto          p1 = new Produto( numProduto: 15 , nomeProduto: "Sabao de Coco" )
		
		
		  for( int i = 0 ; i < 10 ; i++ )
			  {
				  lst.add( p1 )
				  println lst.get( i ).getNumProduto() + lst.get( i ).getNomeProduto()
			  }

		 def pedido_01 = new Pedido( numPedido: 1 , lstNomeProdutos: lst , qtdProdutos: 10 , valorPedido: "100.00" )
		  //.save( failOnError: true  )
		
		
		for( int i = 0 ; i < 10 ; i++ )
	       println  pedido_01.getNumPedido() + pedido_01.getLstNomeProdutos().get( i ).getNumProduto() + pedido_01.getLstNomeProdutos().get( i ).getNomeProduto() + pedido_01.getQtdProdutos() + pedido_01.getValorPedido()	
		
		/*
		
		   def db = [ url: 'jdbc:mysql://localhost/TESTE1' , user: 'Dagvaldo' , password: '123' , drive: 'com.mysql.jdbc.Driver' ]
		   def sql = Sql.newInstance(db.url, db.user, db.password, db.driver)
		   
		   sql.execute( " INSERT INTO cliente VALUES (" + "RODRIGO TESTESS" , 15 + ")" )   
		   
		   */
		
	}


}
