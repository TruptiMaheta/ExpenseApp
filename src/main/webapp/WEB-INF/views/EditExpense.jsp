<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Random" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
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
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-md-6" style="margin: auto">

				<s:form action="../updateexpense" method="post" modelAttribute="user"
					enctype="multipart/form-data"
					class="row  right mx-auto shadow-lg p-2 mb-3 bg-body rounded">
					<fieldset>
						<legend>
							<h3 align="center">Edit Expense</h3>
						</legend>
						<s:hidden path="expenseId" value="${user.expenseId}"></s:hidden>
						<div class="form-group">
							<label for="exampleDataList"
								class="form-label form-label-margin-bottom"><h5>Enter
									Payee</h5></label> <input action="test2" class="form-control"
								list="datalistOptions" id="exampleDataList"
								placeholder="Type to search..." name="payeeName" value="${user.payeeName}"
								onchange='onInputPayee()'>

							<datalist id="datalistOptions">
								<c:forEach items="${payee}" var="payedata">
									<option value="${payedata.pname}"></option>
								</c:forEach>
							</datalist>

						</div>
						<div class="row">
							<div class="col-sm">
								<div class="form-group">
									<label for="exampleInputEmail1" class="form-label"><h5>
											Amount</h5></label> <input type="number" class="form-control"
										name="ammount" value="${user.ammount}"> <span><h5>${error}</h5></span>
								</div>
							</div>
							<%-- <div class="col-sm">
								<div class="form-group">
									<label for="exampleInputEmail1" class="form-label"><h5>
											Account Type</h5></label> <input type="text" class="form-control"
										name="account_type" value="${user.account_type}" disabled> 
								</div>
							</div> --%>
							<div class="col-sm">
								<div class="form-group">
									<label for="exampleDataList"
										class="form-label form-label-margin-bottom">
										<h5>Account Type</h5>
									</label> <select class="form-select glow" disabled
										aria-label="Default select Account" name="useraccountID">
										<c:forEach items="${users}" var="useraccount">
											<option value="${useraccount.at_id}">${useraccount.type}</option>
										</c:forEach>
									</select>
								</div>
							</div>  
						</div>
						<div class="row">
							<div class="col-sm">
								<div class="form-group">
									<label for="Category" class="form-label"><h5>Category</h5></label><input
										type="text" class="form-control" name="categorydatalist"
										list="categorydatalist" onchange='onInput(this)'
										id="categoryinput" value="${user.categorydatalist}">
									<datalist id="categorydatalist">
										<c:forEach items="${category}" var="catdata">
											<option value="${catdata.cname}"></option>
										</c:forEach>
									</datalist>
								</div>
							</div>

							<div class="col-sm">
								<div class="form-group">
									<label for="subCategory" class="form-label"><h5>SubCategory</h5></label><input
										type="text" class="form-control" name="subcategorydatalist"
										list="subcategorydatalist" id="subcategoryinput" value="${user.subcategorydatalist}">
									<datalist id="subcategorydatalist">
										<c:forEach items="${subCategory}" var="catdata">
											<option value="${catdata.sname}"></option>
										</c:forEach>
									</datalist>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm">
								<div class="form-group">
									<label for="exampleInputEmail1" class="form-label"><h5>
											Description</h5></label> <textarea type="number" class="form-control"
										name="description" id="description">${user.description }</textarea> <%-- <span><h5>${error}</h5></span> --%>
								</div>
							</div>
							</div>
						<div class="row">
							<div class="col-sm">
								<div class="form-group">
									<label for="inputAddress2" class="form-label"><h5>Current
											Time:</h5></label> <input type="text" id="currentTime" name="timeexp"
										class="form-control" value="${user.timeexp}">
									<script>
										var today = new Date();
										var time = today.getHours() + ":"
												+ today.getMinutes() + ":"
												+ today.getSeconds();
										document.getElementById("currentTime").value = time;
									</script>
								</div>
							</div>
							<div class="col-sm">
								<div class="form-group">
									<label for="inputAddress2" class="form-label"><h5>Current
											Date:</h5></label> <input type="date" id="currentDate"
										class="form-control" name="dateexp" value="${user.dateexp}">
									<script>
										document.getElementById('currentDate').value = new Date()
												.toISOString().substring(0, 10);
									</script>
								</div>
							</div>
						</div>
						<%-- <div class="form-group">
							<label for="formFileMultiple" class="form-label"><h5>
									Receipt</h5></label> <input class="form-control" type="file"
								id="formFileMultiple" name="expimage" value="${user.expimage}">
						</div>  --%>
						<div class="text-md-center">
							<button type="submit" class="btn btn-primary"
								style="margin-bottom: 25px; margin-top: 20px;">
								Edit Expense<br>
							</button>
						</div>
					</fieldset>
				</s:form>
				<script>
					function onInputPayee() {
						var val = document.getElementById("exampleDataList").value;
						var xhttp = new XMLHttpRequest();
						console.log(val);
						xhttp.onreadystatechange = function() {
							if (this.readyState == 4 && this.status == 200) {
								console.log(xhttp.response);
								myFunction(this);
							}
						};
						xhttp.open("GET", "/Assignment/payeecategory/" + val,
								true);
						xhttp.send();

					}

					function onInput(e) {
						var val = document.getElementById("categoryinput").value;
						var opts = document.getElementById('categorydatalist').childNodes;
						console.log(val);
						var xhttp = new XMLHttpRequest();
						xhttp.onreadystatechange = function() {
							if (this.readyState == 4 && this.status == 200) {
								console.log(xhttp.response);
								myFunctionsub(this);
							}
						};
						xhttp.open("GET",
								"/Assignment/payeesubcategory/" + val, true);
						xhttp.send();
					}

					function myFunction(xml) {
						var x, i, xmlDoc, txt;
						var list = [];
						xmlDoc = xml.responseXML;
						console.log("xmlDoc");
						console.log(xmlDoc);
						txt = "";
						x = xmlDoc.getElementsByTagName("cname");
						console.log(x.length)
						for (i = 0; i < x.length; i++) {
							/// txt += x[i].childNodes[0].nodeValue + "<br>";
							console.log("test");
							console.log(x[i].childNodes[0].nodeValue);
							list.push(x[i].childNodes[0].nodeValue);
						}
						console.log(list);
						var list2 = document.getElementById('categorydatalist');

						list.forEach(function(item) {
							var option = document.createElement('option');
							option.value = item;
							list2.appendChild(option);
						});
					}

					function myFunctionsub(xml) {
						var x, i, xmlDoc, txt;
						var list = [];
						xmlDoc = xml.responseXML;
						console.log(xmlDoc);
						txt = "";
						x = xmlDoc.getElementsByTagName("item");
						console.log(x.length)
						for (i = 0; i < x.length; i++) {
							txt += x[i].childNodes[0].nodeValue + "<br>";
							console.log(x[i].childNodes[0].nodeValue);
							list.push(x[i].childNodes[0].nodeValue);
						}
						console.log(list);
						var list2 = document
								.getElementById('subcategorydatalist');

						list.forEach(function(item) {
							var option = document.createElement('option');
							option.value = item;
							list2.appendChild(option);
						});

					}
				</script>
			</div>
		</div>
	</div>
</body>
</html>