
<%@ page import="dominio.FuncionarioDoVarejista" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'funcionarioDoVarejista.label', default: 'FuncionarioDoVarejista')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-funcionarioDoVarejista" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDoVarejista.bairro.label" default="Bairro" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDoVarejistaInstance, field: "bairro")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDoVarejista.cep.label" default="Cep" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDoVarejistaInstance, field: "cep")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDoVarejista.cidade.label" default="Cidade" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDoVarejistaInstance, field: "cidade")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDoVarejista.comp.label" default="Comp" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDoVarejistaInstance, field: "comp")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDoVarejista.confirmaSenha.label" default="Confirma Senha" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDoVarejistaInstance, field: "confirmaSenha")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDoVarejista.email.label" default="Email" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDoVarejistaInstance, field: "email")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDoVarejista.end.label" default="End" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDoVarejistaInstance, field: "end")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDoVarejista.estado.label" default="Estado" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDoVarejistaInstance, field: "estado")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDoVarejista.matricula.label" default="Matricula" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDoVarejistaInstance, field: "matricula")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDoVarejista.nasc.label" default="Nasc" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${funcionarioDoVarejistaInstance?.nasc}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDoVarejista.nomeFuncVarej.label" default="Nome Func Varej" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDoVarejistaInstance, field: "nomeFuncVarej")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDoVarejista.senha.label" default="Senha" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDoVarejistaInstance, field: "senha")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDoVarejista.sexo.label" default="Sexo" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDoVarejistaInstance, field: "sexo")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="funcionarioDoVarejista.tel.label" default="Tel" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: funcionarioDoVarejistaInstance, field: "tel")}</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
