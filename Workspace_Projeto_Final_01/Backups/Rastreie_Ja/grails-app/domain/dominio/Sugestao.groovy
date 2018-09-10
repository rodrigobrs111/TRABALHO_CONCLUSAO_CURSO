package dominio


class Sugestao 
{
    
	int        numSugestao
    String     descSugestao
	Consumidor consumidor
		
	static constraints = {}

	public Sugestao( int numSugestao, String descSugestao , Consumidor consumidor ) 
	{
		this.numSugestao  = numSugestao  ;
		this.descSugestao = descSugestao ;
		this.consumidor   = consumidor   ;
	}

	 
}
