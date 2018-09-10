<%@ page import="teste_07.Dependente" %>



<div class="fieldcontain ${hasErrors(bean: dependenteInstance, field: 'end', 'error')} ">
	<label for="end">
		<g:message code="dependente.end.label" default="End" />
		
	</label>
	<g:textField name="end" value="${dependenteInstance?.end}"/>
</div>

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
	<g:select id="pessoa" name="pessoa.id" from="${teste_07.Pessoa.list()}" optionKey="id" required="" value="${dependenteInstance?.pessoa?.id}" class="many-to-one"/>
</div>

