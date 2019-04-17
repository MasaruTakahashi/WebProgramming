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
<title>UserList</title>
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
		<h1 class="text-center">ユーザー一覧</h1>
		<br> <br>
		<div class="text-right">
			<a href="UserRegistrationServlet" class="text-primary">新規登録</a>
		</div>

		<div class="input-area">


			<div class="form-group row">
				<label for="inputPassword" class="col-sm-4 col-form-label">ログインID</label>
				<div class="col-sm-8">
					<input type="text" class="form-control">
				</div>
			</div>

			<div class="form-group row">
				<label for="inputPassword" class="col-sm-4 col-form-label">ユーザー名</label>
				<div class="col-sm-8">
					<input type="text" class="form-control">
				</div>
			</div>

			<div class="form-group row">
				<label for="inputPassword" class="col-sm-4 col-form-label">生年月日</label>
				<div class="col-sm-3">
					<input type="date" class="form-control">
				</div>
				<p class="col-sm-2 text-center">～</p>
				<div class="col-sm-3">
					<input type="date" class="form-control">
				</div>
			</div>

		</div>

		<div class="form-group row">
			<div class="col-sm-8"></div>

			<div class="col-sm-2">
				<button type="submit" class="btn btn-secondary btn-block">検索</button>
			</div>

			<div class="col-sm-2"></div>
		</div>

	</div>
	<br>

	<div class="container-fluid">

		<hr>
		<table class="table table-bordered">
			<thead class="thead-light">
				<tr>
					<th scope="col">ログインID</th>
					<th scope="col">ユーザー名</th>
					<th scope="col">生年月日</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${userList}">
					<tr>
						<th scope="row">${user.login_id}</th>
						<td>${user.name}</td>
						<td>${user.birth_date}</td>
						<td><a class="btn btn-primary"
							href="UserReferenceServlet?id=${user.id}"
							role="button">詳細</a> <a class="btn btn-success"
							href="UserInfoUpdateServlet?id=${user.id}"
							role="button">更新</a> <a class="btn btn-danger"
							href="file:///C:/Users/LIKEIT_STUDENT.DESKTOP-QQASV86.000/Documents/WebProgramming/Mock/userDelete.html"
							role="button">削除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>