<%@ page import="dominio.GerenteDoVarejista" %>



			<div class="control-group fieldcontain ${hasErrors(bean: gerenteDoVarejistaInstance, field: 'bairro', 'error')} ">
				<label for="bairro" class="control-label"><g:message code="gerenteDoVarejista.bairro.label" default="Bairro" /></label>
				<div class="controls">
					<g:textField name="bairro" value="${gerenteDoVarejistaInstance?.bairro}"/>
					<span class="help-inline">${hasErrors(bean: gerenteDoVarejistaInstance, field: 'bairro', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: gerenteDoVarejistaInstance, field: 'cep', 'error')} ">
				<label for="cep" class="control-label"><g:message code="gerenteDoVarejista.cep.label" default="Cep" /></label>
				<div class="controls">
					<g:textField name="cep" value="${gerenteDoVarejistaInstance?.cep}"/>
					<span class="help-inline">${hasErrors(bean: gerenteDoVarejistaInstance, field: 'cep', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: gerenteDoVarejistaInstance, field: 'cidade', 'error')} ">
				<label for="cidade" class="control-label"><g:message code="gerenteDoVarejista.cidade.label" default="Cidade" /></label>
				<div class="controls">
					<g:textField name="cidade" value="${gerenteDoVarejistaInstance?.cidade}"/>
					<span class="help-inline">${hasErrors(bean: gerenteDoVarejistaInstance, field: 'cidade', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: gerenteDoVarejistaInstance, field: 'comp', 'error')} ">
				<label for="comp" class="control-label"><g:message code="gerenteDoVarejista.comp.label" default="Comp" /></label>
				<div class="controls">
					<g:textField name="comp" value="${gerenteDoVarejistaInstance?.comp}"/>
					<span class="help-inline">${hasErrors(bean: gerenteDoVarejistaInstance, field: 'comp', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: gerenteDoVarejistaInstance, field: 'confirmaSenha', 'error')} ">
				<label for="confirmaSenha" class="control-label"><g:message code="gerenteDoVarejista.confirmaSenha.label" default="Confirma Senha" /></label>
				<div class="controls">
					<g:textField name="confirmaSenha" value="${gerenteDoVarejistaInstance?.confirmaSenha}"/>
					<span class="help-inline">${hasErrors(bean: gerenteDoVarejistaInstance, field: 'confirmaSenha', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: gerenteDoVarejistaInstance, field: 'email', 'error')} ">
				<label for="email" class="control-label"><g:message code="gerenteDoVarejista.email.label" default="Email" /></label>
				<div class="controls">
					<g:textField name="email" value="${gerenteDoVarejistaInstance?.email}"/>
					<span class="help-inline">${hasErrors(bean: gerenteDoVarejistaInstance, field: 'email', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: gerenteDoVarejistaInstance, field: 'end', 'error')} ">
				<label for="end" class="control-label"><g:message code="gerenteDoVarejista.end.label" default="End" /></label>
				<div class="controls">
					<g:textField name="end" value="${gerenteDoVarejistaInstance?.end}"/>
					<span class="help-inline">${hasErrors(bean: gerenteDoVarejistaInstance, field: 'end', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: gerenteDoVarejistaInstance, field: 'estado', 'error')} ">
				<label for="estado" class="control-label"><g:message code="gerenteDoVarejista.estado.label" default="Estado" /></label>
				<div class="controls">
					<g:textField name="estado" value="${gerenteDoVarejistaInstance?.estado}"/>
					<span class="help-inline">${hasErrors(bean: gerenteDoVarejistaInstance, field: 'estado', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: gerenteDoVarejistaInstance, field: 'matricula', 'error')} required">
				<label for="matricula" class="control-label"><g:message code="gerenteDoVarejista.matricula.label" default="Matricula" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="matricula" required="" value="${gerenteDoVarejistaInstance.matricula}"/>
					<span class="help-inline">${hasErrors(bean: gerenteDoVarejistaInstance, field: 'matricula', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: gerenteDoVarejistaInstance, field: 'nasc', 'error')} required">
				<label for="nasc" class="control-label"><g:message code="gerenteDoVarejista.nasc.label" default="Nasc" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<bs:datePicker name="nasc" precision="day"  value="${gerenteDoVarejistaInstance?.nasc}"  />
					<span class="help-inline">${hasErrors(bean: gerenteDoVarejistaInstance, field: 'nasc', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: gerenteDoVarejistaInstance, field: 'nomeGerenteVarej', 'error')} ">
				<label for="nomeGerenteVarej" class="control-label"><g:message code="gerenteDoVarejista.nomeGerenteVarej.label" default="Nome Gerente Varej" /></label>
				<div class="controls">
					<g:textField name="nomeGerenteVarej" value="${gerenteDoVarejistaInstance?.nomeGerenteVarej}"/>
					<span class="help-inline">${hasErrors(bean: gerenteDoVarejistaInstance, field: 'nomeGerenteVarej', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: gerenteDoVarejistaInstance, field: 'senha', 'error')} ">
				<label for="senha" class="control-label"><g:message code="gerenteDoVarejista.senha.label" default="Senha" /></label>
				<div class="controls">
					<g:textField name="senha" value="${gerenteDoVarejistaInstance?.senha}"/>
					<span class="help-inline">${hasErrors(bean: gerenteDoVarejistaInstance, field: 'senha', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: gerenteDoVarejistaInstance, field: 'sexo', 'error')} ">
				<label for="sexo" class="control-label"><g:message code="gerenteDoVarejista.sexo.label" default="Sexo" /></label>
				<div class="controls">
					<g:textField name="sexo" value="${gerenteDoVarejistaInstance?.sexo}"/>
					<span class="help-inline">${hasErrors(bean: gerenteDoVarejistaInstance, field: 'sexo', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: gerenteDoVarejistaInstance, field: 'tel', 'error')} ">
				<label for="tel" class="control-label"><g:message code="gerenteDoVarejista.tel.label" default="Tel" /></label>
				<div class="controls">
					<g:textField name="tel" value="${gerenteDoVarejistaInstance?.tel}"/>
					<span class="help-inline">${hasErrors(bean: gerenteDoVarejistaInstance, field: 'tel', 'error')}</span>
				</div>
			</div>

