<%@ page import="teste_12.Pedido" %>



			<div class="control-group fieldcontain ${hasErrors(bean: pedidoInstance, field: 'produto', 'error')} required">
				<label for="produto" class="control-label"><g:message code="pedido.produto.label" default="Produto" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:select id="produto" name="produto.id" from="${teste_12.Produto.list()}" optionKey="id" required="" value="${pedidoInstance?.produto?.id}" class="many-to-one"/>
					<span class="help-inline">${hasErrors(bean: pedidoInstance, field: 'produto', 'error')}</span>
				</div>
			</div>

