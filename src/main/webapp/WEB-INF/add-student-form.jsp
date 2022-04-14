<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<title>Add Student</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
	
</head>

<body>
	<div>
		<div>
			<h2>NGUYEN HUE HIGHSCHOOL</h2>
		</div>
	</div>
	
	<div>
		<h3>Add Student</h3>
		
		<form method="POST">
			
			<table>
				<tbody>
					<tr>
						<input type="hidden" value="<c:out value="${UPDATE_STUDENT.id}"/>" name="id"/>
						<td><label>First name:</label></td>
						<td><input type="text" name="firstName" value="<c:out value="${UPDATE_STUDENT.firstName}"/>"/></td>
					</tr>
					
					<tr>
						<td><label>Last name:</label></td>
						<td><input type="text" name="lastName" value="<c:out value="${UPDATE_STUDENT.lastName}"/>"/></td>
					</tr>
					
					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email" value="<c:out value="${UPDATE_STUDENT.email}"/>"/></td>
					</tr>
					
						
							<label>ClassRoom:</label></td>
							<select  name="classRoomId" >
							<c:forEach var="tempClass" items="${CLASS_LIST}" >
								<option value="<c:out value="${tempClass.id}"/>"><c:out value="${tempClass.name}"/></option>
							</c:forEach> 
						
					
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="<c:out value="${pageContext.request.contextPath}"/>/">Back to List</a>
		</p>
	</div>
</body>

</html>