<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Random" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>Expense Details</title>
		<script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
		
				<link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
		<script src='//cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js'></script>
		
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
<script>
		$(document).ready( function () {
	$('#myTable').DataTable()
		} )
		</script>
</head>
<body>
<jsp:include page="aheader.jsp"></jsp:include>
	<table class="table table-striped" id="myTable" border="1">
		<thead>
			<tr>
				<th>UserId</th>
				<th>FirstName</th>
				<th>Email</th>
				<th><i class="fas fa-edit fa-lg"></i></th>
				<th><i class="fas fa-trash fa-lg"></i></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.userId}</td>
					<td>${user.firstName }</td>
					<td>${user.email}</td>
					<td><a href="EditUser/${user.userId}"><i class="fas fa-edit"></i></a></td>
					<td><a href="delete/${user.userId}"><i class="fas fa-trash"></i></a> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>