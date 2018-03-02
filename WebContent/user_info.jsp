<%@page import="com.DMS.ghb.entity.Students"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Students students = (Students)request.getSession().getAttribute("user");
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
						<div class="form-horizontal">
							<input id="stuid" hidden value="<%=students.getStuId()%>">
							<div class="form-group">
								<label class="col-sm-2 control-label">姓名</label>

								<div class="col-sm-8">
									<input type="text" id="stuname" name="stuname"
										placeholder="请输入姓名" class="form-control" value="<%=students.getName()%>">
								</div>

							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">请输入学号</label>

								<div class="col-sm-8">
									<input type="text" id="stunum" name="stunum"
										placeholder="请输入学号" class="form-control" value="<%=students.getStuNum()%>">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">请输入学院</label>

								<div class="col-sm-8">
									<input type="text" id="studept" name="studept"
										placeholder="请输入学院" class="form-control" value="<%=students.getDepartments()%>">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">请输入专业</label>

								<div class="col-sm-8">
									<input type="text" id="stumajor" name="stumajor"
										placeholder="请输入专业" class="form-control" value="<%=students.getMajor()%>"> 
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">请输入班级</label>

								<div class="col-sm-8">
									<input type="text" id="stucls" name="stucls"
										placeholder="请输入班级" class="form-control" value="<%=students.getClasses()%>">
								</div>
							</div>
							<div class="form-group">
								<button class="btn btn-sm btn-primary pull-right m-t-n-xs"
									style="position: relative; left: -48%;" onclick="upStudent()">
									<strong>保存</strong>
								</button>
							</div>
						</div>
						<center>
							<p class="col-sm-12">学生登录默认密码为学号</p>
						</center>
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
		});

		function upStudent() {
			var stuId = $("#stuid").val();
			var stuname = $("#stuname").val();
			var stunum = $("#stunum").val();

			var reg = /^[0-9]*$/;
			var b = reg.test(stunum)
			if (!b) {
				layer.msg('学号请填入数字', {
					time : 1000,
					icon : 7,
					anim : 6
				});
				return;
			}
			var studept = $("#studept").val();
			var stumajor = $("#stumajor").val();
			var stucls = $("#stucls").val();
			$.ajax({
				type : "post",
				url : "/dms/changeStuInfo",
				data : {
					stuId : stuId,
					stuname : stuname,
					stunum : stunum,
					studept : studept,
					stumajor : stumajor,
					stucls : stucls
				},
				success : function(data, textStatus) {
					layer.msg('修改成功',
							{
								time : 1000,
								icon : 1,
								end : function(index, layero) {
									var index = parent.layer
											.getFrameIndex(window.name); //先得到当前iframe层的索引
									window.parent.location.reload();
									parent.layer.close(index); //再执行关闭   
								}
							});
				}
			})
		}
	</script>

</body>

</html>