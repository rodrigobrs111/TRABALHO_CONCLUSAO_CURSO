
<%@ page import="dominio.Pedido" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'pedido.label', default: 'Pedido')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-pedido" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="pedido.entrega.label" default="Entrega" /></td>
				
				<td valign="top" class="value"><g:link controller="entrega" action="show" id="${pedidoInstance?.entrega?.id}">${pedidoInstance?.entrega?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="pedido.funcionarioDaTransportadora.label" default="Funcionario Da Transportadora" /></td>
				
				<td valign="top" class="value"><g:link controller="funcionarioDaTransportadora" action="show" id="${pedidoInstance?.funcionarioDaTransportadora?.id}">${pedidoInstance?.funcionarioDaTransportadora?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="pedido.numPedido.label" default="Num Pedido" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: pedidoInstance, field: "numPedido")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="pedido.qtdProdutos.label" default="Qtd Produtos" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: pedidoInstance, field: "qtdProdutos")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="pedido.transportadora.label" default="Transportadora" /></td>
				
				<td valign="top" class="value"><g:link controller="transportadora" action="show" id="${pedidoInstance?.transportadora?.id}">${pedidoInstance?.transportadora?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="pedido.valorPedido.label" default="Valor Pedido" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: pedidoInstance, field: "valorPedido")}</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
