<%@ page import="teste_11.Pessoa" %>



<div class="fieldcontain ${hasErrors(bean: pessoaInstance, field: 'idade', 'error')} required">
	<label for="idade">
		<g:message code="pessoa.idade.label" default="Idade" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="idade" type="number" value="${pessoaInstance.idade}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: pessoaInstance, field: 'nome', 'error')} ">
	<label for="nome">
		<g:message code="pessoa.nome.label" default="Nome" />
		
	</label>
	<g:textField name="nome" value="${pessoaInstance?.nome}"/>
</div>

