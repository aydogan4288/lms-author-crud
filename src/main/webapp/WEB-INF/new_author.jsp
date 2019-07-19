<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<form action="/create_author" method="post" modelAttribute="author">
		<div class="form-group">
			<label for="exampleInputEmail1">Author Name</label> <input
				type="text" name="name" class="form-control" placeholder="Enter Author Name">
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</body>
</html>