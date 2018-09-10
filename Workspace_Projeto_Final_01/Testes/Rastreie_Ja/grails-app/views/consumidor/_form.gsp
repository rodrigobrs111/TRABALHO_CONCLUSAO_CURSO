<%@ page import="dominio.Consumidor" %>



			<div class="control-group fieldcontain ${hasErrors(bean: consumidorInstance, field: 'bairro', 'error')} ">
				<label for="bairro" class="control-label"><g:message code="consumidor.bairro.label" default="Bairro" /></label>
				<div class="controls">
					<g:textField name="bairro" value="${consumidorInstance?.bairro}"/>
					<span class="help-inline">${hasErrors(bean: consumidorInstance, field: 'bairro', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: consumidorInstance, field: 'cep', 'error')} ">
				<label for="cep" class="control-label"><g:message code="consumidor.cep.label" default="Cep" /></label>
				<div class="controls">
					<g:textField name="cep" value="${consumidorInstance?.cep}"/>
					<span class="help-inline">${hasErrors(bean: consumidorInstance, field: 'cep', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: consumidorInstance, field: 'cidade', 'error')} ">
				<label for="cidade" class="control-label"><g:message code="consumidor.cidade.label" default="Cidade" /></label>
				<div class="controls">
					<g:textField name="cidade" value="${consumidorInstance?.cidade}"/>
					<span class="help-inline">${hasErrors(bean: consumidorInstance, field: 'cidade', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: consumidorInstance, field: 'comp', 'error')} ">
				<label for="comp" class="control-label"><g:message code="consumidor.comp.label" default="Comp" /></label>
				<div class="controls">
					<g:textField name="comp" value="${consumidorInstance?.comp}"/>
					<span class="help-inline">${hasErrors(bean: consumidorInstance, field: 'comp', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: consumidorInstance, field: 'confirmaSenha', 'error')} ">
				<label for="confirmaSenha" class="control-label"><g:message code="consumidor.confirmaSenha.label" default="Confirma Senha" /></label>
				<div class="controls">
					<g:textField name="confirmaSenha" value="${consumidorInstance?.confirmaSenha}"/>
					<span class="help-inline">${hasErrors(bean: consumidorInstance, field: 'confirmaSenha', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: consumidorInstance, field: 'email', 'error')} ">
				<label for="email" class="control-label"><g:message code="consumidor.email.label" default="Email" /></label>
				<div class="controls">
					<g:textField name="email" value="${consumidorInstance?.email}"/>
					<span class="help-inline">${hasErrors(bean: consumidorInstance, field: 'email', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: consumidorInstance, field: 'end', 'error')} ">
				<label for="end" class="control-label"><g:message code="consumidor.end.label" default="End" /></label>
				<div class="controls">
					<g:textField name="end" value="${consumidorInstance?.end}"/>
					<span class="help-inline">${hasErrors(bean: consumidorInstance, field: 'end', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: consumidorInstance, field: 'estado', 'error')} ">
				<label for="estado" class="control-label"><g:message code="consumidor.estado.label" default="Estado" /></label>
				<div class="controls">
					<g:textField name="estado" value="${consumidorInstance?.estado}"/>
					<span class="help-inline">${hasErrors(bean: consumidorInstance, field: 'estado', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: consumidorInstance, field: 'matricula', 'error')} required">
				<label for="matricula" class="control-label"><g:message code="consumidor.matricula.label" default="Matricula" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="matricula" required="" value="${consumidorInstance.matricula}"/>
					<span class="help-inline">${hasErrors(bean: consumidorInstance, field: 'matricula', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: consumidorInstance, field: 'nasc', 'error')} required">
				<label for="nasc" class="control-label"><g:message code="consumidor.nasc.label" default="Nasc" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<bs:datePicker name="nasc" precision="day"  value="${consumidorInstance?.nasc}"  />
					<span class="help-inline">${hasErrors(bean: consumidorInstance, field: 'nasc', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: consumidorInstance, field: 'nomeConsum', 'error')} ">
				<label for="nomeConsum" class="control-label"><g:message code="consumidor.nomeConsum.label" default="Nome Consum" /></label>
				<div class="controls">
					<g:textField name="nomeConsum" value="${consumidorInstance?.nomeConsum}"/>
					<span class="help-inline">${hasErrors(bean: consumidorInstance, field: 'nomeConsum', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: consumidorInstance, field: 'senha', 'error')} ">
				<label for="senha" class="control-label"><g:message code="consumidor.senha.label" default="Senha" /></label>
				<div class="controls">
					<g:textField name="senha" value="${consumidorInstance?.senha}"/>
					<span class="help-inline">${hasErrors(bean: consumidorInstance, field: 'senha', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: consumidorInstance, field: 'sexo', 'error')} ">
				<label for="sexo" class="control-label"><g:message code="consumidor.sexo.label" default="Sexo" /></label>
				<div class="controls">
					<g:textField name="sexo" value="${consumidorInstance?.sexo}"/>
					<span class="help-inline">${hasErrors(bean: consumidorInstance, field: 'sexo', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: consumidorInstance, field: 'tel', 'error')} ">
				<label for="tel" class="control-label"><g:message code="consumidor.tel.label" default="Tel" /></label>
				<div class="controls">
					<g:textField name="tel" value="${consumidorInstance?.tel}"/>
					<span class="help-inline">${hasErrors(bean: consumidorInstance, field: 'tel', 'error')}</span>
				</div>
			</div>

