
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



	<g:form url="[action:'_encerrarReclamacao',controller:'reclamacao']" method = "post" >
			Número da Reclamação: <input type = "text"                   name   = "numReclamacao" /><br/>
						          <input type = "submit"                 value  = "Encerrar Reclamacao" onclick="return confirm('${message(code: 'Tem certeza que deseja encerrar a reclamação?', default: 'Tem certeza que deseja encerrar a reclamação?')}');" >
	</g:form><br/><br/><br/><br/>

	
	<section id="list-reclamacao" class="first">
	
	<table class="table table-bordered">
		<thead>
			<tr>
				<g:sortableColumn property="numReclamacao" title="${message(code: 'reclamacao.numReclamacao.label', default: 'Num Reclamacao')}" />
			
				<g:sortableColumn property="dataAbertura" title="${message(code: 'reclamacao.dataAbertura.label', default: 'Data Abertura')}" />
			
				<g:sortableColumn property="dataResposta" title="${message(code: 'reclamacao.dataResposta.label', default: 'Data Resposta')}" />
			
				<g:sortableColumn property="dataSolucaoProblema" title="${message(code: 'reclamacao.dataSolucaoProblema.label', default: 'Data Solucao Problema')}" />
			
				<g:sortableColumn property="status" title="${message(code: 'reclamacao.status.label', default: 'Status')}" />

			    <g:sortableColumn property="comentario" title="${message(code: 'reclamacao.comentario.label', default: 'Comentario')}" />

                <th><g:message code="reclamacao.supervisorDoVarejista.label" default="supervisorDoVarejista" /></th>

                <th><g:message code="reclamacao.pedido.label" default="Pedido" /></th>
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${reclamacaoInstanceList}" status="i" var="reclamacaoInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			

			    <td><g:link action="show" id="${reclamacaoInstance.id}">${fieldValue(bean: reclamacaoInstance, field: "numReclamacao")}</g:link></td>

			    <td><g:formatDate date="${reclamacaoInstance.dataAbertura}" /></td>
			
				<td><g:formatDate date="${reclamacaoInstance.dataResposta}" /></td>
			
				<td><g:formatDate date="${reclamacaoInstance.dataSolucaoProblema}" /></td>
			
				<td>${fieldValue(bean: reclamacaoInstance, field: "status")}</td>

				<td>${fieldValue(bean: reclamacaoInstance, field: "comentario")}</td>

	            <td><g:link action="show" id="${reclamacaoInstance.id}">${fieldValue(bean: reclamacaoInstance, field: "supervisorDoVarejista")}</g:link></td>

	            <td><g:link action="show" id="${reclamacaoInstance.id}">${fieldValue(bean: reclamacaoInstance, field: "pedido")}</g:link></td>
						
			</tr>
		</g:each>
		</tbody>
	</table>
		<div class="pagination">
			<bs:paginate total="${reclamacaoInstanceTotal}" />
		</div>
	</section><br/><br/><br/><br/><br/><br/>

</body>

</html>
