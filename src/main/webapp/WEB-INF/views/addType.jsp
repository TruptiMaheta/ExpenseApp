<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Random" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<style type="text/css">
.error {
	color: red;
}

.fieldset {
	background-position: center;
	background-size: cover;
}

.legend {
	width: 200px;
	padding: 10px 20px;
}
</style>
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

</head>
<body>
	<jsp:include page="aheader.jsp"></jsp:include></br>
	<div class="container">
		<div class="row">
			<div class="col-md-6" style="margin: auto">
				<form action="addType" method="post"
					class="row  right mx-auto shadow-lg p-2 mb-3 bg-body rounded">
					<fieldset>
						<legend>
							<h3 align="center">Add Account Type</h3>
						</legend>
						<div class="form-group">
							<label for="type">Account Type:</label> <input type="text"
								Class="form-control" id="type" placeholder="Enter Account Type"
								name="type" />
						</div>
						<div class="text-md-center">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
	<br />
	<br />
	<div class="w-25 p-3" style="margin: auto">
		<fieldset>
			<h3 align="center">Account Type</h3>
			<table class="table table-striped" border="1">
				<thead>
					<tr>
						<th>Id</th>
						<th>Account Type</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${role}" var="user">
						<tr>
							<td>${user.at_id}</td>
							<td>${user.type}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</fieldset>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>