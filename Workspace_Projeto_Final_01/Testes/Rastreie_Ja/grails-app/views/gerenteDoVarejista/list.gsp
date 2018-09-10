
<%@ page import="dominio.GerenteDoVarejista" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'gerenteDoVarejista.label', default: 'GerenteDoVarejista')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-gerenteDoVarejista" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>
			
				<g:sortableColumn property="matricula" title="${message(code: 'gerenteDoVarejista.matricula.label', default: 'Matricula')}" />
			
				<g:sortableColumn property="nomeGerenteVarej" title="${message(code: 'gerenteDoVarejista.nomeGerenteVarej.label', default: 'Nome Gerente do Varejista')}" />
			
				<g:sortableColumn property="email" title="${message(code: 'gerenteDoVarejista.email.label', default: 'Email')}" />
			
				<g:sortableColumn property="sexo" title="${message(code: 'gerenteDoVarejista.sexo.label', default: 'Sexo')}" />
			
				<g:sortableColumn property="nasc" title="${message(code: 'gerenteDoVarejista.nasc.label', default: 'Nasc')}" />
			
				<g:sortableColumn property="tel" title="${message(code: 'gerenteDoVarejista.tel.label', default: 'Tel')}" />

				<g:sortableColumn property="end" title="${message(code: 'gerenteDoVarejista.end.label', default: 'End')}" />

				<g:sortableColumn property="comp" title="${message(code: 'gerenteDoVarejista.comp.label', default: 'Comp')}" />
			
				<g:sortableColumn property="cep" title="${message(code: 'gerenteDoVarejista.cep.label', default: 'Cep')}" />
			
				<g:sortableColumn property="cidade" title="${message(code: 'gerenteDoVarejista.cidade.label', default: 'Cidade')}" />
			
				<g:sortableColumn property="estado" title="${message(code: 'gerenteDoVarejista.estado.label', default: 'Estado')}" />
			
				<g:sortableColumn property="bairro" title="${message(code: 'gerenteDoVarejista.bairro.label', default: 'Bairro')}" />

			</tr>
		</thead>
		<tbody>
		<g:each in="${gerenteDoVarejistaInstanceList}" status="i" var="gerenteDoVarejistaInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
                <td><g:link action="show" id="${gerenteDoVarejistaInstance.id}">${fieldValue(bean: gerenteDoVarejistaInstance, field: "matricula")}</g:link></td>
			
				<td>${fieldValue(bean: gerenteDoVarejistaInstance, field: "nomeGerenteVarej")}</td>
			
				<td>${fieldValue(bean: gerenteDoVarejistaInstance, field: "email")}</td>
			
				<td>${fieldValue(bean: gerenteDoVarejistaInstance, field: "sexo")}</td>
			
				<td>${fieldValue(bean: gerenteDoVarejistaInstance, field: "nasc")}</td>
				
				<td>${fieldValue(bean: gerenteDoVarejistaInstance, field: "tel")}</td>
				
				<td>${fieldValue(bean: gerenteDoVarejistaInstance, field: "end")}</td>
				
				<td>${fieldValue(bean: gerenteDoVarejistaInstance, field: "comp")}</td>
			
				<td>${fieldValue(bean: gerenteDoVarejistaInstance, field: "cep")}</td>
			
				<td>${fieldValue(bean: gerenteDoVarejistaInstance, field: "cidade")}</td>
			
				<td>${fieldValue(bean: gerenteDoVarejistaInstance, field: "estado")}</td>
				
				<td>${fieldValue(bean: gerenteDoVarejistaInstance, field: "bairro")}</td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${gerenteDoVarejistaInstanceTotal}" />
	</div>
</section><br/><br/><br/><br/><br/><br/>

</body>

</html>
