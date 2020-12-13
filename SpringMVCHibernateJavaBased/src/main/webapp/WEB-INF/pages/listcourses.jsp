<%@page import="com.jbk.entity.Course"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Course> l=(List<Course>)request.getAttribute("courseList");%>
<center>
<h2>Course list</h2>
<table border="1">
<tr>
<th>Course Id </th>
<th>Course Name </th>
</tr>
<%for(Course c:l)
{
	%>
	<tr>
	<td><%out.println(c.getCourseId());%></td>
	<td><%out.println(c.getCourseName());%></td>
	</tr>
<%
}
%>
</table>

</center>

</body>
</html>