package teste3
import asia.grails.tutorial.HelloController
import teste3.Cliente


class Main 
{
	static void main(args)
	{
		Cliente cliente = new Cliente( "Dagvaldo" , 20 , 123 )
	                      new HelloController( cliente )                 
	}

	 static constraints = 
	{}
}
