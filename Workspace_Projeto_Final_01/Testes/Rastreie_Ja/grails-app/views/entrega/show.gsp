
<%@ page import="dominio.Entrega" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'entrega.label', default: 'Entrega')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-entrega" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="entrega.classificacao.label" default="Classificacao" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: entregaInstance, field: "classificacao")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="entrega.dataEncerramento.label" default="Data Encerramento" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${entregaInstance?.dataEncerramento}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="entrega.dataEntrega.label" default="Data Entrega" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${entregaInstance?.dataEntrega}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="entrega.dataRecebimento.label" default="Data Recebimento" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${entregaInstance?.dataRecebimento}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="entrega.dataSolicitacao.label" default="Data Solicitacao" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${entregaInstance?.dataSolicitacao}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="entrega.status.label" default="Status" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: entregaInstance, field: "status")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="entrega.valorEntrega.label" default="Valor Entrega" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: entregaInstance, field: "valorEntrega")}</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
