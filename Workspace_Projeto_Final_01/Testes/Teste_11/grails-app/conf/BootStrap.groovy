import teste_11.Autor
import teste_11.Dono
import teste_11.Empresa
import teste_11.Livro

class BootStrap {

    def init = { servletContext ->
	
		
		
	// Relacionamento 1 para 1		


//	def emp1 = new Empresa(  num: 22 , nome: "XXX" , dono: new Dono( num: 5454 , nome: "Sergio Albb" )  ).save()
/*    def emp2 = new Empresa(  id2: 2 , num: 22 , nome: "XXX" , dono: new Dono( num: 54   , nome: "Sergio Albb" ) ).save()
	def emp3 = new Empresa(  id2: 3 , num: 22 , nome: "XXX" , dono: new Dono( num: 787  , nome: "Sergio Albb" ) ).save()
	def emp4 = new Empresa(  id2: 4 , num: 22 , nome: "XXX" , dono: new Dono( num: 000  , nome: "Sergio Albb" ) ).save()
		
*/
		
	def autor1 = new Autor( nome: "RONALDO"  ).save()
    def livro1 = new Livro( nome: "O PEQUENO1" ).save()
	def livro2 = new Livro( nome: "O PEQUENO2" ).save()
	def livro3 = new Livro( nome: "O PEQUENO3" ).save()
	def livro4 = new Livro( nome: "O PEQUENO4" ).save()
	
	
	
	
    }
    def destroy = {
    }
}
