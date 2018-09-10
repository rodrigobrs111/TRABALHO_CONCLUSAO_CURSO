import java.util.List;
import teste_05.Customer

class BootStrap {

    def init =
	 { servletContext ->
		
		List< Integer > lst1 = new ArrayList< Integer >()
		List< Double >  lst2 = new ArrayList< Double >()
		List< Float >   lst3 = new ArrayList< Float >()
		
		lst1.add( 1 ) ;
		lst1.add( 1 ) ;
		lst1.add( 1 ) ;
		lst1.add( 1 ) ;
		lst1.add( 1 ) ;
		lst1.add( 1 ) ;
		lst1.add( 1 ) ;
		lst1.add( 1 ) ;
		lst1.add( 1 ) ;
		lst1.add( 1 ) ;
		lst1.add( 1 ) ;
		lst1.add( 1 ) ;
		lst1.add( 1 ) ;
		lst1.add( 1 ) ;

      Customer c1 = new Customer( nome: "Carlos" , tel: "2547-1166" , lst1: lst1 , lst2: lst1 , lst3: lst1  ).save()
				
	}
   
	  def destroy = 
	  {}
}
