<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/common.css">
<title>login page</title>
</head>
<body>
	<div class="container-fluid">
		<br>
		<br>
		<h1 class="text-center">ログイン画面</h1>
		<br>
		<br>
		<br>
		<br>
		<div class="input-area">

		<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>


			<form action="loginServlet" method="post">


				<div class="form-group row">
					<label for="inputPassword" class="col-sm-4 col-form-label">ログインID</label>
					<div class="col-sm-8">
						<input type="text" name="login_id" class="form-control">
					</div>
				</div>

				<div class="form-group row">
					<label for="inputPassword" class="col-sm-4 col-form-label">パスワード</label>
					<div class="col-sm-8">
						<input type="password" name="password" class="form-control">
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-3"></div>
					<div class="col-sm-2"></div>
					<div class="col-sm-3">
						<button type="submit" class="btn btn-secondary btn-block">ログイン</button>
					</div>
					<div class="col-sm-2"></div>
					<div class="col-sm-3"></div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>