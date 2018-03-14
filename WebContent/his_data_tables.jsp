<%@page import="java.util.List"%>
<%@page import="com.DMS.ghb.entity.Documents"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	List<Documents> hisDoc =(List<Documents>) request.getAttribute("hisDoc");
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
						<h5>任务</h5>
						<button type="button"
							class="btn btn-primary btn-xs"
							style="float: right; margin-right: 10px;" onclick="his()">归档</button>
					</div>
					<div class="ibox-content">
						<table
							class="table table-striped table-bordered table-hover dataTables-example">
							<thead>
								<tr>
									<th>名称</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="<%=hisDoc%>" var="h">
									<tr>
										<td>${h.fileName }</td>
										<td><button type="button" class="btn btn-primary btn-sm"
										onclick="downLoad('${h.docId}')">下载</button>
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

	<script src="js/plugins/jeditable/jquery.jeditable.js"></script>

	<!-- Data Tables -->
	<script src="js/plugins/dataTables/jquery.dataTables.js"></script>
	<script src="js/plugins/dataTables/dataTables.bootstrap.js"></script>
	<script src="js/plugins/layer/layer.min.js"></script>

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
		function his() {
			var index=layer.load();
			$.ajax({
				type : "post",
				url : "/dms/historyFile",
				data : {},
				success : function(data, textStatus) {
					if (data == "success") {
						layer.msg('完成', {
							time : 1000,
							icon : 1,
							end :function(){
								layer.close(index);
								window.location.href="getHis"
							}
						});
					} else {
						layer.msg('服务器错误', {
							time : 1000,
							icon : 7,
						});
						layer.close(index);
					}
				}
			});
		}
		function downLoad(fileId) {
			window.location.href = "downLoadFile?fileId="+fileId;
		}
	</script>

</body>

</html>