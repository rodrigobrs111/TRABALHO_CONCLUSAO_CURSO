package dominio

import java.util.Date

class FuncionarioDaTransportadora
{

	int    matricula 
	String nomeFuncTransp
	String senha
	String confirmaSenha
	String email
	String sexo
	Date   nasc
	String tel
	String end
	String comp
	String cep
	String cidade
	String estado
	String bairro

	static constraints = {}

	public FuncionarioDaTransportadora(int matricula, String nomeFuncTransp,
			String senha, String confirmaSenha, String email, String sexo,
			Date nasc, String tel, String end, String comp, String cep,
			String cidade, String estado, String bairro) 
	{
		this.matricula      = matricula
		this.nomeFuncTransp = nomeFuncTransp
		this.senha          = senha
		this.confirmaSenha  = confirmaSenha
		this.email          = email
		this.sexo           = sexo
		this.nasc           = nasc
		this.tel            = tel
		this.end            = end
		this.comp           = comp
		this.cep            = cep
		this.cidade         = cidade
		this.estado         = estado
		this.bairro         = bairro
	}


	

}
