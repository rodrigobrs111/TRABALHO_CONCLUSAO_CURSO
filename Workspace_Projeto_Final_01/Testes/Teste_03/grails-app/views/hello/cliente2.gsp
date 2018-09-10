<!DOCTYPE html>
<html>

	<head>
		 <meta name = "layout"  content =  "main" />
		 <title> CLIENTE 2 </title>
	</head>

    <g:form action = "save">
	    <label for = "nome"> Nome: </label> <br/>
	    <g:textField name = "nome" value = "${cliente2.nome}" />
	    <label for = "idade"> Idade: </label> <br/>
	    <g:textField name = "idade" value = "${cliente2.idade}" />
    </g:form>


</html>
