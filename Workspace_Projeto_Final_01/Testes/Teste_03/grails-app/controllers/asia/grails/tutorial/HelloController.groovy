package asia.grails.tutorial
import teste3.Cliente


class HelloController
{
	Cliente cliente2 
	
	def index()
	{
		cliente = new Cliente( nome: "Bael" , idade: 10 , senha: 5556 )
		[ cliente : cliente ]
	}
	
	HelloController( Cliente cliente )
	{
		this.cliente = cliente
		salvaCliente()
	}
	
     void salvaCliente() 
	 {
		cliente.save() 
	 }	
	 

}

