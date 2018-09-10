package teste_11

class Dono {

	int num 
	String nome 
	
	static hasOne = [ empresa: Empresa ]
	
    static constraints = 
	{
		empresa unique: true
    }
}
