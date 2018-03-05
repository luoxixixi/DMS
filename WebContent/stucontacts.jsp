<%@page import="com.DMS.ghb.entity.Students"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	List<Students> students = (List<Students>)request.getAttribute("students");
%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>- 联系人</title>
<meta name="keywords" content="">
<meta name="description" content="">

<link rel="shortcut icon" href="favicon.ico">
<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">

	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<c:forEach items="<%=students%>" var="s">
				<div class="col-sm-4">
					<div class="contact-box">
							<div class="col-sm-8">
								<h3 >
									<strong >${s.name }</strong>
								</h3>
								<p>
									<i class="fa fa-map-marker"></i> ${s.departments } ${s.major } ${s.classes }
								</p>
								<address>
									<strong>${s.stuNum }</strong><br> <abbr title="学号">学号:</abbr>
									${s.stuNum }
								</address>
							</div>
							<div class="clearfix">
								<button type="button"
									class="btn btn-primary btn-xs"
									style="float: right; margin-right: 10px;" onclick="ask('${s.stuId }','${s.name }')">拒绝</button>
							</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<!-- 全局js -->
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>
	<script src="js/plugins/layer/layer.min.js"></script>



	<!-- 自定义js -->
	<script src="js/content.js?v=1.0.0"></script>



	<script>
		$(document).ready(function() {
			$('.contact-box').each(function() {
				animationHover(this, 'pulse');
			});
		});
		
		function ask(id,name){
			var msg ="是否拒绝"+name;
			layer.confirm(msg, {
				icon : 3,
				btn : [ '是', '否' ]
			//按钮
			}, function() {
				$.ajax({
					type : "post",
					url : "/dms/choiceStu",
					data : {
						stuId : id
					},
					success : function(data, textStatus) {
						if (data == 'success') {
							layer.msg('操作成功', {
								time : 1000,
								icon : 1,
								end : function(index, layero) {
									window.location.href="getStu";
								}
							});
						} else {
							layer.msg('服务器错误！', {
								time : 1000,
								icon : 7,
							});
						}
					}
				})
			});
		}
	</script>




</body>

</html>
