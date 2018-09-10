
<%@ page import="dominio.Entrega" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'entrega.label', default: 'Entrega')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-entrega" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>
			
				<g:sortableColumn property="classificacao" title="${message(code: 'entrega.classificacao.label', default: 'Classificacao')}" />
			
				<g:sortableColumn property="dataEncerramento" title="${message(code: 'entrega.dataEncerramento.label', default: 'Data Encerramento')}" />
			
				<g:sortableColumn property="dataEntrega" title="${message(code: 'entrega.dataEntrega.label', default: 'Data Entrega')}" />
			
				<g:sortableColumn property="dataRecebimento" title="${message(code: 'entrega.dataRecebimento.label', default: 'Data Recebimento')}" />
			
				<g:sortableColumn property="dataSolicitacao" title="${message(code: 'entrega.dataSolicitacao.label', default: 'Data Solicitacao')}" />
			
				<g:sortableColumn property="status" title="${message(code: 'entrega.status.label', default: 'Status')}" />
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${entregaInstanceList}" status="i" var="entregaInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td><g:link action="show" id="${entregaInstance.id}">${fieldValue(bean: entregaInstance, field: "classificacao")}</g:link></td>
			
				<td><g:formatDate date="${entregaInstance.dataEncerramento}" /></td>
			
				<td><g:formatDate date="${entregaInstance.dataEntrega}" /></td>
			
				<td><g:formatDate date="${entregaInstance.dataRecebimento}" /></td>
			
				<td><g:formatDate date="${entregaInstance.dataSolicitacao}" /></td>
			
				<td>${fieldValue(bean: entregaInstance, field: "status")}</td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${entregaInstanceTotal}" />
	</div>
</section>

</body>

</html>
