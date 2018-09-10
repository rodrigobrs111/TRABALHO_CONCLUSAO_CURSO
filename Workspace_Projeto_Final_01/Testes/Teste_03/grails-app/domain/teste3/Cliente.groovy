package teste3
import java.sql.*;


class Cliente 
{

	String nome 
	int    idade 
	int    senha 
		
    static constraints = 
	{}

	Cliente( String nome , int idade , int senha ) 
	{
		this.nome  = nome
		this.idade = idade
		this.senha = senha		
	}
		
	void save()
	{
		
		try 
		{
			
			Connection conn = classe.forName( "com.mysql.jdbc.Driver" )                                     ;
					   conn = DriverManager.getConnection( "jdbc:mysql://localhost/TESTE1" , nome , senha ) ;
	        Statement  stm  = conn.createStatement()                                                        ;
			String     sql  = "INSERT INTO CLIENTE"                         + 
			                  "VALUES ( '" + nome + "' '" + idade + "' ) ;"   
			
		  stm.executeUpdate( sql ) ; 
		} 
		catch ( Exception e )
		{
		  e.printStackTrace()
	    }
	
	}
		
	
	
}
