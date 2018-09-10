

<%@ page import="dominio.Pedido" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="kickstart">
	</head>
	<body>
		<h1>TODOS OS PEDIDOS </h1>


		   <br/><br/><br/><br/>
		   <g:form  controller="pedido"  > 
		   		Buscar Pedido: <input type="text" name="buscarPedido" /> 
		   		               <input type="submit" value="Buscar"    /> 
		   </g:form>
		   <br/><br/><br/>

			
		
		<table border="1" >
		
			<tr>
			<th> Numero </th>
			<th> Nome </th>
			<th>QTD</th>
			<th>Preço</th>
			</tr>
	
		<g:each  var="i" in="${(0..<9)}" >
			<tr>
				<td>TESTE</td>
				<td>TESTE</td>
				<td>TESTE</td>
				<td>TESTE</td>						
			</tr>
			
		</g:each>
			
		</table>

            <br/><br/><br/>
			<div style="width:150px;height:150px;line-height:3em;overflow:auto;padding:5px;">
			
			This 'div' element contains more content than the previous one. Because there's too much
			 text to fit into the box, the box grows scrollbars. 
			
			</div>
	
	</body>
</html>
