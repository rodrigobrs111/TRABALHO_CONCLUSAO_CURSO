package org.mycompany

class Address {

	
	String streetAddress;
	String city;
	String state;
	String zipCode;

	//Date moveInDate;
	//Date moveOutDate;

	static BelongsTo = [ person: Person ] // Indica que a classe é proprietária do relacionamento
	
    static constraints = {
    }
}
