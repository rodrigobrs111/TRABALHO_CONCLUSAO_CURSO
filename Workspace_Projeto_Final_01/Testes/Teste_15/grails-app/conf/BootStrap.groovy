class BootStrap {

    def init = { servletContext ->
		
		
		for( int i  =  1 ; i <= 1000 ; i++ )
		 println  i + "|" + "10/10/2014" + "|" + "RIO DE JANEIRO" + "|" +  "EM ANDAMENTO" + "|" + "PEDIDO EM ANDAMENTO" 
    }
    def destroy = {
		
    }
}
