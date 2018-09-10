<%@ page import="dominio.FuncionarioDaTransportadora" %>



			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'bairro', 'error')} ">
				<label for="bairro" class="control-label"><g:message code="funcionarioDaTransportadora.bairro.label" default="Bairro" /></label>
				<div class="controls">
					<g:textField name="bairro" value="${funcionarioDaTransportadoraInstance?.bairro}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'bairro', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'cep', 'error')} ">
				<label for="cep" class="control-label"><g:message code="funcionarioDaTransportadora.cep.label" default="Cep" /></label>
				<div class="controls">
					<g:textField name="cep" value="${funcionarioDaTransportadoraInstance?.cep}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'cep', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'cidade', 'error')} ">
				<label for="cidade" class="control-label"><g:message code="funcionarioDaTransportadora.cidade.label" default="Cidade" /></label>
				<div class="controls">
					<g:textField name="cidade" value="${funcionarioDaTransportadoraInstance?.cidade}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'cidade', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'comp', 'error')} ">
				<label for="comp" class="control-label"><g:message code="funcionarioDaTransportadora.comp.label" default="Comp" /></label>
				<div class="controls">
					<g:textField name="comp" value="${funcionarioDaTransportadoraInstance?.comp}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'comp', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'confirmaSenha', 'error')} ">
				<label for="confirmaSenha" class="control-label"><g:message code="funcionarioDaTransportadora.confirmaSenha.label" default="Confirma Senha" /></label>
				<div class="controls">
					<g:textField name="confirmaSenha" value="${funcionarioDaTransportadoraInstance?.confirmaSenha}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'confirmaSenha', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'email', 'error')} ">
				<label for="email" class="control-label"><g:message code="funcionarioDaTransportadora.email.label" default="Email" /></label>
				<div class="controls">
					<g:textField name="email" value="${funcionarioDaTransportadoraInstance?.email}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'email', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'end', 'error')} ">
				<label for="end" class="control-label"><g:message code="funcionarioDaTransportadora.end.label" default="End" /></label>
				<div class="controls">
					<g:textField name="end" value="${funcionarioDaTransportadoraInstance?.end}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'end', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'estado', 'error')} ">
				<label for="estado" class="control-label"><g:message code="funcionarioDaTransportadora.estado.label" default="Estado" /></label>
				<div class="controls">
					<g:textField name="estado" value="${funcionarioDaTransportadoraInstance?.estado}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'estado', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'matricula', 'error')} required">
				<label for="matricula" class="control-label"><g:message code="funcionarioDaTransportadora.matricula.label" default="Matricula" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="matricula" required="" value="${funcionarioDaTransportadoraInstance.matricula}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'matricula', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'nasc', 'error')} required">
				<label for="nasc" class="control-label"><g:message code="funcionarioDaTransportadora.nasc.label" default="Nasc" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<bs:datePicker name="nasc" precision="day"  value="${funcionarioDaTransportadoraInstance?.nasc}"  />
					<span class="help-inline">${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'nasc', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'nomeFuncTransp', 'error')} ">
				<label for="nomeFuncTransp" class="control-label"><g:message code="funcionarioDaTransportadora.nomeFuncTransp.label" default="Nome Func Transp" /></label>
				<div class="controls">
					<g:textField name="nomeFuncTransp" value="${funcionarioDaTransportadoraInstance?.nomeFuncTransp}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'nomeFuncTransp', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'senha', 'error')} ">
				<label for="senha" class="control-label"><g:message code="funcionarioDaTransportadora.senha.label" default="Senha" /></label>
				<div class="controls">
					<g:textField name="senha" value="${funcionarioDaTransportadoraInstance?.senha}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'senha', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'sexo', 'error')} ">
				<label for="sexo" class="control-label"><g:message code="funcionarioDaTransportadora.sexo.label" default="Sexo" /></label>
				<div class="controls">
					<g:textField name="sexo" value="${funcionarioDaTransportadoraInstance?.sexo}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'sexo', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'tel', 'error')} ">
				<label for="tel" class="control-label"><g:message code="funcionarioDaTransportadora.tel.label" default="Tel" /></label>
				<div class="controls">
					<g:textField name="tel" value="${funcionarioDaTransportadoraInstance?.tel}"/>
					<span class="help-inline">${hasErrors(bean: funcionarioDaTransportadoraInstance, field: 'tel', 'error')}</span>
				</div>
			</div>

