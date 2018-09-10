<%@ page import="dominio.Reclamacao" %>



			<div class="control-group fieldcontain ${hasErrors(bean: reclamacaoInstance, field: 'dataAbertura', 'error')} required">
				<label for="dataAbertura" class="control-label"><g:message code="reclamacao.dataAbertura.label" default="Data Abertura" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<bs:datePicker name="dataAbertura" precision="day"  value="${reclamacaoInstance?.dataAbertura}"  />
					<span class="help-inline">${hasErrors(bean: reclamacaoInstance, field: 'dataAbertura', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: reclamacaoInstance, field: 'dataResposta', 'error')} required">
				<label for="dataResposta" class="control-label"><g:message code="reclamacao.dataResposta.label" default="Data Resposta" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<bs:datePicker name="dataResposta" precision="day"  value="${reclamacaoInstance?.dataResposta}"  />
					<span class="help-inline">${hasErrors(bean: reclamacaoInstance, field: 'dataResposta', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: reclamacaoInstance, field: 'dataSolucaoProblema', 'error')} required">
				<label for="dataSolucaoProblema" class="control-label"><g:message code="reclamacao.dataSolucaoProblema.label" default="Data Solucao Problema" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<bs:datePicker name="dataSolucaoProblema" precision="day"  value="${reclamacaoInstance?.dataSolucaoProblema}"  />
					<span class="help-inline">${hasErrors(bean: reclamacaoInstance, field: 'dataSolucaoProblema', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: reclamacaoInstance, field: 'numPedido', 'error')} required">
				<label for="numPedido" class="control-label"><g:message code="reclamacao.numPedido.label" default="Num Pedido" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="numPedido" required="" value="${reclamacaoInstance.numPedido}"/>
					<span class="help-inline">${hasErrors(bean: reclamacaoInstance, field: 'numPedido', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: reclamacaoInstance, field: 'numReclamacao', 'error')} required">
				<label for="numReclamacao" class="control-label"><g:message code="reclamacao.numReclamacao.label" default="Num Reclamacao" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="numReclamacao" required="" value="${reclamacaoInstance.numReclamacao}"/>
					<span class="help-inline">${hasErrors(bean: reclamacaoInstance, field: 'numReclamacao', 'error')}</span>
				</div>
			</div>

