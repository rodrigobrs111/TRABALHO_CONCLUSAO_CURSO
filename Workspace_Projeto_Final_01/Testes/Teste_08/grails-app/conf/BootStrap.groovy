import teste_08.Pessoa

class BootStrap 
{

    def init =
	{ servletContext ->
		
		def pessoa1 = new Pessoa( nome: "RODRIGO" , idade: 18 ).save()
		
    }
    
	def destroy = {}
}
