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
			<a href="<c:out value="${pageContext.request.contextPath}"/>/AddClass">AddClass</a>
			<!-- Get Button -->
			</br>
			</br>
		
			<table>
			<tr>
				<th>Class Name</th>
				<th>Teacher</th>
	
			</tr>
			
			<c:forEach var="tempClass" items="${CLASS_LIST}" >
				 
				<tr>
					<td><c:out value="${tempClass.name}"/></td>
					<td><c:out value="${tempClass.teacher}"/></td>
					<td><a href="<c:out value="${pageContext.request.contextPath}"/>/AddClass?ID=<c:out value="${tempClass.id}"/>">EDIT</a></td>
					<td><a href="<c:out value="${pageContext.request.contextPath}"/>/DeleteClass?ID=<c:out value="${tempClass.id}"/>">DELETE</a></td>
				</tr>
				
			</c:forEach>
			</table>
			</br>
			
			<a href="<c:out value="${pageContext.request.contextPath}"/>/">Student-List</a>
			
		</div>
	</div>
	
</body>

</html>