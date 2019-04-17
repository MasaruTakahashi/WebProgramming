<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/common.css">
<title>UserReference</title>
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
		<br>
		<br>
		<h1 class="text-center">ユーザー情報参照</h1>
		<br>
		<br>
		<br>
		<br>
		<div class="input-area">
		<div class="row">
		<label for="inputPassword" class="col-sm-4 col-form-label">ログインID</label>
		<div class="col-sm-8">${userinfo2.login_id}</div>
		</div>

		<div class="row">
		<label for="inputPassword" class="col-sm-4 col-form-label">ユーザー名</label>
		<div class="col-sm-8">${userinfo2.name}</div>
		</div>
		<div class="row">
		<label for="inputPassword" class="col-sm-4 col-form-label">生年月日</label>
		<div class="col-sm-8">${userinfo2.birth_date}</div>
		</div>
		<div class="row">
		<label for="inputPassword" class="col-sm-4 col-form-label">登録日時</label>
		<div class="col-sm-8">${userinfo2.create_date}</div>
		</div>
		<div class="row">
		<label for="inputPassword" class="col-sm-4 col-form-label">更新日時</label>
		<div class="col-sm-8">${userinfo2.update_date}</div>
		</div>
		</div>

	</div>
	<br>
	<br>
	<br>
	<a href="#" onclick="history.back(); return false;" class="text-primary ml-5 ">戻る</a>
</body>
</html>