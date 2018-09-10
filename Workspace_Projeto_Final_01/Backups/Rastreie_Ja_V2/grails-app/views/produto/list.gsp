
<%@ page import="dominio.Produto" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="kickstart">
		<g:set var="entityName" value="${message(code: 'produto.label', default: 'Produto')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		
		
		<g:form url="[action:'save',controller:'produto']" method = "post" ><br/>
				Número do Produto: <input type = "text" name = "numProduto"/><br/>
					              <input type = "submit" value = "Buscar" >
		</g:form><br/><br/>
		
		
    <section id="list-produto" class="first">
	<table class="table table-bordered">			
				<thead>
					<tr>
						<g:sortableColumn property="numProduto" title="${message(code: 'produto.numProduto.label', default: 'Num Produto')}" />
					
						<g:sortableColumn property="nomeProduto" title="${message(code: 'produto.nomeProduto.label', default: 'Nome Produto')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${produtoInstanceList}" status="i" var="produtoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
			
						<td>${fieldValue(bean: produtoInstance, field: "numProduto")}</td>
					
						<td><g:link action="show" id="${produtoInstance.id}">${fieldValue(bean: produtoInstance, field: "nomeProduto")}</g:link></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<bs:paginate total="${produtoInstanceTotal}" />
			</div>
			</section><br/><br/><br/><br/><br/><br/>
	
	</body>
</html>
