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
	background-image: linear-gradient(to top, #fff1eb 0%, #ace0f9 100%);
	margin: 0px;
}
</style>
</head>

<body>

	<!-- 页面头部 -->
	<div class="container">
		<header>
			<iframe src="header.jsp" width="100%" height="50px" scrolling="no"
				frameborder="0"></iframe>
		</header>
	</div>

	<!-- 主要内容 -->
	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<!-- 用户登录及注册 -->
				<iframe src="login.jsp" width="190" height="600" scrolling="no"
					frameborder="0"></iframe>
			</div>
			<div class="col-md-6">
				<!-- 文件显示 -->
				<iframe src="blank.jsp" name="blank" width="945px" height="600px"
					scrolling="yes" frameborder="0"></iframe>
			</div>
		</div>
	</div>

	<!-- 页面底部 -->
	<div class="container">
		<footer>
			<iframe src="footer.jsp" width="100%" height="50px" scrolling="no"
				frameborder="0"></iframe>
		</footer>
	</div>

</body>

</html>