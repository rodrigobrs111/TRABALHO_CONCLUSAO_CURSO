
<%@ page import="teste_05.Customer" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'customer.label', default: 'Customer')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-customer" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-customer" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list customer">
			
				<g:if test="${customerInstance?.n1}">
				<li class="fieldcontain">
					<span id="n1-label" class="property-label"><g:message code="customer.n1.label" default="N1" /></span>
					
						<span class="property-value" aria-labelledby="n1-label"><g:fieldValue bean="${customerInstance}" field="n1"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${customerInstance?.n2}">
				<li class="fieldcontain">
					<span id="n2-label" class="property-label"><g:message code="customer.n2.label" default="N2" /></span>
					
						<span class="property-value" aria-labelledby="n2-label"><g:fieldValue bean="${customerInstance}" field="n2"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${customerInstance?.n3}">
				<li class="fieldcontain">
					<span id="n3-label" class="property-label"><g:message code="customer.n3.label" default="N3" /></span>
					
						<span class="property-value" aria-labelledby="n3-label"><g:fieldValue bean="${customerInstance}" field="n3"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${customerInstance?.nome}">
				<li class="fieldcontain">
					<span id="nome-label" class="property-label"><g:message code="customer.nome.label" default="Nome" /></span>
					
						<span class="property-value" aria-labelledby="nome-label"><g:fieldValue bean="${customerInstance}" field="nome"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${customerInstance?.tel}">
				<li class="fieldcontain">
					<span id="tel-label" class="property-label"><g:message code="customer.tel.label" default="Tel" /></span>
					
						<span class="property-value" aria-labelledby="tel-label"><g:fieldValue bean="${customerInstance}" field="tel"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${customerInstance?.id}" />
					<g:link class="edit" action="edit" id="${customerInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
