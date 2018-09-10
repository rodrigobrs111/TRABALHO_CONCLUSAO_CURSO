
<%@ page import="dominio.SupervisorDoVarejista" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'supervisorDoVarejista.label', default: 'SupervisorDoVarejista')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-supervisorDoVarejista" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>
			
			    <g:sortableColumn property="matricula" title="${message(code: 'supervisorDoVarejista.matricula.label', default: 'Matricula')}" />
			
				<g:sortableColumn property="nomeSupervisorVarej" title="${message(code: 'supervisorDoVarejista.nomeSupervisorVarej.label', default: 'Nome Supervisor do Varejista')}" />
			
				<g:sortableColumn property="email" title="${message(code: 'supervisorDoVarejista.email.label', default: 'Email')}" />
			
				<g:sortableColumn property="sexo" title="${message(code: 'supervisorDoVarejista.sexo.label', default: 'Sexo')}" />
			
				<g:sortableColumn property="nasc" title="${message(code: 'supervisorDoVarejista.nasc.label', default: 'Nasc')}" />
			
				<g:sortableColumn property="tel" title="${message(code: 'supervisorDoVarejista.tel.label', default: 'Tel')}" />

				<g:sortableColumn property="end" title="${message(code: 'supervisorDoVarejista.end.label', default: 'End')}" />

				<g:sortableColumn property="comp" title="${message(code: 'supervisorDoVarejista.comp.label', default: 'Comp')}" />
			
				<g:sortableColumn property="cep" title="${message(code: 'supervisorDoVarejista.cep.label', default: 'Cep')}" />
			
				<g:sortableColumn property="cidade" title="${message(code: 'supervisorDoVarejista.cidade.label', default: 'Cidade')}" />
			
				<g:sortableColumn property="estado" title="${message(code: 'supervisorDoVarejista.estado.label', default: 'Estado')}" />
			
				<g:sortableColumn property="bairro" title="${message(code: 'supervisorDoVarejista.bairro.label', default: 'Bairro')}" />

			
			</tr>
		</thead>
		<tbody>
		<g:each in="${supervisorDoVarejistaInstanceList}" status="i" var="supervisorDoVarejistaInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
                <td><g:link action="show" id="${supervisorDoVarejistaInstance.id}">${fieldValue(bean: supervisorDoVarejistaInstance, field: "matricula")}</g:link></td>
			
				<td>${fieldValue(bean: supervisorDoVarejistaInstance, field: "nomeSupervisorVarej")}</td>
			
				<td>${fieldValue(bean: supervisorDoVarejistaInstance, field: "email")}</td>
			
				<td>${fieldValue(bean: supervisorDoVarejistaInstance, field: "sexo")}</td>
			
				<td>${fieldValue(bean: supervisorDoVarejistaInstance, field: "nasc")}</td>
				
				<td>${fieldValue(bean: supervisorDoVarejistaInstance, field: "tel")}</td>
				
				<td>${fieldValue(bean: supervisorDoVarejistaInstance, field: "end")}</td>
				
				<td>${fieldValue(bean: supervisorDoVarejistaInstance, field: "comp")}</td>
			
				<td>${fieldValue(bean: supervisorDoVarejistaInstance, field: "cep")}</td>
			
				<td>${fieldValue(bean: supervisorDoVarejistaInstance, field: "cidade")}</td>
			
				<td>${fieldValue(bean: supervisorDoVarejistaInstance, field: "estado")}</td>
				
				<td>${fieldValue(bean: supervisorDoVarejistaInstance, field: "bairro")}</td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${supervisorDoVarejistaInstanceTotal}" />
	</div>
</section><br/><br/><br/><br/><br/><br/>

</body>

</html>
