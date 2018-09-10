
<%@ page import="dominio.Sugestao" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'sugestao.label', default: 'Sugestao')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
	
		<g:form url="[action:'save',controller:'produto']" method = "post" ><br/>
		   	  Número da Sugestão: <input type = "text" name = "numProduto"/><br/>
					              <input type = "submit" value = "Buscar" >
		</g:form><br/><br/>
	
	
<section id="list-sugestao" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>
			
				<g:sortableColumn property="numSugestao" title="${message(code: 'sugestao.numSugestao.label', default: 'Num Sugestao')}" />
	
				<g:sortableColumn property="descSugestao" title="${message(code: 'sugestao.descSugestao.label', default: 'Desc Sugestao')}" />
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${sugestaoInstanceList}" status="i" var="sugestaoInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td>${fieldValue(bean: sugestaoInstance, field: "numSugestao")}</td>
	
				<td><g:link action="show" id="${sugestaoInstance.id}">${fieldValue(bean: sugestaoInstance, field: "descSugestao")}</g:link></td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${sugestaoInstanceTotal}" />
	</div>
</section><br/><br/><br/><br/><br/><br/>


</body>

</html>
