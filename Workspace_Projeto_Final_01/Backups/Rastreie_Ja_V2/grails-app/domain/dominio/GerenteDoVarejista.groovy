package dominio

import java.util.Date
import java.util.GregorianCalendar;


class GerenteDoVarejista 
{
	
	int    matricula
	String nomeGerenteVarej
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


	public GerenteDoVarejista(int matricula, String nomeGerenteVarej,
			String senha, String confirmaSenha, String email, String sexo,
			Date nasc, String tel, String end, String comp, String cep,
			String cidade, String estado, String bairro)
	 {
		this.matricula        = matricula
		this.nomeGerenteVarej = nomeGerenteVarej
		this.senha            = senha
		this.confirmaSenha    = confirmaSenha
		this.email            = email
		this.sexo             = sexo
		this.nasc             = nasc
		this.tel              = tel
		this.end              = end
		this.comp             = comp
		this.cep              = cep
		this.cidade           = cidade
		this.estado           = estado
		this.bairro           = bairro
	}



	
	
	
    	

}
