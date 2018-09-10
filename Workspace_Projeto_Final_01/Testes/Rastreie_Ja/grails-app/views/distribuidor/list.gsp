
<%@ page import="dominio.Distribuidor" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'distribuidor.label', default: 'Distribuidor')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-distribuidor" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>
			
	
				<g:sortableColumn property="numDist" title="${message(code: 'distribuidor.numDist.label', default: 'Num Dist')}" />
			
				<g:sortableColumn property="nomeDist" title="${message(code: 'distribuidor.nomeDist.label', default: 'Nome Dist')}" />
			
				<th><g:message code="distribuidor.supervisorDoVarejista.label" default="Supervisor Do Varejista" /></th>
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${distribuidorInstanceList}" status="i" var="distribuidorInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
			
				<td>${fieldValue(bean: distribuidorInstance, field: "nomeDist")}</td>
			
				<td>${fieldValue(bean: distribuidorInstance, field: "numDist")}</td>
	
				<td><g:link action="show" id="${distribuidorInstance.id}">${fieldValue(bean: distribuidorInstance, field: "supervisorDoVarejista")}</g:link></td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${distribuidorInstanceTotal}" />
	</div>
</section>

</body>

</html>
