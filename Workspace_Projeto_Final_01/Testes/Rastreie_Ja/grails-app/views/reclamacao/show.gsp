
<%@ page import="dominio.Reclamacao" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'reclamacao.label', default: 'Reclamacao')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-reclamacao" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="reclamacao.comentario.label" default="Comentario" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: reclamacaoInstance, field: "comentario")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="reclamacao.dataAbertura.label" default="Data Abertura" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${reclamacaoInstance?.dataAbertura}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="reclamacao.dataResposta.label" default="Data Resposta" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${reclamacaoInstance?.dataResposta}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="reclamacao.dataSolucaoProblema.label" default="Data Solucao Problema" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${reclamacaoInstance?.dataSolucaoProblema}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="reclamacao.numReclamacao.label" default="Num Reclamacao" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: reclamacaoInstance, field: "numReclamacao")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="reclamacao.pedido.label" default="Pedido" /></td>
				
				<td valign="top" class="value"><g:link controller="pedido" action="show" id="${reclamacaoInstance?.pedido?.id}">${reclamacaoInstance?.pedido?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="reclamacao.status.label" default="Status" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: reclamacaoInstance, field: "status")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="reclamacao.supervisorDoVarejista.label" default="Supervisor Do Varejista" /></td>
				
				<td valign="top" class="value"><g:link controller="supervisorDoVarejista" action="show" id="${reclamacaoInstance?.supervisorDoVarejista?.id}">${reclamacaoInstance?.supervisorDoVarejista?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
