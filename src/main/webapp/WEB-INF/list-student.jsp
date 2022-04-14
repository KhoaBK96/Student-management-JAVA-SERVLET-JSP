<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<c:set var="context" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
	<title>Student Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>NGUYEN HUE HIGHSCHOOL</h2>
		</div>
	</div>
	
	<div id="container">	
		<div id="content">
		
			<!-- Add Button -->
			<a href="<c:out value="${pageContext.request.contextPath}"/>/AddStudent">AddStudent</a>
			<!-- Get Button -->
			</br>
			</br>

			<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>ClassName</th>
				<th>Teacher</th>
				
			</tr>
			
			<c:forEach var="tempStudent" items="${STUDENT_LIST}" >
				 
				<tr>
					<td><c:out value="${tempStudent.firstName}"/></td>
					<td><c:out value="${tempStudent.lastName}"/></td>
					<td><c:out value="${tempStudent.email}"/></td>
					<td><c:out value="${tempStudent.classRoom.name}"/></td>
					<td><c:out value="${tempStudent.classRoom.teacher}"/></td>
					<td><a href="<c:out value="${pageContext.request.contextPath}"/>/AddStudent?ID=<c:out value="${tempStudent.id}"/>">EDIT</a></td>
					<td><a href="<c:out value="${pageContext.request.contextPath}"/>/DeleteStudent?ID=<c:out value="${tempStudent.id}"/>">DELETE</a></td>
				</tr>
				
			</c:forEach>
			</table>
			</br>
			
			<a href="<c:out value="${pageContext.request.contextPath}"/>/ListClass">Class-List</a>
			
		</div>
	</div>
	
	

</body>
</html>