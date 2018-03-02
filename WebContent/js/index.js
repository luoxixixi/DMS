$(function() {
	// 菜单点击
	J_iframe
	$(".J_menuItem").on('click', function() {
		var url = $(this).attr('href');
		$("#J_iframe").attr('src', url);
		return false;
	});
});

$("#exit").click(function() {
	layer.confirm('是否退出？', {
		icon : 3,
		btn : [ '是', '否' ]
	// 按钮
	}, function() {

	});
});
