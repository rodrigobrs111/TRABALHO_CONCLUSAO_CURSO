package dominio

class Produto 
{
	int    numProduto
	int    codProduto
	String nomeProduto
	
		
	static constraints = {}


	public Produto( int numProduto , int codProduto , String nomeProduto )
	{
		this.numProduto  = numProduto  ;
		this.codProduto  = codProduto  ;
		this.nomeProduto = nomeProduto ;
	}
}
