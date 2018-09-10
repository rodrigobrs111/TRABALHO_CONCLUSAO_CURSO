
<%@ page import="dominio.FuncionarioDaTransportadora" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'funcionarioDaTransportadora.label', default: 'FuncionarioDaTransportadora')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-funcionarioDaTransportadora" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDaTransportadora.bairro.label" default="Bairro" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "bairro")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDaTransportadora.cep.label" default="Cep" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "cep")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDaTransportadora.cidade.label" default="Cidade" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "cidade")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDaTransportadora.comp.label" default="Comp" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "comp")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDaTransportadora.confirmaSenha.label" default="Confirma Senha" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "confirmaSenha")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDaTransportadora.email.label" default="Email" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "email")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDaTransportadora.end.label" default="End" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "end")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDaTransportadora.estado.label" default="Estado" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "estado")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDaTransportadora.matricula.label" default="Matricula" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "matricula")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDaTransportadora.nasc.label" default="Nasc" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${funcionarioDaTransportadoraInstance?.nasc}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDaTransportadora.nomeFuncTransp.label" default="Nome Func Transp" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "nomeFuncTransp")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDaTransportadora.senha.label" default="Senha" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "senha")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDaTransportadora.sexo.label" default="Sexo" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "sexo")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDaTransportadora.tel.label" default="Tel" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "tel")}</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
