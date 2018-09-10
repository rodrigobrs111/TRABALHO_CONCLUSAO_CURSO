package dominio

import java.util.Date
import java.util.GregorianCalendar;

class FuncionarioDoVarejista
{
	
	int                   matricula
	String                nomeFuncVarej
	String                senha
	String                confirmaSenha
	String                email
	String                sexo
	Date                  nasc
	String                tel
	String                end
	String                comp
	String                cep
	String                cidade
	String                estado
	String                bairro
    SupervisorDoVarejista supervisorDoVarejista
	
	static constraints = {}


	public FuncionarioDoVarejista( int matricula , String nomeFuncVarej ,
			String senha , String confirmaSenha , String email , String sexo ,
			Date nasc , String tel , String end , String comp , String cep ,
			String cidade , String estado , String bairro , SupervisorDoVarejista supervisorDoVarejista ) 
	{
		this.matricula             = matricula
		this.nomeFuncVarej         = nomeFuncVarej
		this.senha                 = senha
		this.confirmaSenha         = confirmaSenha
		this.email                 = email
		this.sexo                  = sexo
		this.nasc                  = nasc
		this.tel                   = tel
		this.end                   = end
		this.comp                  = comp
		this.cep                   = cep
		this.cidade                = cidade
		this.estado                = estado
		this.bairro                = bairro
		this.supervisorDoVarejista = supervisorDoVarejista
		
	}


	
	
	
}
