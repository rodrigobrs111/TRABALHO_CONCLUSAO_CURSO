<%@ page import="dominio.Reclamacao" %>



			<div class="control-group fieldcontain ${hasErrors(bean: reclamacaoInstance, field: 'comentario', 'error')} ">
				<label for="comentario" class="control-label"><g:message code="reclamacao.comentario.label" default="Comentario" /></label>
				<div class="controls">
					<g:textField name="comentario" value="${reclamacaoInstance?.comentario}"/>
					<span class="help-inline">${hasErrors(bean: reclamacaoInstance, field: 'comentario', 'error')}</span>
				</div>
			</div>

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

			<div class="control-group fieldcontain ${hasErrors(bean: reclamacaoInstance, field: 'numReclamacao', 'error')} required">
				<label for="numReclamacao" class="control-label"><g:message code="reclamacao.numReclamacao.label" default="Num Reclamacao" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="numReclamacao" required="" value="${reclamacaoInstance.numReclamacao}"/>
					<span class="help-inline">${hasErrors(bean: reclamacaoInstance, field: 'numReclamacao', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: reclamacaoInstance, field: 'pedido', 'error')} required">
				<label for="pedido" class="control-label"><g:message code="reclamacao.pedido.label" default="Pedido" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:select id="pedido" name="pedido.id" from="${dominio.Pedido.list()}" optionKey="id" required="" value="${reclamacaoInstance?.pedido?.id}" class="many-to-one"/>
					<span class="help-inline">${hasErrors(bean: reclamacaoInstance, field: 'pedido', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: reclamacaoInstance, field: 'status', 'error')} ">
				<label for="status" class="control-label"><g:message code="reclamacao.status.label" default="Status" /></label>
				<div class="controls">
					<g:textField name="status" value="${reclamacaoInstance?.status}"/>
					<span class="help-inline">${hasErrors(bean: reclamacaoInstance, field: 'status', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: reclamacaoInstance, field: 'supervisorDoVarejista', 'error')} required">
				<label for="supervisorDoVarejista" class="control-label"><g:message code="reclamacao.supervisorDoVarejista.label" default="Supervisor Do Varejista" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:select id="supervisorDoVarejista" name="supervisorDoVarejista.id" from="${dominio.SupervisorDoVarejista.list()}" optionKey="id" required="" value="${reclamacaoInstance?.supervisorDoVarejista?.id}" class="many-to-one"/>
					<span class="help-inline">${hasErrors(bean: reclamacaoInstance, field: 'supervisorDoVarejista', 'error')}</span>
				</div>
			</div>

