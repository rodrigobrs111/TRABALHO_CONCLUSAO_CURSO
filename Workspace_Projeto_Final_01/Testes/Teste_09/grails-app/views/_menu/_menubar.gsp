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
	
		<g:each status="i" var="c" in="${grailsApplication.controllerClasses.sort { it.logicalPropertyName } }">
			<li class="controller${params.controller == c.logicalPropertyName ? " active" : ""}">
				<g:link controller="${c.logicalPropertyName}" action="index">





				<a class="dropdown-toggle" data-toggle="dropdown" href="#">
				<g:message code="${c.logicalPropertyName}.label" default="${c.logicalPropertyName.capitalize()}"/><b class="caret"></b></a>
		
		
			<ul class="dropdown-menu">
			
			<li class="">
				<a tabindex="-1" href="#"><b>Technical Admin</b></a>
			</li>
			<g:if env="development">
			<li class=""><a href="${createLink(uri: '/dbconsole')}"><g:message code="default.dbconsole.label"/></a></li>
			</g:if>
			<li class=""><a href="${createLink(uri: '/systeminfo')}"><g:message code="default.systeminfo.label"/></a></li>
				<li class="dropdown-submenu">
				<a tabindex="-1" href="#">All Controller</a>
				<ul class="dropdown-menu">
					<li class="controller"><g:link controller="home">HomeController</g:link></li>
					<li class="divider"></li>
					<g:each var="d" in="${grailsApplication.controllerClasses.sort { it.logicalPropertyName } }">
						<g:if test="${d.logicalPropertyName != 'home'}">
				     	<li class="controller"><g:link controller="${d.logicalPropertyName}">${d?.fullName?.substring(d?.fullName?.lastIndexOf('.')+1)}</g:link></li>
						</g:if>
					</g:each>
				</ul>
			</li>
			</ul>
		
		
		
		
		
		
		
		
				</g:link>
			</li>
		</g:each>
		
	</ul>
</div>
