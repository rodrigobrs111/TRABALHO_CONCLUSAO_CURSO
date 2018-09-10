<%@ page import="teste_11.Autor" %>



<div class="fieldcontain ${hasErrors(bean: autorInstance, field: 'livros', 'error')} ">
	<label for="livros">
		<g:message code="autor.livros.label" default="Livros" />
		
	</label>
	<g:select name="livros" from="${teste_11.Livro.list()}" multiple="multiple" optionKey="id" size="5" value="${autorInstance?.livros*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: autorInstance, field: 'nome', 'error')} ">
	<label for="nome">
		<g:message code="autor.nome.label" default="Nome" />
		
	</label>
	<g:textField name="nome" value="${autorInstance?.nome}"/>
</div>

