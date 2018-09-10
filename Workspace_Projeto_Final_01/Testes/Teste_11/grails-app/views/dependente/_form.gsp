<%@ page import="teste_11.Dependente" %>



<div class="fieldcontain ${hasErrors(bean: dependenteInstance, field: 'nome', 'error')} ">
	<label for="nome">
		<g:message code="dependente.nome.label" default="Nome" />
		
	</label>
	<g:textField name="nome" value="${dependenteInstance?.nome}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dependenteInstance, field: 'pessoa', 'error')} required">
	<label for="pessoa">
		<g:message code="dependente.pessoa.label" default="Pessoa" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="pessoa" name="pessoa.id" from="${teste_11.Pessoa.list()}" optionKey="id" required="" value="${dependenteInstance?.pessoa?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: dependenteInstance, field: 'tel', 'error')} required">
	<label for="tel">
		<g:message code="dependente.tel.label" default="Tel" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="tel" type="number" value="${dependenteInstance.tel}" required=""/>
</div>

