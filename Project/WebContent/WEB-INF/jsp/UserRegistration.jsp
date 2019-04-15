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
<title>UserRegistration</title>
</head>
<body>

	<div class="bg-dark">
		<div class="row">
			<div class="col-sm-6 text-right">
				<p class="text-light">${userinfo.name}さん</p>
			</div>
			<div class="col-sm-6 text-right">
				<a
					href="LogoutServlet"
					class="text-danger mr-3">ログアウト</a>
			</div>
		</div>
	</div>



	<div class="container-fluid">
		<br> <br>
		<h1 class="text-center">ユーザー新規登録</h1>
		<br> <br> <br> <br>

		<div class="input-area">

		<c:if test="${errMsg != null}" >
	    <div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div>
	</c:if>

	<form action="UserRegistrationServlet" method="post">

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
				<label for="inputPassword"  class="col-sm-4 col-form-label">パスワード(確認)</label>
				<div class="col-sm-8">
					<input type="password" name="passwordRe" class="form-control">
				</div>
			</div>


			<div class="form-group row">
				<label for="inputPassword" class="col-sm-4 col-form-label">ユーザー名</label>
				<div class="col-sm-8">
					<input type="text" name="name" class="form-control">
				</div>
			</div>


		<div class="form-group row">
			<label for="inputPassword" class="col-sm-4 col-form-label">生年月日</label>
			<div class="col-sm-8">
				<input type="date" name="birth_date" class="form-control">
			</div>
		</div>

		<div class="form-group row">
		<div class="col-sm-3"></div>
		<div class="col-sm-2"></div>
			<div class="col-sm-3">
			<button type="submit" class="btn btn-secondary btn-block">登録</button></div>
			<div class="col-sm-2"></div>
			<div class="col-sm-3"></div>
			</div>
			</form>
		</div>

		</div>




		<a href="#" onclick="history.back(); return false;"
			class="text-primary ml-5 ">戻る</a>


</body>
</html>