<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<script
	src="https://raw.githack.com/eKoopmans/html2pdf/master/dist/html2pdf.bundle.js"></script>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include></br>
	<div class="w-50 p-3" style="margin: auto" align="center">
		
			<h3 align="center">View Profile</h3>
			<table class="table table-striped" border="1" >
				<thead>
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Name</th>
						<th scope="col">Email</th>
						<th scope="col">Password</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${user}" var="expensedetails">
						<tr>
							<td>${expensedetails.userId}</td>
							<td>${expensedetails.firstName}</td>
							<td>${expensedetails.email}</td>
							<td>${expensedetails.password}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
</body>
</html>