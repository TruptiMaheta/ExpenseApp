<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>Expense Details</title>
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
	$(document).ready(function() {
		$('#myTable').DataTable()
	})
</script>
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css' />
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
	
</head>
<body>
	<jsp:include page="aheader.jsp"></jsp:include>
	<h1 align="center">EXPENSES</h1>
	

	<table class="table table-striped" id="myTable" border="1">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Payee Name</th>
				<th scope="col">Category</th>
				<th scope="col">Sub Category</th>
				<th scope="col">Amount Debit</th>
				<th scope="col">Account</th>
				<th scope="col">Time</th>
				<th scope="col">Date</th>
				<th scope="col">Description</th>
				<th scope="col">Documents</th>
				<th><i class="fas fa-edit fa-lg"></i></th>
				<th><i class="fas fa-trash fa-lg"></i></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${expenseDetails}" var="expensedetails">
				<tr>
					<td>${expensedetails.expenseId}</td>
					<td>${expensedetails.payeeName}</td>
					<td>${expensedetails.categorydatalist}</td>
					<td>${expensedetails.subcategorydatalist}</td>
					<td>${expensedetails.ammount}</td>
					<td>${expensedetails.type}</td>
					<td>${expensedetails.timeexp}</td>
					<td>${expensedetails.dateexp}</td>
					<td>${expensedetails.description}</td>
					<td><form action="viewImage" method="post">
							<input type="hidden" value="${expensedetails.image }"
								name="imageurl" /> <input type="submit" value="view" />
						</form></td>
					<td><a href="aeditexpense/${expensedetails.expenseId }"><i class="fas fa-edit"></i></a></td>
					<td><a href="adeleteexpense/${expensedetails.expenseId }"><i class="fas fa-trash"></i></a></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>