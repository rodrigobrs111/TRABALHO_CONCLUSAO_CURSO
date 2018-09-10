package teste_11

// RELACIONAMENTO 1 PARA N 
// LADO 1

class Autor {

	
	String nome 
	static hasMany = [ livros : Livro ]
	
    static constraints = {
    }
}
