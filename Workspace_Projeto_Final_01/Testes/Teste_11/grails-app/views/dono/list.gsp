
<%@ page import="teste_11.Dono" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'dono.label', default: 'Dono')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-dono" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-dono" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="dono.empresa.label" default="Empresa" /></th>
					
						<g:sortableColumn property="nome" title="${message(code: 'dono.nome.label', default: 'Nome')}" />
					
						<g:sortableColumn property="num" title="${message(code: 'dono.num.label', default: 'Num')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${donoInstanceList}" status="i" var="donoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${donoInstance.id}">${fieldValue(bean: donoInstance, field: "empresa")}</g:link></td>
					
						<td>${fieldValue(bean: donoInstance, field: "nome")}</td>
					
						<td>${fieldValue(bean: donoInstance, field: "num")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${donoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
