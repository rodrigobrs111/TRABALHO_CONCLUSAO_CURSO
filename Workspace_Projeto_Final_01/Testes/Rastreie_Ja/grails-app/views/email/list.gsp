
<%@ page import="extra.Email" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'email.label', default: 'Email')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-email" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${emailInstanceList}" status="i" var="emailInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${emailInstanceTotal}" />
	</div>
</section>

</body>

</html>
