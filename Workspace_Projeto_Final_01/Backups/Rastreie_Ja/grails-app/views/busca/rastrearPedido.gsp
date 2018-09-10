

<html>
    
    <head>
       <meta name="layout" content="kickstart" />
    </head>

	<body><br/><br/><br/>
	
	
	
		<h2>Nova Busca:</h2>
		
			<g:form url="[action:'_rastrearPedido',controller:'busca']" method = "GET" ><br/>
				             Numero do Pedido: <input type = "text" name = "numPedido"/><br/>
					                           <input type = "submit" value = "Buscar" >
			 </g:form><br/><br/><br/><br/> 
			 
		<section id="list-busca" class="first">
		
			<table class="table table-bordered">
				<thead>
				  <tr>
					  <g:sortableColumn property="Data" title="Data"/> 
					  <g:sortableColumn property="Local" title="Local"/>
					  <g:sortableColumn property="Situação" title="Situação"/>
					  <g:sortableColumn property="Descrição" title="Descrição"/>
				  </tr>
				  
					  <g:each in="${lstDatas}" status="i" var="k" >
					  
							<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
					  	 	  	<td>${lstDatas.get(i)}</td>
							    <td>${lstLocais.get(i)}</td>
							    <td>${lstSituacoes.get(i)}</td>
							    <td>${lstDescricoes.get(i)}</td>
				  	 		</tr>
				  	 		
					  </g:each>		
					  		
				  		
				</table>
		</section><br/><br/><br/><br/><br/><br/><br/><br/>
	</body>



</html>