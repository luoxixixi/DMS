<%@page import="com.DMS.ghb.entity.Students"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	List<Students> students = (List<Students>)request.getAttribute("allstudent");
%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>- 数据表格</title>
<meta name="keywords" content="">
<meta name="description" content="">

<link rel="shortcut icon" href="favicon.ico">
<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

<!-- Data Tables -->
<link href="css/plugins/dataTables/dataTables.bootstrap.css"
	rel="stylesheet">

<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>学生信息维护</h5>
						<button id="addstudent" type="button"
							class="btn btn-primary btn-xs"
							style="float: right; margin-right: 10px;">添加</button>
					</div>
					<div class="ibox-content">
						<table
							class="table table-striped table-bordered table-hover dataTables-example">
							<thead>
								<tr>
									<th>学号</th>
									<th>姓名</th>
									<th>学院</th>
									<th>专业</th>
									<th>班级</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="<%=students%>" var="s">
									<tr class="gradeX">
										<td>${s.stuNum }</td>
										<td>${s.name }</td>
										<td>${s.departments }</td>
										<td class="center">${s.major }</td>
										<td class="center">${s.classes }</td>
										<td class="center">
											<button type="button" class="btn btn-primary btn-sm"
												onclick="updataStu('${s.stuId}','${s.stuNum }','${s.name }','${s.departments }','${s.major }','${s.classes }')">修改</button>
											<button type="button" class="btn btn-primary btn-sm"
												onclick="deleteStu('${s.stuId}')">删除</button>
										</td>

									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 全局js -->
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>
	<script src="js/plugins/layer/layer.min.js"></script>

	<script src="js/plugins/jeditable/jquery.jeditable.js"></script>

	<!-- Data Tables -->
	<script src="js/plugins/dataTables/jquery.dataTables.js"></script>
	<script src="js/plugins/dataTables/dataTables.bootstrap.js"></script>

	<!-- 自定义js -->
	<script src="js/content.js?v=1.0.0"></script>

	<!-- Page-Level Scripts -->
	<script>
		$(document).ready(function() {
			$('.dataTables-example').dataTable();

			/* Init DataTables */
			var oTable = $('#editable').dataTable();

			/* Apply the jEditable handlers to the table */
			oTable.$('td').editable('../example_ajax.php', {
				"callback" : function(sValue, y) {
					var aPos = oTable.fnGetPosition(this);
					oTable.fnUpdate(sValue, aPos[0], aPos[1]);
				},
				"submitdata" : function(value, settings) {
					return {
						"row_id" : this.parentNode.getAttribute('id'),
						"column" : oTable.fnGetPosition(this)[2]
					};
				},

				"width" : "90%",
				"height" : "100%"
			});

		});

		function fnClickAddRow() {
			$('#editable').dataTable()
					.fnAddData(
							[ "Custom row", "New row", "New row", "New row",
									"New row" ]);

		}
		function updataStu(id, num, name, dept, major, cls) {
			layer.open({
				type : 2,
				title : '修改学生信息',
				shadeClose : true,
				shade : false,
				maxmin : true, //开启最大化最小化按钮
				area : [ '893px', '600px' ],
				content : 'upstudent.html',
				success : function(layero, index) {
					// 获取子页面的iframe
					var iframe = window['layui-layer-iframe' + index];
					// 向子页面的全局函数child传参
					iframe.initdata(id, num, name, dept, major, cls)
				}
			});
		}
		function deleteStu(id) {
			layer.confirm('是否删除？', {
				icon : 3,
				btn : [ '是', '否' ]
			//按钮
			}, function() {
				$.ajax({
					type : "post",
					url : "/dms/deleteStu",
					data : {
						stuId : id
					},
					success : function(data, textStatus) {
						layer.msg('已删除',
								{
									time : 1000,
									icon : 1,
									end : function(index, layero) {
										window.location.reload();
									}
								});
					}
				})
			});
		}
	</script>

</body>

</html>