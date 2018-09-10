
<%@ page import="dominio.Troca" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'troca.label', default: 'Troca')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-troca" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="troca.consumidor.label" default="Consumidor" /></td>
				
				<td valign="top" class="value"><g:link controller="consumidor" action="show" id="${trocaInstance?.consumidor?.id}">${trocaInstance?.consumidor?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="troca.dataColeta.label" default="Data Coleta" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${trocaInstance?.dataColeta}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="troca.dataEntregaConsumidor.label" default="Data Entrega Consumidor" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${trocaInstance?.dataEntregaConsumidor}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="troca.dataEntregaVarej.label" default="Data Entrega Varej" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${trocaInstance?.dataEntregaVarej}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="troca.dataSolicit.label" default="Data Solicit" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${trocaInstance?.dataSolicit}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="troca.devolucao.label" default="Devolucao" /></td>
				
				<td valign="top" class="value"><g:link controller="devolucao" action="show" id="${trocaInstance?.devolucao?.id}">${trocaInstance?.devolucao?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="troca.numPedidoAnt.label" default="Num Pedido Ant" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: trocaInstance, field: "numPedidoAnt")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="troca.numPedidoNovo.label" default="Num Pedido Novo" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: trocaInstance, field: "numPedidoNovo")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="troca.numTroca.label" default="Num Troca" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: trocaInstance, field: "numTroca")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="troca.pedido.label" default="Pedido" /></td>
				
				<td valign="top" class="value"><g:link controller="pedido" action="show" id="${trocaInstance?.pedido?.id}">${trocaInstance?.pedido?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="troca.valorTroca.label" default="Valor Troca" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: trocaInstance, field: "valorTroca")}</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
