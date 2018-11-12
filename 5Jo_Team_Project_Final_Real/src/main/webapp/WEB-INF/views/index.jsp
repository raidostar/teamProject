<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="ko" class="no-js">
<style>
#mask {
	position: absolute;
	left: 0;
	top: 0;
	z-index: 100;
	background-color: #000;
	display: none;
}

#loadingImg {
	position: absolute;
	left: 45%;
	top: 50%;
	background: #fffff0;
	z-index: 120;
}
</style>

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>요리(料理)보고 조리(調理)보고</title>
<meta name="description"
	content="A multi grid layout with an initial fullscreen intro" />
<meta name="keywords"
	content="fullscreen image, grid layout, flexbox grid, transition" />
<meta name="author" content="Codrops" />
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link rel="stylesheet" type="text/css" href="css/layout-multi.css" />
<link rel="stylesheet" type="text/css" href="css/test.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/buttons.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<script src="resources/jquery-3.3.1.min.js"></script>
<script src="js/modernizr.custom.js"></script>
<style>
/* ---------- FONTAWESOME ---------- */
/* ---------- https://fortawesome.github.com/Font-Awesome/ ---------- */
/* ---------- http://weloveiconfonts.com/ ---------- */
@import url(http://weloveiconfonts.com/api/?family=fontawesome);

/* ---------- ERIC MEYER'S RESET CSS ---------- */
/* ---------- https://meyerweb.com/eric/tools/css/reset/ ---------- */
@import url(https://meyerweb.com/eric/tools/css/reset/reset.css);

/* ---------- FONTAWESOME ---------- */
[class*="fontawesome-"]:before {
	font-family: 'FontAwesome', sans-serif;
}

/* ---------- GENERAL ---------- */
input {
	background-image: none;
	border: none;
	margin: 0;
	padding: 0;
	transition: all .3s;
}

/* ---------- ALIGN ---------- */
.align {
	align-items: center;
	display: flex;
	flex-direction: column;
	justify-content: center;
}

/* ---------- GRID ---------- */
.grid {
	margin-left: auto;
	margin-right: auto;
	max-width: 90%;
	width: 800px;
}

/* ---------- LOGIN ---------- */
#login h2 {
	margin-top: 15%;
	background: #f95252;
	border-radius: 20px 20px 0 0;
	color: #fff;
	font-size: 28px;
	padding: 5px 26px;
}

#login h2 span[class*="fontawesome-"] {
	margin-right: 14px;
}

#login fieldset {
	background: wheat;
	text-align: -webkit-center;
	padding: 0px 60px;
}

#login fieldset p {
	color: #777;
	text-align: left;
}

#login fieldset p:last-child {
	margin-bottom: 0;
}

#login fieldset input {
    height: 40px;
	}

#login fieldset input[type="text"], #login fieldset input[type="password"]
	{
	background: #eee;
	color: #777;
	padding: 4px 10px;
	width: 100%;
}

#login fieldset input[type="radio"] {
	width: 10%;
}

.gender__radio {
	background: #eee;
	color: #777;
	padding: 4px 10px;
}
.gender{
	height: 20px;
}

