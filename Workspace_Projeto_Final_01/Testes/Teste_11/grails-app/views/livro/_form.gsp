<%@ page import="teste_11.Livro" %>



<div class="fieldcontain ${hasErrors(bean: livroInstance, field: 'nome', 'error')} ">
	<label for="nome">
		<g:message code="livro.nome.label" default="Nome" />
		
	</label>
	<g:textField name="nome" value="${livroInstance?.nome}"/>
</div>

