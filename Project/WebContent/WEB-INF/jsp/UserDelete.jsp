<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<link rel="stylesheet" href="css/common.css">
<title>UserDelete</title>
</head>
<body>

		<div class="bg-dark">
			<div class="row">
				<div class="col-sm-6 text-right">
					<p class="text-light">さん</p>
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
		<h1 class="text-center">ユーザー削除確認</h1>
		<br> <br> <br> <br>

		<div class="input-area">
		<p class="text-center">ログインID:</p>
		<p class="text-center">を本当に削除してよろしいでしょうか。</p>
		<br>
		<br>
		</div>
			<div class="form-group row">
		<div class="col-sm-4"></div>

			<div class="col-sm-2">
			<a class="btn btn-secondary btn-block"
			 href="file:///C:/Users/LIKEIT_STUDENT.DESKTOP-QQASV86.000/Documents/WebProgramming/Mock/userList.html"
			  role="button">キャンセル</a></div>


			<div class="col-sm-2">
			<button type="button" class="btn btn-primary btn-block">OK</button></div>

			<div class="col-sm-4"></div>
			</div>
		</div>

</body>
</html>