<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/test.css" />
<link rel="stylesheet" type="text/css" href="css/boardwrite.css" />
<meta charset="UTF-8">
<title>글 수정</title>
</head>
<body class="write__page">
	<div class="intro__content">
		<div id="movie__board1">

			<div id="searchdiv"></div>
			<div id="board__list">

				<div id="wrapper">
					<div class="spacer" style="margin-bottom: 5%;"></div>
					<div id="stylized" class="myform" align="center">

						<form action="MovieboardUpdate" method="post"
							onsubmit="return formCheck()" enctype="multipart/form-data">
							<input type="hidden" name="boardNum" id="boardnum"
								value="${board.boardNum}"> <input type="hidden"
								name="userId" id="userid" value="${loginId}">
							<h2>掲示板 修正</h2>
							<p>修正の映像を再ロードしてください。</p>


							<label>Subject <span class="small">제목</span></label> <input
								type="text" name="title" id="title" value="${board.title}">
							<div class="spacer"></div>
							<label>FileUpload <span class="small">파일</span></label> <input
								type="file" name="upload" id="upload" accept="video/*" />
							<div class="spacer"></div>
							<label>Content <span class="small">내용</span></label>
							<textarea id="Content" name="content">${board.content}</textarea>
							<div class="spacer"></div>
							<div>
								<button type="submit">수정</button>
								<button onclick="boardList()">목록</button>
							</div>
							<div class="spacer"></div>

						</form>
					</div>

				</div>
			</div>
		</div>
	</div>

	<script src="js/movie.js"></script>
</body>
</html>