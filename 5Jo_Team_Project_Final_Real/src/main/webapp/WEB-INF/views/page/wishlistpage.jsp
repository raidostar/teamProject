<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
#body_back {
	background: antiquewhite;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/wishlistpage.css" />
<script src="resources/jquery-3.3.1.min.js"></script>
<script>
	$(function() {
		initWishList();
	});

	function initWishList() {

		$.ajax({
			method : 'POST',
			url : 'showlist',
			success : output
		});
	}

	function output(list) {
		var wishlist = '';

		for (var i = 0; i < list.length; i++) {

			var imglink = list[i].imglink;
			var title = list[i].title;
			var boardNum = list[i].boardNum;

			wishlist += '<div class="recipe__board__table1">';
			wishlist += '<div id="wish__List1">';
			wishlist += '<img class="img__size1" src="' + imglink + '"/><br>';
			wishlist += '</div>';
			wishlist += '<div id="wish__List2">';
			wishlist += '<input type ="button" class = "title" value ="'
					+ title + '" data-boardNum ="' + boardNum
					+ '" onclick="javascript:openChild(' + boardNum + ')"/>';
			wishlist += '<input type ="button" id="wishDelete" class =" wishDelete " value="削除" data-boardNum ="' + boardNum+'"/>';
			wishlist += '</div>'
			wishlist += '</div>';
		}
		$('#list').html(wishlist);
		$('.wishDelete').click(deleteWish);
	}

	function openChild(boardNum) {

		var link = "letsgit?boardNum=" + boardNum;

		windowObj = window.open(link, "child",
				"width=1100, height=500, resizable = no");

	}
	function returnBack() {
		location.href = "./";
		$('#page2').get(0).click();
	}

	function deleteWish() {
		var deletecheck = confirm("削除しますか。");
		var boardNum = $(this).attr('data-boardNum');
		if (deletecheck == true) {
			$.ajax({
				method : 'post',
				url : 'deleteWishList',
				data : 'boardNum=' + boardNum,
				success : function(result) {
					if (result != null) {
						alert('お気に入りから削除されました。');
						initWishList();
					} else {
						alert('もう一度やり直してください。')
					}
				}
			});
		} else {
			alert('キャンセルされました。')
		}
	}
</script>

<title>WishList</title>
</head>
<body id="body_back">
	<h1>${sessionScope.loginId}様 ,WishList</h1>
	<input type="button" class="quit" value="戻る" onclick="returnBack()" />

	<div id="list"></div>

</body>
</html>