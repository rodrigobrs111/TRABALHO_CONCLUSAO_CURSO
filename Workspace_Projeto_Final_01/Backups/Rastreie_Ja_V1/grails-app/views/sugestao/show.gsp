
<%@ page import="dominio.Sugestao" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'sugestao.label', default: 'Sugestao')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-sugestao" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="sugestao.descSugestao.label" default="Desc Sugestao" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: sugestaoInstance, field: "descSugestao")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="sugestao.numSugestao.label" default="Num Sugestao" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: sugestaoInstance, field: "numSugestao")}</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
