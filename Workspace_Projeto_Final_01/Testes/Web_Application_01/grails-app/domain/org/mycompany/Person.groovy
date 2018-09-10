package org.mycompany

import java.sql.Connection
import java.sql.Statement

class Person 
{
	String         firstName  
	String         lastName 
    List< Address > lstPersons = new ArrayList< Address >() 
	
	
	static hasMany = [ addresses: Address ]  // Define uma associação de 1 para muitos entre 2 classes nesse caso <Person , Adress > 
	
	static constaints = 
	{
		firstName( blank: false ) 
		lastName( blank: false )
	}
	
	void addTo_( Address ad )
	{
		lst.add( ad )		
	}
	
	void save()
	{
		println "SALVOU!!"
	}
	
	void save2 ()
	{
		Connection conn 
		  
		Class.forName( "com.mysql.jdbc.Drive" )                                                   ;
		conn = driverManager.getConnection( "jdbc:mysql://localhost/TESTE1" , firstName , "123" ) ;
		Statement stm = conn.createStatement()                                                    ; 
		String sql   = "INSERT INTO PERSON VALUES (" + firstname + "," + "0" + ");"               ;
		
		stm.excuteUpdate( sql ) ;
		conn.close()            ;
		stm.close()             ;
		
	}
	
	String toString()
	{
	   return "${firstName} ${lastName}"
	}
}
