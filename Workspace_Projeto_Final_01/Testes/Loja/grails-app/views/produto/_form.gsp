<%@ page import="loja.Produto" %>



<div class="fieldcontain ${hasErrors(bean: produtoInstance, field: 'nome', 'error')} ">
	<label for="nome">
		<g:message code="produto.nome.label" default="Nome" />
		
	</label>
	<g:textField name="nome" value="${produtoInstance?.nome}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: produtoInstance, field: 'preco', 'error')} required">
	<label for="preco">
		<g:message code="produto.preco.label" default="Preco" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="preco" value="${fieldValue(bean: produtoInstance, field: 'preco')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: produtoInstance, field: 'quantidade', 'error')} required">
	<label for="quantidade">
		<g:message code="produto.quantidade.label" default="Quantidade" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="quantidade" type="number" value="${produtoInstance.quantidade}" required=""/>
</div>

