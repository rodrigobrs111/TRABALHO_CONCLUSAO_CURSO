<%@ page import="dominio.Produto" %>



<div class="fieldcontain ${hasErrors(bean: produtoInstance, field: 'nomeProduto', 'error')} ">
	<label for="nomeProduto">
		<g:message code="produto.nomeProduto.label" default="Nome Produto" />
		
	</label>
	<g:textField name="nomeProduto" value="${produtoInstance?.nomeProduto}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: produtoInstance, field: 'numProduto', 'error')} required">
	<label for="numProduto">
		<g:message code="produto.numProduto.label" default="Num Produto" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="numProduto" type="number" value="${produtoInstance.numProduto}" required=""/>
</div>

