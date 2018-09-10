<@ page contentType="text/html;charset=UTF-8" >
<@ page contentType="text/html;charset=UTF-8" >

<html  xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
	
	<head>
	<meta name = "layout" content = "main" />	
	<r:require modules = "bootStrap "/>
	</head>
	
	<body>
	<section>
	<div class = "container" >
	<div class = "row">
	<header>
	<h3> Person <small class = "lead">  Adress List </small> </h3>
	</header>
	<div class = "span3"> 
	<g:link class = "btn btn-block btn-link" action = "create">
	 Create New Person
	</g:link>
	<div class = "well">
	<ul class = "nav nav-list">
	<li class = "nav-header" > People</li>
	<li class = "active"> 
	<a id = "view-all" href = "#">
	<i class = "icon-chevron-right pull-right" ></i>
	<b> View All</b>
	</a>
	 </li>
	 <g:each in = "${people}" var = "person" status = "i">
	 <li>
	 <a href = "#Person-${person.id}">
	 <i class = "icon-chevron-right pull-right"></i>
	 ${ "${ person.firstName } ${ person.lastName }" }
	 </a>
	 </li>
	 </g:each>
	</ul>
	</div>
	</div>
	<div class= "span9">
	<g:each in = "${people}" var = "person" status = "i">
	<div id = "#Person-${person.id}" class = "well well-small">
	<table class = "table table-bordered table-striped">
    <caption>
    ${ "${ person.firstName } ${ person.lastName }" }: List of know addresses
    </caption>
    <thead>
    <tr>
    <th> State    </th>
    <th> City     </th>
    <th> Street   </th>
    <th> Zip Code </th>
    <th> Options  </th>
    </tr>
    </thead>
    <tbody>
    <g:each in = "${ person.addresses }" var ="address" >
    <tr>
    <td> ${address.state} } </td>
    <td> ${address.city} } </td>
    <td> ${address.streetAddress} } </td>
    <td> ${address.zipCode} } </td>
    <td> <g:link class = "btn btn-small btn-inverse" controller = "address"  action = "edit" id = "${address.id}"  >
   <i class = "icon-edit icon-white"> </i>
    </g:link>
    </td>
    </tr>
     </g:each>
    </tbody>
	</table>
	<div class = "btn-group" >
	<g:link class = "btn btn-primary" action = "edit" id = "${person.id }" >
	<i class = "icon-edit icon-white" > </i>Edit
	</g:link>
	</div>
	</div>
	</g:each>
	</div>
	</div>
	</div>
	</section>
	<g:javascript >
	$( 'ul.nav > li > a' ).click( function( e ) )
	{
	  if( $(this).attr( 'id' ) == "view-all" )
	  {
	    $( 'div[ id*= "person-" ]' ).fadenIn( 'fast' ) ;	
	  }
	  else
	  {
	     var aRef = $(this) ;
	     var tablesToHide = $( 'div[ id*="Person-" ]:visible' ).length > 1 ?
	     $( 'div[ id*="Person-" ]:visible' ) : $($'.nav > li[ class = "active" ]' > a ).attr( 'href' ) ) ;
	     tablesToHide.hide()                                                                             ;
	     $(aRef.attr( 'href' )).fadeIn( 'fast' )                                                         ;
	     
	  }
	  $('.nav > li[ class = "active" ]').removeClass( 'active' ) ;
	  $(this).parent().addClass( 'active' )                      ;
	  
	} ) ;
	
	</g:javascript>
	
	</body>

</html>



