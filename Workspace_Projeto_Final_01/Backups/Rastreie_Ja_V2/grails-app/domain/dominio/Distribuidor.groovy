package dominio

class Distribuidor 
{
	
	int    numDist
	String nomeDist
	String senha
	String confirmaSenha
	
	
	static constraints = {}


	public Distribuidor(int numDist , String nomeDist , String senha , String confirmaSenha) 
	{
		this.numDist       = numDist
		this.nomeDist      = nomeDist
		this.senha         = senha
		this.confirmaSenha = confirmaSenha
	}


	

}
