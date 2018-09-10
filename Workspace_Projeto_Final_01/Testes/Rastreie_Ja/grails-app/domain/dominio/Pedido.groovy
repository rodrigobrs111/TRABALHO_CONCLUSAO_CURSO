package dominio


class Pedido 
{
	int                         numPedido
	int                         qtdProdutos
	float                       valorPedido
	Transportadora              transportadora
	FuncionarioDaTransportadora funcionarioDaTransportadora
	Entrega                     entrega
	List< Produto >             lstProdutos
	
	static constraints = {}
	
	

	public Pedido()
	{}


	public Pedido( int numPedido , int qtdProdutos , float valorPedido ,
                   List< Produto >  lstProdutos , Entrega entrega ,
				   Transportadora transportadora , FuncionarioDaTransportadora funcionarioDaTransportadora )
	 {
		this.numPedido                   = numPedido                   ;
		this.qtdProdutos                 = qtdProdutos                 ;
		this.valorPedido                 = valorPedido                 ;
		this.transportadora              = transportadora              ;
		this.funcionarioDaTransportadora = funcionarioDaTransportadora ;
		this.lstProdutos                 = lstProdutos                 ;
		this.entrega                     = entrega                     ;
	 }

	
	 
	 
		 
}
