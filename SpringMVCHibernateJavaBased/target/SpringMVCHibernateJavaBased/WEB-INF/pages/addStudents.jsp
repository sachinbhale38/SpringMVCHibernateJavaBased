<%@page import="com.jbk.entity.Course"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddStudents</title>
</head>
<body>
<%List<Course> lc= (List<Course>)request.getAttribute("courseList"); %>
	<center>
		<h1>Add new Student</h1>
		<form action="save" method="post">
			<table border="1">
				<tr>
					<td>Enter Name</td>
					<td><input type="text" name="studName"></td>
				</tr>
				<tr>
					<td>Enter Address</td>
					<td><input type="text" name="studAddress"></td>
				</tr>
				<tr>
					<td>Enter Contact</td>
					<td><input type="text" name="studContact"></td>
				</tr>
				<tr>
					<td>Enter Email</td>
					<td><input type="text" name="studEmail"></td>
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
					<td></td>
					<td><input type="submit" value="Submit"></td>
				</tr>

			</table>

		</form>
	</center>

</body>
</html>