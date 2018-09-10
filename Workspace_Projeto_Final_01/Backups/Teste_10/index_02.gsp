<%@ page import="extra.Home" %>
<!DOCTYPE html>

<html>
	
	<head>
		<title><g:message code="Bem Vindo ao Rastreie Já" args="[meta(name:'app.name')]"/> </title>
		<meta name ="layout" content = "kickstart" />
	</head>
	
	<body>
	<h1> Rastreie seu pedido aqui: </h1>
	
		<form action="" method = "post" >
		Numero do Pedido: <input type = "text" name = "text"/><br/>
			              <input type = "submit" value = "Buscar" >
		 </form>
	</body>

</html>