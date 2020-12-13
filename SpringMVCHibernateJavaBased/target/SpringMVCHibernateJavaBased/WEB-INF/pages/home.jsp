<%@page import="com.jbk.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1>Welcome Home</h1>
	<%
		List<Student> studentslist = (List<Student>) request.getAttribute("studentslist");
	%>

	<!-- <<form action="getStudents" method="get">
<input type="submit" value="getStudents">

</form> -->

	<center>
		<table border="2">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Address</th>
				<th>Contact</th>
				<th>Email</th>
				<th>Course</th>
				<th>Delete</th>
				<th>Edit</th>
			</tr>
			<%
				for (Student st : studentslist) {
			%>
			<tr>
				<td>
					<%
						out.println(st.getStudId());
					%>
				</td>
				<td>
					<%
						out.println(st.getStudName());
					%>
				</td>
				<td>
					<%
						out.println(st.getStudAddress());
					%>
				</td>
				<td>
					<%
						out.println(st.getStudContact());
					%>
				</td>
				<td>
					<%
						out.println(st.getStudEmail());
					%>
				</td>
				<td>
					<%
						out.println(st.getCourse().getCourseName());
					%>
				</td>
				<td><a href="delete?id=<%=st.getStudId()%>">Delete</a></td>
				<td><a href="update?id=<%=st.getStudId()%>">Edit</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<a href="addStudents">Add Student</a>
		<br>
		<a href="addCourse">Add Course</a>
		<br>
		<a href="listCourse">List of Courses</a>
	</center>

</body>
</html>