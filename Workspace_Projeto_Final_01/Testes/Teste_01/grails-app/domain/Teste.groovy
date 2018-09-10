

class Teste
 {

	static void main(args)
	{
	
	  def a = 'jhjhjhj'
 	  def t1 = "asa" , t2 = "ddasd"
  
	    println "${t1} , ${t2}" 	
	    println "a + a = ${ a + a }"
		println a 
		println "TESTE !!!!!!!!!" 

		// Listas 
		
		List<Integer> lst = new ArrayList<Integer>() 
		def lst2 = [] 
		
		for( int i = 0 ; i < 10 ; i++ )
		{
		  lst[ i ]  = i 
		  lst2[ i ]	= i
		}	
	
		for( int i = 0 ; i < 10 ; i++ )
		{
			println "${lst[ i ]} , ${lst2[ i ]}"
		}
	
		
		
			
	}
	

}
