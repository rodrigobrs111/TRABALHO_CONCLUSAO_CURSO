<!DOCTYPE html>

<html>

   <head>
   <meta name = "layout" content = "main" />
   <title> CLIENTE </title>    
   </head>

   <body>
   
	   <table>
	   <tr>
		   <td> Nome:  </td>       
		   <td> Idade: </td>	
	   </tr>
	  
	  <g:each in ="${list}"  var = "c">
		  <tr>
			  <td> ${c.nome}  </td>
			  <td> ${c.idade} </td>	  
		  </tr>
	  </g:each>
	  
	   </table>
	   
   </body>

	
</html>