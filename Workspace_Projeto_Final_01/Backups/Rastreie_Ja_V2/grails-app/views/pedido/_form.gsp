<%@ page import="dominio.Pedido" %>



			<div class="control-group fieldcontain ${hasErrors(bean: pedidoInstance, field: 'numPedido', 'error')} required">
				<label for="numPedido" class="control-label"><g:message code="pedido.numPedido.label" default="Num Pedido" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="numPedido" required="" value="${pedidoInstance.numPedido}"/>
					<span class="help-inline">${hasErrors(bean: pedidoInstance, field: 'numPedido', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: pedidoInstance, field: 'qtdProdutos', 'error')} required">
				<label for="qtdProdutos" class="control-label"><g:message code="pedido.qtdProdutos.label" default="Qtd Produtos" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="qtdProdutos" required="" value="${pedidoInstance.qtdProdutos}"/>
					<span class="help-inline">${hasErrors(bean: pedidoInstance, field: 'qtdProdutos', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: pedidoInstance, field: 'status', 'error')} ">
				<label for="status" class="control-label"><g:message code="pedido.status.label" default="Status" /></label>
				<div class="controls">
					<g:textField name="status" value="${pedidoInstance?.status}"/>
					<span class="help-inline">${hasErrors(bean: pedidoInstance, field: 'status', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: pedidoInstance, field: 'valorPedido', 'error')} required">
				<label for="valorPedido" class="control-label"><g:message code="pedido.valorPedido.label" default="Valor Pedido" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="valorPedido" step="any" required="" value="${pedidoInstance.valorPedido}"/>
					<span class="help-inline">${hasErrors(bean: pedidoInstance, field: 'valorPedido', 'error')}</span>
				</div>
			</div>

