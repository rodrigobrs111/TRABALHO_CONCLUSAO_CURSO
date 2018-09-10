
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
	
	
	<g:form  name="autorizarColeta">
			<g:actionSubmit class="btn btn-primary"  action="_autorizarColeta" value="Autorizar Coleta" />
	</g:form><br/><br/>
	
		
	<section id="list-pedido" class="first">
	
	<table class="table table-bordered">
		<thead>
			<tr>
			
				<g:sortableColumn property="numPedido" title="${message(code: 'pedido.numPedido.label', default: 'Num Pedido')}" />
			
				<th><g:message code="pedido.produto.label" default="Produto" /></th>
			
				<g:sortableColumn property="qtdProdutos" title="${message(code: 'pedido.qtdProdutos.label', default: 'Qtd Produtos')}" />

    	 		<th><g:message code="pedido.funcionarioDaTransportadora.label" default="Funcionario Da Transportadora" /></th>
	
				<th><g:message code="pedido.entrega.label" default="Entrega" /></th>
			
				<th><g:message code="pedido.transportadora.label" default="Transportadora" /></th>
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${pedidoInstanceList}" status="i" var="pedidoInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
			
				<td>${fieldValue(bean: pedidoInstance, field: "numPedido")}</td>
		
	        <g:form action="exibeListaProdutos" > 
				<td><g:link action="exibeListaProdutos"  id="${pedidoInstance.id}">Produtos</g:link></td>
			    <g:hiddenField name="id" value="${pedidoInstance?.id}" />
		    </g:form>	
			
				<td>${fieldValue(bean: pedidoInstance, field: "qtdProdutos")}</td>
		
				<td><g:link action="show" id="${pedidoInstance.id}">${fieldValue(bean: pedidoInstance, field: "funcionarioDaTransportadora")}</g:link></td>
		
				<td><g:link action="show" id="${pedidoInstance.id}">${fieldValue(bean: pedidoInstance, field: "entrega")}</g:link></td>
			
				<td><g:link action="show" id="${pedidoInstance.id}">${fieldValue(bean: pedidoInstance, field: "transportadora")}</g:link></td>
		
			
			</tr>
		</g:each>
		</tbody>
	</table>
		<div class="pagination">
			<bs:paginate total="${pedidoInstanceTotal}" />
		</div>
	</section><br/><br/><br/><br/><br/><br/>



</body>

</html>