#login h3 {
	height: 62px;
	background: #f95252;
	border-radius: 0 0 20px 20px;
	color: #fff;
	font-size: 28px;
	padding: 5px 26px;
	background: #f95252;
}
</Style>
</head>
<body>
	<nav class="thumb-nav">
		<a data-container="container-1" id="page1" class="thumb-nav__item"
			href="#"> <img src="img/thumbs/1.png" alt="thumbs1" /><span>1</span>
		</a> <a data-container="container-2" id="page2" class="thumb-nav__item"
			href="#"> <img src="img/thumbs/2.png" alt="thumbs2" /><span>2</span>
		</a> <a data-container="container-3" class="thumb-nav__item" href="#">
			<img src="img/thumbs/3.png" alt="thumbs3" /><span>3</span>
		</a> <a data-container="container-4" class="thumb-nav__item" href="#">
			<img src="img/thumbs/4.png" alt="thumbs4" /><span>4</span>
		</a> <a data-container="container-6" class="thumb-nav__item" href="#">
			<img src="img/thumbs/8.png" alt="thumbs6" /><span>5</span>
		</a>
	</nav>

	<!-- page/page1.jsp 1page 불러오기 -->
	<div id="container-1" class="container theme-1">
		<header class="intro">
			<img class="intro__image" src="img/1.jpg" alt="Lava" />
			<div class="intro__content">
				<div id="movie__table" style="text-align: center;">
					<section id="wrapper">
						<div class="videoContainer">

							<video id="myVideo" class="video1" controls preload="auto"
								width="600">
								<source src="bestmovie?best=1" type="video/mp4" />
								<p>video tag를 지원하지 않는 브라우저입니다..</p>
							</video>
							<div class="caption">「今週の優秀者の動画」</div>
							<div class="control">
								<div class="btmControl">
									<div class="btnPlay btn" title="Play/Pause video"></div>
									<div class="progress-bar">
										<div class="progress">
											<span class="bufferBar"></span> <span class="timeBar"></span>
										</div>
									</div>
									<!--<div class="volume" title="Set volume">
               <span class="volumeBar"></span>
            </div>-->
									<div class="sound sound2 btn" title="Mute/Unmute sound">
										<span class="icon-sound"></span>
									</div>
									<div class="btnFS btn" title="Switch to full screen">
										<span class="icon-fullscreen"></span>
									</div>
								</div>

							</div>
						</div>
					</section>
					<button id="trigger"
						class="trigger btn_change button button--sacnite button--round-l hidden__btn"
						style="width: 1px; height: 1px;"></button>
					================== 금주의 Movie ==================
				</div>
				<h1 class="intro__title">Main</h1>


				<!-- Login-Join 합쳐서 아랫단에다가 뿌리기 -->
				<div class="intro__subtitle">
					<div class="intro__description">
						<div class="btn_change">

							<button id="home_btn"
								class="btn_change home__btn button button--sacnite button--round-l">ホーム</button>

							<c:if test="${empty sessionScope.loginId}">
								<button id="login__btn"
									class="btn_change button button--sacnite button--round-l">ログイン</button>
								<button id="join__btn"
									class="btn_change button button--sacnite button--round-l">会員登録</button>
							</c:if>
							<c:if test="${not empty sessionScope.loginId}">
								<button id="logout__btn"
									class="btn_change button button--sacnite button--round-l">ログアウト</button>
								
							</c:if>

						</div>
					</div>
				</div>
			</div>
		</header>

		<!-- result에 Join과 Login HTML로 뿌려서 폼 받아오기  -->
		<section class="related">
			<div class="opcity">d</div>
		</section>
	</div>

	<!-- page/page2.jsp 2page 불러오기 -->
	<div id="container-2" class="container theme-1">
		<header class="intro">
			<img class="intro__image" src="img/2.jpg" alt="Road" />
			<div class="intro__content">
				<div class="intro__content1">
					<div class="recipe__board">
						<div>
							<div id="searchproducts"></div>
							<table id="productResult">
							</table>
						</div>
					</div>
					<div id="pageProductsBtn"></div>

				</div>
				<h1 class="intro__title">RecipeBoard</h1>
				<div class="intro__subtitle">
					<div class="intro__description">
						<div class="demos">
							<span> : </span>
							<!--id에 home btn 주기  -->
							<button id="recipeHome_btn"
								class="btn_change home__btn button button--sacnite button--round-l">ホーム</button>
							<button id="recipe__btn"
								class="trigger btn_change button button--sacnite button--round-l">レシピ</button>
								<c:if test="${not empty sessionScope.loginId}">
								<button id="map__btn" class="btn_change button button--sacnite button--round-l">マップ</button>
								</c:if>
						</div>
					</div>
				</div>
			</div>
		</header>
		<section class="related10">
			<div id="recipeDetail"></div>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<div id=recipeDetailBtn></div>
			<div class="opcity">d</div>
		</section>

		<!-- 		<section class="related">
			<div id="list__recipe">
				<div id="left__frame">asd</div>
				<div id="right__frame">dsa</div>
			</div>
		</section> -->
	</div>

	<!-- page/page3.jsp 불러오기 -->
	<div id="container-3" class="container  theme-1">
		<header class="intro">
			<img class="intro__image" src="img/3.jpg" alt="Glacier" />
			<div class="intro__content">
				<div id="movie__board">

					<!-- code here -->
					<div id="searchdiv"></div>
					<div id="board__list">
						<table class="board">
							<tr>
								<th class="mainTitle">タイトル</th>
								<th>作成者</th>
								<th>閲覧数</th>
								<th>作成日</th>
							</tr>
						</table>
					</div>
					<div id="result"></div>
				</div>
				<div id="board__manu">
					<a href="MovieboardWrite" class="cp_textlink06">書き込む</a>
				</div>
				<div id="pageBtn"></div>

				<h1 class="intro__title">Movie<h1>
				<div class="intro__subtitle">
					<div class="intro__description">
						<div class="demos">
							<span></span>
							<button
								class="btn_change home__btn button button--sacnite button--round-l">ホーム</button>
							<button id="movie__btn"
								class="trigger btn_change button button--sacnite button--round-l">動画掲示板</button>
						</div>
					</div>
				</div>
			</div>
		</header>
		<!-- 영상 Detail 단 -->

		<div id="loadingImg">
			<!-- 로딩바 -->
			<img src="resources/loading.gif" />
		</div>
		<div id="mask">
			<!-- 배경 -->
		</div>
		<section class="related">
			<div class="board__table" align="center">
				<h1>Movie Board</h1>
				<div id="result2"></div>
				<div id="result3"></div>
			</div>
			<div class="opcity">dd</div>
		</section>
	</div>

	<!-- page/page4.jsp 4page 불러오기 -->
	<%@ include file="/WEB-INF/views/page/page4.jsp"%>



	<!-- page/page5.jsp 5page 불러오기 -->
	<%-- <%@ include file="/WEB-INF/views/page/page5.jsp"%> --%>

	<!-- 6page(StreamBoard) -->

	<div id="container-6" class="container  theme-1">
		<header class="intro">
			<img class="intro__image" src="img/8.jpg" alt="Glacier" />
			<div class="intro__content">

				<!-- code here -->

				<h1 class="intro__title">Streaming</h1>
				<div class="intro__subtitle">
					<div class="intro__description">
						<div class="demos">
							<span></span>
							<button
								class="btn_change home__btn button button--sacnite button--round-l">ホーム</button>
							<button id="streaming"
								class="btn_change button button--sacnite button--round-l">ストリーミング</button>
								<button class="trigger" style="width: 0.1px; height: 0.1px; opacity: 0; margin-left: 100em;"></button>
						</div>
					</div>
				</div>
			</div>
		</header>
		<!-- 실시간 스트리밍 Detail 단 (어떻게 할지는 조금 더 고민......)-->
		<section class="related">
			<div class="opcity">d</div>
		</section>
	</div>

