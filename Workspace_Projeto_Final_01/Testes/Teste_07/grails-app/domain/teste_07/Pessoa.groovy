package teste_07

class Pessoa 
{

	String nome
	String tel
	int    idade
	String end 
	
	static hasMany = [ dependentes : Dependente ]
		
    static constraints = {}
	
}
