class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

	//	"/"(view:"/index")
	"/"(controller: "pessoa" , action: "create" )
			"500"(view:'/error')

	}
}
