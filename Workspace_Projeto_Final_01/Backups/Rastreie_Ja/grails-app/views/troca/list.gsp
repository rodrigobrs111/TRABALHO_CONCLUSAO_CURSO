
<%@ page import="dominio.Troca" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'troca.label', default: 'Troca')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-troca" class="first">

		
		<g:form url="[action:'buscarTroca', controller:'troca']" method = "post" >
				Número da Troca: <input type = "text"            name   = "numTroca"/><br/>
					             <input type = "submit"          value  = "Buscar" >
		</g:form><br/><br/><br/><br/>



	<table class="table table-bordered">
		<thead>
			<tr>
			
			
				<g:sortableColumn property="numTroca" title="${message(code: 'troca.numTroca.label', default: 'NumTroca')}" />
			
				<g:sortableColumn property="numPedidoAnt" title="${message(code: 'troca.numPedidoAnt.label', default: 'NumPedidoAnt')}" />
			
				<g:sortableColumn property="numPedidoNovo" title="${message(code: 'troca.numPedidoNovo.label', default: 'numPedidoNovo')}" />
			
				<g:sortableColumn property="dataSolicit" title="${message(code: 'troca.dataSolicit.label', default: 'Data Solicit')}" />

				<g:sortableColumn property="dataColeta" title="${message(code: 'troca.dataColeta.label', default: 'Data Coleta')}" />

				<g:sortableColumn property="dataEntregaVarej" title="${message(code: 'troca.dataEntregaVarej.label', default: 'Data Entrega Varej')}" />
			
				<g:sortableColumn property="dataEntregaConsumidor" title="${message(code: 'troca.dataEntregaConsumidor.label', default: 'Data Entrega Consumidor')}" />
	
				<g:sortableColumn property="valorTroca" title="${message(code: 'troca.valorTroca.label', default: 'Valor Troca')}" />
	
				<th><g:message code="troca.pedido.label" default="Pedido" /></th>
	
				<th><g:message code="troca.consumidor.label" default="Consumidor" /></th>
			
				<th><g:message code="troca.devolucao.label" default="Devolucao" /></th>


			</tr>
		</thead>
		<tbody>
		<g:each in="${trocaInstanceList}" status="i" var="trocaInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			
				
				<td><g:link action="show" id="${trocaInstance.id}">${fieldValue(bean: trocaInstance, field: "numTroca")}</g:link></td>
				
				<td>${fieldValue(bean: trocaInstance, field: "numPedidoAnt")}</td>

				<td>${fieldValue(bean: trocaInstance, field: "numPedidoNovo")}</td>
			
				<td><g:formatDate date="${trocaInstance.dataSolicit}" /></td>
			
				<td><g:formatDate date="${trocaInstance.dataColeta}" /></td>
			
				<td><g:formatDate date="${trocaInstance.dataEntregaVarej}" /></td>

				<td><g:formatDate date="${trocaInstance.dataEntregaConsumidor}" /></td>
			
				<td>${fieldValue(bean: trocaInstance, field: "valorTroca")}</td>
			
			   <td><g:link action="show" id="${trocaInstance.id}">${fieldValue(bean: trocaInstance, field: "pedido")}</g:link></td>
			
		       <td><g:link action="show" id="${trocaInstance.id}">${fieldValue(bean: trocaInstance, field: "consumidor")}</g:link></td>
			
			   <td><g:link action="show" id="${trocaInstance.id}">${fieldValue(bean: trocaInstance, field: "devolucao")}</g:link></td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="pagination">
		<bs:paginate total="${trocaInstanceTotal}" />
	</div>
</section>

</body>

</html>
