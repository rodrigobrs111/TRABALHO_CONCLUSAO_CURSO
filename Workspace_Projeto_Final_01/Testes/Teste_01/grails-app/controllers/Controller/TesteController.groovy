package Controller

class TesteController 
{
	File file = new File( "lib/TESTE.txt" )
	
    def index()
	{
	
		FileWriter writer = new FileWriter( file ,false);
		String linhasArq = ""

		
		file << "CCCCCCCCCCCCCC\n"
		
		file.eachLine { line ->
	
		  linhasArq = linhasArq + line + "\n"
	}
		println "===================="
		print linhasArq
		println "===================="
		
		
		writer.write( linhasArq )
		writer.close()
		
		hi()
		
		render "TESTE"
	}
	
	def hi()
	{
		
		try
		{
	
			FileInputStream fstream        = new FileInputStream( file )
			BufferedReader  br             = new BufferedReader( new InputStreamReader( fstream ) )
			String          strLine        = null
			
			while ( ( strLine = br.readLine() ) != null )
			{
				println "=========HI==========="
				println strLine
				println "===================="
			}

		}
		catch( FileNotFoundException e )
		{
		   e.printStackTrace()
		}
		catch( IOException e )
		{
		  e.printStackTrace()
		}

		
		render (view:'index')
	}
}
