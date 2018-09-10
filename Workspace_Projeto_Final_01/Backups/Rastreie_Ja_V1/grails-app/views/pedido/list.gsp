
<%@ page import="dominio.Pedido" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'pedido.label', default: 'Pedido')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-pedido" class="first">
	<table class="table table-bordered">
		<thead>
			<tr>
		
                <g:sortableColumn property="numPedido" title="${message(code: 'pedido.numPedido.label', default: 'Num Pedido')}" />
			
				<th><g:message code="pedido.produto.label" default="Produto" /></th>
			
				<g:sortableColumn property="qtdProdutos" title="${message(code: 'pedido.qtdProdutos.label', default: 'Qtd Produtos')}" />
			
				<g:sortableColumn property="status" title="${message(code: 'pedido.status.label', default: 'Status')}" />
			
				<g:sortableColumn property="valorPedido" title="${message(code: 'pedido.valorPedido.label', default: 'Valor Pedido')}" />
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${pedidoInstanceList}" status="i" var="pedidoInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td><g:link action="show" id="${pedidoInstance.id}">${fieldValue(bean: pedidoInstance, field: "numPedido")}</g:link></td>
			
				<td>${fieldValue(bean: pedidoInstance, field: "produto")}</td>
			
				<td>${fieldValue(bean: pedidoInstance, field: "qtdProdutos")}</td>
			
				<td>${fieldValue(bean: pedidoInstance, field: "status")}</td>
			
				<td>${fieldValue(bean: pedidoInstance, field: "valorPedido")}</td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${pedidoInstanceTotal}" />
	</div>
</section>

</body>

</html>
