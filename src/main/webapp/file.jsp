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
<meta name="description" content="网站描述：蚂蚁云盘存储系统">

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

</head>

<body>
	<!-- 按钮触发模态框 -->
	<button class="btn btn-primary btn-lg" data-toggle="modal"
		data-target="#myModal">文件上传</button>
	
	<!-- 按钮触发刷新页面 -->
		<form action="GetFileDataServlet" method="post"
		enctype="multipart/form-data">
		<button type="submit" class="btn btn-primary">文件刷新</button>
	</form>

	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">文件上传</h4>
				</div>
				<form action="UploadServlet" method="post"
					enctype="multipart/form-data">
					<div class="modal-body">
						<!-- 模态框内容 -->

						<img src="img/fileupload.jpg" height="71px" width="71px">
						<!-- 文件上传按钮 -->
						<input id="upfile" type="file" name="file"> <br>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary">文件上传</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<table class="table">
		<caption>网盘文件</caption>
		<thead>
			<tr>
				<th width="50px">多选</th>
				<th>名称</th>
				<th>类型</th>
				<th>上传时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach items="${requestScope.filelist}" var="li">
				<tr>
					<td><input type="checkbox" name="" id="" value="" /></td>
					<td><a
						href="${pageContext.request.contextPath }/DownloadServlet?fileuuid=${li.getFileuuid()}&filepath=${li.getFilepath()}">${li.getFilename()}</a></td>
					<td>${li.getFiletype()}</td>
					<td>${li.getUploaddate()}</td>
					<td><a href="">删除</a>&nbsp;&nbsp;<a href="">分享</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<nav aria-label="Page navigation">
		<ul class="pagination">
			<li><a href="#" aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span>
			</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>
</body>
</html>