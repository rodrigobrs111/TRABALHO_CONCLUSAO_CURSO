<%@ page import="teste_15.Teste" %>



<div class="fieldcontain ${hasErrors(bean: testeInstance, field: 'numPedido', 'error')} required">
	<label for="numPedido">
		<g:message code="teste.numPedido.label" default="Num Pedido" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="numPedido" type="number" value="${testeInstance.numPedido}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: testeInstance, field: 'tam', 'error')} required">
	<label for="tam">
		<g:message code="teste.tam.label" default="Tam" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="tam" type="number" value="${testeInstance.tam}" required=""/>
</div>

