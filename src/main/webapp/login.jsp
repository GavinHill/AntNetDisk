<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<!-- 声明文档兼容模式，表示使用IE浏览器的最新模式 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- 设置视口的宽度，页面初始缩放值 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<!-- content的取值为webkit,ie-comp,ie-stand之一，区分大小写，分别代表用webkit内核，IE兼容内核，IE标准内核。 -->
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta name="keywords" content="关键词：网盘">
<meta name="description" content="网站描述：小蚁云盘存储系统">
<link rel="icon" href="img/iocn/ant.ico">

<title>小蚁网盘</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.3.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

<script type="text/javascript">
	//JavaScript脚本标注
	function openreg() {
		window
				.open(
						"register.jsp",
						"newwindow",
						"height=400, width=400, toolbar= no, menubar = no, scrollbars = no, resizable = no, location = no, status = no ")
	}
</script>
<style type="text/css">
body {
	margin: 0px;
	background-color: #F9F2F3;
}
</style>
</head>

<body>
	<div class="col-sm-3 col-md-2 sidebar">
		<form class="form-login" method="post" action="LoginServlet">
			<h4 class="form-signin-heading">欢迎使用，请登录</h4>
			<br> <input type="text" id="inputAccount" name="inputAccount"
				class="form-control" placeholder="用户账号" required autofocus>
			<br> <input type="password" id="inputPassword"
				name="inputPassword" class="form-control" placeholder="密码" required>
			<br>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">请记住我
				</label>
			</div>
			<br>
			<button class="btn btn-primary" type="submit">登录</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="btn btn-primary" type="button" onclick="openreg()">注册</button>
		</form>
	</div>
</body>

</html>