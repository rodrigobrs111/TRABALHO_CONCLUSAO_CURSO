
<html>


	<head>
	    <meta name="layout" content="kickstart">
	</head>

<body>
         <center><h6>

	            	<g:form url="[action:'validarCadastro', controller:'cadastro']" method = "post" accept-charset="UTF-8">
					   Login: <input style="margin-bottom: 20px;" type="text" placeholder="Matricula" id="matricula" name="matricula"><br/>
					   Senha: <input style="margin-bottom: 20px;" type="password" placeholder="Senha" id="senha" name="senha"><br/>
			     		<input type="submit" id="entrar"    value="Entrar">
					</g:form>
			
					<g:form url ="[action: 'escolherFormulario' , controller: 'cadastro']" method = "post" accept-charset="UTF-8">
						<input  type="submit" id="cadastrar" value="Cadastre-se">
					</g:form>
		<h6><center><br/><br/><br/><br/><br/><br/>			
</body>










<!--



FORM2
	<form id="sroForm" name="frm1" method="get" action="http://www.correios.com.br/sistemas/rastreamento/default.cfm" onsubmit="return validaCodigoSro();">
	<fieldset>
	<label>Digite at� 50 c�digos de 13 d�gitos cada, separando-os com ponto e v�rgula. Ex: AA123456789BR;AA987654321BR;AA100833276BR<br>
	<textarea id="objetos" name="objetos" class="f8col fldSRO f3row" style="text-transform:uppercase;" onblur="this.value=this.value.toUpperCase()" onkeydown="if (event.keyCode == 13) { this.form.submit(); return false; }"></textarea>
	</label>
	<div class="separator"></div>
	<div class="btnform">
	<input type="submit" id="btnPesq" name="btnPesq" class="btn1 float-right btnSubmit" value="Buscar">
	</div>
	</fieldset>
	</form>
	
	
	
	FORM3
	<form name="formbusca" id="formbusca" action="http://www.correios.com.br/sistemas/rastreamento/resultadoBusca.cfm" method="post" target="_blank">
      
      <label for="criterioDeBusca" style="margin-left:-9000px; float:left;">Criterio de Busca</label>
      <input type="text" id="criterioDeBusca" name="criterioDeBusca" value="Pesquisar" onfocus="javascript: if( this.value == 'Pesquisar' ){ this.value = '' } " onblur="javascript: if( this.value == ''){ this.value= 'Pesquisar'}">
      <a class="btnbuscar" href="javascript:void(0);" onclick="validate_form(document.getElementById('formbusca'));" title="bot�o Buscar">.</a>
    </form>
	
	
	FORM4
	 <br/><br/><br/><br/><br/><br/><br/><br/><br/>
	<form method="get" action="http://www.correios.com.br/sistemas/rastreamento/default.cfm">
      <input type="submit" class="btn2" value="Nova Consulta">  
    </form>
	

     FORM5
	<div class="ctrlcontent">
		<table class="tmptabela tblSroResultado">
		<thead>
		<tr>
		<th class="text-left">Identificador</th>
		<th class="text-left">Status</th>
		<th class="text-left">Data / Local</th>
		</tr>
		</thead>
		<colgroup>
		<col width="110px;">
		<col width="260px">
		<col>
		</colgroup>	
		<tbody>				
		<form id="sroForm" name="frm1" method="get" action="http://www.correios.com.br/sistemas/rastreamento/resultado.cfm"></form>
		<input type="hidden" name="objetos" value="#indexSRO#">
		
		<tr>
		<td><a href="javascript:document.frm1.objetos.value = 'SS123456789BR';document.forms.namedItem('frm1').submit();"><span class="codSro"><span>SS</span><span>123</span><span>456</span><span>789</span><span>BR</span></span></a></td>
		<td><b>Encaminhado</b></td>
		<td>17/09/2013 FORTALEZA/CE</td>
		</tr>
		
		<tr>
		<td colspan="3"><font color="#FF0000"><b>Objeto Inv�lido ou n�o encontrado!</b></font></td>
		</tr>
		
		
		</tbody>
		</table>
		<div>
		<form method="post" action="http://www.correios.com.br/sistemas/rastreamento/default.cfm">
		<input type="submit" class="btn2" value="Nova Consulta">  
		</form>
		</div>
	</div>




     FORM6
	<tbody>				
		<form id="sroForm" name="frm1" method="post" action="sistemas/rastreamento/resultado.cfm"></form>
		<input type="hidden" name="objetos" value="#indexSRO#">
		
		<tr>
		<td><a href="javascript:document.frm1.objetos.value = 'SS123456789BR';document.forms.namedItem('frm1').submit();"><span class="codSro"><span>SS</span><span>123</span><span>456</span><span>789</span><span>BR</span></span></a></td>
		<td><b>Encaminhado</b></td>
		<td>17/09/2013 FORTALEZA/CE</td>
		</tr>
		
		<tr>
		<td colspan="3"><font color="#FF0000"><b>Objeto Inv�lido ou n�o encontrado!</b></font></td>
		</tr>
		
		
	</tbody>




-->