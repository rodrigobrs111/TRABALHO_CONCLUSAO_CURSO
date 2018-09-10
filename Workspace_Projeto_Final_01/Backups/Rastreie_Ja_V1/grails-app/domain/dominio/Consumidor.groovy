package dominio

import java.util.Date;

class Consumidor 
{
	int    matricula
	String nomeConsum 
    String email
	String sexo
	Date   nasc	
	String tel
	String end 
	String comp
	String cep 
	String cidade
	String estado 
	String Bairro
		
	static constraints = {}
	
	public Consumidor(int matricula, String nomeConsum, String email,
			String sexo, Date nasc, String tel, String end, String comp,
			String cep, String cidade, String estado, String bairro) 
	{
		this.matricula = matricula;
		this.nomeConsum = nomeConsum;
		this.email = email;
		this.sexo = sexo;
		this.nasc = nasc;
		this.tel = tel;
		this.end = end;
		this.comp = comp;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		Bairro = bairro;
	}



}
