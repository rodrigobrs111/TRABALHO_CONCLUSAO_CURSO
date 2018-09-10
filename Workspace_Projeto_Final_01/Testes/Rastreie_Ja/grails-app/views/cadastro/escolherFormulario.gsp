
<html>

	<head>
		<title><g:message code="Rastreie Já" /> </title>
		<meta name="layout" content="kickstart" />
		

	</head>
	
	<body>

		<ul class="nav pull-left">
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#"><g:message code="NOVO USUÁRIO"/><b class="caret"></b></a>
				<ul class="dropdown-menu">
							<li class=""><g:link url="[action: 'create' , controller: 'consumidor']" >                   Novo Consumidor                    </g:link></li>
							<li class=""><g:link url="[action: 'create' , controller: 'distribuidor']" >                 Novo Distribuidor                  </g:link></li>
							<li class=""><g:link url="[action: 'create' , controller: 'funcionarioDaTransportadora']"  > Novo Funcionário da Transportadora </g:link></li>
							<li class=""><g:link url="[action: 'create' , controller: 'funcionarioDoVarejista']" >       Novo Funcionário do Varejista      </g:link></li>
							<li class=""><g:link url="[action: 'create' , controller: 'SupervisorDoVarejista']" >        Novo Supervisor do Varejista       </g:link></li>
							<li class=""><g:link url="[action: 'create' , controller: 'GerenteDoVarejista']" >           Novo Gerente do Varejista          </g:link></li>
			   </ul>
			</li>
		</ul><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
	
	</body> 
	
</html>