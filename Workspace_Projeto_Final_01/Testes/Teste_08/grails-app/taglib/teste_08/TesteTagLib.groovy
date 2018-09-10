package teste_08

class TesteTagLib 
{
	def myService
	
	
		void testThisTag()
		 {
			def appliedTagLib = applyTemplate('<thisTag attr="value" />')
			def parametersFromService = myService.method("argument")
			def renderedTemplate = render(template:'/myFolder/myView',
										  model:parametersFromService)
			assertEquals appliedTagLib, renderedTemplate
		 }
	
}
