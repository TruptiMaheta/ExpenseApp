<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Random" isELIgnored="false"%>
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
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>Expense Details</title>

	<link
	href='//cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css'
	rel='stylesheet'
	integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC'
	crossorigin='anonymous'>
</head>
<body>
<jsp:include page="aheader.jsp"></jsp:include></br>
	<div class="container">
		<div class="row">
			<div class="col-md-6" style="margin: auto">
				
				<s:form action="../update" method="post" modelAttribute="user"
				class="row  right mx-auto shadow-lg p-2 mb-3 bg-body rounded">
				<fieldset>
							<legend>
								<h3 align="center">Edit User</h3>
							</legend>
					
					<s:hidden path="userId" value="${user.userId}"></s:hidden>
					<div class="form-group">
						<label for="firstName">FirstName:</label>
						<s:input type="text" cssClass="form-control" id="email"
							placeholder="Enter firstname" path="firstName"
							value="${user.firstName}" />
						<s:errors path="firstName" cssClass="error"></s:errors>
					</div>

					<div class="form-group">
						<label for="email">Email:</label>
						<s:input type="text" cssClass="form-control" id="email"
							placeholder="Enter email" path="email" value="${user.email}" />
						<s:errors path="email" cssClass="error"></s:errors>
					</div>
					<div class="form-group">
						<label for="pwd">Password:</label>
						<s:input type="password" cssClass="form-control" id="pwd"
							placeholder="Enter password" path="password"
							value="${user.password }" />
						<s:errors path="password" cssClass="error"></s:errors>
					</div>
					<div class="text-md-center">
					<s:button type="submit" class="btn btn-primary">Submit</s:button>
					</div>
					</fieldset>
				</s:form>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include> 
</body>
</html>