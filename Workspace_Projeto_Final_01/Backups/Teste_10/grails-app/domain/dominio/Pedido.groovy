package dominio

import java.util.List;

/**
 * Pedido
 * A domain class describes the data object and it's mapping to the database
 */
class Pedido 
{
    int             numPedido
	List< Produto > lstNomeProdutos = new ArrayList< Produto >()
	int             qtdProdutos
	float           valorPedido
    
	static constraints = {}

	public Pedido( int numPedido, List<Produto> lstNomeProdutos,
	    		   int qtdProdutos, float valorPedido)
	 {
		this.numPedido = numPedido;
		this.lstNomeProdutos = lstNomeProdutos;
		this.qtdProdutos = qtdProdutos;
		this.valorPedido = valorPedido;
	 }	
	
	

}
