class UrlMappings {

	static mappings = {
		
		"/"	{
			controller	=   'email'
			action		= { 'email' }
			view		= { 'email' }
		}
		
		
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

	//	"/"(view:"/index")
	//	"500"(view:'/error')
	}
}
