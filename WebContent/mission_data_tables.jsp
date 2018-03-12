<%@page import="com.DMS.ghb.entity.Users"%>
<%@page import="com.DMS.ghb.entity.Mission"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	List<Mission> missions=(List<Mission>)request.getAttribute("missions");
  Users users = (Users)session.getAttribute("suser");
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
	<input type="text" id="userType" value="<%=users.getType()%>" hidden="">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>任务</h5>
						<button id="addmission" type="button"
							class="btn btn-primary btn-xs"
							style="float: right; margin-right: 10px;">添加</button>

					</div>
					<div class="ibox-content">
						<table
							class="table table-striped table-bordered table-hover dataTables-example">
							<thead>
								<tr>
									<th>调查名称</th>
									<th>发布者</th>
									<th>结束时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="<%=missions%>" var="m">
									<tr class="gradeX">
										<td>${m.missionName }</td>
										<td>${m.teachers.name }</td>
										<td>${m.missionEndTime }</td>
										<td>
											<button name="button0" type="button"
												class="btn btn-primary btn-sm"
												onclick="answer('${m.missionType}','${m.id}','${m.missionContent }')">作答</button>
											<button name="button1" type="button"
												class="btn btn-primary btn-sm"
												onclick="showMission('${m.missionType}','${m.id}','${m.missionContent }')">查看</button>
											<input type="text" hidden="" value="${m.missionStatus==0 }">
											<c:if test="${m.missionStatus==0 }">
												<button name="button2" type="button"
													class="btn btn-primary btn-sm"
													onclick="endMission(${'m.id'})">结束</button>
											</c:if>
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
			var userType = $("#userType").val();
			if (userType == "1") {
				$("#addmission").remove();
				var b = $("button[name=button2]");
				b.each(function(index, element) {
					element.remove();
				});
			} else if (userType == "2") {
				$("#addmission").remove();
				var b = $("button[name=button2]");
				b.each(function(index, element) {
					element.remove();
				});
				var b = $("button[name=button0]");
				b.each(function(index, element) {
					element.remove();
				});
			}
			else {
				var b = $("button[name=button0]");
				b.each(function(index, element) {
					element.remove();
				});
			}

		}
		function answer(type,id,mes) {
			layer.open({
				  title: '任务说明',
				  content: mes,
				  yes: function(index, layero){
					  if(type=="1"){
							window.location.href="mymissionpaper.html?misId="+id;
						}else if (type=="2") {
							window.location.href="mymissioncompany.html?misId="+id;
						}
					  }
				});
			
		}
		function showMission(type,id,mes) {
			var userType = $("#userType").val();
			if(userType == "1"){
				layer.open({
					  title: '任务说明',
					  content: mes,
					  yes: function(index, layero){
						  if(type=="1"){
								window.location.href="getPaperById";
							}else if (type=="2") {
								window.location.href="getCompanyById";
							}
							
						  }
						});  
			}else {
				layer.open({
					  title: '任务说明'
					  ,content: mes,
					  yes: function(index, layero){
						  if(type=="1"){
								window.location.href="getAllpaper?mId="+id;
							}else if (type=="2") {
								window.location.href="getCompanyByMisson?mId="+id;
							}
						  }
						});  
			}
			

			}
		function endMission(id) {
			$.ajax({
				type : "post",
				url : "/dms/",
				data : {
					misId:id
				},
				success : function(data, textStatus) {
					layer.msg('已结束', {
						time : 1000,
						icon : 1,
					});
				}
			})
		}
	</script>

</body>

</html>