
<%@ page import="teste_12.Produto" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'produto.label', default: 'Produto')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-produto" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>
			
				<g:sortableColumn property="nome" title="${message(code: 'produto.nome.label', default: 'Nome')}" />
			
				<th><g:message code="produto.pedido.label" default="Pedido" /></th>
			
				<g:sortableColumn property="preco" title="${message(code: 'produto.preco.label', default: 'Preco')}" />
			
				<g:sortableColumn property="quantidade" title="${message(code: 'produto.quantidade.label', default: 'Quantidade')}" />
			
				<g:sortableColumn property="teste1" title="${message(code: 'produto.teste1.label', default: 'Teste1')}" />
			
				<g:sortableColumn property="teste10" title="${message(code: 'produto.teste10.label', default: 'Teste10')}" />
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${produtoInstanceList}" status="i" var="produtoInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td><g:link action="show" id="${produtoInstance.id}">${fieldValue(bean: produtoInstance, field: "nome")}</g:link></td>
			
				<td>${fieldValue(bean: produtoInstance, field: "pedido")}</td>
			
				<td>${fieldValue(bean: produtoInstance, field: "preco")}</td>
			
				<td>${fieldValue(bean: produtoInstance, field: "quantidade")}</td>
			
				<td>${fieldValue(bean: produtoInstance, field: "teste1")}</td>
			
				<td>${fieldValue(bean: produtoInstance, field: "teste10")}</td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${produtoInstanceTotal}" />
	</div>
</section>

</body>

</html>
