
<!doctype html>
<html lang="en">
<head>
<title>Signup</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="resources/assets/css/style.css">
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body class="img js-fullheight"
	style="background-image: url(resources/assets/images/bg.jpg);">
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">SignUp</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<div class="login-wrap p-0">
						<h3 class="mb-4 text-center">Create account</h3>
						<form action="saveuser" method="post" name="reg"
							enctype="multipart/form-data" modelAttribute="user"
							class="signin-form">
							<div class="form-group">
								<input type="text" name="firstName" class="form-control"
									placeholder="firstName" required>
									
							</div>

							<div class="form-group">
								<input type="email" name="email" class="form-control"
									placeholder="email" id="email" required>
									<span id="emailError"></span>
							</div>
							<div class="form-group">
								<input id="password-field" name="password" type="password"
									class="form-control" placeholder="Password" required> <span
									toggle="#password-field"
									class="fa fa-fw fa-eye field-icon toggle-password"></span>
							</div>

							<div class="form-group">
								<input type="file" name="profile" required>
							</div>
							<div class="form-group">
								<button type="submit"
									class="form-control btn btn-primary submit px-3">SignIn
								</button>
							</div>
							<div>
								<a href="signup" style="color: #fff">already have an account? LOGIN</a>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</section>
	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>

	<script type="text/javascript">
		function checkEmail() {
			let email = document.reg.email.value;
			console.log(email);
			$.get("checkemail/" + email, function(data) {
				console.log(data);
				if (data) {
				 	$("#emailError").text("Email Already In Use");
				}else{
					$("#emailError").text("");
				}
			}).fail(function(err) {
				console.log("error"+err);
			});
		}
		$(document).ready(function() {
			$("#email").blur(function() {
				checkEmail();
			})
		})
	</script>
	<script src="resources/assets/js/jquery.min.js"></script>
	<script src="resources/assets/js/popper.js"></script>
	<script src="resources/assets/js/bootstrap.min.js"></script>
	<script src="resources/assets/js/main.js"></script>

</body>
</html>