<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.List" import="me.coding.gavinhill.domain.Cloudfile"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<style type="text/css">
body {
	margin: 0px;
	background-color: #F9F2F3;
}

#nav {
	width: 100%;
	height: 50px;
	position: fixed;
	bottom: 0;
}
</style>

</head>
<body>
	<div class="dropdown">
		<button type="button" class="btn dropdown-toggle" id="selectSFile"
			data-toggle="dropdown">
			选择显示的分享文件种类<span class="caret"></span>
		</button>
		<ul class="dropdown-menu" role="menu" aria-labelledby="selectSFile">
			<li role="presentation"><a role="menuitem" tabindex="-1"
				href="GetShareFileServlet?select=0">我的分享</a></li>
			<li role="presentation"><a role="menuitem" tabindex="-1"
				href="GetShareFileServlet?select=1">分享给我</a></li>
		</ul>
	</div>

	<!-- 用户文件 -->
	<h3>网盘文件</h3>
	<table class="table">
		<caption></caption>
		<thead>
			<tr>
				<th width="50px">多选</th>
				<th>名称</th>
				<th>类型</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.filelist}" var="li">
				<tr>
					<td><input type="checkbox" name="" id="" value="" /></td>
					<td><a
						href="${pageContext.request.contextPath }/DownloadServlet?fileid=${li.getFileid()}&filetype=${li.getFiletype()}&fileuuid=${li.getFileuuid()}&filepath=${li.getFilepath()}">${li.getFilename()}</a></td>
					<td>${li.getFiletype()}</td>
					<td><a
						href="${pageContext.request.contextPath}/FileManageServlet?managedorder=delete&delid=${li.getFileid()}">删除</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>