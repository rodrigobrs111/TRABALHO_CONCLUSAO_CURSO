
<%@ page import="dominio.Devolucao" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'devolucao.label', default: 'Devolucao')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-devolucao" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="devolucao.funcionarioDoVarejista.label" default="Funcionario Do Varejista" /></td>
				
				<td valign="top" class="value"><g:link controller="funcionarioDoVarejista" action="show" id="${devolucaoInstance?.funcionarioDoVarejista?.id}">${devolucaoInstance?.funcionarioDoVarejista?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="devolucao.numDevol.label" default="Num Devol" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: devolucaoInstance, field: "numDevol")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="devolucao.numPedido.label" default="Num Pedido" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: devolucaoInstance, field: "numPedido")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="devolucao.transportadora.label" default="Transportadora" /></td>
				
				<td valign="top" class="value"><g:link controller="transportadora" action="show" id="${devolucaoInstance?.transportadora?.id}">${devolucaoInstance?.transportadora?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="devolucao.valorDevol.label" default="Valor Devol" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: devolucaoInstance, field: "valorDevol")}</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
