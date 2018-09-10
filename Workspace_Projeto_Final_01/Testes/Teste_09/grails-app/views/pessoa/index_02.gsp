<%@ page import="teste_09.Pessoa" %>

<html>

	<head>
		<title>  INDEX_02 </title>
		<meta name = "layout" content = "kickstart" >
		
	</head>

	<body>
	    <br/><br/><br/><br/><br/><br/><br/><br/>
		<h1> Rastrear Pedido </h1>
			<z:menubar id = "menubar">
				
				<z:menu label = "File">
					<z:menupopup>
						<z:menuitem label = "New" />
						<z:menuitem label = "Open" />
						<z:menuitem label = "Save" />
					  <z:menuseparator/>
					    <z:menuitem label = "Exit" /> 
				   </z:menupopup>
				</z:menu>
				
	  			<z:menu label = "Help" >
	                <z:menupopup>
	                 <z:menuitem label = "Index" />
	                 <z:menu label = "About" >
		                 <z:menupopup>
		                 <z:menuitem label = "About ZK" />	                 
		                 <z:menuitem label = "About Potix" />
		                 </z:menupopup>
				     </z:menu>  
	                </z:menupopup>
	           </z:menu>     
   		  </z:menubar>
	     <z:resources/>	
	     
			     
		<select>
		  <option>Milk</option>
		  <option>Coffee</option>
		  <option>Tea</option>
		</select>
	     
	     <br/><br/><br/>
	     
	     <form action="" method = "get" > 
		   Número do Pedido: <input  type =  "text" name = "Nome" >         <br/>
		                     <input  type =  "submit" value = "Confirmar" > <br/> 
	     </form>
	     <br/><br/><br/><br/><br/><br/><br/><br/>
	</body>

</html>