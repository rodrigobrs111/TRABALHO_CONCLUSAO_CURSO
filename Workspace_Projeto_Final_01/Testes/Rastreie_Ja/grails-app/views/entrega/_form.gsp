<%@ page import="dominio.Entrega" %>



			<div class="control-group fieldcontain ${hasErrors(bean: entregaInstance, field: 'classificacao', 'error')} ">
				<label for="classificacao" class="control-label"><g:message code="entrega.classificacao.label" default="Classificacao" /></label>
				<div class="controls">
					<g:textField name="classificacao" value="${entregaInstance?.classificacao}"/>
					<span class="help-inline">${hasErrors(bean: entregaInstance, field: 'classificacao', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: entregaInstance, field: 'dataEncerramento', 'error')} required">
				<label for="dataEncerramento" class="control-label"><g:message code="entrega.dataEncerramento.label" default="Data Encerramento" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<bs:datePicker name="dataEncerramento" precision="day"  value="${entregaInstance?.dataEncerramento}"  />
					<span class="help-inline">${hasErrors(bean: entregaInstance, field: 'dataEncerramento', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: entregaInstance, field: 'dataEntrega', 'error')} required">
				<label for="dataEntrega" class="control-label"><g:message code="entrega.dataEntrega.label" default="Data Entrega" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<bs:datePicker name="dataEntrega" precision="day"  value="${entregaInstance?.dataEntrega}"  />
					<span class="help-inline">${hasErrors(bean: entregaInstance, field: 'dataEntrega', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: entregaInstance, field: 'dataRecebimento', 'error')} required">
				<label for="dataRecebimento" class="control-label"><g:message code="entrega.dataRecebimento.label" default="Data Recebimento" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<bs:datePicker name="dataRecebimento" precision="day"  value="${entregaInstance?.dataRecebimento}"  />
					<span class="help-inline">${hasErrors(bean: entregaInstance, field: 'dataRecebimento', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: entregaInstance, field: 'dataSolicitacao', 'error')} required">
				<label for="dataSolicitacao" class="control-label"><g:message code="entrega.dataSolicitacao.label" default="Data Solicitacao" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<bs:datePicker name="dataSolicitacao" precision="day"  value="${entregaInstance?.dataSolicitacao}"  />
					<span class="help-inline">${hasErrors(bean: entregaInstance, field: 'dataSolicitacao', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: entregaInstance, field: 'status', 'error')} ">
				<label for="status" class="control-label"><g:message code="entrega.status.label" default="Status" /></label>
				<div class="controls">
					<g:textField name="status" value="${entregaInstance?.status}"/>
					<span class="help-inline">${hasErrors(bean: entregaInstance, field: 'status', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: entregaInstance, field: 'valorEntrega', 'error')} required">
				<label for="valorEntrega" class="control-label"><g:message code="entrega.valorEntrega.label" default="Valor Entrega" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="valorEntrega" step="any" required="" value="${entregaInstance.valorEntrega}"/>
					<span class="help-inline">${hasErrors(bean: entregaInstance, field: 'valorEntrega', 'error')}</span>
				</div>
			</div>

