package teste4

import asia.grails.tutorial.HelloController

class Main 
{
	static void main(args)
	{
		Cliente cliente = new Cliente( nome: "Dagvaldo" , idade: 20 , senha: "123" ) ;
						  new HelloController( cliente )                             ;
	}
	
    static constraints = 
	{}
}
