<%@page import="com.DMS.ghb.entity.Teachers"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%
	List<Teachers> teachers = (List<Teachers>)request.getAttribute("allteacher");
	
	%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>- 教师信息</title>
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
						<h5>教师信息维护</h5>
						<button id="addteacher" type="button"
							class="btn btn-primary btn-xs"
							style="float: right; margin-right: 10px;">添加 </button>
					</div>
					<div class="ibox-content">
						<table
							class="table table-striped table-bordered table-hover dataTables-example">
							<thead>
								<tr>
									<th>姓名</th>
									<th>联系电话</th>
									<th>学院</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="<%=teachers%>" var="t">
								<tr>
									<td>${t.name }</td>
									<td>${t.phone}</td>
									<td>${t.major }</td>
									<td><button type="button" class="btn btn-primary btn-sm" onclick="upteacher('${t.teaId }', '${t.name }', '${t.phone}')">修改</button>
										<button type="button" class="btn btn-primary btn-sm" onclick="deleteTeaher('${t.teaId }')">删除</button>
									</td>
								</tr>
								</c:forEach>
							</tbody>
							<tfoot>

							</tfoot>
						</table>

					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- å¨å±js -->
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>
	<script src="js/plugins/layer/layer.min.js"></script>



	<script src="js/plugins/jeditable/jquery.jeditable.js"></script>

	<!-- Data Tables -->
	<script src="js/plugins/dataTables/jquery.dataTables.js"></script>
	<script src="js/plugins/dataTables/dataTables.bootstrap.js"></script>

	<!-- èªå®ä¹js -->
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
		function upteacher(id,name,phone){
			layer.open({
				type : 2,
				title : '修改教师信息',
				shadeClose : true,
				shade : false,
				maxmin : true, //开启最大化最小化按钮
				area : [ '893px', '600px' ],
				content : 'upteacher.html',
				success : function(layero, index) {
					// 获取子页面的iframe
					var iframe = window['layui-layer-iframe' + index];
					// 向子页面的全局函数child传参
					iframe.initdata(id, name, phone);
				}
			});
			
		}
		function deleteTeaher(id){
			layer.confirm('是否删除？', {
				icon : 3,
				btn : [ '是', '否' ]
			//按钮
			}, function() {
				$.ajax({
					type : "post",
					url : "/dms/deleteTea",
					data : {
						teaId : id
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
