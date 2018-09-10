
<%@ page import="dominio.FuncionarioDoVarejista" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'funcionarioDoVarejista.label', default: 'FuncionarioDoVarejista')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-funcionarioDoVarejista" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>
			
				<g:sortableColumn property="matricula" title="${message(code: 'funcionarioDoVarejista.matricula.label', default: 'Matricula')}" />
			
				<g:sortableColumn property="nomeFuncVarej" title="${message(code: 'funcionarioDoVarejista.nomeFuncVarej.label', default: 'Nome Funcionário do Varejista')}" />
			
				<g:sortableColumn property="email" title="${message(code: 'funcionarioDoVarejista.email.label', default: 'Email')}" />
			
				<g:sortableColumn property="sexo" title="${message(code: 'funcionarioDoVarejista.sexo.label', default: 'Sexo')}" />
			
				<g:sortableColumn property="nasc" title="${message(code: 'funcionarioDoVarejista.nasc.label', default: 'Nasc')}" />
			
				<g:sortableColumn property="tel" title="${message(code: 'funcionarioDoVarejista.tel.label', default: 'Tel')}" />

				<g:sortableColumn property="end" title="${message(code: 'funcionarioDoVarejista.end.label', default: 'End')}" />

				<g:sortableColumn property="comp" title="${message(code: 'funcionarioDoVarejista.comp.label', default: 'Comp')}" />
			
				<g:sortableColumn property="cep" title="${message(code: 'funcionarioDoVarejista.cep.label', default: 'Cep')}" />
			
				<g:sortableColumn property="cidade" title="${message(code: 'funcionarioDoVarejista.cidade.label', default: 'Cidade')}" />
			
				<g:sortableColumn property="estado" title="${message(code: 'funcionarioDoVarejista.estado.label', default: 'Estado')}" />
			
				<g:sortableColumn property="bairro" title="${message(code: 'funcionarioDoVarejista.bairro.label', default: 'Bairro')}" />

			
			</tr>
		</thead>
		<tbody>
		<g:each in="${funcionarioDoVarejistaInstanceList}" status="i" var="funcionarioDoVarejistaInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td><g:link action="show" id="${funcionarioDoVarejistaInstance.id}">${fieldValue(bean: funcionarioDoVarejistaInstance, field: "matricula")}</g:link></td>
			
				<td>${fieldValue(bean: funcionarioDoVarejistaInstance, field: "nomeFuncVarej")}</td>
			
				<td>${fieldValue(bean: funcionarioDoVarejistaInstance, field: "email")}</td>
			
				<td>${fieldValue(bean: funcionarioDoVarejistaInstance, field: "sexo")}</td>
			
				<td>${fieldValue(bean: funcionarioDoVarejistaInstance, field: "nasc")}</td>
				
				<td>${fieldValue(bean: funcionarioDoVarejistaInstance, field: "tel")}</td>
				
				<td>${fieldValue(bean: funcionarioDoVarejistaInstance, field: "end")}</td>
				
				<td>${fieldValue(bean: funcionarioDoVarejistaInstance, field: "comp")}</td>
			
				<td>${fieldValue(bean: funcionarioDoVarejistaInstance, field: "cep")}</td>
			
				<td>${fieldValue(bean: funcionarioDoVarejistaInstance, field: "cidade")}</td>
			
				<td>${fieldValue(bean: funcionarioDoVarejistaInstance, field: "estado")}</td>
				
				<td>${fieldValue(bean: funcionarioDoVarejistaInstance, field: "bairro")}</td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${funcionarioDoVarejistaInstanceTotal}" />
	</div>
</section><br/><br/><br/><br/><br/><br/>

</body>

</html>
