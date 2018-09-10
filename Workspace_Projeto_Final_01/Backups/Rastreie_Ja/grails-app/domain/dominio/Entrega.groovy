package dominio

import java.util.Date;

class Entrega 
{
	
	Date               dataSolicitacao
	Date               dataEntrega
	Date               dataRecebimento
	Date               dataEncerramento
	String             status
	String             classificacao
	float              valorEntrega
	Consumidor         consumidor
	GerenteDoVarejista gerenteDoVarejista	
	
	static constraints = {}




	public Entrega( Date dataSolicitacao , Date dataEntrega ,
			Date dataRecebimento , Date dataEncerramento , String status ,
			String classificacao , float valorEntrega , Consumidor consumidor ,
			GerenteDoVarejista gerenteDoVarejista )
	 {
		this.dataSolicitacao    = dataSolicitacao    ;
		this.dataEntrega        = dataEntrega        ;
		this.dataRecebimento    = dataRecebimento    ;
		this.dataEncerramento   = dataEncerramento   ;
		this.status             = status             ;
		this.classificacao      = classificacao      ;
		this.valorEntrega       = valorEntrega       ;
		this.consumidor         = consumidor         ;
		this.gerenteDoVarejista = gerenteDoVarejista ;
	}

	 
	 public Entrega(Date dataSolicitacao, Date dataEntrega,  String status, String classificacao, float valorEntrega)
	 {
		 this.dataSolicitacao  = dataSolicitacao  ;
		 this.dataEntrega      = dataEntrega      ;
		 this.status           = status           ;
		 this.classificacao    = classificacao    ;
		 this.valorEntrega     = valorEntrega     ;
	 }


}
