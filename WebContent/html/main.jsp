<%@ page contentType="text/html; charset = UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Main File</title>
</head>
<body>
	<div class="jumbotron text-center">
		<h1>Simple file upload example!</h1>
		<p>Please upload file</p>
	</div>
	<div class="container">





		<form action="savefile" method="post" enctype="multipart/form-data">
			Select File: 
			<input type="file" name="file" />
			<input type="submit" value="Upload File" />
		</form>
		
		${msg}







	</div>
</body>
</html>