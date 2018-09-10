package dominio

import java.util.Date;

class Reclamacao 
{
	int  numReclamacao
	int  numPedido
	Date dataAbertura
	Date dataResposta
	Date dataSolucaoProblema
		
		
	static constraints = {}
	
	
	public Reclamacao( int numReclamacao , int numPedido , Date dataAbertura , Date dataResposta , Date dataSolucaoProblema )
	{
		this.numReclamacao       = numReclamacao       ;
		this.numPedido           = numPedido           ;
		this.dataAbertura        = dataAbertura        ;
		this.dataResposta        = dataResposta        ;
		this.dataSolucaoProblema = dataSolucaoProblema ;
	}
}
