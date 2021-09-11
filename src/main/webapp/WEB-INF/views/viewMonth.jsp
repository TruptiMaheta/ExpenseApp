<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title><link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<script
	src="https://raw.githack.com/eKoopmans/html2pdf/master/dist/html2pdf.bundle.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include></br>

	<div id="pdf" align="center">
	<h3 align="center">View Month Report</h3>
		<table class="table table-striped" border="1">
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Payee Name</th>
				<th scope="col">Category</th>
				<th scope="col">Sub Category</th>
				<th scope="col">Amount Debit</th>
				<th scope="col">Account</th>
				<th scope="col">Time</th>
				<th scope="col">Date</th>
				<th scope="col">Description</th>

			</tr>
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
				</tr>
			</c:forEach>
		</table>
	</div></br>
	<div align="center">
	<button onclick="generatePDF()" class="btn btn-primary">Month Report</button>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</body>
<script>
    function generatePDF(){
        const pdf=document.getElementById('pdf');
    html2pdf()
    .from(pdf)
    .save();
    }
</script>
</html>