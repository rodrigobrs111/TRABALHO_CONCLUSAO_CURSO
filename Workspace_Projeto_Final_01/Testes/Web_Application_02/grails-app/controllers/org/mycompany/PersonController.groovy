package org.mycompany

class PersonControlle
{
	def scaffold = Person

    def index =
	{
		def people = Person.list( [ sort: "lastName" , order: "asc" ] )
		return [ people: people ]
	}
}
