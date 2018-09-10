<%@ page import="teste_11.Dono" %>



<div class="fieldcontain ${hasErrors(bean: donoInstance, field: 'empresa', 'error')} required">
	<label for="empresa">
		<g:message code="dono.empresa.label" default="Empresa" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="empresa" name="empresa.id" from="${teste_11.Empresa.list()}" optionKey="id" required="" value="${donoInstance?.empresa?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: donoInstance, field: 'nome', 'error')} ">
	<label for="nome">
		<g:message code="dono.nome.label" default="Nome" />
		
	</label>
	<g:textField name="nome" value="${donoInstance?.nome}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: donoInstance, field: 'num', 'error')} required">
	<label for="num">
		<g:message code="dono.num.label" default="Num" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="num" type="number" value="${donoInstance.num}" required=""/>
</div>

