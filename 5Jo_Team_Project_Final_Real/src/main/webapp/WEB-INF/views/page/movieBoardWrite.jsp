<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko" class="ko">
<head>
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/test.css" />
<link rel="stylesheet" type="text/css" href="css/boardwrite.css" />
<script type="text/javascript">
	function formCheck() {
		var title = document.getElementById("title");
		var content = document.getElementById("content");
		var file = document.getElementById("file");
		var type = file.files[0].type;

		if (title.value == '' || content.value == '') {
			alert('タイトルとメッセージを入力してください。');
			return false;
		}
		if (file.value == '') {
			alert('ファイルをアップロードしてください。')
		}
		if (type.search('video')) {
			alert('動画のみアップロードできます。');
			return false;
		}

		return true;
	}
	function boardList() {
		location.href = "boardList";
	}
</script>
</head>
<body class="write__page">
	<div class="intro__content">
		<div id="movie__board1">

			<div id="searchdiv"></div>
			<div id="board__list">
				<div class="container">
					<section class="content1">
						<div class="box bg-1">
							<div id="wrapper">
								<div class="spacer" style="margin-bottom: 5%;"></div>
								<div id="stylized" class="myform" align="center">
									<form action="boardWrite" method="post"
										onsubmit="return formCheck()" enctype="multipart/form-data">
										<input type="hidden" name="action" value="write"> <input
											type="hidden" name="userid" id="userid" value="${loginId}">
										<h1>Movie 掲示板</h1>
										<p>自分の自慢のレシピの映像をアップロードしてください。</p>

										<label>Subject <span class="small">제목</span>
										</label><input type="text" name="title" id="Subject" />
										<div class="spacer"></div>
										<label>FileUpload <span class="small">파일</span>
										</label> <input type="file" name="upload" id="upload" />
										<div class="spacer"></div>
										<label>Content <span class="small">내용</span>
										</label>
										<textarea id="Content" name="content"></textarea>
										<div class="spacer"></div>
										<div>
											<button
												class="button button--antiman button--round-l button--text-medium"
												type="submit">글쓰기</button>
											<button
												class="button button--antiman button--round-l button--text-medium"
												onclick="boardList()">취소</button>
										</div>
										<div class="spacer"></div>
									</form>
								</div>
							</div>
						</div>
					</section>
				</div>
			</div>

		</div>
	</div>

	<!-- 	<script src="js/movie.js"></script> -->
</body>
</html>
