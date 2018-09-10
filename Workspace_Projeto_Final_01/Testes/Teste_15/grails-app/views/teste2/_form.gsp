<%@ page import="teste_15.Teste2" %>



<div class="fieldcontain ${hasErrors(bean: teste2Instance, field: 'nome', 'error')} ">
	<label for="nome">
		<g:message code="teste2.nome.label" default="Nome" />
		
	</label>
	<g:textField name="nome" value="${teste2Instance?.nome}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: teste2Instance, field: 't', 'error')} required">
	<label for="t">
		<g:message code="teste2.t.label" default="T" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="t" name="t.id" from="${teste_15.Teste.list()}" optionKey="id" required="" value="${teste2Instance?.t?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: teste2Instance, field: 'tel', 'error')} ">
	<label for="tel">
		<g:message code="teste2.tel.label" default="Tel" />
		
	</label>
	<g:textField name="tel" value="${teste2Instance?.tel}"/>
</div>

