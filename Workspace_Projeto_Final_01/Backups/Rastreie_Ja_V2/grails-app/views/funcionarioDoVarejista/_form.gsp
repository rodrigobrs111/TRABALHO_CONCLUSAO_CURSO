<%@ page import="dominio.FuncionarioDoVarejista" %>



			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'bairro', 'error')} ">
				<label for="bairro" class="control-label"><g:message code="funcionarioDoVarejista.bairro.label" default="Bairro" /></label>
				<div class="controls">
					<g:textField name="bairro" value="${funcionarioDoVarejistaInstance?.bairro}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'bairro', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'cep', 'error')} ">
				<label for="cep" class="control-label"><g:message code="funcionarioDoVarejista.cep.label" default="Cep" /></label>
				<div class="controls">
					<g:textField name="cep" value="${funcionarioDoVarejistaInstance?.cep}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'cep', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'cidade', 'error')} ">
				<label for="cidade" class="control-label"><g:message code="funcionarioDoVarejista.cidade.label" default="Cidade" /></label>
				<div class="controls">
					<g:textField name="cidade" value="${funcionarioDoVarejistaInstance?.cidade}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'cidade', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'comp', 'error')} ">
				<label for="comp" class="control-label"><g:message code="funcionarioDoVarejista.comp.label" default="Comp" /></label>
				<div class="controls">
					<g:textField name="comp" value="${funcionarioDoVarejistaInstance?.comp}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'comp', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'confirmaSenha', 'error')} ">
				<label for="confirmaSenha" class="control-label"><g:message code="funcionarioDoVarejista.confirmaSenha.label" default="Confirma Senha" /></label>
				<div class="controls">
					<g:textField name="confirmaSenha" value="${funcionarioDoVarejistaInstance?.confirmaSenha}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'confirmaSenha', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'email', 'error')} ">
				<label for="email" class="control-label"><g:message code="funcionarioDoVarejista.email.label" default="Email" /></label>
				<div class="controls">
					<g:textField name="email" value="${funcionarioDoVarejistaInstance?.email}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'email', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'end', 'error')} ">
				<label for="end" class="control-label"><g:message code="funcionarioDoVarejista.end.label" default="End" /></label>
				<div class="controls">
					<g:textField name="end" value="${funcionarioDoVarejistaInstance?.end}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'end', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'estado', 'error')} ">
				<label for="estado" class="control-label"><g:message code="funcionarioDoVarejista.estado.label" default="Estado" /></label>
				<div class="controls">
					<g:textField name="estado" value="${funcionarioDoVarejistaInstance?.estado}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'estado', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'matricula', 'error')} required">
				<label for="matricula" class="control-label"><g:message code="funcionarioDoVarejista.matricula.label" default="Matricula" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="matricula" required="" value="${funcionarioDoVarejistaInstance.matricula}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'matricula', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'nasc', 'error')} required">
				<label for="nasc" class="control-label"><g:message code="funcionarioDoVarejista.nasc.label" default="Nasc" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<bs:datePicker name="nasc" precision="day"  value="${funcionarioDoVarejistaInstance?.nasc}"  />
					<span class="help-inline">${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'nasc', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'nomeFuncVarej', 'error')} ">
				<label for="nomeFuncVarej" class="control-label"><g:message code="funcionarioDoVarejista.nomeFuncVarej.label" default="Nome Func Varej" /></label>
				<div class="controls">
					<g:textField name="nomeFuncVarej" value="${funcionarioDoVarejistaInstance?.nomeFuncVarej}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'nomeFuncVarej', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'senha', 'error')} ">
				<label for="senha" class="control-label"><g:message code="funcionarioDoVarejista.senha.label" default="Senha" /></label>
				<div class="controls">
					<g:textField name="senha" value="${funcionarioDoVarejistaInstance?.senha}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'senha', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'sexo', 'error')} ">
				<label for="sexo" class="control-label"><g:message code="funcionarioDoVarejista.sexo.label" default="Sexo" /></label>
				<div class="controls">
					<g:textField name="sexo" value="${funcionarioDoVarejistaInstance?.sexo}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'sexo', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'tel', 'error')} ">
				<label for="tel" class="control-label"><g:message code="funcionarioDoVarejista.tel.label" default="Tel" /></label>
				<div class="controls">
					<g:textField name="tel" value="${funcionarioDoVarejistaInstance?.tel}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDoVarejistaInstance, field: 'tel', 'error')}</span>
				</div>
			</div>

