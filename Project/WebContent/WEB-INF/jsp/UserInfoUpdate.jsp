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
<title>UserInfoUpdate</title>
</head>
<body>

	<div class="bg-dark">
		<div class="row">
			<div class="col-sm-6 text-right">
				<p class="text-light">${userinfo.name}さん</p>
			</div>
			<div class="col-sm-6 text-right">
				<a href="LogoutServlet" class="text-danger mr-3">ログアウト</a>
			</div>
		</div>
	</div>


	<div class="container-fluid">
		<br> <br>
		<h1 class="text-center">ユーザー情報更新</h1>
		<br> <br> <br> <br>
		<div class="input-area">
		<c:if test="${errMsg != null}"><div class="alert alert-danger" role="alert">
		  ${errMsg}
		</div></c:if>

			<input type="hidden" name="login_id" value="${userinfo2.login_id}">

			<div class="form-group row">
				<p class="col-sm-4">ログインID</p>
				<div class="col-sm-8">${userinfo2.login_id}</div>
			</div>

			<div class="form-group row">
				<label for="inputPassword" class="col-sm-4 col-form-label">パスワード</label>
				<div class="col-sm-8">
					<input type="password" name="password" class="form-control">
				</div>
			</div>

			<div class="form-group row">
				<label for="inputPassword" class="col-sm-4 col-form-label">パスワード(確認)</label>
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
					<input type="text" name="birth_date" class="form-control">
				</div>
			</div>

			<div class="form-group row">
				<div class="col-sm-3"></div>
				<div class="col-sm-2"></div>
				<div class="col-sm-3">
					<button type="submit" class="btn btn-secondary btn-block">更新</button>
				</div>
				<div class="col-sm-2"></div>
				<div class="col-sm-3"></div>
			</div>
		</div>

	</div>

	<a href="#" onclick="history.back(); return false;"
		class="text-primary ml-5 ">戻る</a>
</body>
</html>