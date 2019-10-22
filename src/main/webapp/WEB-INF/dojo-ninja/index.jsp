<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	
	<body>
		
		<h1>All Dojos</h1>
		<table>
		    <thead>
		        <tr>
		            <th>Locations</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${dojos}" var="dojo">
		        <tr>
		            <td> <a href="/dojos/${dojo.id}"><c:out value="${dojo.name}"/></a> </td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
		<a href="/dojos/new">New Dojo</a> <br />
		<a href="/ninjas/new">New Ninja</a>
		
	</body>
</html>