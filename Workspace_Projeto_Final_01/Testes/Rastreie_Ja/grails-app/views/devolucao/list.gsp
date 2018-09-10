
<%@ page import="dominio.Devolucao" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'devolucao.label', default: 'Devolucao')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-devolucao" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>
			
			
				<g:sortableColumn property="numDevol" title="${message(code: 'devolucao.numDevol.label', default: 'Num Devol')}" />
			
				<g:sortableColumn property="numPedido" title="${message(code: 'devolucao.numPedido.label', default: 'Num Pedido')}" />
			
				<th><g:message code="devolucao.transportadora.label" default="Transportadora" /></th>
	
				<th><g:message code="devolucao.funcionarioDoVarejista.label" default="Funcionario Do Varejista" /></th>
			
				<g:sortableColumn property="valorDevol" title="${message(code: 'devolucao.valorDevol.label', default: 'Valor Devol')}" />
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${devolucaoInstanceList}" status="i" var="devolucaoInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
			
				<td>${fieldValue(bean: devolucaoInstance, field: "numDevol")}</td>
			
				<td>${fieldValue(bean: devolucaoInstance, field: "numPedido")}</td>
			
				<td>${fieldValue(bean: devolucaoInstance, field: "transportadora")}</td>
	
				<td><g:link action="show" id="${devolucaoInstance.id}">${fieldValue(bean: devolucaoInstance, field: "funcionarioDoVarejista")}</g:link></td>
			
				<td>${fieldValue(bean: devolucaoInstance, field: "valorDevol")}</td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${devolucaoInstanceTotal}" />
	</div>
</section>

</body>

</html>
