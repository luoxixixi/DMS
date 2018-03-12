<%@page import="com.DMS.ghb.entity.Company"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	List<Company> companies =(List<Company>) request.getAttribute("companies");
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
						<h5>任务</h5>
						<button type="button" class="btn btn-primary btn-xs"
							style="float: right; margin-right: 10px;" onclick="ex('${mId }')">导出</button>

					</div>
					<div class="ibox-content">
						<table
							class="table table-striped table-bordered table-hover dataTables-example">
							<thead>
								<tr>
									<th>学号</th>
									<th>学生姓名</th>
									<th>实习单位</th>
									<th>单位地址</th>
									<th>指导教师</th>
									<th>单位电话</th>
									<th>审批</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="<%=companies%>" var="c">
									<tr class="gradeX">
										<td>${c.stuId.stuNum }</td>
										<td>${c.stuId.name }</td>
										<td>${c.name }</td>
										<td>${c.address }</td>
										<td>${c.cTeacher }</td>
										<td>${c.cPhonr }</td>
										<td><button type="button" class="btn btn-primary btn-sm" onclick="hege('${c.companyId}')">合格</button>
											<button type="button" class="btn btn-primary btn-sm"
												onclick="buhege('${c.companyId}')">不合格</button></td>
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
			if (type == "3") {
				$('table tr').find('th:eq(6)').remove();
				$('table tr').find('td:eq(6)').remove();
			}
		}
		function ex(mId) {
			layer.load();
			var url = "/dms/exceptCom?mId="+mId;
			var xhr = new XMLHttpRequest();
			xhr.open('GET', url, true); // 也可以使用POST方式，根据接口
			xhr.responseType = "blob"; // 返回类型blob
			// 定义请求完成的处理函数，请求前也可以增加加载框/禁用下载按钮逻辑
			xhr.onload = function() {
				// 请求完成
				$("#bg,.loading").hide();
				if (this.status === 200) {
					// 返回200
					var blob = this.response;
					var reader = new FileReader();
					// alert(reader);
					reader.readAsDataURL(blob); // 转换为base64，可以直接放入a表情href
					reader.onload = function(e) {
						// 转换完成，创建一个a标签用于下载
						var a = document.createElement('a');
						a.download =getData()+'-学生实习单位.xls';
						a.href = e.target.result;
						$("body").append(a); // 修复firefox中无法触发click
						a.click();
						$(a).remove();
					}
				}
				 layer.closeAll('loading');
			};
			// 发送ajax请求
			xhr.send()
		}
		
		function hege(id) {
			$.ajax({
				type : "post",
				url : "/dms/changeCMessage",
				data : {
					cId : id,
					message : "合格" 
				},
				success : function(data, textStatus) {
					if (data == "success") {
						layer.msg('已审核', {
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
		function buhege(id) {
			layer.prompt({
				title : '请输入不合格原因',
				formType : 2
			}, function(text, index) {
				$.ajax({
					type : "post",
					url : "/dms/changeCMessage",
					data : {
						cId : id,
						message : "不合格，原因："+text 
					},
					success : function(data, textStatus) {
						if (data == "success") {
							layer.msg('已审核', {
								time : 1000,
								icon : 1,
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
		function p(s) {
		    return s < 10 ? '0' + s: s;
		}
		function getData(){
			var myDate = new Date();
			//获取当前年
			var year=myDate.getFullYear();
			//获取当前月
			var month=myDate.getMonth()+1;
			//获取当前日
			var date=myDate.getDate(); 
			var h=myDate.getHours();       //获取当前小时数(0-23)
			var m=myDate.getMinutes();     //获取当前分钟数(0-59)
			var s=myDate.getSeconds();  
			var now=year+p(month)+p(date)+p(h)+p(m)+p(s);
		}
	</script>

</body>

</html>