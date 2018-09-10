package dominio

class Distribuidor 
{
	
	int                   numDist
	String                nomeDist
	String                senha
	String                confirmaSenha
	SupervisorDoVarejista supervisorDoVarejista
	
	
	static constraints = {}


	public Distribuidor( int numDist , String nomeDist , String senha ,
			String confirmaSenha , SupervisorDoVarejista supervisorDoVarejista ) 
	{
		this.numDist               = numDist               ; 
		this.nomeDist              = nomeDist              ;
		this.senha                 = senha                 ;
		this.confirmaSenha         = confirmaSenha         ;
		this.supervisorDoVarejista = supervisorDoVarejista ;
	}


	
	

}
