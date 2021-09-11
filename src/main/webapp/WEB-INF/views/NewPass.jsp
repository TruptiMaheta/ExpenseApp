<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Random" isELIgnored="false"%>   
<html lang="en">
<head>
<title>forget</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="resources/assets/css/style.css">
<script>  
function matchPassword() {  
  var pw1 = document.getElementById("pass1").value;  
  var pw2 = document.getElementById("pass2").value;  
  if(pw1 != pw2)  
  {   
	  alert("Passwords doesn't match!!!");
   
  } else {
      alert("Passwords Match!!!");
      document.getElementById("regForm").submit();
  }
}  
</script> 
</head>
<body class="img js-fullheight"
	style="background-image: url(resources/assets/images/bg.jpg);">
	<section class="ftco-section">
		<div class="container">
			
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<div class="login-wrap p-0">
						<h3 class="mb-4 text-center">Create New Password</h3>
						<form action="newpass" id="regForm" method="post" modelAttribute="user"
							class="signin-form" >
							<div class="form-group">
								<input id="pass1" name="pass1" type="password"
									class="form-control" placeholder="Password" required> 
									<span toggle="#password-field"
									class="fa fa-fw fa-eye field-icon toggle-password"></span>

							</div>
							<div class="form-group">
								<input id="pass2" name="pass2" type="password"
									class="form-control" placeholder="Confirm Password" required>
								<span toggle="#password-field"
									class="fa fa-fw fa-eye field-icon toggle-password"></span>
							</div>
							<input type="hidden" name="email" value="${users}">

							<div class="form-group">
								<button type="submit"
									class="form-control btn btn-primary submit px-3" onclick="matchPassword()">Submit
								</button>
							</div>
						</form>
						<h5 style="color:white">${error }</h5>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="resources/assets/js/jquery.min.js"></script>
	<script src="resources/assets/js/popper.js"></script>
	<script src="resources/assets/js/bootstrap.min.js"></script>
	<script src="resources/assets/js/main.js"></script>
</body>
</html>