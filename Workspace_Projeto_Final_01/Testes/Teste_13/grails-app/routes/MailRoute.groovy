import org.codehaus.groovy.grails.commons.*

 
class MailRoute {

	def configure = {
     
		  def config = ConfigurationHolder.config
		  
		  from("seda:mailQueue").process {

			  def name = it.in.body.name
			  def to = it.in.body.email
			  def html = new groovy.xml.StreamingMarkupBuilder().bind {

				  html {

					  body {

						  p "${name},"

						  p {

							  mkp.yield "Thank you for your interest in "

							  a href:'http://camel.apache.org', "Apache Camel"

							  mkp.yield "."

							  }

						  p {

							  i "P.S. Grails rocks"

							}
						  

						  }

					  }

				  }

			  it.out.setBody html.toString()
			  it.out.setHeader "to", to
			  it.out.setHeader "from", "h.kleinikkink@gmail.com"
			  it.out.setHeader "subject", "Mail sent from Apache Camel"

			  }

		  .to("smtps://smtp.gmail.com?username=${config.smtps.user}&password=${config.smtps.password}&contentType=text/html")

		  }

	}
}
