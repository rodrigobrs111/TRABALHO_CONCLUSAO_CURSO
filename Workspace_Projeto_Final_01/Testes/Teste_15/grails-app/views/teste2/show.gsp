
<%@ page import="teste_15.Teste2" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'teste2.label', default: 'Teste2')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-teste2" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-teste2" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list teste2">
			
				<g:if test="${teste2Instance?.nome}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"><g:message code="teste2.nome.label" default="Nome" /></span>
					
						<span class="property-value" aria-labelledby="nome-label"><g:fieldValue bean="${teste2Instance}" field="nome"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${teste2Instance?.t}">
				<li class="fieldcontain">
					<span id="t-label" class="property-label"><g:message code="teste2.t.label" default="T" /></span>
					
						<span class="property-value" aria-labelledby="t-label"><g:link controller="teste" action="show" id="${teste2Instance?.t?.id}">${teste2Instance?.t?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${teste2Instance?.tel}">
				<li class="fieldcontain">
					<span id="tel-label" class="property-label"><g:message code="teste2.tel.label" default="Tel" /></span>
					
						<span class="property-value" aria-labelledby="tel-label"><g:fieldValue bean="${teste2Instance}" field="tel"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${teste2Instance?.id}" />
					<g:link class="edit" action="edit" id="${teste2Instance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
