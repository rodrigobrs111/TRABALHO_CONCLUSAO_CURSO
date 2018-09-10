<%@ page import="dominio.Troca" %>



			<div class="control-group fieldcontain ${hasErrors(bean: trocaInstance, field: 'consumidor', 'error')} required">
				<label for="consumidor" class="control-label"><g:message code="troca.consumidor.label" default="Consumidor" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:select id="consumidor" name="consumidor.id" from="${dominio.Consumidor.list()}" optionKey="id" required="" value="${trocaInstance?.consumidor?.id}" class="many-to-one"/>
					<span class="help-inline">${hasErrors(bean: trocaInstance, field: 'consumidor', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: trocaInstance, field: 'dataColeta', 'error')} required">
				<label for="dataColeta" class="control-label"><g:message code="troca.dataColeta.label" default="Data Coleta" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<bs:datePicker name="dataColeta" precision="day"  value="${trocaInstance?.dataColeta}"  />
					<span class="help-inline">${hasErrors(bean: trocaInstance, field: 'dataColeta', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: trocaInstance, field: 'dataEntregaConsumidor', 'error')} required">
				<label for="dataEntregaConsumidor" class="control-label"><g:message code="troca.dataEntregaConsumidor.label" default="Data Entrega Consumidor" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<bs:datePicker name="dataEntregaConsumidor" precision="day"  value="${trocaInstance?.dataEntregaConsumidor}"  />
					<span class="help-inline">${hasErrors(bean: trocaInstance, field: 'dataEntregaConsumidor', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: trocaInstance, field: 'dataEntregaVarej', 'error')} required">
				<label for="dataEntregaVarej" class="control-label"><g:message code="troca.dataEntregaVarej.label" default="Data Entrega Varej" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<bs:datePicker name="dataEntregaVarej" precision="day"  value="${trocaInstance?.dataEntregaVarej}"  />
					<span class="help-inline">${hasErrors(bean: trocaInstance, field: 'dataEntregaVarej', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: trocaInstance, field: 'dataSolicit', 'error')} required">
				<label for="dataSolicit" class="control-label"><g:message code="troca.dataSolicit.label" default="Data Solicit" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<bs:datePicker name="dataSolicit" precision="day"  value="${trocaInstance?.dataSolicit}"  />
					<span class="help-inline">${hasErrors(bean: trocaInstance, field: 'dataSolicit', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: trocaInstance, field: 'devolucao', 'error')} required">
				<label for="devolucao" class="control-label"><g:message code="troca.devolucao.label" default="Devolucao" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:select id="devolucao" name="devolucao.id" from="${dominio.Devolucao.list()}" optionKey="id" required="" value="${trocaInstance?.devolucao?.id}" class="many-to-one"/>
					<span class="help-inline">${hasErrors(bean: trocaInstance, field: 'devolucao', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: trocaInstance, field: 'numPedidoAnt', 'error')} required">
				<label for="numPedidoAnt" class="control-label"><g:message code="troca.numPedidoAnt.label" default="Num Pedido Ant" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="numPedidoAnt" required="" value="${trocaInstance.numPedidoAnt}"/>
					<span class="help-inline">${hasErrors(bean: trocaInstance, field: 'numPedidoAnt', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: trocaInstance, field: 'numPedidoNovo', 'error')} required">
				<label for="numPedidoNovo" class="control-label"><g:message code="troca.numPedidoNovo.label" default="Num Pedido Novo" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="numPedidoNovo" required="" value="${trocaInstance.numPedidoNovo}"/>
					<span class="help-inline">${hasErrors(bean: trocaInstance, field: 'numPedidoNovo', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: trocaInstance, field: 'numTroca', 'error')} required">
				<label for="numTroca" class="control-label"><g:message code="troca.numTroca.label" default="Num Troca" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="numTroca" required="" value="${trocaInstance.numTroca}"/>
					<span class="help-inline">${hasErrors(bean: trocaInstance, field: 'numTroca', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: trocaInstance, field: 'pedido', 'error')} required">
				<label for="pedido" class="control-label"><g:message code="troca.pedido.label" default="Pedido" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:select id="pedido" name="pedido.id" from="${dominio.Pedido.list()}" optionKey="id" required="" value="${trocaInstance?.pedido?.id}" class="many-to-one"/>
					<span class="help-inline">${hasErrors(bean: trocaInstance, field: 'pedido', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: trocaInstance, field: 'valorTroca', 'error')} required">
				<label for="valorTroca" class="control-label"><g:message code="troca.valorTroca.label" default="Valor Troca" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="valorTroca" step="any" required="" value="${trocaInstance.valorTroca}"/>
					<span class="help-inline">${hasErrors(bean: trocaInstance, field: 'valorTroca', 'error')}</span>
				</div>
			</div>

