
<%@ page import="dominio.Distribuidor" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'distribuidor.label', default: 'Distribuidor')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-distribuidor" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="distribuidor.confirmaSenha.label" default="Confirma Senha" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: distribuidorInstance, field: "confirmaSenha")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="distribuidor.nomeDist.label" default="Nome Dist" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: distribuidorInstance, field: "nomeDist")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="distribuidor.numDist.label" default="Num Dist" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: distribuidorInstance, field: "numDist")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="distribuidor.senha.label" default="Senha" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: distribuidorInstance, field: "senha")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="distribuidor.supervisorDoVarejista.label" default="Supervisor Do Varejista" /></td>
				
				<td valign="top" class="value"><g:link controller="supervisorDoVarejista" action="show" id="${distribuidorInstance?.supervisorDoVarejista?.id}">${distribuidorInstance?.supervisorDoVarejista?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
