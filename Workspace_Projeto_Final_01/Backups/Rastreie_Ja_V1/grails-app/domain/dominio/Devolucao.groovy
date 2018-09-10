package dominio

class Devolucao 
{
	
	int   numDevol
	int   numPedido
	float valorDevol
    
	static constraints = {}

	public Devolucao(int numDevol, int numPedido, float valorDevol) 
	{
		this.numDevol = numDevol;
		this.numPedido = numPedido;
		this.valorDevol = valorDevol;
	}	

	
}
