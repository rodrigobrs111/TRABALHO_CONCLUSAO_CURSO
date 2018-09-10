
<%@ page import="dominio.Pedido" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="kickstart">
		<g:set var="entityName" value="${message(code: 'pedido.label', default: 'Pedido')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	
	<body>
	
	
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		
		<g:form url="[action:'buscarPedido',controller:'pedido']" method = "post" ><br/>
				Número do Pedido: <input type = "text" name = "numPedido"/><br/>
					              <input type = "submit" value = "Buscar" >
		</g:form><br/><br/>
		
		
		<section id="list-pedido" class="first">
      	<table class="table table-bordered">	
		<thead>
			      <tr>
					
						<g:sortableColumn property="numPedido" title="${message(code: 'pedido.numPedido.label', default: 'Num Pedido')}" />
					
						<th><g:message code="pedido.produto.label" default="Produto" /></th>
					
						<g:sortableColumn property="qtdProdutos" title="${message(code: 'pedido.qtdProdutos.label', default: 'Qtd Produtos')}" />
					
						<g:sortableColumn property="status" title="${message(code: 'pedido.status.label', default: 'Status')}" />
		
						<g:sortableColumn property="valorPedido" title="${message(code: 'pedido.valorPedido.label', default: 'Valor Pedido')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${pedidoInstanceList}" status="i" var="pedidoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}"  >
					
							<td><g:link action="show" id="${pedidoInstance.id}">${fieldValue(bean: pedidoInstance, field: "numPedido")}</g:link></td>
						
							<td>${fieldValue(bean: pedidoInstance, field: "produto")}</td>
						
							<td>${fieldValue(bean: pedidoInstance, field: "qtdProdutos")}</td>
						
			             	<td>${fieldValue(bean: pedidoInstance, field: "status")}</td>
							
						   	<td>${fieldValue(bean: pedidoInstance, field: "valorPedido")}</td>
		
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
			</div>
		</section><br/><br/><br/>
		 
	    <h1>Pesquisa de Satisfação do Consumidor</h1><br/>	
		
	    <form action="radio">
	      <input type="radio" name="muitoRuim" id="muitoRuim" value="muitoRuim">Muito Ruim<br/>
		  <input type="radio" name="ruim" id="ruim" value="ruim">Ruim<br/>
		  <input type="radio" name="regular" id="regular" value="regular">Regular<br/>
		  <input type="radio" name="bom" id="bom" value="bom">Bom<br/>
		  <input type="radio" name="muitoBom" id="muitoBom" value="muitoBom">Muito Bom<br/>
		  <input type="radio" name="excelente" id="excelente" value="excelente">Excelente<br/>
		</form>
	    
		
		
		<g:form url="[ action:'list' , controller: 'pedido' ]" method="post">
	  			      <input type="submit" value="Confirmar Recebimento"/>
 	   </g:form><br/><br/><br/><br/><br/><br/>	
		
	</body>
</html>
