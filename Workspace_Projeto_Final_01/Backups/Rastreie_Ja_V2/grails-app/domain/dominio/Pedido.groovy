package dominio

import java.util.List;

class Pedido 
{
	int              numPedido
	int              qtdProdutos
	float            valorPedido
	String           status 
	List < Produto > lstProdutos
	
	static constraints = {}
	
	static belongsTo = [ lstProdutos : Produto ]
	

	public Pedido()
	{}
	
	public Pedido( int numPedido , int qtdProdutos , float valorPedido , String status , List< Produto > lstProdutos )
	 {
		this.numPedido   = numPedido   ;
		this.qtdProdutos = qtdProdutos ;
		this.valorPedido = valorPedido ;
		this.status      = status      ; 
		this.lstprodutos = produtos    ;    
	 }
}
