<%@ page import="dominio.Reclamacao" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'reclamacao.label', default: 'Reclamacao')}" />
	<title><g:message code="default.edit.label" args="[entityName]" /></title>
</head>

<body>

<section id="edit-reclamacao" class="first">

	<g:hasErrors bean="${reclamacaoInstance}">
	<div class="alert alert-error">
		<g:renderErrors bean="${reclamacaoInstance}" as="list" />
	</div>
	</g:hasErrors>

	<g:form method="post" class="form-horizontal" >
		<g:hiddenField name="id" value="${reclamacaoInstance?.id}" />
		<g:hiddenField name="version" value="${reclamacaoInstance?.version}" />
		<fieldset class="form">
			<g:render template="form"/>
		</fieldset>
		<div class="form-actions">
		
		 <h2>Necessidade de Troca do Pedido:</h2>
		  <br/>
		  <input type="radio" name="necessidadeTroca" id="Sim" value="Sim">Sim<br/>
		  <input type="radio" name="necessidadeTroca" id="Nao" value="Não">Nao<br/><br/><br/><br/>
		  <g:actionSubmit class="btn btn-primary" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" />
		  <g:actionSubmit class="btn btn-danger" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
          <button class="btn" type="reset">Cancel</button>
	
		</div>
	</g:form>

</section> <br/><br/><br/><br/><br/><br/>	
		
			
</body>

</html>
