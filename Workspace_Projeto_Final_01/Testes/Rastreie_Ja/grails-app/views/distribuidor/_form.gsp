<%@ page import="dominio.Distribuidor" %>



			<div class="control-group fieldcontain ${hasErrors(bean: distribuidorInstance, field: 'confirmaSenha', 'error')} ">
				<label for="confirmaSenha" class="control-label"><g:message code="distribuidor.confirmaSenha.label" default="Confirma Senha" /></label>
				<div class="controls">
					<g:textField name="confirmaSenha" value="${distribuidorInstance?.confirmaSenha}"/>
					<span class="help-inline">${hasErrors(bean: distribuidorInstance, field: 'confirmaSenha', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: distribuidorInstance, field: 'nomeDist', 'error')} ">
				<label for="nomeDist" class="control-label"><g:message code="distribuidor.nomeDist.label" default="Nome Dist" /></label>
				<div class="controls">
					<g:textField name="nomeDist" value="${distribuidorInstance?.nomeDist}"/>
					<span class="help-inline">${hasErrors(bean: distribuidorInstance, field: 'nomeDist', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: distribuidorInstance, field: 'numDist', 'error')} required">
				<label for="numDist" class="control-label"><g:message code="distribuidor.numDist.label" default="Num Dist" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="numDist" required="" value="${distribuidorInstance.numDist}"/>
					<span class="help-inline">${hasErrors(bean: distribuidorInstance, field: 'numDist', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: distribuidorInstance, field: 'senha', 'error')} ">
				<label for="senha" class="control-label"><g:message code="distribuidor.senha.label" default="Senha" /></label>
				<div class="controls">
					<g:textField name="senha" value="${distribuidorInstance?.senha}"/>
					<span class="help-inline">${hasErrors(bean: distribuidorInstance, field: 'senha', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: distribuidorInstance, field: 'supervisorDoVarejista', 'error')} required">
				<label for="supervisorDoVarejista" class="control-label"><g:message code="distribuidor.supervisorDoVarejista.label" default="Supervisor Do Varejista" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:select id="supervisorDoVarejista" name="supervisorDoVarejista.id" from="${dominio.SupervisorDoVarejista.list()}" optionKey="id" required="" value="${distribuidorInstance?.supervisorDoVarejista?.id}" class="many-to-one"/>
					<span class="help-inline">${hasErrors(bean: distribuidorInstance, field: 'supervisorDoVarejista', 'error')}</span>
				</div>
			</div>

