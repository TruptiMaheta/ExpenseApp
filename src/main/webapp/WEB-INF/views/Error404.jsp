<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>

<%
response.setStatus(404);
%>

<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>404 HTML Tempalte</title>

<!-- Google font -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,700,900"
	rel="stylesheet">

<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet"
	href="resources/assets/css/style.css" />

<style>
.content {
	max-width: 500px;
	margin: auto;
}
</style>

</head>

<body class="img js-fullheight"
	style="background-image: url(resources/assets/images/bg.jpg);">
	<div id="container" style="text-align: center;">
		<div id="notfound" class="content">
			<div class="notfound">
				<div class="notfound-404">
					<h1 align="center">Oops!</h1>
				</div>
				<h2 align="center">404 - Page not found</h2>
				<a href="signup">Go To Homepage</a>
			</div>
		</div>
	</div>
</body>

</html>
