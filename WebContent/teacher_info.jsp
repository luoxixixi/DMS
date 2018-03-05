<%@page import="com.DMS.ghb.entity.Teachers"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Teachers teachers = (Teachers)request.getSession().getAttribute("user");
%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>- 基本表单</title>
<meta name="keywords" content="">
<meta name="description" content="">

<link rel="shortcut icon" href="favicon.ico">
<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>修改信息</h5>
						<div class="ibox-tools"></div>
					</div>
					<div class="ibox-content">
						<div  class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-2 control-label">姓名</label>

								<div class="col-sm-8">
								<input id="tId" value="<%=teachers.getTeaId()%>" hidden="">
									<input id="tName" type="text" name="name" placeholder="请输入姓名"
										class="form-control" value="<%=teachers.getName()%>">
								</div>

							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">简介</label>

								<div class="col-sm-8">
									<textarea id="tContent" placeholder="请输入个人简介 如 擅长的方向"  class="form-control">
									<%=teachers.getTeaInfo()%>
										</textarea>
								</div>

							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">专业</label>

								<div class="col-sm-8">
									<input type="text" id="tMajor" value="<%=teachers.getMajor()%>" placeholder="请输入所在专业名称" class="form-control">
								</div>

							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">手机号码</label>

								<div class="col-sm-8">
									<input type="text" id="tPhone" value="<%=teachers.getPhone()%>" placeholder="请输入电话" class="form-control"
										disabled="disabled">
								</div>
								<button  class="btn btn-sm btn-primary pull-left m-t-n-xs">修改手机号码</button>

							</div>
							<div class="form-group">

								<button class="btn btn-sm btn-primary pull-right m-t-n-xs"
									style="position: relative; left: -49%;">
									<strong>提交</strong>
								</button>
							</div>

						</div>
					</div>

				</div>

			</div>
		</div>
	</div>

	<!-- 全局js -->
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>
	<script src="js/plugins/layer/layer.min.js"></script>

	<!-- 自定义js -->
	<script src="js/content.js?v=1.0.0"></script>

	<!-- iCheck -->
	<script src="js/plugins/iCheck/icheck.min.js"></script>
	<script>
		$(document).ready(function() {
			$('.i-checks').iCheck({
				checkboxClass : 'icheckbox_square-green',
				radioClass : 'iradio_square-green',
			});
			var tContent=$("#tContent").val();
			var tMajor=$("#tMajor").val();
			if(tContent=="null"||tMajor=="null"){
				$("#tContent").val("");
				$("#tMajor").val("");
			}
		});
		
		function upteacher() {
			var id = $("#tId").val()
			var name = $("#tName").val();
			if (name == "") {
				layer.msg('请输入姓名', {
					time : 1000,
					icon : 7,
					anim : 6
				});
				return;
			}
			var phone = $("#tPhone").val();
			var reg = /^1[0-9]{10}$/;
			var b = reg.test(phone);
			if (!b) {
				layer.msg('请正确填入手机号码', {
					time : 1000,
					icon : 7,
					anim : 6
				});
				return;
			}
			var tContent=$("#tContent").val();
			var tMajor=$("#tMajor").val();
			$.ajax({
				type : "post",
				url : "/dms/changeTeaInfo",
				data : {
					teacherId : id,
					teacherName : name,
					teacherPhone : phone,
					tMajor : tContent,
					tInfo : tMajor
				},
				success : function(data, textStatus) {
					if (data == 'success') {
						layer.msg('修改成功', {
							time : 1000,
							icon : 1,
							end : function(index, layero) {
								window.parent.reload();
							}
						});
					} else if (data == '1') {
						layer.msg('该手机号已注册', {
							time : 1000,
							icon : 7,
							anim : 6
						});
					} else {
						layer.msg('服务器错误', {
							time : 1000,
							icon : 7,
							anim : 6
						});
					}
				}
			})
		}
	</script>

</body>

</html>