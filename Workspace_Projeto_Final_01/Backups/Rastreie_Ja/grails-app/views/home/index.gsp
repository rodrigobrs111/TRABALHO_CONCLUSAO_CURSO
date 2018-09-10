


<html>

	<head>
		<title><g:message code="Bem Vindo ao Rastreie Já" args="[meta(name:'app.name')]"/> </title>
		<meta name="layout" content="kickstart" />
		

	</head>
	
	<body>
				
	    <br/><br/><br/><br/>
		<h1> Rastreie seu pedido aqui: </h1>
		
			<g:form url="[action:'_rastrearPedido',controller:'busca']" method = "GET" ><br/>
				             Numero do Pedido: <input type = "text" name = "numPedido"/><br/>
					                           <input type = "submit" value = "Buscar" >
			 </g:form>
	    <br/><br/><br/><br/><br/><br/><br/><br/><br/>
	    <br/><br/><br/><br/><br/><br/><br/><br/><br/>
	
    
	
	
	</body>

</html>
