<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Random"%>
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
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h2>Signup</h2>
				<s:form action="adduser" method="post" modelAttribute="user">
					<div class="form-group">
						<label for="firstName">FirstName:</label>
						<s:input type="text" cssClass="form-control" id="firstName"
							placeholder="Enter firstname" path="firstName"></s:input>
						<s:errors path="firstName" cssClass="error"></s:errors>
					</div>
					<div class="form-group">
						<label for="email">Email:</label>
						<s:input type="email" cssClass="form-control" id="email"
							placeholder="Enter email" path="email"></s:input>
						<s:errors path="email" cssClass="error"></s:errors>
					</div>
					<div class="form-group">
						<label for="pwd">Password:</label>
						<s:input type="password" cssClass="form-control" id="pwd"
							placeholder="Enter password" path="password"></s:input>
						<s:errors path="password" cssClass="error"></s:errors>
					</div>					
					<s:button type="submit" class="btn btn-primary">Submit</s:button>
				</s:form>
			</div>
		</div>
	</div>
</body>
</html>