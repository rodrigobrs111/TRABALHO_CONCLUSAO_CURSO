<g:if test="${session.layout == null || session.layout == 'grid'}">
	<g:set var="menutype" value="nav nav-tabs" />
</g:if>
<g:elseif test="${session.layout == 'fluid'}">
	<g:set var="menutype" value="nav nav-tabs" />
</g:elseif>

<!-- position of menu: LTR (left-to-right, European) or RTL (right-to-left, Oriental) -->
<g:if test="${session.menuposition == 'right' && session.layout == 'grid'}">
	<g:set var="menuposition" value="pull-right" />
</g:if>
<g:elseif test="${session.menuposition == 'right' && session.layout == 'fluid'}">
	<g:set var="menuposition" value="tabbable tabs-right" /> <!-- pull-right -->
</g:elseif>

<g:elseif test="${session.layout == 'fluid'}">
	<g:set var="menuposition" value="tabbable tabs-left" /> <!-- pull-left -->
</g:elseif>
<g:else>
	<g:set var="menuposition" value="" />
</g:else>


<div class="${menuposition}">
	<ul class="${menutype}" data-role="listview" data-split-icon="gear" data-filter="true">




 
	
	<ul class="nav pull-left">
		<li class="dropdown">
			<a class="dropdown-toggle" data-toggle="dropdown" href="#"><g:message code="PEDIDOS"/><b class="caret"></b></a>
			<ul class="dropdown-menu">
				<g:if env="development">
				<li class=""><g:link url="[action: 'confirmarRecebimento' , controller: 'pedido']" >Confirmar Recebimento</g:link></li>
				</g:if>
				<li class="dropdown-submenu">
					<a tabindex="-1" href="#">Vizualizar Pedidos</a>
					<ul class="dropdown-menu">
						<li class=""><g:link url="[action: 'list'            , controller: 'pedido']" >Todos os Pedidos</g:link></li>
						<li class=""><g:link url="[action: 'autorizarColeta' , controller: 'pedido']" >Autorizar Coleta</g:link></li>
						<li class=""><g:link url="[action: 'cancelarEntrega' , controller: 'pedido']" >Cancelar Entrega</g:link></li>
						<li class=""><g:link url="[action: 'encerrarEntrega' , controller: 'pedido']" >Encerrar Entrega</g:link></li>
				   </ul>
				</li>
			</ul>
		</li>
	</ul>
	
	
	
	
		<ul class="nav pull-left">
		<li class="dropdown">
			<a class="dropdown-toggle" data-toggle="dropdown" href="#"><g:message code="PRODUTOS"/><b class="caret"></b></a>
			<ul class="dropdown-menu">
				<g:if env="development">
					<li class=""><g:link url="[action: 'list'  , controller: 'produto']" >Visualizar Produtos</g:link></li>
			    </g:if>
				   </ul>
				</li>
			</ul>
	

	
		<ul class="nav pull-left">
		<li class="dropdown">
			<a class="dropdown-toggle" data-toggle="dropdown" href="#"><g:message code="RECLAMAÇÕES"/><b class="caret"></b></a>
			<ul class="dropdown-menu">
				<li class="dropdown-submenu">
					<a tabindex="-1" href="#">Vizualizar Reclamações</a>
					<ul class="dropdown-menu">
						<li class=""><g:link url="[action: 'list'                , controller: 'reclamacao']" >Visualizar Reclamações</g:link></li>
						<li class=""><g:link url="[action: 'list'                , controller: 'sugestao'  ]" >Visualizar Sugestões</g:link></li>
						<li class=""><g:link url="[action: 'create'              , controller: 'reclamacao']" >Registrar Reclamação</g:link></li>
						<li class=""><g:link url="[action: 'create'              , controller: 'sugestao'  ]" >Registrar Sugestão</g:link></li>
		  	      </ul>
				</li>
			</ul>
		</li>
	</ul>
	
	
	
		<ul class="nav pull-left">
		<li class="dropdown">
			<a class="dropdown-toggle" data-toggle="dropdown" href="#"><g:message code="RELATÓRIOS"/><b class="caret"></b></a>
			<ul class="dropdown-menu">
				<g:if env="development">
					<li class=""><g:link url="[action: 'visualizarRelatorios'  , controller: 'relatorio']" >Visualizar Relatórios</g:link></li>
			    </g:if>
				   </ul>
				</li>
			</ul>
	
	
	
	
	
	
		
	</ul>
</div>


