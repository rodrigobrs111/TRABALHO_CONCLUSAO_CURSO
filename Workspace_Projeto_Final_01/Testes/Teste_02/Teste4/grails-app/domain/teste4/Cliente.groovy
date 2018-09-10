package teste4
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class Cliente 
{

	
	String nome
	int    idade
	String senha
		
	static constraints =
	{}

	Cliente( String nome , int idade , String senha )
	{
		this.nome  = nome
		this.idade = idade
		this.senha = senha
	}
		
	void save()
	{
		
		try
		{
			Connection conn ;
			
			
			           Class.forName( "com.mysql.jdbc.Driver" )                                             ;
					   conn = DriverManager.getConnection( "jdbc:mysql://localhost/TESTE1" , nome , senha ) ;
			Statement  stm  = conn.createStatement()                                                        ;
			String     sql  = "INSERT INTO CLIENTE"                         +
							  "VALUES ( '" + nome + "' , '" + idade + "' ) ;"                               ;
			
		  stm.executeUpdate( sql ) ;
		  stm.close()              ;
		  conn.close()             ;		  
		}
		catch ( Exception e )
		{
		  e.printStackTrace()
		}
	
	}
		


}
