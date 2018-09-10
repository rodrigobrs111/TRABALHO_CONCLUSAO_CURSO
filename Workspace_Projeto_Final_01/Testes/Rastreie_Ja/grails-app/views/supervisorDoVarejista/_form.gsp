<%@ page import="dominio.SupervisorDoVarejista" %>



			<div class="control-group fieldcontain ${hasErrors(bean: supervisorDoVarejistaInstance, field: 'bairro', 'error')} ">
				<label for="bairro" class="control-label"><g:message code="supervisorDoVarejista.bairro.label" default="Bairro" /></label>
				<div class="controls">
					<g:textField name="bairro" value="${supervisorDoVarejistaInstance?.bairro}"/>
					<span class="help-inline">${hasErrors(bean: supervisorDoVarejistaInstance, field: 'bairro', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: supervisorDoVarejistaInstance, field: 'cep', 'error')} ">
				<label for="cep" class="control-label"><g:message code="supervisorDoVarejista.cep.label" default="Cep" /></label>
				<div class="controls">
					<g:textField name="cep" value="${supervisorDoVarejistaInstance?.cep}"/>
					<span class="help-inline">${hasErrors(bean: supervisorDoVarejistaInstance, field: 'cep', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: supervisorDoVarejistaInstance, field: 'cidade', 'error')} ">
				<label for="cidade" class="control-label"><g:message code="supervisorDoVarejista.cidade.label" default="Cidade" /></label>
				<div class="controls">
					<g:textField name="cidade" value="${supervisorDoVarejistaInstance?.cidade}"/>
					<span class="help-inline">${hasErrors(bean: supervisorDoVarejistaInstance, field: 'cidade', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: supervisorDoVarejistaInstance, field: 'comp', 'error')} ">
				<label for="comp" class="control-label"><g:message code="supervisorDoVarejista.comp.label" default="Comp" /></label>
				<div class="controls">
					<g:textField name="comp" value="${supervisorDoVarejistaInstance?.comp}"/>
					<span class="help-inline">${hasErrors(bean: supervisorDoVarejistaInstance, field: 'comp', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: supervisorDoVarejistaInstance, field: 'confirmaSenha', 'error')} ">
				<label for="confirmaSenha" class="control-label"><g:message code="supervisorDoVarejista.confirmaSenha.label" default="Confirma Senha" /></label>
				<div class="controls">
					<g:textField name="confirmaSenha" value="${supervisorDoVarejistaInstance?.confirmaSenha}"/>
					<span class="help-inline">${hasErrors(bean: supervisorDoVarejistaInstance, field: 'confirmaSenha', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: supervisorDoVarejistaInstance, field: 'email', 'error')} ">
				<label for="email" class="control-label"><g:message code="supervisorDoVarejista.email.label" default="Email" /></label>
				<div class="controls">
					<g:textField name="email" value="${supervisorDoVarejistaInstance?.email}"/>
					<span class="help-inline">${hasErrors(bean: supervisorDoVarejistaInstance, field: 'email', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: supervisorDoVarejistaInstance, field: 'end', 'error')} ">
				<label for="end" class="control-label"><g:message code="supervisorDoVarejista.end.label" default="End" /></label>
				<div class="controls">
					<g:textField name="end" value="${supervisorDoVarejistaInstance?.end}"/>
					<span class="help-inline">${hasErrors(bean: supervisorDoVarejistaInstance, field: 'end', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: supervisorDoVarejistaInstance, field: 'estado', 'error')} ">
				<label for="estado" class="control-label"><g:message code="supervisorDoVarejista.estado.label" default="Estado" /></label>
				<div class="controls">
					<g:textField name="estado" value="${supervisorDoVarejistaInstance?.estado}"/>
					<span class="help-inline">${hasErrors(bean: supervisorDoVarejistaInstance, field: 'estado', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: supervisorDoVarejistaInstance, field: 'matricula', 'error')} required">
				<label for="matricula" class="control-label"><g:message code="supervisorDoVarejista.matricula.label" default="Matricula" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="matricula" required="" value="${supervisorDoVarejistaInstance.matricula}"/>
					<span class="help-inline">${hasErrors(bean: supervisorDoVarejistaInstance, field: 'matricula', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: supervisorDoVarejistaInstance, field: 'nasc', 'error')} required">
				<label for="nasc" class="control-label"><g:message code="supervisorDoVarejista.nasc.label" default="Nasc" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<bs:datePicker name="nasc" precision="day"  value="${supervisorDoVarejistaInstance?.nasc}"  />
					<span class="help-inline">${hasErrors(bean: supervisorDoVarejistaInstance, field: 'nasc', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: supervisorDoVarejistaInstance, field: 'nomeSupervisorVarej', 'error')} ">
				<label for="nomeSupervisorVarej" class="control-label"><g:message code="supervisorDoVarejista.nomeSupervisorVarej.label" default="Nome Supervisor Varej" /></label>
				<div class="controls">
					<g:textField name="nomeSupervisorVarej" value="${supervisorDoVarejistaInstance?.nomeSupervisorVarej}"/>
					<span class="help-inline">${hasErrors(bean: supervisorDoVarejistaInstance, field: 'nomeSupervisorVarej', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: supervisorDoVarejistaInstance, field: 'senha', 'error')} ">
				<label for="senha" class="control-label"><g:message code="supervisorDoVarejista.senha.label" default="Senha" /></label>
				<div class="controls">
					<g:textField name="senha" value="${supervisorDoVarejistaInstance?.senha}"/>
					<span class="help-inline">${hasErrors(bean: supervisorDoVarejistaInstance, field: 'senha', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: supervisorDoVarejistaInstance, field: 'sexo', 'error')} ">
				<label for="sexo" class="control-label"><g:message code="supervisorDoVarejista.sexo.label" default="Sexo" /></label>
				<div class="controls">
					<g:textField name="sexo" value="${supervisorDoVarejistaInstance?.sexo}"/>
					<span class="help-inline">${hasErrors(bean: supervisorDoVarejistaInstance, field: 'sexo', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: supervisorDoVarejistaInstance, field: 'tel', 'error')} ">
				<label for="tel" class="control-label"><g:message code="supervisorDoVarejista.tel.label" default="Tel" /></label>
				<div class="controls">
					<g:textField name="tel" value="${supervisorDoVarejistaInstance?.tel}"/>
					<span class="help-inline">${hasErrors(bean: supervisorDoVarejistaInstance, field: 'tel', 'error')}</span>
				</div>
			</div>

