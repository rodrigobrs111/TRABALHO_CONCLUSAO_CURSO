
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
			
			
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${distribuidorInstanceList}" status="i" var="distribuidorInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td><g:link action="show" id="${distribuidorInstance.id}">${fieldValue(bean: distribuidorInstance, field: "numDist")}</g:link></td>
			
				<td>${fieldValue(bean: distribuidorInstance, field: "nomeDist")}</td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${distribuidorInstanceTotal}" />
	</div>
</section><br/><br/><br/><br/><br/><br/>

</body>

</html>
