package asia.grails.tutorial
import teste2.Cliente

class HelloController 
{
	
    def index()
	{ 
		Cliente cliente = new Cliente( idade: 10 )
		[ cliente : cliente ]
		
	}
	
}


