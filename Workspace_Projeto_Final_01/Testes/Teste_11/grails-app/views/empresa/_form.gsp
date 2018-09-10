<%@ page import="teste_11.Empresa" %>



<div class="fieldcontain ${hasErrors(bean: empresaInstance, field: 'dono', 'error')} required">
	<label for="dono">
		<g:message code="empresa.dono.label" default="Dono" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="dono" name="dono.id" from="${teste_11.Dono.list()}" optionKey="id" required="" value="${empresaInstance?.dono?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: empresaInstance, field: 'nome', 'error')} ">
	<label for="nome">
		<g:message code="empresa.nome.label" default="Nome" />
		
	</label>
	<g:textField name="nome" value="${empresaInstance?.nome}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: empresaInstance, field: 'num', 'error')} required">
	<label for="num">
		<g:message code="empresa.num.label" default="Num" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="num" type="number" value="${empresaInstance.num}" required=""/>
</div>

