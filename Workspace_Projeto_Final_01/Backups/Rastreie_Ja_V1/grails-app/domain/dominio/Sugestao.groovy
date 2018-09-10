package dominio


class Sugestao 
{
    
	int    numSugestao
    String descSugestao
		
	static constraints = {}

	public Sugestao(int numSugestao, String descSugestao) 
	{
		this.numSugestao = numSugestao;
		this.descSugestao = descSugestao;
	}

	 
}
