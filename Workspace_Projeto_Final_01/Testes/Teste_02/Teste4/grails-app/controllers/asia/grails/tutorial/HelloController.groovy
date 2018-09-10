package asia.grails.tutorial

import teste4.Cliente;

class HelloController 
{
	
	Cliente cliente
	
    def index()
	{}
	
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
