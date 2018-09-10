
<%@ page import="dominio.SupervisorDoVarejista" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'supervisorDoVarejista.label', default: 'SupervisorDoVarejista')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-supervisorDoVarejista" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="supervisorDoVarejista.bairro.label" default="Bairro" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: supervisorDoVarejistaInstance, field: "bairro")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="supervisorDoVarejista.cep.label" default="Cep" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: supervisorDoVarejistaInstance, field: "cep")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="supervisorDoVarejista.cidade.label" default="Cidade" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: supervisorDoVarejistaInstance, field: "cidade")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="supervisorDoVarejista.comp.label" default="Comp" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: supervisorDoVarejistaInstance, field: "comp")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="supervisorDoVarejista.confirmaSenha.label" default="Confirma Senha" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: supervisorDoVarejistaInstance, field: "confirmaSenha")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="supervisorDoVarejista.email.label" default="Email" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: supervisorDoVarejistaInstance, field: "email")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="supervisorDoVarejista.end.label" default="End" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: supervisorDoVarejistaInstance, field: "end")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="supervisorDoVarejista.estado.label" default="Estado" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: supervisorDoVarejistaInstance, field: "estado")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="supervisorDoVarejista.matricula.label" default="Matricula" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: supervisorDoVarejistaInstance, field: "matricula")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="supervisorDoVarejista.nasc.label" default="Nasc" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${supervisorDoVarejistaInstance?.nasc}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="supervisorDoVarejista.nomeSupervisorVarej.label" default="Nome Supervisor Varej" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: supervisorDoVarejistaInstance, field: "nomeSupervisorVarej")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="supervisorDoVarejista.senha.label" default="Senha" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: supervisorDoVarejistaInstance, field: "senha")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="supervisorDoVarejista.sexo.label" default="Sexo" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: supervisorDoVarejistaInstance, field: "sexo")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="supervisorDoVarejista.tel.label" default="Tel" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: supervisorDoVarejistaInstance, field: "tel")}</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
