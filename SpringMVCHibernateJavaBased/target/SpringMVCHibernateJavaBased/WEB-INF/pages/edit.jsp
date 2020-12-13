<%@page import="com.jbk.entity.Course"%>
<%@page import="com.jbk.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
	<%
		Student s = (Student) request.getAttribute("student");
	%>
	<%List<Course> lc= (List<Course>)request.getAttribute("courseList"); %>
	<center>
		<h1>Update Student</h1>
		<form action="edit" method="post">


			<table border="1">
				
				<tr>
					<td>Enter Name</td>
					<td><input type="text" name="studName"
						value="<%out.println(s.getStudName());%>"></td>
				</tr>
				<tr>
					<td>Enter Address</td>
					<td><input type="text" name="studAddress"
						value="<%out.println(s.getStudAddress());%>"></td>
				</tr>
				<tr>
					<td>Enter Contact</td>
					<td><input type="text" name="studContact"
						value="<%out.println(s.getStudContact());%>"></td>
				</tr>
				<tr>
					<td>Enter Email</td>
					<td><input type="text" name="studEmail"
						value="<%out.println(s.getStudEmail());%>"></td>
				</tr>
				<tr>
					<td>Enter Course</td>
					<td>
					<select name="course.courseId">
					<%for(Course c:lc)
					{
						%>
			
					<option value="<%=c.getCourseId()%>"><%out.println(c.getCourseName()); %></option>
					<%}%>
				
					</select>
					</td>
				</tr>
			
				<tr>
					<td><input type="hidden" name="studId"
						value="<%out.println(s.getStudId());%>"></td>
					<td><input type="submit" value="Submit"></td>
				</tr>

			</table>

		</form>
	</center>


</body>
</html>