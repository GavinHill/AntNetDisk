<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

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
<meta name="description" content="网站描述：蚂蚁云盘存储系统">
<link rel="icon" href="img/iocn/ant.ico">

<title>蚂蚁网盘</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.3.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

<style type="text/css">
body {
	background-color: #D0E9FF;
	margin: 0px;
}
</style>

<script>
//判断是否注册成功
function isRegisterSuccess() {
	var str="${isRegisterSuccess}";//el表达式
	if(str=="fail") {
	    alert("账号已注册！");
	}
}
</script>
</head>

<body onload="isRegisterSuccess()">
    <% String isRegisterSuccess =(String)request.getAttribute("isRegisterSuccess"); %> 
	<div class="col-sm-3 col-md-2 sidebar">
		<form class="form-register" method="post" action="RegisterServlet">
			<h2 class="form-register-heading">欢迎注册</h2>
			<input type="text" id="inputAccount" name="inputAccount" class="form-control"placeholder="用户账号" required autofocus>
			<br>
			<input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="用户密码" required>
			<br>
			<input type="text"id="inputName" name="inputName" class="form-control" placeholder="用户姓名" required>
			<br>
			<input type="tel" id="inputTel" name="inputTel" class="form-control" placeholder="用户手机" required> <br>
			<button class="btn btn-primary" type="submit">确认</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button class="btn btn-primary" type="button">取消</button>
		</form>
	</div>
</body>

</html>