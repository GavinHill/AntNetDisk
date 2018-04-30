<%@page import="java.util.List"%>
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
	margin: 0px;
	background-color: #F9F2F3;
}
</style>
<script type="text/javascript">
	//该用户界面加载时将blank.jsp刷新为file.jsp
	window.onload = function() {
		top.frames["blank"].location = "GetFileDataServlet";
	}
</script>
</head>

<body>

	<%
	%>
	<div class="col-sm-10 col-md-10">
		<h3>欢迎使用，${username}</h3>

		<div class="dropdown">
			<button type="button" class="btn dropdown-toggle" id="accountSetMenu"
				data-toggle="dropdown">
				账户设置 <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" role="menu"
				aria-labelledby="accountSetMenu">
				<li role="presentation"><a role="menuitem" tabindex="-1"
					href="#">修改名称</a></li>
				<li role="presentation"><a role="menuitem" tabindex="-1"
					href="#">修改密码</a></li>
			</ul>
		</div>
	</div>
</body>
</html>