// var $parentNode = window.parent.document;

// function $childNode(name) {
//     return window.frames[name]
// }

// // tooltips
// $('.tooltip-demo').tooltip({
//     selector: "[data-toggle=tooltip]",
//     container: "body"
// });

// // 使用animation.css修改Bootstrap Modal
// $('.modal').appendTo("body");

// $("[data-toggle=popover]").popover();

//判断当前页面是否在iframe中
if(top == this) {
	var gohome = '<div class="gohome"><a class="animated bounceInUp" href="index.html?v=4.0" title="返回首页"><i class="fa fa-home"></i></a></div>';
	$('body').append(gohome);
}

//animation.css
function animationHover(element, animation) {
	element = $(element);
	element.hover(
		function() {
			element.addClass('animated ' + animation);
		},
		function() {
			//动画完成之前移除class
			window.setTimeout(function() {
				element.removeClass('animated ' + animation);
			}, 2000);
		});
}

//拖动面板
function WinMove() {
	var element = "[class*=col]";
	var handle = ".ibox-title";
	var connect = "[class*=col]";
	$(element).sortable({
			handle: handle,
			connectWith: connect,
			tolerance: 'pointer',
			forcePlaceholderSize: true,
			opacity: 0.8,
		})
		.disableSelection();
};

$("#addmission").click(function() {
	layer.open({
		type: 2,
		title: '添加任务',
		shadeClose: true,
		shade: false,
		maxmin: true, //开启最大化最小化按钮
		area: ['893px', '400px'],
		content: 'addmission.html'
	});
});
$("#addann").click(function() {
	layer.open({
		type: 2,
		title: '添加任务',
		shadeClose: true,
		shade: false,
		maxmin: true, //开启最大化最小化按钮
		area: ['893px', '600px'],
		content: 'announcementList.html'
	});
});

$("#addstudent").click(function() {
	layer.open({
		type: 2,
		title: '修改学生',
		shadeClose: true,
		shade: false,
		maxmin: true, //开启最大化最小化按钮
		area: ['893px', '600px'],
		content: 'addstudent.html'
	});
});
$("#addteacher").click(function() {
	layer.open({
		type: 2,
		title: '添加教师',
		shadeClose: true,
		shade: false,
		maxmin: true, //开启最大化最小化按钮
		area: ['893px', '600px'],
		content: 'addteacher.html'
	});
});
$("#openPDF").click(function() {
	layer.open({
		type: 2,
		title: '预览',
		shadeClose: true,
		shade: false,
		maxmin: true, //开启最大化最小化按钮
		area: ['893px', '600px'],
		content: '文件上传示例.pdf'
	});
});
$("#hisbutton").click(function() {
	window.location.href="historyFile";
	//layer.load();
});
$("#buhege").click(function(){
	layer.open({
  title: '不合格原因'
  ,content: "<input/>"
});     
  
})
