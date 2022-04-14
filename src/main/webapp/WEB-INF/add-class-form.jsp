<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>Add Class</title>
</head>
<body>
	<div>
		<div>
			<h2>NGUYEN HUE HIGHSCHOOL</h2>
		</div>
	</div>
	
	<div>
		<h3>Add Class</h3>
		
		<form method="POST">
			
			<table>
				<tbody>
					<tr>
						<input type="hidden" value="<c:out value="${UPDATE_CLASS.id}"/>" name="id"/>
						<td><label>Name:</label></td>
						<td><input type="text" name="name" value="<c:out value="${UPDATE_CLASS.name}"/>"/></td>
					</tr>
					
					<tr>
						<td><label>Teacher:</label></td>
						<td><input type="text" name="teacher" value="<c:out value="${UPDATE_CLASS.teacher}"/>"/></td>
					</tr>
					
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="<c:out value="${pageContext.request.contextPath}"/>/ListClass">Back to List</a>
		</p>
	</div>
</body>
</html>