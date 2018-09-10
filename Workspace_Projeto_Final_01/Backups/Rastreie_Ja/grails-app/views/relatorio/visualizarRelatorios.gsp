<html>
  <head>
  	<meta name="layout" content="kickstart">
  </head>
  
  
  	<body><br/><br/><br/>
	
		<section id="list-relatorio" class="first">
		
			<table class="table table-bordered">
				<thead>
				
				<g:each in="${(1..1)}" status ="i" var="k" >
				
				  <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
					 <g:sortableColumn property="Relatório de Reclamações Atendidas" title="Relatório de Reclamações Atendidas"/>  
				  </tr>
						     <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
				                <td>	
									<g:form>
						                 <g:actionSubmit class="btn btn-primary"  action="geraRelReclamacoesAtendidas" value=" 1ºTRIMESTRE DE ${anoPedido}" />
						                 <input type="hidden" name="trimestre" value="1" >
				 	                </g:form>
	 	                         </td>
					 	     </tr> 
				  	 	 
				             <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
				                <td>	
									<g:form>
						                 <g:actionSubmit class="btn btn-primary"  action="geraRelReclamacoesAtendidas" value=" 2ºTRIMESTRE DE ${anoPedido}" />
						                 <input type="hidden" name="trimestre" value="4" >
				 	                </g:form>
	 	                         </td>
					 	     </tr> 

				             <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
				                <td>	
									<g:form>
						                 <g:actionSubmit class="btn btn-primary"  action="geraRelReclamacoesAtendidas" value=" 3ºTRIMESTRE DE ${anoPedido}" />
						                 <input type="hidden" name="trimestre" value="7" >
				 	                </g:form>
	 	                         </td>
					 	     </tr> 

				             <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
				                <td>	
									<g:form>
						                 <g:actionSubmit class="btn btn-primary"  action="geraRelReclamacoesAtendidas" value=" 4ºTRIMESTRE DE ${anoPedido}" />
						                 <input type="hidden" name="trimestre" value="10" >
				 	                </g:form>
	 	                         </td>
					 	     </tr> 
				 </g:each> 		
			
				</table>
		</section><br/><br/><br/>
		
		
	   <section id="list-relatorio" class="first">
		
			<table class="table table-bordered">
				<thead>
				
				<g:each in="${(1..1)}" status ="i" var="k" >
				
				 <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
					 <g:sortableColumn property="Relatório de Nível de Satisfação do Consumidor" title="Relatório de Nível de Satisfação do Consumidor"/>  
				  </tr>
						     <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
				                <td>	
									<g:form>
						                 <g:actionSubmit class="btn btn-primary"  action="geraRelNivelSatisfacaoConsumidor" value=" 1ºTRIMESTRE DE ${anoPedido}" />
						                 <input type="hidden" name="trimestre" value="1" >
				 	                </g:form>
	 	                         </td>
					 	     </tr> 
				  	 	 
				             <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
				                <td>	
									<g:form>
						                 <g:actionSubmit class="btn btn-primary"  action="geraRelNivelSatisfacaoConsumidor" value=" 2ºTRIMESTRE DE ${anoPedido}" />
						                 <input type="hidden" name="trimestre" value="4" >
				 	                </g:form>
	 	                         </td>
					 	     </tr> 

				             <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
				                <td>	
									<g:form>
						                 <g:actionSubmit class="btn btn-primary"  action="geraRelNivelSatisfacaoConsumidor" value=" 3ºTRIMESTRE DE ${anoPedido}" />
						                 <input type="hidden" name="trimestre" value="7" >
				 	                </g:form>
	 	                         </td>
					 	     </tr> 

				             <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
				                <td>	
									<g:form>
						                 <g:actionSubmit class="btn btn-primary"  action="geraRelNivelSatisfacaoConsumidor" value=" 4ºTRIMESTRE DE ${anoPedido}" />
						                 <input type="hidden" name="trimestre" value="10" >
				 	                </g:form>
	 	                         </td>
					 	     </tr> 
					  		
			</g:each>
			
				</table>
		</section><br/><br/><br/>
			
				<section id="list-relatorio" class="first">
		
			<table class="table table-bordered">
				<thead>
				
				<g:each in="${(1..1)}" status ="i" var="k" >
				
				  <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
					 <g:sortableColumn property="Relatório de Pedidos Entregues dentro do Prazo" title="Relatório de Pedidos Entregues dentro do Prazo"/>  
				  </tr>
						     <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
				                <td>	
									<g:form>
						                 <g:actionSubmit class="btn btn-primary"  action="geraRelPedidosEntreguesPrazo" value=" 1ºTRIMESTRE DE ${anoPedido}" />
						                 <input type="hidden" name="trimestre" value="1" >
				 	                </g:form>
	 	                         </td>
					 	     </tr> 
				  	 	 
				             <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
				                <td>	
									<g:form>
						                 <g:actionSubmit class="btn btn-primary"  action="geraRelPedidosEntreguesPrazo" value=" 2ºTRIMESTRE DE ${anoPedido}" />
						                 <input type="hidden" name="trimestre" value="4" >
				 	                </g:form>
	 	                         </td>
					 	     </tr> 

				             <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
				                <td>	
									<g:form>
						                 <g:actionSubmit class="btn btn-primary"  action="geraRelPedidosEntreguesPrazo" value=" 3ºTRIMESTRE DE ${anoPedido}" />
						                 <input type="hidden" name="trimestre" value="7" >
				 	                </g:form>
	 	                         </td>
					 	     </tr> 

				             <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
				                <td>	
									<g:form>
						                 <g:actionSubmit class="btn btn-primary"  action="geraRelPedidosEntreguesPrazo" value=" 4ºTRIMESTRE DE ${anoPedido}" />
						                 <input type="hidden" name="trimestre" value="10" >
				 	                </g:form>
	 	                         </td>
					 	     </tr> 
				</g:each>	  		
			
				</table>
		</section><br/><br/><br/>
		
	</body>
  
  
</html>