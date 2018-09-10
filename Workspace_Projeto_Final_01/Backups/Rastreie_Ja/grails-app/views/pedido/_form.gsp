<%@ page import="dominio.Pedido" %>



			<div class="control-group fieldcontain ${hasErrors(bean: pedidoInstance, field: 'entrega', 'error')} required">
				<label for="entrega" class="control-label"><g:message code="pedido.entrega.label" default="Entrega" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:select id="entrega" name="entrega.id" from="${dominio.Entrega.list()}" optionKey="id" required="" value="${pedidoInstance?.entrega?.id}" class="many-to-one"/>
					<span class="help-inline">${hasErrors(bean: pedidoInstance, field: 'entrega', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: pedidoInstance, field: 'funcionarioDaTransportadora', 'error')} required">
				<label for="funcionarioDaTransportadora" class="control-label"><g:message code="pedido.funcionarioDaTransportadora.label" default="Funcionario Da Transportadora" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:select id="funcionarioDaTransportadora" name="funcionarioDaTransportadora.id" from="${dominio.FuncionarioDaTransportadora.list()}" optionKey="id" required="" value="${pedidoInstance?.funcionarioDaTransportadora?.id}" class="many-to-one"/>
					<span class="help-inline">${hasErrors(bean: pedidoInstance, field: 'funcionarioDaTransportadora', 'error')}</span>
				</div>
			</div>

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

			<div class="control-group fieldcontain ${hasErrors(bean: pedidoInstance, field: 'transportadora', 'error')} required">
				<label for="transportadora" class="control-label"><g:message code="pedido.transportadora.label" default="Transportadora" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:select id="transportadora" name="transportadora.id" from="${dominio.Transportadora.list()}" optionKey="id" required="" value="${pedidoInstance?.transportadora?.id}" class="many-to-one"/>
					<span class="help-inline">${hasErrors(bean: pedidoInstance, field: 'transportadora', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: pedidoInstance, field: 'valorPedido', 'error')} required">
				<label for="valorPedido" class="control-label"><g:message code="pedido.valorPedido.label" default="Valor Pedido" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="valorPedido" step="any" required="" value="${pedidoInstance.valorPedido}"/>
					<span class="help-inline">${hasErrors(bean: pedidoInstance, field: 'valorPedido', 'error')}</span>
				</div>
			</div>

