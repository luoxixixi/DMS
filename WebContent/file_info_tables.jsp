<%@page import="com.DMS.ghb.entity.Documents"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	List<Documents> documents =(List<Documents>)request.getAttribute("documents");
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
	<input id="usertype" type="text" value="${suser.type }" hidden="">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>文件列表</h5>
					</div>
					<div class="ibox-content">
						<table
							class="table table-striped table-bordered table-hover dataTables-example">
							<thead>
								<tr>
									<th>文件名</th>
									<th>上传时间</th>
									<th>上传者</th>
									<th>审批状态</th>
									<th>审批</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="<%=documents%>" var="d">
									<tr class="gradeX">
										<td>${d.fileName }</td>
										<td>${d.upTime }</td>
										<td>${d.fileType }</td>
										<td>${d.message }</td>
										<td class="center">
											<button type="button" class="btn btn-primary btn-sm"
												onclick="hege('${d.docId}')">合格</button>
											<button type="button" class="btn btn-primary btn-sm"
												onclick="buhege('${d.docId}')">不合格</button>
										</td>
										<td class="center">
											<button type="button" class="btn btn-primary btn-sm"
												onclick="downFile('${d.docId}')">下载</button>
											<button type="button" class="btn btn-primary btn-sm"
												onclick="showFile('${d.docId}')">查看</button>
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
	<script src="js/layer/layer.js"></script>

	<script src="js/plugins/jeditable/jquery.jeditable.js"></script>

	<!-- Data Tables -->
	<script src="js/plugins/dataTables/jquery.dataTables.js"></script>
	<script src="js/plugins/dataTables/dataTables.bootstrap.js"></script>

	<!-- 自定义js -->
	<script src="js/content.js?v=1.0.0"></script>


	<!-- Page-Level Scripts -->
	<script>
		$(document).ready(function() {
			init();
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

		function init() {
			var type = $("#usertype").val();
			if (type == "1") {
				$('table tr').find('th:eq(4)').remove();
				$('table tr').find('td:eq(4)').remove();
			}
		}
		function showFile(fileId) {
			layer.load();
			$.ajax({
				type : "post",
				url : "/dms/showFile",
				data : {
					docId : fileId
				},
				success : function(data, textStatus) {
					if (data == "error") {
						layer.msg('暂不支持该格式请下载后查看', {
							time : 2000,
							icon : 7,
						});
					} else if (data == "e") {
						layer.msg('服务器错误', {
							time : 2000,
							icon : 7,
						});
					} else {
						layer.open({
							type : 2,
							title : '预览',
							shadeClose : true,
							shade : false,
							maxmin : true, //开启最大化最小化按钮
							area : [ '880px', '550px' ],
							content : data,
							cancel : function() {
								$.ajax({
									type : "post",
									url : "/dms/deletePDF",
									data : {
										req : data
									}
								});
							}
						});
					}
					layer.closeAll("loading");
				},
			})
		}
		function downFile(fileId) {
			window.location.href = "downLoadFile?fileId=" + fileId;
		}
		function deleteFile(fileId, fileName) {
			layer.confirm('是否删除？', {
				icon : 3,
				btn : [ '是', '否' ]
			//按钮
			}, function() {
				$.ajax({
					type : "post",
					url : "/dms/deleteFile",
					data : {
						fileName : fileName,
						fileId : fileId
					},
					success : function(data, textStatus) {
						layer.msg('已删除', {
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
		function hege(fileId) {
			$.ajax({
				type : "post",
				url : "/dms/checkFile",
				data : {
					docId : fileId,
					message : "合格"
				},
				success : function(data, textStatus) {
					if (data == "success") {
						layer.msg('已审核', {
							time : 1000,
							icon : 1,
							end : function() {
								window.location.reload();
							}
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
		function buhege(fileId) {
			layer.prompt({
				title : '请输入不合格原因',
				formType : 2
			}, function(text, index) {
				$.ajax({
					type : "post",
					url : "/dms/checkFile",
					data : {
						docId : fileId,
						message : "不合格，原因：" + text
					},
					success : function(data, textStatus) {
						if (data == "success") {
							layer.msg('已审核', {
								time : 1000,
								icon : 1,
								end : function() {
									window.location.reload();
								}
							});
							layer.close(index);
						} else {
							layer.msg('服务器错误', {
								time : 1000,
								icon : 7,
							});
						}
					}
				});
			});
		}
	</script>




</body>

</html>
