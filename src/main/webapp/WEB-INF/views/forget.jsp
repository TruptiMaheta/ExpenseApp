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

</head>
<body class="img js-fullheight"
	style="background-image: url(resources/assets/images/bg.jpg);">
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Forget Password</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<div class="login-wrap p-0">
						<h3 class="mb-4 text-center">Forget Password</h3>
						<form action="forgetPassword" method="post" modelAttribute="user"
							class="signin-form">
							<div class="form-group">
								<input type="email" name="email" class="form-control"
									placeholder="email" required>
							</div>

							<div class="form-group">
								<button type="submit"
									class="form-control btn btn-primary submit px-3">forget
								</button>
							</div>
						</form>
						<h5>${error}</h5>
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

