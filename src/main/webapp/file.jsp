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
	<form action="GetFileDataServlet?parentid=0" method="post">
		<!-- 按钮触发文件上传模态框 -->
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#uploadModal">文件上传</button>

		<!-- 按钮触发刷新页面 -->
		<button type="submit" class="btn btn-primary">文件刷新</button>

		<!-- 按钮触发新建文件夹页面 -->
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#newFolderModal" style="float:right">新建文件夹</button>
	</form>
	<!-- 分隔线 -->
	<hr color=#4B4B4B>

	<!-- 上传文件模态框（Modal） -->
	<div class="modal fade" id="uploadModal" tabindex="-1" role="dialog"
		aria-labelledby="uploadModalLabel" aria-hidden="true">
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

	<!-- 新建文件夹模态框（Modal） -->
	<div class="modal fade" id="newFolderModal" tabindex="-1" role="dialog"
		aria-labelledby="newFolderModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">新建文件夹</h4>
				</div>
				<form action="FileManageServlet?managedorder=newfolder" method="post">
					<div class="modal-body">
					
						<!-- 模态框内容 -->
						<div class="form-group">
							<label for="name">新建文件夹名称</label> 
							<input type="text"
								class="form-control" id="foldername" name="foldername" placeholder="请输入名称">
						</div>
						<br>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<button type="submit" class="btn btn-primary">新建文件夹</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- 网盘文件 -->
	<h3>网盘文件</h3>
	<table class="table">
		<caption></caption>
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
					<td>
					    <a
						href="${pageContext.request.contextPath }/DownloadServlet?fileid=${li.getFileid()}&filetype=${li.getFiletype()}&fileuuid=${li.getFileuuid()}&filepath=${li.getFilepath()}"
					    >${li.getFilename()}</a></td>
					<td>${li.getFiletype()}</td>
					<td>${li.getUploaddate()}</td>
					<td>
					    <a href="${pageContext.request.contextPath}/FileManageServlet?managedorder=delete&delid=${li.getFileid()}">删除</a>
						&nbsp;&nbsp;
						&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath}/FileManageServlet?managedorder=share&fileid=${li.getFileid()}">分享</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<nav aria-label="Page navigation" >
		<ul class="pagination" style="margin-left: 265px">
			<li><a href="#" aria-label="Previous"> <span
					aria-hidden="true">&laquo;</span>
			</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">6</a></li>
			<li><a href="#">7</a></li>
			<li><a href="#">8</a></li>
			<li><a href="#">9</a></li>
			<li><a href="#">10</a></li>
			<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>
</body>
</html>