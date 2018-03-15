<%@page import="com.DMS.ghb.entity.Announcement"%>
<%@page import="com.DMS.ghb.entity.Mission"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	List<Mission> missions=(List<Mission>)request.getAttribute("missions");
List<Announcement> announcements= (List<Announcement>)request.getAttribute("annList");
%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>- 任务清单</title>
<meta name="keywords" content="">
<meta name="description" content="">

<link rel="shortcut icon" href="favicon.ico">
<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content  animated fadeInRight">
		<div class="row">
			<div class="col-sm-6">
				<div class="ibox">
					<div class="ibox-content">
						<h3>任务列表</h3>
					</div>
					<ul class="sortable-list connectList agile-list ui-sortable">
						<c:forEach items="<%=missions%>" var="m">
							<li class="danger-element" style=""><b>${m.missionName }</b>
								<p>${m.missionContent }</p>
								<div class="agile-detail">
									<i class="fa fa-clock-o"></i> ${m.missionTime }
								</div></li>
						</c:forEach>
					</ul>
				</div>
			</div>

			<div class="col-sm-6">
				<div class="ibox">
					<div class="ibox-content">
						<h3>公告</h3>
					</div>
					<ul class="sortable-list connectList agile-list ui-sortable">
						<c:forEach items="<%=announcements%>" var="a">
							<li class="danger-element" style=""><b>${a.head }</b>
								<div class="agile-detail">
									<i class="fa fa-clock-o"></i> ${a.time }/${a.teaId.name }
								</div></li>
						</c:forEach>
					</ul>
				</div>
			</div>

		</div>

	</div>

	<!-- 全局js -->
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>
	<script src="js/jquery-ui-1.10.4.min.js"></script>
	<script src="js/plugins/layer/layer.min.js"></script>

	<!-- 自定义js -->
	<script src="js/content.js?v=1.0.0"></script>

	<script>
		$(document).ready(function() {
			$(".sortable-list").sortable({
				connectWith : ".connectList"
			}).disableSelection();

		});
	</script>

</body>

</html>