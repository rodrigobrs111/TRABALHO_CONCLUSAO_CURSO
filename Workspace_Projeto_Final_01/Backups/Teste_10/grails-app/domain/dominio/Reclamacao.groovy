package dominio

import java.util.Date;

/**
 * Reclamacao
 * A domain class describes the data object and it's mapping to the database
 */
class Reclamacao 
{
     
    int  numPedido 
	Date dataAbertura	
	Date dataResposta
	Date dataSolucaoProblema
	
	
	static constraints = {}


	public Reclamacao(int numPedido, Date dataAbertura, Date dataResposta,
			Date dataSolucaoProblema) 
	{
		this.numPedido = numPedido;
		this.dataAbertura = dataAbertura;
		this.dataResposta = dataResposta;
		this.dataSolucaoProblema = dataSolucaoProblema;
	}
	
	
}

