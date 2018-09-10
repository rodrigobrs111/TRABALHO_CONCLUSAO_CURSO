<html>
	
	<head>
		<g:actionSubmit value="Update" />
		<!--'Update' is action, label is 'Some update label'-->
		<g:actionSubmit value="Some update label" action="Update" />
		
		<!--label derived from message bundle-->
		<g:actionSubmit value="${message(code:'label.update')}" action="Update" />
		
		<g:actionSubmit value="Delete" />
		
		<g:actionSubmit value="DeleteAll"
		                onclick="return confirm('Are you sure???')" />
	</head>

</html>