<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.slim.js"
	integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY="
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
<script src='//cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js'></script>

<link
	href='//cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css'
	rel='stylesheet'
	integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC'
	crossorigin='anonymous'>
<script>
		$(document).ready( function () {
			$('#myTable').DataTable()
		} )
		</script>
</head>
<body>
	<h3>Account List</h3>
	<table class="table" id="myTable">
		<thead>
			<tr>
				<th>Id</th>
				<th>Account Name</th>
				<th>Balance</th>
				<th>Date</th>
				<th>Time</th>
				<th>Account Type</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${account}" var="user">
				<tr>
					<td>${user.a_id}</td>
					<td>${user.aname}</td>
					<td>${user.balance}</td>
					<td>${user.currentDate}</td>
					<td>${user.currentTime}</td>
					<td>${user.type}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>