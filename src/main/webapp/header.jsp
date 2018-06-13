<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
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

<title>小蚁网盘</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.3.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

<style>
body {
	
}
</style>
<script type="text/javascript">
	//打开我的网盘文件
	function openMyFile() {
		top.frames["myiframe"].location = "GetFileDataServlet?parentid=0";
	}
	
	//打开分享文件
	function openShareFile() {
		top.frames["myiframe"].location = "GetShareFileServlet?select=0";
	}
	
	//进行搜索时进入GetFileDataServlet将file.jsp刷新
	function getFileByName() {
		var fname = document.getElementById("mysearch").value;
		top.frames["myiframe"].location = "GetFileDataServlet?filename="
				+ fname;
	}
</script>
</head>

<body>
	<!-- 导航栏 -->
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">小蚁网盘</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#" onclick="openMyFile()">网盘文件</a></li>
					<li><a href="#" onclick="openShareFile()">好友分享</a></li>
				</ul>
				<form class="navbar-form navbar-right">
					<div class="form-group">
						<input id="mysearch" type="text" class="form-control"
							placeholder="输入想要查找的文件名称">
					</div>
					<button type="button" class="btn btn-default"
						onclick="getFileByName()">搜索</button>
				</form>
			</div>
		</div>
	</nav>

</body>

</html>