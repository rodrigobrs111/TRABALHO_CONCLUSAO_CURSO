import org.mycompany.Person

class BootStrap 
{

    def init = 
	{ servletContext ->
		
		if ( !Person.count() )
		{
			
	
			def johnDoe        = new Person( firstName: "John"    , lastName: "Doe" ).save(  )
			def joeReed        = new Person( firstName: "Joe"     , lastName: "Reed" ).save(  )
			def jimSmith       = new Person( firstName: "Jim"     , lastName: "Smith" ).save(  )
			def patrickHartwin = new Person( firstName: "Patrick" , lastName: "Hartwin" ).save(  )
			def steveGunther   = new Person( firstName: "Steve"   , lastName: "Gunther" ).save(  )
			def samWhiting     = new Person( firstName: "Sam"     , lastName: "Whiting" ).save(  )
			def sarahMathews   = new Person( firstName: "Sarah"   , lastName: "Mathews" ).save(  )
			def lisaPudock     = new Person( firstName: "Lisa"    , lastName: "Pudock" ).save(  )
			def karaWhiting    = new Person( firstName: "Kara"    , lastName: "Whiting" ).save(  )
			def Martin         = new Person( fisrtName: "Martin"  , lastName: "Lawrence" ).save(  )

		}

	}
	
	
	
    def destroy = 
	{}
}
