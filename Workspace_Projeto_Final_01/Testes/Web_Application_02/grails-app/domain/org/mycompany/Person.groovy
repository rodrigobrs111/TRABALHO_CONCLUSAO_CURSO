package org.mycompany
import java.util.List;

class Person 
{
	String          firstName
	String          lastName
	List< Address > lstPersons = new ArrayList< Address >()

	
	static hasMany = [ addresses: Address ]  // Define uma associa��o de 1 para muitos entre 2 classes nesse caso <Person , Adress >
	
    static constraints = 
	{}
	
}
