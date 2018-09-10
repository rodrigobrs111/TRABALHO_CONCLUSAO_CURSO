
<%@ page import="teste_12.Pedido" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'pedido.label', default: 'Pedido')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
			<g:form url="[action:'show',controller:'pedido']" method = "post" >
		             <input type = "hidden"                  name   = "numPedido"/>
			         <input type = "submit" value = "Cancelar Entrega" >
		</g:form><br/><br/><br/><br/>
		
		
	
	
<section id="list-pedido" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>
			
				<th><g:message code="pedido.produto.label" default="Produto" /></th>
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${pedidoInstanceList}" status="i" var="pedidoInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td><g:link action="show" id="${pedidoInstance.id}">${fieldValue(bean: pedidoInstance, field: "produto")}</g:link></td>
			
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
