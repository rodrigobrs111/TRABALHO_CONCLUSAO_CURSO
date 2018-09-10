
<%@ page import="dominio.Consumidor" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'consumidor.label', default: 'Consumidor')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-consumidor" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>
			
				<g:sortableColumn property="matricula" title="${message(code: 'consumidor.matricula.label', default: 'Matricula')}" />
			
				<g:sortableColumn property="nomeConsum" title="${message(code: 'consumidor.nomeConsum.label', default: 'Nome Consumidor')}" />
			
				<g:sortableColumn property="email" title="${message(code: 'consumidor.email.label', default: 'Email')}" />
			
				<g:sortableColumn property="sexo" title="${message(code: 'consumidor.sexo.label', default: 'Sexo')}" />
			
				<g:sortableColumn property="nasc" title="${message(code: 'consumidor.nasc.label', default: 'Nasc')}" />
			
				<g:sortableColumn property="tel" title="${message(code: 'consumidor.tel.label', default: 'Tel')}" />

				<g:sortableColumn property="end" title="${message(code: 'consumidor.end.label', default: 'End')}" />

				<g:sortableColumn property="comp" title="${message(code: 'consumidor.comp.label', default: 'Comp')}" />
			
				<g:sortableColumn property="cep" title="${message(code: 'consumidor.cep.label', default: 'Cep')}" />
			
				<g:sortableColumn property="cidade" title="${message(code: 'consumidor.cidade.label', default: 'Cidade')}" />
			
				<g:sortableColumn property="estado" title="${message(code: 'consumidor.estado.label', default: 'Estado')}" />
			
				<g:sortableColumn property="bairro" title="${message(code: 'consumidor.bairro.label', default: 'Bairro')}" />


			</tr>
		</thead>
		<tbody>
		<g:each in="${consumidorInstanceList}" status="i" var="consumidorInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				<td><g:link action="show" id="${consumidorInstance.id}">${fieldValue(bean: consumidorInstance, field: "matricula")}</g:link></td>
			
				<td>${fieldValue(bean: consumidorInstance, field: "nomeConsum")}</td>
			
				<td>${fieldValue(bean: consumidorInstance, field: "email")}</td>
			
				<td>${fieldValue(bean: consumidorInstance, field: "sexo")}</td>
			
				<td>${fieldValue(bean: consumidorInstance, field: "nasc")}</td>
				
				<td>${fieldValue(bean: consumidorInstance, field: "tel")}</td>
				
				<td>${fieldValue(bean: consumidorInstance, field: "end")}</td>
				
				<td>${fieldValue(bean: consumidorInstance, field: "comp")}</td>
			
				<td>${fieldValue(bean: consumidorInstance, field: "cep")}</td>
			
				<td>${fieldValue(bean: consumidorInstance, field: "cidade")}</td>
			
				<td>${fieldValue(bean: consumidorInstance, field: "estado")}</td>
				
				<td>${fieldValue(bean: consumidorInstance, field: "bairro")}</td>
				
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${consumidorInstanceTotal}" />
	</div>
</section><br/><br/><br/><br/><br/><br/>

</body>

</html>
