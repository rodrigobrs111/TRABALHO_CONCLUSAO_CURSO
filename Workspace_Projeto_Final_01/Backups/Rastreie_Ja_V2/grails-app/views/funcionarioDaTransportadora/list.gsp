
<%@ page import="dominio.FuncionarioDaTransportadora" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'funcionarioDaTransportadora.label', default: 'FuncionarioDaTransportadora')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-funcionarioDaTransportadora" class="first">

	<table class="table table-bordered">
		<thead>
			<tr>
			
				<g:sortableColumn property="matricula" title="${message(code: 'funcionarioDaTransportadora.matricula.label', default: 'Matricula')}" />
			
				<g:sortableColumn property="nomeFuncTransp" title="${message(code: 'funcionarioDaTransportadora.nomeFuncVarej.label', default: 'Nome Funcionário da Transportadora')}" />
			
				<g:sortableColumn property="email" title="${message(code: 'funcionarioDaTransportadora.email.label', default: 'Email')}" />
			
				<g:sortableColumn property="sexo" title="${message(code: 'funcionarioDaTransportadora.sexo.label', default: 'Sexo')}" />
			
				<g:sortableColumn property="nasc" title="${message(code: 'funcionarioDaTransportadora.nasc.label', default: 'Nasc')}" />
			
				<g:sortableColumn property="tel" title="${message(code: 'funcionarioDaTransportadora.tel.label', default: 'Tel')}" />

				<g:sortableColumn property="end" title="${message(code: 'funcionarioDaTransportadora.end.label', default: 'End')}" />

				<g:sortableColumn property="comp" title="${message(code: 'funcionarioDaTransportadora.comp.label', default: 'Comp')}" />
			
				<g:sortableColumn property="cep" title="${message(code: 'funcionarioDaTransportadora.cep.label', default: 'Cep')}" />
			
				<g:sortableColumn property="cidade" title="${message(code: 'funcionarioDaTransportadora.cidade.label', default: 'Cidade')}" />
			
				<g:sortableColumn property="estado" title="${message(code: 'funcionarioDaTransportadora.estado.label', default: 'Estado')}" />
			
				<g:sortableColumn property="bairro" title="${message(code: 'funcionarioDaTransportadora.bairro.label', default: 'Bairro')}" />

			
			</tr>
		</thead>
		<tbody>
		<g:each in="${funcionarioDaTransportadoraInstanceList}" status="i" var="funcionarioDaTransportadoraInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
                <td><g:link action="show" id="${funcionarioDaTransportadoraInstance.id}">${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "matricula")}</g:link></td>
			
				<td>${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "nomeFuncTransp")}</td>
			
				<td>${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "email")}</td>
			
				<td>${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "sexo")}</td>
			
				<td>${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "nasc")}</td>
				
				<td>${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "tel")}</td>
				
				<td>${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "end")}</td>
				
				<td>${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "comp")}</td>
			
				<td>${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "cep")}</td>
			
				<td>${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "cidade")}</td>
			
				<td>${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "estado")}</td>
				
				<td>${fieldValue(bean: funcionarioDaTransportadoraInstance, field: "bairro")}</td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${funcionarioDaTransportadoraInstanceTotal}" />
	</div>
</section><br/><br/><br/><br/><br/><br/>

</body>

</html>
