
<%@ page import="teste_15.Teste2" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'teste2.label', default: 'Teste2')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-teste2" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-teste2" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nome" title="${message(code: 'teste2.nome.label', default: 'Nome')}" />
					
						<th><g:message code="teste2.t.label" default="T" /></th>
					
						<g:sortableColumn property="tel" title="${message(code: 'teste2.tel.label', default: 'Tel')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${teste2InstanceList}" status="i" var="teste2Instance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${teste2Instance.id}">${fieldValue(bean: teste2Instance, field: "nome")}</g:link></td>
					
						<td>${fieldValue(bean: teste2Instance, field: "t")}</td>
					
						<td>${fieldValue(bean: teste2Instance, field: "tel")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${teste2InstanceTotal}" />
			</div>
		</div>
	</body>
</html>
