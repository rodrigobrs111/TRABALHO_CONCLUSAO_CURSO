
<%@ page import="dominio.Reclamacao" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'reclamacao.label', default: 'Reclamacao')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-reclamacao" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>

				<g:sortableColumn property="numReclamacao" title="${message(code: 'reclamacao.numReclamacao.label', default: 'Num Reclamacao')}" />

				<g:sortableColumn property="numPedido" title="${message(code: 'reclamacao.numPedido.label', default: 'Num Pedido')}" />
			
				<g:sortableColumn property="dataAbertura" title="${message(code: 'reclamacao.dataAbertura.label', default: 'Data Abertura')}" />
			
				<g:sortableColumn property="dataResposta" title="${message(code: 'reclamacao.dataResposta.label', default: 'Data Resposta')}" />
			
				<g:sortableColumn property="dataSolucaoProblema" title="${message(code: 'reclamacao.dataSolucaoProblema.label', default: 'Data Solucao Problema')}" />
			
			
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${reclamacaoInstanceList}" status="i" var="reclamacaoInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td>${fieldValue(bean: reclamacaoInstance, field: "numReclamacao")}</td>
			
				<td>${fieldValue(bean: reclamacaoInstance, field: "numPedido")}</td>
			
				<td><g:link action="show" id="${reclamacaoInstance.id}">${fieldValue(bean: reclamacaoInstance, field: "dataAbertura")}</g:link></td>
			
				<td><g:formatDate date="${reclamacaoInstance.dataResposta}" /></td>
			
				<td><g:formatDate date="${reclamacaoInstance.dataSolucaoProblema}" /></td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${reclamacaoInstanceTotal}" />
	</div>
</section>

</body>

</html>
