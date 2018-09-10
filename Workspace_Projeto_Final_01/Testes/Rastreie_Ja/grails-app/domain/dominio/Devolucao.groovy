package dominio

class Devolucao 
{
	
	int                    numDevol
	int                    numPedido
	float                  valorDevol
	Transportadora         transportadora
	
	static constraints = {}

	static belongsTo = [ funcionarioDoVarejista: FuncionarioDoVarejista ]

	public Devolucao(int numDevol , int numPedido , float valorDevol ,
			FuncionarioDoVarejista funcionarioDoVarejista ,
			Transportadora transportadora )
	 {
		this.numDevol               = numDevol               ;
		this.numPedido              = numPedido              ;
		this.valorDevol             = valorDevol             ;
		this.funcionarioDoVarejista = funcionarioDoVarejista ;
		this.transportadora         = transportadora         ;
	}
	
	
}
