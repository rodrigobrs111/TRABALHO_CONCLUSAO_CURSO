package org.mycompany

class Address
 {

	String streetAddress;
	String city;
	String state;
	String zipCode;

	//Date moveInDate;
	//Date moveOutDate;


	static BelongsTo = [ person: Person ] // Indica que a classe é proprietária do relacionamento
		
	// Faz a validação lógica para cada campo
	static constraints =
	{
		 streetAddress( blank: false )
		 city( blank: false )
		 state( blank: false , size: 2..2 )
		 zipCode( blank: false , size: 5..5 , validator: { val , obj -> val?.isNumber() } )
	
		//Date moveInDate  ;
		//Date moveOutDate ;
	}
	
	String toString()
	{ 
		return "${streetAddress} ${city}, ${state}, ${zipCode}"
	}

	
}
