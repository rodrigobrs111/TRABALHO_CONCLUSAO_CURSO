import teste_07.Dependente
import teste_07.Pessoa

class BootStrap {

    def init = 
	{ servletContext ->

					
		for( int i = 0 ; i < 100 ; i++ )
		{
		  def p1  = new Pessoa( nome: "Jose" , tel: "2547-1166" , idade: 21 , end: "Praça das xxx" ).save()
		  def p2  = new Dependente( nome: "Jose" , end: "Praça das xxx" ).save()
		}
		
		
		
		
		   }
    def destroy = {
    }
}
