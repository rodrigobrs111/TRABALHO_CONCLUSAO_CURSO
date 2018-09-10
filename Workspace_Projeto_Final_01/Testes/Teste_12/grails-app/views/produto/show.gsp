
<%@ page import="teste_12.Produto" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'produto.label', default: 'Produto')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-produto" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.nome.label" default="Nome" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: produtoInstance, field: "nome")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.pedido.label" default="Pedido" /></td>
				
				<td valign="top" class="value"><g:link controller="pedido" action="show" id="${produtoInstance?.pedido?.id}">${produtoInstance?.pedido?.encodeAsHTML()}</g:link></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.preco.label" default="Preco" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: produtoInstance, field: "preco")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.quantidade.label" default="Quantidade" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: produtoInstance, field: "quantidade")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.teste1.label" default="Teste1" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: produtoInstance, field: "teste1")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.teste10.label" default="Teste10" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: produtoInstance, field: "teste10")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.teste11.label" default="Teste11" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: produtoInstance, field: "teste11")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.teste12.label" default="Teste12" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: produtoInstance, field: "teste12")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.teste13.label" default="Teste13" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: produtoInstance, field: "teste13")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.teste14.label" default="Teste14" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: produtoInstance, field: "teste14")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.teste15.label" default="Teste15" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: produtoInstance, field: "teste15")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.teste16.label" default="Teste16" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: produtoInstance, field: "teste16")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.teste17.label" default="Teste17" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: produtoInstance, field: "teste17")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.teste18.label" default="Teste18" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: produtoInstance, field: "teste18")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.teste19.label" default="Teste19" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: produtoInstance, field: "teste19")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.teste2.label" default="Teste2" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: produtoInstance, field: "teste2")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.teste20.label" default="Teste20" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: produtoInstance, field: "teste20")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.teste3.label" default="Teste3" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: produtoInstance, field: "teste3")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.teste4.label" default="Teste4" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: produtoInstance, field: "teste4")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.teste5.label" default="Teste5" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: produtoInstance, field: "teste5")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.teste6.label" default="Teste6" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: produtoInstance, field: "teste6")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.teste7.label" default="Teste7" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: produtoInstance, field: "teste7")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.teste8.label" default="Teste8" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: produtoInstance, field: "teste8")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="produto.teste9.label" default="Teste9" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: produtoInstance, field: "teste9")}</td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
