package dominio

import java.util.Date;

class Troca 
{
	
	int   numTroca 
	int   numPedidoAnt
	int   numPedidoNovo
    Date  dataSolicit 
	Date  dataColeta
	Date  dataEntregaVarej
	Date  dataEntregaConsumidor
	float valorTroca
	
	static constraints = {}

	public Troca(int numTroca, int numPedidoAnt, int numPedidoNovo,
			Date dataSolicit, Date dataColeta, Date dataEntregaVarej,
			Date dataEntregaConsumidor, float valorTroca)
 {
		this.numTroca = numTroca;
		this.numPedidoAnt = numPedidoAnt;
		this.numPedidoNovo = numPedidoNovo;
		this.dataSolicit = dataSolicit;
		this.dataColeta = dataColeta;
		this.dataEntregaVarej = dataEntregaVarej;
		this.dataEntregaConsumidor = dataEntregaConsumidor;
		this.valorTroca = valorTroca;
	}
	
	
	

}
