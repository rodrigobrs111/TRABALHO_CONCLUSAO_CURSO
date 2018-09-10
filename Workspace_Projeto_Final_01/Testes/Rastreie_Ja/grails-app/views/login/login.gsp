
<html>


	<head>
	    <meta name="layout" content="main">
	</head>

<body>

        <br/><br/><br/><br/>
        <center><h6>

	            	<g:form url="[action:'validarCadastro', controller:'cadastro']" method = "post" accept-charset="UTF-8">
					   Matricula: <input style="margin-bottom: 20px;" type="text" placeholder="Matricula" id="matricula" name="matricula"><br/>
					   Senha:     <input style="margin-bottom: 20px;" type="password" placeholder="Senha" id="senha" name="senha"><br/>
			     		<input type="submit" id="entrar"    value="Entrar">
					</g:form><br/>
			
					<g:form url ="[action: 'escolherFormulario' , controller: 'cadastro']" method = "post" accept-charset="UTF-8">
					<input  type="submit" id="cadastrar" value="Cadastre-se">
					</g:form>
		<h6><center><br/><br/><br/><br/><br/><br/>			
</body>