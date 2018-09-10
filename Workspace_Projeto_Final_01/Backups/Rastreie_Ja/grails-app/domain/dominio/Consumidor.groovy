package dominio

import java.util.Date

class Consumidor 
{
	int    matricula
	String nomeConsum
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
		
	static constraints = 
	{}
	/*
	static mapping = 
	{
		table 'Consumidor'
		version true
		columns
		{
			matricula     column: "matricula"
			nomeConsum    column: "nomeConsum"
			senha         column: "senha"
			confirmaSenha column: "confirmaSenha"
			email         column: "email"
			sexo          column: "sexo"
			nasc          column: "nasc"
			tel           column: "tel"
			end           column: "end"
			comp          column: "comp"
			cep           column: "cep"
			cidade        column: "cidade"
			estado        column: "estado"
			bairro        column: "bairro"
		}
	} */

	public Consumidor(int matricula, String nomeConsum, String senha,
			String confirmaSenha, String email, String sexo, Date nasc,
			String tel, String end, String comp, String cep, String cidade,
			String estado, String bairro)
	 {
		this.matricula     = matricula
		this.nomeConsum    = nomeConsum
		this.senha         = senha
		this.confirmaSenha = confirmaSenha
		this.email         = email
		this.sexo          = sexo
		this.nasc          = nasc
		this.tel           = tel
		this.end           = end
		this.comp          = comp
		this.cep           = cep
		this.cidade        = cidade
		this.estado        = estado
		this.bairro        = bairro
	}


	
	




}
