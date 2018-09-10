<%@ page import="teste_07.Pessoa" %>



<div class="fieldcontain ${hasErrors(bean: pessoaInstance, field: 'dependentes', 'error')} ">
	<label for="dependentes">
		<g:message code="pessoa.dependentes.label" default="Dependentes" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${pessoaInstance?.dependentes?}" var="d">
    <li><g:link controller="dependente" action="show" id="${d.id}">${d?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="dependente" action="create" params="['pessoa.id': pessoaInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'dependente.label', default: 'Dependente')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: pessoaInstance, field: 'end', 'error')} ">
	<label for="end">
		<g:message code="pessoa.end.label" default="End" />
		
	</label>
	<g:textField name="end" value="${pessoaInstance?.end}"/>
</div>

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

<div class="fieldcontain ${hasErrors(bean: pessoaInstance, field: 'tel', 'error')} ">
	<label for="tel">
		<g:message code="pessoa.tel.label" default="Tel" />
		
	</label>
	<g:textField name="tel" value="${pessoaInstance?.tel}"/>
</div>

