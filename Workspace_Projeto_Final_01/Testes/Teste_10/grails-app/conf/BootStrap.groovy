import java.util.List;
import dominio.Pedido
import dominio.Produto;


class BootStrap
{

    def init = 
	{ servletContext ->
		
		
		List< Produto > lst = new ArrayList< Produto >()
	    Produto          p1 = new Produto( numProduto: 15 , nomeProduto: "Sabao de Coco" )  
        
	      for( int i = 0 ; i < 10 ; i++ )	
             lst.add(  p1 )				
			
		def pedido_01 = new Pedido( numPedido: 1 , lstNomeProdutos: lst , qtdProdutos: 10 , valorPedido: "100.00" ).save()
		
    }
    def destroy = {}
}
