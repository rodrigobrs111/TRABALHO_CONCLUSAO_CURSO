<%@ page import="dominio.Devolucao" %>



			<div class="control-group fieldcontain ${hasErrors(bean: devolucaoInstance, field: 'funcionarioDoVarejista', 'error')} required">
				<label for="funcionarioDoVarejista" class="control-label"><g:message code="devolucao.funcionarioDoVarejista.label" default="Funcionario Do Varejista" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:select id="funcionarioDoVarejista" name="funcionarioDoVarejista.id" from="${dominio.FuncionarioDoVarejista.list()}" optionKey="id" required="" value="${devolucaoInstance?.funcionarioDoVarejista?.id}" class="many-to-one"/>
					<span class="help-inline">${hasErrors(bean: devolucaoInstance, field: 'funcionarioDoVarejista', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: devolucaoInstance, field: 'numDevol', 'error')} required">
				<label for="numDevol" class="control-label"><g:message code="devolucao.numDevol.label" default="Num Devol" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="numDevol" required="" value="${devolucaoInstance.numDevol}"/>
					<span class="help-inline">${hasErrors(bean: devolucaoInstance, field: 'numDevol', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: devolucaoInstance, field: 'numPedido', 'error')} required">
				<label for="numPedido" class="control-label"><g:message code="devolucao.numPedido.label" default="Num Pedido" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="numPedido" required="" value="${devolucaoInstance.numPedido}"/>
					<span class="help-inline">${hasErrors(bean: devolucaoInstance, field: 'numPedido', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: devolucaoInstance, field: 'transportadora', 'error')} required">
				<label for="transportadora" class="control-label"><g:message code="devolucao.transportadora.label" default="Transportadora" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:select id="transportadora" name="transportadora.id" from="${dominio.Transportadora.list()}" optionKey="id" required="" value="${devolucaoInstance?.transportadora?.id}" class="many-to-one"/>
					<span class="help-inline">${hasErrors(bean: devolucaoInstance, field: 'transportadora', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: devolucaoInstance, field: 'valorDevol', 'error')} required">
				<label for="valorDevol" class="control-label"><g:message code="devolucao.valorDevol.label" default="Valor Devol" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="valorDevol" step="any" required="" value="${devolucaoInstance.valorDevol}"/>
					<span class="help-inline">${hasErrors(bean: devolucaoInstance, field: 'valorDevol', 'error')}</span>
				</div>
			</div>

