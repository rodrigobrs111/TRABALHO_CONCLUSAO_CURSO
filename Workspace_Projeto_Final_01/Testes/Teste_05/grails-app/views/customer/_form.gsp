<%@ page import="teste_05.Customer" %>



<div class="fieldcontain ${hasErrors(bean: customerInstance, field: 'n1', 'error')} required">
	<label for="n1">
		<g:message code="customer.n1.label" default="N1" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="n1" type="number" value="${customerInstance.n1}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: customerInstance, field: 'n2', 'error')} required">
	<label for="n2">
		<g:message code="customer.n2.label" default="N2" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="n2" type="number" value="${customerInstance.n2}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: customerInstance, field: 'n3', 'error')} required">
	<label for="n3">
		<g:message code="customer.n3.label" default="N3" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="n3" type="number" value="${customerInstance.n3}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: customerInstance, field: 'nome', 'error')} ">
	<label for="nome">
		<g:message code="customer.nome.label" default="Nome" />
		
	</label>
	<g:textField name="nome" value="${customerInstance?.nome}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: customerInstance, field: 'tel', 'error')} ">
	<label for="tel">
		<g:message code="customer.tel.label" default="Tel" />
		
	</label>
	<g:textField name="tel" value="${customerInstance?.tel}"/>
</div>

