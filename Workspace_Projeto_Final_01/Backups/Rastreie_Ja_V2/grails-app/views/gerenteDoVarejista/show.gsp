
<%@ page import="dominio.GerenteDoVarejista" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'gerenteDoVarejista.label', default: 'GerenteDoVarejista')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-gerenteDoVarejista" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="gerenteDoVarejista.bairro.label" default="Bairro" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: gerenteDoVarejistaInstance, field: "bairro")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="gerenteDoVarejista.cep.label" default="Cep" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: gerenteDoVarejistaInstance, field: "cep")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="gerenteDoVarejista.cidade.label" default="Cidade" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: gerenteDoVarejistaInstance, field: "cidade")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="gerenteDoVarejista.comp.label" default="Comp" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: gerenteDoVarejistaInstance, field: "comp")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="gerenteDoVarejista.confirmaSenha.label" default="Confirma Senha" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: gerenteDoVarejistaInstance, field: "confirmaSenha")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="gerenteDoVarejista.email.label" default="Email" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: gerenteDoVarejistaInstance, field: "email")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="gerenteDoVarejista.end.label" default="End" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: gerenteDoVarejistaInstance, field: "end")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="gerenteDoVarejista.estado.label" default="Estado" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: gerenteDoVarejistaInstance, field: "estado")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="gerenteDoVarejista.matricula.label" default="Matricula" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: gerenteDoVarejistaInstance, field: "matricula")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="gerenteDoVarejista.nasc.label" default="Nasc" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${gerenteDoVarejistaInstance?.nasc}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="gerenteDoVarejista.nomeGerenteVarej.label" default="Nome Gerente Varej" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: gerenteDoVarejistaInstance, field: "nomeGerenteVarej")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="gerenteDoVarejista.senha.label" default="Senha" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: gerenteDoVarejistaInstance, field: "senha")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="gerenteDoVarejista.sexo.label" default="Sexo" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: gerenteDoVarejistaInstance, field: "sexo")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="gerenteDoVarejista.tel.label" default="Tel" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: gerenteDoVarejistaInstance, field: "tel")}</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
