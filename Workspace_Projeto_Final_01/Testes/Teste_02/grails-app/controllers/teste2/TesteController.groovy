package teste2


class TesteController {

	static scaffold = true
	
	def email 
	{
		sendMail {
			to "fred@g2one.com"
			subject "Hello Fred"
			body 'How are you?'
		  }
	}
	


}
