package dominio

class Produto 
{
	int    numProduto
	String nomeProduto
		
	static constraints = {}


	public Produto( int numProduto , String nomeProduto )
	{
		this.numProduto  = numProduto  ;
		this.nomeProduto = nomeProduto ;
	}
}
