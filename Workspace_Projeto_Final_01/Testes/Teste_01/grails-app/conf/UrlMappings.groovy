class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

	//	"/"(view:"/index")
		"/"( controller: "teste" )
		"500"(view:'/error')
	}
}
