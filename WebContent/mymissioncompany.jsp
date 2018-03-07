<%@page import="com.DMS.ghb.entity.Company"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Company company = (Company) request.getAttribute("company");
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
						<h5>审批意见</h5>
						<div class="ibox-tools"></div>
					</div>
					<div class="ibox-content">
						<div class="form-horizontal">
							<div class="form-group">
								<p style="text-align: center; font-size: 16px;"><%=company.getMessage()%></p>
							</div>
						</div>
					</div>

				</div>

			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>我的实习单位</h5>
						<div class="ibox-tools"></div>
					</div>
					<div class="ibox-content">
						<div class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-2 control-label">单位名称</label>

								<div class="col-sm-8">
									<input id="cname" type="text" name="name" placeholder="请输入单位名称"
										class="form-control" value="<%=company.getName()%>">
								</div>

							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">单位地址</label>

								<div class="col-sm-8">
									<input id="caddress" type="text" name="name"
										placeholder="请输入单位地址" class="form-control" value="<%=company.getAddress()%>">
								</div>

							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">单位指导教师</label>

								<div class="col-sm-8">
									<input id="cteacher" type="text" name="name"
										placeholder="请输入教师姓名" class="form-control" value="<%=company.getcTeacher()%>">
								</div>

							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">单位电话</label>

								<div class="col-sm-8">
									<input id="cphone" type="text" name="name" placeholder="请输入电话"
										class="form-control" value="<%=company.getcPhonr()%>">
								</div>

							</div>
							<div class="form-group">
								<button class="btn btn-sm btn-primary pull-right m-t-n-xs"
									style="position: relative; top: -40px; left: -90px;"
									onclick="upCompany()">
									<strong>修改</strong>
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
		});
		function upCompany() {
			var id = "<%=company.getCompanyId()%>";
			var cname = $("#cname").val();
			var caddress = $("#caddress").val();
			var cteacher = $("#cteacher").val();
			var cphone = $("#cphone").val();
			$.ajax({
				type : "post",
				url : "/dms/changeCom",
				data : {
					cId : id,
					cname : cname,
					caddress : caddress,
					cteacher : cteacher,
					cphone : cphone
				},
				success : function(data, textStatus) {
					if (data == "success") {
						layer.msg('已修改', {
							time : 1000,
							icon : 1,
						});

					} else {
						layer.msg('服务器错误', {
							time : 1000,
							icon : 7,
						});
					}
				}

			});
		}
		function GetQueryString(name) {
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
			var r = window.location.search.substr(1).match(reg);
			if (r != null)
				return unescape(r[2]);
			return null;
		}
	</script>

</body>

</html>