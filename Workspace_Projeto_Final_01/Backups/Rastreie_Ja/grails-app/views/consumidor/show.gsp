
<%@ page import="dominio.Consumidor" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'consumidor.label', default: 'Consumidor')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-consumidor" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="consumidor.bairro.label" default="Bairro" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: consumidorInstance, field: "bairro")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="consumidor.cep.label" default="Cep" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: consumidorInstance, field: "cep")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="consumidor.cidade.label" default="Cidade" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: consumidorInstance, field: "cidade")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="consumidor.comp.label" default="Comp" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: consumidorInstance, field: "comp")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="consumidor.confirmaSenha.label" default="Confirma Senha" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: consumidorInstance, field: "confirmaSenha")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="consumidor.email.label" default="Email" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: consumidorInstance, field: "email")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="consumidor.end.label" default="End" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: consumidorInstance, field: "end")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="consumidor.estado.label" default="Estado" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: consumidorInstance, field: "estado")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="consumidor.matricula.label" default="Matricula" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: consumidorInstance, field: "matricula")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="consumidor.nasc.label" default="Nasc" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${consumidorInstance?.nasc}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="consumidor.nomeConsum.label" default="Nome Consum" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: consumidorInstance, field: "nomeConsum")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="consumidor.senha.label" default="Senha" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: consumidorInstance, field: "senha")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="consumidor.sexo.label" default="Sexo" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: consumidorInstance, field: "sexo")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="consumidor.tel.label" default="Tel" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: consumidorInstance, field: "tel")}</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
