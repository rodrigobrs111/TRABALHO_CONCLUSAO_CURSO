<%@ page import="dominio.Sugestao" %>



			<div class="control-group fieldcontain ${hasErrors(bean: sugestaoInstance, field: 'descSugestao', 'error')} ">
				<label for="descSugestao" class="control-label"><g:message code="sugestao.descSugestao.label" default="Desc Sugestao" /></label>
				<div class="controls">
					<g:textField name="descSugestao" value="${sugestaoInstance?.descSugestao}"/>
					<span class="help-inline">${hasErrors(bean: sugestaoInstance, field: 'descSugestao', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: sugestaoInstance, field: 'numSugestao', 'error')} required">
				<label for="numSugestao" class="control-label"><g:message code="sugestao.numSugestao.label" default="Num Sugestao" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="numSugestao" required="" value="${sugestaoInstance.numSugestao}"/>
					<span class="help-inline">${hasErrors(bean: sugestaoInstance, field: 'numSugestao', 'error')}</span>
				</div>
			</div>

