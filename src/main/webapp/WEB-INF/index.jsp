<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<h3>Welcome to the dashboard</h3>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Author Name</th>
				<th scope="col">Remove</th>
				<th scope="col">Edit</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ authors }" var="author">
				<tr>
					<td><c:out value="${ author.id }" /></td>
					<td><c:out value="${ author.name }" /></td>
					<td><form action="/remove_author/${author.id}" method="post">
							<input type="hidden" name="_method" value="delete"> <input
								class="btn btn-danger" type="submit" value="Delete Author">
						</form></td>
					<td><a class="btn btn-primary" href="/authors/${author.id}/edit" role="button">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<nav class="navbar navbar-light bg-light">
		<form action="/new" class="form-inline">
			<button class="btn btn-outline-success" type="submit">Create
				Author</button>
		</form>
	</nav>
</body>
</html>