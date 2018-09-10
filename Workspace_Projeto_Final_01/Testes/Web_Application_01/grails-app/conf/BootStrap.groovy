import org.mycompany.Person

class BootStrap {

    def init = 
	{ servletContext ->
   		
				if (!Person.count())
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
		
	
			//	 johnDoe.addTo_(  new Address(state: "NY", city: "Windsor", streetAddress: "117 W 2nd St", zipCode: "13865") )
					
				//	.addTo( new Address(state: "TX", city: "Alberta", streetAddress: "117 W 2nd St", zipCode: "55555")
				  /*  ).addTo(
							new Address(state: "NY", city: "Longely", streetAddress: "2 Sandy Creek", zipCode: "34009")
					).addTo(
							new Address(state: "ME", city: "Ladly", streetAddress: "117 W 2nd St", zipCode: "55533")
					).addTo(
							new Address(state: "KY", city: "Korba", streetAddress: "3 Apple St", zipCode: "40351")
					).save()
		
					joeReed.addTo(
							new Address(state: "KY", city: "Frankfort", streetAddress: "33 Main St", zipCode: "77625")
					).addTo(
							new Address(state: "PA", city: "Scranton", streetAddress: "71 Kind Ave Apt 3", zipCode: "44567")
					).addTo(
							new Address(state: "PA", city: "Scranton", streetAddress: "8559 Hard Rock", zipCode: "44567")
					).addTo(
							new Address(state: "WV", city: "Charleston", streetAddress: "8233 Juniper Rd", zipCode: "33982")
					).save()
		
					jimSmith.addTo(
							new Address(state: "PA", city: "Blue Ridge", streetAddress: "780 Country Rd", zipCode: "44564")
					).addTo(
							new Address(state: "TX", city: "Ft. Worth", streetAddress: "55 Holdem Dr." , zipCode: "77298")
					).save()
		
					patrickHartwin.addTo(
							new Address(state: "CA", city: "Sacramento", streetAddress: "1 Beach Rd", zipCode: "98765")
					).addTo(
							new Address(state: "CA", city: "Sacramento", streetAddress: "53 Sinking Dr." , zipCode: "98765")
					).save()
		
					steveGunther.addTo(
							new Address(state: "CA", city: "Sacramento", streetAddress: "1 Beach Rd", zipCode: "98765")
					).addTo(
							new Address(state: "CA", city: "Sacramento", streetAddress: "53 Sinking Dr." , zipCode: "98765")
					).addTo(
							new Address(state: "CA", city: "Sacramento", streetAddress: "759 Sinking Dr." , zipCode: "98765")
					).save()
		
					samWhiting.addTo(
							new Address(state: "CA", city: "Sacramento", streetAddress: "1 Beach Rd", zipCode: "98765")
					).save()
		
					sarahMathews.addTo(
							new Address(state: "VT", city: "Burlington", streetAddress: "81 Lake Dr.", zipCode: "22183")
					).addTo(
							new Address(state: "VT", city: "Burlington", streetAddress: "40 Shorten Ave Apt 33" , zipCode: "22183")
					).addTo(
							new Address(state: "NY", city: "Plattsburgh", streetAddress: "1772 Lovely Lane" , zipCode: "22795")
					).save()
		
					lisaPudock.addTo(
							new Address(state: "VT", city: "Burlington", streetAddress: "81 Lake Dr.", zipCode: "22183")
					).addTo(
							new Address(state: "VT", city: "Burlington", streetAddress: "40 Shorten Ave Apt 33" , zipCode: "22183")
					).addTo(
							new Address(state: "NY", city: "Plattsburgh", streetAddress: "1772 Lovely Lane" , zipCode: "22795")
					).save()
		
					karaWhiting.addTo(
							new Address(state: "CA", city: "Sandiego", streetAddress: "9901 Shore Dr.", zipCode: "98741")
					).save()
					
					Martin.addTo(
						  new Address( State: "CA" , city: "Sandiego", streetAddress: "9901 Shore Dr." , zipCode: "9871" )
						 ).save(  )
					
					*/
			}
		}
			
			
		def destroy = {}
	
	
}
