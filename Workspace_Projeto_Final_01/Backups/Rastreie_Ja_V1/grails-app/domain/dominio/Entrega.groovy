package dominio

import java.util.Date;

class Entrega 
{
	
	int   numPedido
	Date  dataSolicit
	Date  dataEntrega
	float valorEntrega
	
	static constraints = {}


	public Entrega(int numPedido, Date dataSolicit, Date dataEntrega,
			float valorEntrega) 
	{
		this.numPedido = numPedido;
		this.dataSolicit = dataSolicit;
		this.dataEntrega = dataEntrega;
		this.valorEntrega = valorEntrega;
	}	
	

}
