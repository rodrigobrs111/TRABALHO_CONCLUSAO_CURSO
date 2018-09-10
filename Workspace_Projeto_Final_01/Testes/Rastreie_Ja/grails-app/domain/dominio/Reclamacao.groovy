package dominio

import java.util.Date;

class Reclamacao 
{
	int                   numReclamacao
	Date                  dataAbertura
	Date                  dataResposta
	Date                  dataSolucaoProblema
	String                status 	
	String                comentario
	Pedido                pedido
	SupervisorDoVarejista supervisorDoVarejista
		
	static constraints = {}
	
	
	public Reclamacao( int numReclamacao ,  Date dataAbertura ,
		                Date dataResposta , Date dataSolucaoProblema , String status , 
						String comentario , Pedido pedido , SupervisorDoVarejista supervisorDoVarejista )
	{
		this.numReclamacao         = numReclamacao         ;
		this.dataAbertura          = dataAbertura          ;
		this.dataResposta          = dataResposta          ;
		this.dataSolucaoProblema   = dataSolucaoProblema   ;
		this.status                = status                ;  
		this.comentario            = comentario            ;
		this.pedido                = pedido                ;
		this.supervisorDoVarejista = supervisorDoVarejista ;
	}
}
