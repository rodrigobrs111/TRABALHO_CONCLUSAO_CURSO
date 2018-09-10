package dominio

/**
 * Produto
 * A domain class describes the data object and it's mapping to the database
 */
class Produto 
{
	int    numProduto
	String nomeProduto 
	
	static constraints = {}


	public Produto(int numProduto, String nomeProduto) 
	{
		this.numProduto = numProduto;
		this.nomeProduto = nomeProduto;
	}	

}
