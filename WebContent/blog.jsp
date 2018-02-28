<%@page import="com.DMS.ghb.entity.Announcement"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
 List<Announcement> announcements= (List<Announcement>)request.getAttribute("annList");	
%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>- 文章列表</title>
<meta name="keywords" content="">
<meta name="description" content="">

<link rel="shortcut icon" href="favicon.ico">
<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content  animated fadeInRight blog">
<c:forEach items="<%=announcements%>" var="a">
		<div class="row">
			<div class="col-lg-4">
				<div class="ibox">
					<div class="ibox-content">
						<a href="showAnn?annId=${a.annId }" class="btn-link">
							<h2>${a.head }</h2>
						</a>
						<div class="small m-b-xs">
							<strong>${a.teaId.name }</strong> <span class="text-muted"><i
								class="fa fa-clock-o"></i>${a.time }</span>
						</div>
						<p>
							<a href="deleteAnn?annId=${a.annId }">删除</a>
						</p>
					</div>
				</div>

			</div>
		</div>
</c:forEach>
	</div>

	<!-- 全局js -->
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>
	<script src="js/plugins/layer/layer.min.js"></script>

	<!-- 自定义js -->
	<script src="js/content.js?v=1.0.0"></script>





</body>

</html>
