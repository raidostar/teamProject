<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/letsgit.css" />
<script src="resources/jquery-3.3.1.min.js"></script>
<script>
	$(function() {
		initRecipeZzim();
	});

	function initRecipeZzim() {
		var boardnum = "${boardNum}";

		$.ajax({
			method : 'get',
			url : 'searchRecipe',
			data : {
				"boardNum" : boardnum
			},
			success : recipeDetail
		});
	}
	function recipeDetail(board) {
		var recipeDetail = '';
		var boardNum = board.boardNum;
		var imglink2 = board.imglink;
		var title2 = board.title;
		var category2 = board.category;
		var material2 = board.material;
		var amount2 = board.amount;
		var recipe2 = board.recipe;
		var tips2 = board.tips;
		
		
		recipeDetail += '<div class="recipe__board__table1">';
		recipeDetail += '<div id="Product__board1">';
		recipeDetail += '<img class="img__size1" src="' + imglink2 + '"/>';
		recipeDetail += '</div>';
		recipeDetail += '<div id="Product__board2">';
		recipeDetail += 'タイトル <div class = "title" value ="' + title2 + '">'
				+ title2 + '</div><br>';
		recipeDetail += '<div class = "category" value ="' + category2 + '">'
				+ category2 + '</div><br>';
		recipeDetail += '材料 <div class = "material" value ="' + material2 + '">'
				+ material2 + '</div><br>';
		recipeDetail += '数量 <div class = "amount" value ="' + amount2 + '">'
				+ amount2 + '</div><br>';
		recipeDetail += 'レシピ <br><div class = "recipe" value ="' + recipe2 + '">'
				+ recipe2 + '</div><br>';
		recipeDetail += 'チップ <div class = "tips" value ="' + tips2 + '">'
				+ tips2 + '</div><br>';
		recipeDetail += '</div>';
		recipeDetail += '</div>';

		$('#recipeZzimDetail').html(recipeDetail);

		
	}
</script>

<title>Insert title here</title>
</head>
<body id="body_back">
	<div id="recipeZzimDetail"></div>


</body>
</html>