</body>
<script src="js/classie.js"></script>
<script src="js/main.js"></script>
<script>
	$(function() {
		init();
	});

	$(document).ready(function() {

		$('#loadingImg').hide(); //첫 시작시 로딩바를 숨겨준다.
		$('#mask').hide();

	}).ajaxStart(function() {

		$('#loadingImg').show(); //ajax실행시 로딩바를 보여준다.
		$('#mask').show();
	}).ajaxStop(function() {

		$('#loadingImg').hide(); //ajax종료시 로딩바를 숨겨준다.
		$('#mask').hide();
	});

	function init() {

		$.ajax({
			method : 'GET',
			url : 'movieBoard',
			success : output
		});
	}

	function output(List) {

		var vedio = '';
		var vedio1 = '';
		var search1 = '';
		var currentPage = parseInt(List.currentPage);
		var pagePerGroup = parseInt(List.navi.pagePerGroup);
		var currentPageGrNext = currentPage + pagePerGroup;
		var currentPageGrBack = currentPage - pagePerGroup;
		var startPageGroup = parseInt(List.navi.startPageGroup);
		var endPageGroup = parseInt(List.navi.endPageGroup);
		var currentPage = parseInt(List.navi.currentPage);
		var number = '';

		search1 += '<div id="search__table">'
		search1 += '<select name="searchItem" id="searchItem" class="search__table">'
		search1 += '<option value="userId">作成者</option>'
		search1 += '<option value="title">タイトル</option>'
		search1 += '<option value="content">メッセージ</option>'
		search1 += '</select>'
		search1 += '<input type="text" name="searchWord" value="'+ List.searchWord+ '" id="searchWord" class="search__table" />'
		search1 += '<input type="button" value="検索" id="search" class="search search__table" />'
		search1 += '</div>'

		for (var i = 0; i < List.list.length; i++) {
			var userId = List.list[i].userId;
			var title = List.list[i].title;
			var content = List.list[i].content;
			var boardNum = List.list[i].boardNum;
			var regdate = List.list[i].regdate;
			var hitCount = List.list[i].hitCount;

			vedio += '<div id="board__table">'
			vedio += '<input class="detail trigger heading" type="button" data-Num="'+ boardNum + '" value ="' + title + '"/>'
			vedio += '<input readonly class = "userId" value ="' + userId + '"/>'
			vedio += '<input readonly class = "hitCount" value ="' + hitCount + '"/>'
			vedio += '<input readonly class = "regdate" value ="' + regdate + '"/>'
			vedio += '</div>'
		}

		for (var page = startPageGroup; page <= endPageGroup; page++) {
			if (page == currentPage) {
				number += '<input type="button" class="currentPageNum btn__page" data-currentPage="'+ page+ '" data-searchItem="'+ List.searchItem+ '" data-searchWord="'+ List.searchWord+ '" style="color:red" value="' + page + '">'
			}
			if (page != currentPage) {
				number += '<input type="button" class="justPageNum btn__page" data-currentPage="'+ page+ '" data-searchItem="'+ List.searchItem+ '" data-searchWord="'+ List.searchWord+ '" value="'+ page + '">'
			}
		}

		vedio1 += '<div class="boardfooter">'
		vedio1 += '<input type="button" value="◁◁" class="GrNext btn__page" data-currentPage="'+ currentPageGrBack+ '" data-searchItem="'+ List.searchItem+ '" data-searchWord="' + List.searchWord + '"></a>'
		vedio1 += '<input type="button" value="◀" class="back btn__page" data-currentPage="'+ currentPage+ '" data-searchItem="'+ List.searchItem+ '" data-searchWord="' + List.searchWord + '"></a>'
		vedio1 += number
		vedio1 += '<input type="button" value="▶" class="next btn__page" data-currentPage="'+ currentPage+ '" data-searchItem="'+ List.searchItem+ '" data-searchWord="' + List.searchWord + '"></a>'
		vedio1 += '<input type="button" value="▷▷" class="GrBack btn__page" data-currentPage="'+ currentPageGrNext+ '" data-searchItem="'+ List.searchItem+ '" data-searchWord="' + List.searchWord + '"></a>'
		vedio1 += '</div>'

		$('#searchdiv').html(search1);
		$('#pagenumber').html(number);
		$('#result').html(vedio);
		$('#pageBtn').html(vedio1);
		$('input:button.detail').click(Moviedetail);
		$('input:button.next').click(next);
		$('input:button.back').click(back);
		$('input:button.GrNext').click(GrNext);
		$('input:button.GrBack').click(GrBack);
		$('input:button.search').click(search);
		$('input:button.currentPageNum').click(pageChange);
		$('input:button.justPageNum').click(pageChange);

	}//function output

	function next() {
		var currentPage = $(this).attr('data-currentPage');
		var searchItem = $(this).attr('data-searchItem');
		var searchWord = $(this).attr('data-searchWord');
		var currentPagePlus = parseInt(currentPage) + 1;

		$.ajax({
			method : 'get',
			url : 'movieBoard',
			data : {
				"currentPage" : currentPagePlus,
				"searchItem" : searchItem,
				"searchWord" : searchWord
			},
			success : output
		});
	}//function next

	function back() {
		var currentPage = $(this).attr('data-currentPage');
		var searchItem = $(this).attr('data-searchItem');
		var searchWord = $(this).attr('data-searchWord');
		var currentPageminus = parseInt(currentPage) - 1;

		$.ajax({
			method : 'get',
			url : 'movieBoard',
			data : {
				"currentPage" : currentPageminus,
				"searchItem" : searchItem,
				"searchWord" : searchWord
			},
			success : output
		});
	}

	function GrNext() {
		var currentPage = $(this).attr('data-currentPage');
		var searchItem = $(this).attr('data-searchItem');
		var searchWord = $(this).attr('data-searchWord');

		var currentPage = parseInt(currentPage);

		$.ajax({
			method : 'get',
			url : 'movieBoard',
			data : {
				"currentPage" : currentPage,
				"searchItem" : searchItem,
				"searchWord" : searchWord
			},
			success : output
		});
	}

	function GrBack() {
		var currentPage = $(this).attr('data-currentPage');
		var searchItem = $(this).attr('data-searchItem');
		var searchWord = $(this).attr('data-searchWord');

		var currentPage = parseInt(currentPage);

		$.ajax({
			method : 'get',
			url : 'movieBoard',
			data : {
				"currentPage" : currentPage,
				"searchItem" : searchItem,
				"searchWord" : searchWord
			},
			success : output
		});
	}

	function search() {
		var searchWord = $('#searchWord').val();
		var searchItem = $('#searchItem').val();

		$.ajax({
			method : 'get',
			url : 'movieBoard',
			data : {
				"searchItem" : searchItem,
				"searchWord" : searchWord
			},
			success : output
		});

	}

	function pageChange() {
		var page = $(this).attr('data-currentPage');
		var searchItem = $(this).attr('data-searchItem');
		var searchWord = $(this).attr('data-searchWord');

		$.ajax({
			method : 'get',
			url : 'movieBoard',
			data : {
				"currentPage" : page,
				"searchItem" : searchItem,
				"searchWord" : searchWord
			},
			success : output
		});
	}

	function Moviedetail() {
		var boardNum = $(this).attr('data-Num');

		$.ajax({
			method : 'post',
			url : 'movieDtailOne',
			data : 'boardNum=' + boardNum,
			success : movieDetail
		});
	}

	function movieDetail(board) {
		$('#movie__btn').click();

		var movieDetail = '';
		var movieUpdate = '';
		var movieDelete = '';

		var userId = board.userId;
		var title = board.title;
		var content = board.content;
		var boardNum = board.boardNum;
		var regdate = board.regdate;
		var like = board.like;

		movieDetail += '<div>'
		movieDetail += '<span class = "userId">' + userId + '</span><p>'
		movieDetail += '<span class = "title">' + title + '</span><p>'
		movieDetail += '<video id="boardMovie" class="video1" controls src="download?boardNum='
				+ boardNum
				+ '">'
				+ "Your user agent does not support the HTML5 Video element."
				+ '</video></p>'
		movielike(board);
		movieDetail += '<span class = "content">' + content + '</span>'
		movieDetail += '</div></hr>'
		movieDetail += '<a class="cp_textlink06" href="MovieboardUpdate?boardNum='
				+ boardNum + '">修正</a>'
		movieDetail += '<input type="button" class="moviedelete" data-boardNum="'+boardNum+'" value="削除" />'

		$('#result2').html(movieDetail);
		$('#update').html(movieUpdate);
		$('#delete').html(movieDelete);
		$('input:button.moviedelete').click(moviedeletecheck);

	}

	function movielike(board) {
		var movielike = '';

		if (board.like == true) {
			movielike += '<input type="button" value ="♡" class="like" data-boardnum = "'+board.boardNum+'"/>'
					+ board.point
		} else {
			movielike += '<input type="button" value ="♥" class="like" data-boardnum = "'+board.boardNum+'"/>'
					+ board.point
		}
		$('#result3').html(movielike);
		$('input:button.like').on('click', addlike);
	}

	function addlike() {
		var boardNum = $(this).attr('data-boardNum');
		$.ajax({
			method : 'post',
			url : 'addlike',
			data : 'boardNum=' + boardNum,
			success : movielike
		});
	}

	function moviedeletecheck() {
		var deletecheck = confirm("削除しますか。");
		var boardNum = $(this).attr('data-boardNum');
		if (deletecheck == true) {
			$.ajax({
				method : 'post',
				url : 'MovieboardDelete',
				data : 'boardNum=' + boardNum,
				success : function(result) {
					if (result == 1) {
						alert('削除されました。');
						init();
						$("#movie__btn").click();
					} else {
						alert('もう一度やり直してください。')
					}
				}
			});
		} else {
			alert('キャンセルしました。')
		}
	}

	$(function() {
		productInit();
	});

	function productInit() {
		$.ajax({
			method : 'GET',
			url : 'receiptBoard',
			success : recipeInformation
		});
	}
	function recipeInformation(List) {
		var search2 = '';
		var currentPage2 = parseInt(List.currentPage);
		var currentPage3 = parseInt(List.navi.currentPage);
		var pagePerGroup2 = parseInt(List.navi.pagePerGroup);
		var currentPageGrNext2 = currentPage3 + pagePerGroup2;
		var currentPageGrBack2 = currentPage3 - pagePerGroup2;
		var startPageGroup2 = parseInt(List.navi.startPageGroup);
		var endPageGroup2 = parseInt(List.navi.endPageGroup);
		var number2 = '';
		var productsBts = '';
		var dataProductsdetail = '';

		/* select 문 */
		dataProducts = '<tr>'
		dataProducts += '<th>番号</th>'
		dataProducts += '<th>タイトル</th>'
		dataProducts += '<th>カテゴリー</th>'
		dataProducts += '</tr>'

		/* 검색 란 */
		search2 += '<div class="d5">'
		search2 += '<select name="productItem" id="productItem">'
		search2 += '<option value="material">材料</option>'
		search2 += '<option value="title">タイトル</option>'
		search2 += '<option value="category">カテゴリー</option>'
		search2 += '</select>'
		search2 += '<input type="text" name="productWord" value="'+List.searchWord+'" id="productWord" />'
		search2 += '<button value="検索" id="searchProduct" class="searchProduct btn_change" />'
		search2 += '</div>'

		/* 상단 게시판 , 아랫단 게시판 반복문*/
		for (var i = 0; i < List.list.length; i++) {

			var boardNum = List.list[i].boardNum;
			var category = List.list[i].category;
			var title = List.list[i].title;
			var material = List.list[i].material;
			var amount = List.list[i].amount;
			var recipe = List.list[i].recipe;
			var imglink = List.list[i].imglink;
			var tips = List.list[i].tips;
			/*--------------------재료,수량,레시피정보 공백기준으로 split 작업---------------------- */
			var imfor4='';
			var reallyRecipe4='';
			var material = material.split(" ");
			
			var amount = amount.split(" ");
			
			var recipe = recipe.split(" ");
			
			for(var j=0;j<material.length-1;j++){
				imfor4+= '<'+material[j]+" : "+amount[j]+'> ';
			}
			
			for(var k=0;k<recipe.length-1;k++){
				reallyRecipe4+=(k+1)+'。 '+recipe[k]+'<br>';
			}
			/*------------------------------------------------------------------------- */

			if (currentPage3 != 1) {
				var boardNumFact = currentPage3 * 10 - 10 + (i * 1 + 1);
			} else {
				var boardNumFact = (i * 1 + 1);
			}

			/*아랫단 전체 레시피 불러오기  */
			dataProductsdetail += '<div class="recipe__board__table">';
			dataProductsdetail += '<div id="Product__board1">';
			dataProductsdetail += '<img class="img__size" src="' + imglink + '"/><br>';
			dataProductsdetail += '</div>';
			dataProductsdetail += '<div id="Product__board2">';
			dataProductsdetail += 'タイトル <div class = "title" value ="' + i+1 + '">'
					+ title + '</div><br>';
			dataProductsdetail += '<div class = "category" value ="' + category + '">'
					+ category + '</div><br>';
			dataProductsdetail += '材料 数量 <div class = "material" value ="' + imfor4 + '">'
					+ imfor4 + '</div><br>';
			dataProductsdetail += 'レシピ <br><div class = "recipe" value ="' + reallyRecipe4 + '">'
					+ reallyRecipe4 + '</div><br>';
			dataProductsdetail += 'チップ <div class = "tips" value ="' + tips + '">'
					+ tips + '</div><br>';
			dataProductsdetail += '<input type="button" class = "wishlist" value="mylist" data-boardNum="'+boardNum+'"/>'
			dataProductsdetail += '<input type="button" class = "wishlistpage" value="マイリストページへ移動" data-boardNum="'+boardNum+'"/><br>'
			dataProductsdetail += '</div>';
			dataProductsdetail += '</div>';

			/*상단  레시피 불러오기  */
			dataProducts += '<tr>'
			dataProducts += '<td><input readonly class = "boardNum" value ="' + boardNumFact + '"/></td>'
			dataProducts += '<td><input class="productDetail" type="button" data-Num="'+ boardNum + '" value ="' + title + '"/></td>'
			dataProducts += '<td><input readonly class = "category" value ="' + category + '"/></td>'
			dataProducts += '</tr>'
		}
		/*패이지 처리  */
		for (var page = startPageGroup2; page <= endPageGroup2; page++) {

			if (page == currentPage3) {

				number2 += '<input type="button" class="currentPageNum2 btn__page" data-currentPage="'+ page+ '" data-searchItem="'+ List.searchItem+ '" data-searchWord="'+ List.searchWord+ '" style="color:red" value="' + page + '"/>'
			}
			if (page != currentPage3) {

				number2 += '<input type="button" class="justPageNum2 btn__page" data-currentPage="'+ page+ '" data-searchItem="'+ List.searchItem+ '" data-searchWord="'+ List.searchWord+ '" value="'+ page + '"/>'
			}

		}

		/*패이지 버튼 처리  */
		productsBts += '<div class="boardfooter1">'
		productsBts += '<input type="button" value="◁◁" class="ppBack btn__page" data-currentPage="'+ currentPageGrBack2+ '" data-searchItem="'+ List.searchItem+ '" data-searchWord="' + List.searchWord + '"/>'
		productsBts += '<input type="button" value="◀" class="pBack btn__page" data-currentPage="'+ currentPage3+ '" data-searchItem="'+ List.searchItem+ '" data-searchWord="' + List.searchWord + '"/>'
		productsBts += number2
		productsBts += '<input type="button" value="▶" class="pNext btn__page" data-currentPage="'+ currentPage3+ '" data-searchItem="'+ List.searchItem+ '" data-searchWord="' + List.searchWord + '"/>'
		productsBts += '<input type="button" value="▷▷" class="ppNext btn__page" data-currentPage="'+ currentPageGrNext2+ '" data-searchItem="'+ List.searchItem+ '" data-searchWord="' + List.searchWord + '"/>'
		productsBts += '</div>'

		$('#searchproducts').html(search2);/*검색창을  searchproducts에 뿌리기*/
		$('#productResult').html(dataProducts);/*상단 게시판 정보  productResult에 뿌리기  */
		$('#pageProductsBtn').html(productsBts);/* 페이지 버튼 정보  pageProductsBtn에 뿌리기 */
		$('#recipeDetail').html(dataProductsdetail);/* 처음 전체 레시피 정보 recipeDetail 뿌리기*/
		$('#recipeDetailBtn').html(productsBts);/* 처음 전체 레시피 버튼 정보  recipeDetailBtn 뿌리기*/
		$('input:button.productDetail').click(recipeDetailInformation);
		$('#searchProduct').click(searchProduct);
		$('input:button.pNext').click(next2);
		$('input:button.pBack').click(back2);
		$('input:button.ppNext').click(GrNext2);
		$('input:button.ppBack').click(GrBack2);
		$('input:button.searchProduct').click(searchProduct);
		$('input:button.justPageNum2').click(pageChange2);
		$('input:button.wishlist').on('click', wishlist);
		$('input:button.wishlistpage').on('click', wishlistpage);
	}
	function next2() {
		var currentPage = $(this).attr('data-currentPage');
		var searchItem = $(this).attr('data-searchItem');
		var searchWord = $(this).attr('data-searchWord');

		var currentPagePlus = parseInt(currentPage) + 1;

		$.ajax({
			method : 'get',
			url : 'receiptBoard',
			data : {
				"currentPage" : currentPagePlus,
				"searchItem" : searchItem,
				"searchWord" : searchWord
			},
			success : recipeInformation
		});
	}
	function back2() {
		var currentPage = $(this).attr('data-currentPage');
		var searchItem = $(this).attr('data-searchItem');
		var searchWord = $(this).attr('data-searchWord');
		var currentPageminus = parseInt(currentPage) - 1;

		$.ajax({
			method : 'get',
			url : 'receiptBoard',
			data : {
				"currentPage" : currentPageminus,
				"searchItem" : searchItem,
				"searchWord" : searchWord
			},
			success : recipeInformation
		});
	}
	function GrNext2() {
		var currentPage = $(this).attr('data-currentPage');
		var searchItem = $(this).attr('data-searchItem');
		var searchWord = $(this).attr('data-searchWord');

		var currentPage = parseInt(currentPage);

		$.ajax({
			method : 'get',
			url : 'receiptBoard',
			data : {
				"currentPage" : currentPage,
				"searchItem" : searchItem,
				"searchWord" : searchWord
			},
			success : recipeInformation
		});
	}
	function GrBack2() {
		var currentPage = $(this).attr('data-currentPage');
		var searchItem = $(this).attr('data-searchItem');
		var searchWord = $(this).attr('data-searchWord');

		var currentPage = parseInt(currentPage);

		$.ajax({
			method : 'get',
			url : 'receiptBoard',
			data : {
				"currentPage" : currentPage,
				"searchItem" : searchItem,
				"searchWord" : searchWord
			},
			success : recipeInformation
		});
	}
	function searchProduct() {
		var searchWord = $('#productWord').val();
		var searchItem = $('#productItem').val();

		$.ajax({
			method : 'get',
			url : 'receiptBoard',
			data : {
				"searchItem" : searchItem,
				"searchWord" : searchWord
			},
			success : recipeInformation
		});

	}
	function pageChange2() {
		var page = $(this).attr('data-currentPage');
		var searchItem = $(this).attr('data-searchItem');
		var searchWord = $(this).attr('data-searchWord');

		$.ajax({
			method : 'get',
			url : 'receiptBoard',
			data : {
				"currentPage" : page,
				"searchItem" : searchItem,
				"searchWord" : searchWord
			},
			success : recipeInformation
		});
	}
	function recipeDetailInformation() {
		var boardnum = $(this).attr('data-Num');
		$.ajax({
			method : 'get',
			url : 'searchRecipe',
			data : {
				"boardNum" : boardnum
			},
			success : recipeDetail
		});
	}
	function recipeDetail(board2) {
		$('#recipe__btn').click();
		
		var recipeDetail = '';
		var imglink2 = board2.imglink;
		var title2 = board2.title;
		var category2 = board2.category;
		var metarial2 = board2.metarial
		var amount2 = board2.amount;
		var recipe2 = board2.recipe;
		var tips2 = board2.tips;
		var btnzero = '';
		var boardNum = board2.boardNum;
		/*--------------------재료,수량,레시피정보 공백기준으로 split 작업---------------------- */
		var info2='';
		var reallyRecipe2='';
		
	 	for(var i=0;i<metarial2.length-1;i++){
			info2+='<'+metarial2[i]+' : '+amount2[i]+'>';
		};
		
		for(var i=0;i<recipe2.length-1;i++){
			reallyRecipe2+=(i+1)+'. '+recipe2[i]+'<br>';
		}
		/*----------------------------------------------------------------------------  */
		recipeDetail += '<div class="recipe__board__table">';
		recipeDetail += '<div id="Product__board1">';
		recipeDetail += '<img class="img__size" src="' + imglink2 + '"/><br>';
		recipeDetail += '</div>';
		recipeDetail += '<div id="Product__board2">';
		recipeDetail += 'タイトル <div class = "title" value ="' + title2 + '">'
				+ title2 + '</div><br>';
		recipeDetail += '<div class = "category" value ="' + category2 + '">'
				+ category2 + '</div><br>';
		recipeDetail += '材料 数量<div class = "material" value ="' + info2 + '">'
				+ info2 + '</div><br>';
		recipeDetail += 'レシピ  <br><div class = "recipe" value ="' + reallyRecipe2 + '">'
				+ reallyRecipe2 + '</div><br>';
		recipeDetail += 'チップ <div class = "tips" value ="' + tips2 + '">'
				+ tips2 + '</div><br>';
		recipeDetail += '<input type="button" class = "wishlist" value="mylist" data-boardNum="'+boardNum+'"/>'
		recipeDetail += '<input type="button" class = "wishlistpage" value="マイリストページへ移動" data-boardNum="'+boardNum+'"/><br>'
		recipeDetail += '</div>';

		$('#recipeDetail').html(recipeDetail);
		$('#recipeDetailBtn').html(btnzero);
		$('input:button.wishlist').click(wishlist);
		$('input:button.wishlistpage').on('click', wishlistpage);
	};

	function wishlist() {
		var boardNum = $(this).attr('data-boardNum');
		$.ajax({
			method : 'get',
			url : 'selectWishList',
			data : {
				"boardNum" : boardNum
			},
			success : yesNo
		});
	}

	function wishlistpage() {
		var boardNum = $(this).attr('data-boardNum');
		$.ajax({
			method : 'get',
			url : 'selectWishList',
			data : {
				"boardNum" : boardNum
			},
			success : wishPage
		});

	}

	function yesNo(result) {
		if (result == -1) {//fail
			alert('すでにマイリストに追加されています。')
		} else if (result == 0) {//success
			alert('マイリストに追加されました。');
		} else if (result == 404) {//non session
			alert('ログインしてください。');
			$('#recipeHome_btn').click();
			$('#login__btn').click();
			/* 	$('#recipe__btn').click();
				$('#page1').get(0).click();
				$('#login__btn').click();
			 */
		}
		;
	}
	function wishPage(result) {
		if (result == 404) {//non session
			alert('ログインしてください。');
			$('#recipeHome_btn').click();
			$('#login__btn').click();
			/* 		$('#recipe__btn').click();
					$('#page1').get(0).click();
					$('#login__btn').click(); */
		} else {//success
			location.href = 'wishlistpage';
		};

	};
</script>
<script src="js/topmovie.js"></script>
<script src="js/member.js"></script>
<script src="http://vjs.zencdn.net/c/video.js"></script>
<script src="js/special.js?ver=1"></script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDp4zkdfhOxEUgXnAoU5PSwP_oKF337r4g&callback=initMap&language=ja&region=JP&libraries=places"></script>
<script src="js/streaming.js?ver=2"></script>
</html>