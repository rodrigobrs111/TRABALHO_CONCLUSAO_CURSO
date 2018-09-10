package teste_07

class Dependente 
{

		String nome
		String end
		
	   static belongsTo = [ pessoa : Pessoa ]
		
    static constraints = {}
}
