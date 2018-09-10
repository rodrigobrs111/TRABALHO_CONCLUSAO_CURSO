package dominio

import java.util.List;

class Pedido 
{
	int             numPedido
	int             qtdProdutos
	float           valorPedido
	String          status 
	
	static constraints = {}
	
	static belongsTo = [ produto : Produto ]
	

	public Pedido()
	{}
	
	public Pedido( int numPedido , int qtdProdutos , float valorPedido , String status , Produto produto )
	 {
		this.numPedido   = numPedido   ;
		this.qtdProdutos = qtdProdutos ;
		this.valorPedido = valorPedido ;
		this.status      = status      ; 
		this.produto     = produto     ;    
	 }
}
