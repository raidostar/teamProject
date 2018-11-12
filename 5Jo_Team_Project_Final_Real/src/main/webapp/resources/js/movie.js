$(function(){
	init();
});

function init(){
	
	$.ajax({
		method:'GET', 
		url:'movieBoard',	
		success : output
	});
}
 	
	function output(List){
		
		var vedio = '';
		var vedio1 = '';
		var search1 = '';
		var currentPage = parseInt(List.currentPage);
		var pagePerGroup = parseInt(List.navi.pagePerGroup);
		var currentPageGrNext = currentPage+pagePerGroup;
		var currentPageGrBack = currentPage-pagePerGroup;
		var startPageGroup = parseInt(List.navi.startPageGroup);
		var endPageGroup = parseInt(List.navi.endPageGroup);
		var currentPage = parseInt(List.navi.currentPage);
		var number = '';
		
		search1 += '<div id="search__table">'
		search1 += '<select name="searchItem" id="searchItem" class="search__table">'
		search1 += '<option value="userId">작성자</option>'
		search1 += '<option value="title">제목</option>'
		search1 += '<option value="content">내용</option>'
		search1 += '</select>'
		search1 += '<input type="text" name="searchWord" value="'+ List.searchWord+ '" id="searchWord" class="search__table" />'
		search1 += '<input type="button" value="검색" id="search" class="search search__table" />'
		search1 += '</div>'
	
		
		for(var i =0; i<List.list.length; i++){
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
		$('input:button.detail').click(function(){
			
		});
		$('input:button.next').click(next);
		$('input:button.back').click(back);
		$('input:button.GrNext').click(GrNext);
		$('input:button.GrBack').click(GrBack);
		$('input:button.search').click(search);
		$('input:button.currentPageNum').click(pageChange);
		$('input:button.justPageNum').click(pageChange);

	}//function output
	
	
	function next(){
		var currentPage = $(this).attr('data-currentPage');
		var searchItem = $(this).attr('data-searchItem');
		var searchWord = $(this).attr('data-searchWord');
		var currentPagePlus = parseInt(currentPage)+1;
		
		$.ajax({
			method:'get', 
			url:'movieBoard',
			data : {"currentPage":currentPagePlus, "searchItem":searchItem, "searchWord":searchWord},
			success : output
		});
	}//function next
	
	function back(){
		var currentPage = $(this).attr('data-currentPage');
		var searchItem = $(this).attr('data-searchItem');
		var searchWord = $(this).attr('data-searchWord');
		var currentPageminus = parseInt(currentPage)-1;
		
		$.ajax({
			method:'get', 
			url:'movieBoard',
			data : {"currentPage":currentPageminus, "searchItem":searchItem, "searchWord":searchWord},
			success : output
		});
	}
	
	function GrNext(){
		var currentPage = $(this).attr('data-currentPage');
		var searchItem = $(this).attr('data-searchItem');
		var searchWord = $(this).attr('data-searchWord');

		var currentPage = parseInt(currentPage);
		
		$.ajax({
			method:'get', 
			url:'movieBoard',
			data : {"currentPage":currentPage, "searchItem":searchItem, "searchWord":searchWord},
			success : output
		});
	}
	
	function GrBack(){
		var currentPage = $(this).attr('data-currentPage');
		var searchItem = $(this).attr('data-searchItem');
		var searchWord = $(this).attr('data-searchWord');

		var currentPage = parseInt(currentPage);
		
		$.ajax({
			method:'get', 
			url:'movieBoard',
			data : {"currentPage":currentPage, "searchItem":searchItem, "searchWord":searchWord},
			success : output
		});
	}
	
	function search(){
		var searchWord = $('#searchWord').val();
		var searchItem = $('#searchItem').val();

		$.ajax({
			method:'get', 
			url:'movieBoard',
			data : {"searchItem":searchItem, "searchWord":searchWord},
			success : output 
		});

	}
	
	function pageChange(){
		var page = $(this).attr('data-currentPage');
		var searchItem = $(this).attr('data-searchItem');
		var searchWord = $(this).attr('data-searchWord');
		
		$.ajax({
			method:'get', 
			url:'movieBoard',
			data : {"currentPage":page, "searchItem":searchItem, "searchWord":searchWord},
			success : output 
		});
	}

	function Moviedetail(){
		var boardNum = $(this).attr('data-Num');
		
		$.ajax({
			method:'post', 
			url:'movieDtailOne',
			data : 'boardNum='+boardNum,
			success : movieDetail
		});
	}
	
		function movieDetail(board){
			$('#movie__btn').click();
			
			var movieDetail ='';
			var movieUpdate ='';
			var movieDelete='';
			
			var userId = board.userId;
			var title = board.title;
			var content = board.content;
			var boardNum = board.boardNum;
			var regdate = board.regdate;
			var like = board.like;
			
			movieDetail += '<div>'
			movieDetail += '<span class = "userId">' + userId + '</span><p>'
			movieDetail += '<span class = "title">' + title + '</span><p>'
			movieDetail += '<video controls src="download?boardNum='+ boardNum+ '">'+ "Your user agent does not support the HTML5 Video element."+ '</video></p>'
			movielike(board);			
			movieDetail += '<span class = "content">' + content + '</span>'
			movieDetail += '</div></hr>'
			movieDetail += '<a href="MovieboardUpdate?boardNum='+boardNum+'">글수정</a>'
			movieDetail += '<input type="button" class="moviedelete" data-boardNum="'+boardNum+'" value="글삭제" />'	
				
			
			$('#result2').html(movieDetail);
			$('#update').html(movieUpdate);
			$('#delete').html(movieDelete);
			$('input:button.moviedelete').click(moviedeletecheck);
	
	}
	
	function movielike(board){
		alert(JSON.stringify(board));
		var movielike ='';
		
		if(board.like == true){
			movielike += '<input type="button" value ="♡" class="like" data-boardnum = "'+board.boardNum+'"/>'+board.point
		}else{
			movielike += '<input type="button" value ="♥" class="like" data-boardnum = "'+board.boardNum+'"/>'+board.point
		}
		$('#result3').html(movielike);
		$('input:button.like').on('click', addlike);
	}

	
	function addlike(){
		var boardNum = $(this).attr('data-boardNum');
		$.ajax({
			method:'post', 
			url:'addlike',
			data : 'boardNum='+boardNum,
			success : movielike
		});	
	}

function moviedeletecheck(){
	var deletecheck = confirm("삭제하시겠습니까?");
	var boardNum = $(this).attr('data-boardNum');
	if(deletecheck == true){
	$.ajax({
		method:'post',
		url:'MovieboardDelete',
		data : 'boardNum='+boardNum,
		success : function(result){
			if(result == 1){
				alert('削除されました。');
				init();
			}else{
				alert('もう一度やり直してください。')
			}
		}
	});	 
	}else{
		alert('キャンセルされました。')
	} 
}

/*$(function(){
	init();
});

function init(){
	
	$.ajax({
		method:'GET', 
		url:'movieBoard',		
		success : output
	});
}
 	
	function output(List){
		
		var vedio = '';
		var vedio1 = '';
		var search1 = '';
		var currentPage = parseInt(List.currentPage);
		var pagePerGroup = parseInt(List.navi.pagePerGroup);
		var currentPageGrNext = currentPage+pagePerGroup;
		var currentPageGrBack = currentPage-pagePerGroup;
		var startPageGroup = parseInt(List.navi.startPageGroup);
		var endPageGroup = parseInt(List.navi.endPageGroup);
		var currentPage = parseInt(List.navi.currentPage);
		var number = '';
		
		search1 += '<div id="search__table">'
		search1 += '<select name="searchItem" id="searchItem" class="search__table">'
		search1 += '<option value="userId">작성자</option>'
		search1 += '<option value="title">제목</option>'
		search1 += '<option value="content">내용</option>'
		search1 += '</select>'
		search1 += '<input type="text" name="searchWord" value="'+ List.searchWord+ '" id="searchWord" class="search__table" />'
		search1 += '<input type="button" value="검색" id="search" class="search search__table" />'
		search1 += '</div>'
	
		
		for(var i =0; i<List.list.length; i++){
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

	}
	
	function next(){
		var currentPage = $(this).attr('data-currentPage');
		var searchItem = $(this).attr('data-searchItem');
		var searchWord = $(this).attr('data-searchWord');

		var currentPagePlus = parseInt(currentPage)+1;
		
		$.ajax({
			method:'get', 
			url:'movieBoard',
			data : {"currentPage":currentPagePlus, "searchItem":searchItem, "searchWord":searchWord},
			success : output
		});
	}
	
	function back(){
		var currentPage = $(this).attr('data-currentPage');
		var searchItem = $(this).attr('data-searchItem');
		var searchWord = $(this).attr('data-searchWord');
		var currentPageminus = parseInt(currentPage)-1;
		
		$.ajax({
			method:'get', 
			url:'movieBoard',
			data : {"currentPage":currentPageminus, "searchItem":searchItem, "searchWord":searchWord},
			success : output
		});
	}
	
	function GrNext(){
		var currentPage = $(this).attr('data-currentPage');
		var searchItem = $(this).attr('data-searchItem');
		var searchWord = $(this).attr('data-searchWord');

		var currentPage = parseInt(currentPage);
		
		$.ajax({
			method:'get', 
			url:'movieBoard',
			data : {"currentPage":currentPage, "searchItem":searchItem, "searchWord":searchWord},
			success : output
		});
	}
	
	function GrBack(){
		var currentPage = $(this).attr('data-currentPage');
		var searchItem = $(this).attr('data-searchItem');
		var searchWord = $(this).attr('data-searchWord');

		var currentPage = parseInt(currentPage);
		
		$.ajax({
			method:'get', 
			url:'movieBoard',
			data : {"currentPage":currentPage, "searchItem":searchItem, "searchWord":searchWord},
			success : output
		});
	}
	
	function search(){
		var searchWord = $('#searchWord').val();
		var searchItem = $('#searchItem').val();

		$.ajax({
			method:'get', 
			url:'movieBoard',
			data : {"searchItem":searchItem, "searchWord":searchWord},
			success : output 
		});

	}
	
	function pageChange(){
		var page = $(this).attr('data-currentPage');
		var searchItem = $(this).attr('data-searchItem');
		var searchWord = $(this).attr('data-searchWord');
		
		$.ajax({
			method:'get', 
			url:'movieBoard',
			data : {"currentPage":page, "searchItem":searchItem, "searchWord":searchWord},
			success : output 
		});
	}

	function Moviedetail(){
		var boardNum = $(this).attr('data-Num');
		
		$.ajax({
			method:'post', 
			url:'movieDtailOne',
			data : 'boardNum='+boardNum,
			success : movieDetail
		});
	}
	
		function movieDetail(board){
			
			var movieDetail ='';
			var movieUpdate ='';
			var movieDelete='';
			
			var userId = board.userId;
			var title = board.title;
			var content = board.content;
			var boardNum = board.boardNum;
			var regdate = board.regdate;
			var like = board.like;
			
			movieDetail += '<div>'
			movieDetail += '<span class = "userId">' + userId + '</span><p>'
			movieDetail += '<span class = "title">' + title + '</span><p>'
			movieDetail += '<video controls src="download?boardNum='+ boardNum+ '">'+ "Your user agent does not support the HTML5 Video element."+ '</video></p>'
			movielike(board);			
			movieDetail += '<span class = "content">' + content + '</span>'
			movieDetail += '</div></hr>'

			movieUpdate += '<a href="MovieboardUpdate?boardNum='+boardNum+'">글수정</a>'
			movieDelete += '<input type="button" class="moviedelete" data-boardNum="'+boardNum+'" value="글삭제" />'	
				
			$('#delete').html(movieDelete);
			$('#update').html(movieUpdate);
			$('#result2').html(movieDetail);
			$('input:button.moviedelete').click(moviedeletecheck);
	
	}
	
	function movielike(board){
		var movielike ='';
		
		if(board.like == true){
			movielike += '<input type="button" value ="♡" class="like" data-boardnum = "'+board.boardNum+'"/>'+board.point
		}else{
			movielike += '<input type="button" value ="♥" class="like" data-boardnum = "'+board.boardNum+'"/>'+board.point
		}
		$('#result3').html(movielike);
		$('input:button.like').on('click', addlike);
	}

	
	function addlike(){
		var boardNum = $(this).attr('data-boardNum');
		$.ajax({
			method:'post', 
			url:'addlike',
			data : 'boardNum='+boardNum,
			success : movielike
		});	
	}

function moviedeletecheck(){
	var deletecheck = confirm("삭제하시겠습니까?");
	var boardNum = $(this).attr('data-boardNum');
	if(deletecheck == true){
	$.ajax({
		method:'post',
		url:'MovieboardDelete',
		data : 'boardNum='+boardNum,
		success : function(result){
			if(result == 1){
				alert('동영상 삭제가 완료되었습니다.');
				init();
			}else{
				alert('동영상 삭제가 완료되지 않았습니다. 다시 시도해 주십시오.')
			}
		}
	});	 
	}else{
		alert('동영상 삭제가 취소되었습니다.')
	} 
}


// Movie 게시판 글 수정

function formCheck() {
	var title = document.getElementById("title");
	var content = document.getElementById("content");
	var file = document.getElementById("file");
	var type = file.files[0].type;
	
	if (title.value == '' || content.value == '') {
		alert('제목과 내용을 입력하세요.');
		return false;
	}if(file.value == ''){
		alert('첨부파일을 꼭 올리셔야 합니다.')
	}if(type.search('video')){
		alert('동영상만 첨부할 수 있습니다.');
		return false;
	}
	
	return true;
}
function boardList() {
	location.href = "boardList";
}*/


/*$(function() {
	init();
});

function init() {

	$.ajax({ 
		url : 'movieBoard',
		success : output
	});

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
		search1 += '<option value="userId">작성자</option>'
		search1 += '<option value="title">제목</option>'
		search1 += '<option value="content">내용</option>'
		search1 += '</select>'
		search1 += '<input type="text" name="searchWord" value="'
				+ List.searchWord
				+ '" id="searchWord" class="search__table" />'
		search1 += '<input type="button" value="검색" id="search" class="search search__table" />'
		search1 += '</div>'

		for (var i = 0; i < List.list.length; i++) {
			var userId = List.list[i].userId;
			var title = List.list[i].title;
			var content = List.list[i].content;
			var boardNum = List.list[i].boardNum;
			var regdate = List.list[i].regdate;

			vedio += '<div id="board__table">'
			vedio += '<input class="detail trigger heading" type="button" data-Num="'
					+ boardNum + '" value ="' + title + '"/>'
			vedio += '<input readonly class = "userId" value ="' + userId
					+ '"/>'
			vedio += '<input readonly class = "hitCount" />'
			vedio += '<input readonly class = "regdate" value ="' + regdate
					+ '"/>'
			vedio += '</div>'
		}

		for (var page = startPageGroup; page <= endPageGroup; page++) {
			if (page == currentPage) {
				number += '<input type="button" class="currentPageNum btn__page" data-currentPage="'
						+ page
						+ '" data-searchItem="'
						+ List.searchItem
						+ '" data-searchWord="'
						+ List.searchWord
						+ '" style="color:red" value="' + page + '">'
			}
			if (page != currentPage) {
				number += '<input type="button" class="justPageNum btn__page" data-currentPage="'
						+ page
						+ '" data-searchItem="'
						+ List.searchItem
						+ '" data-searchWord="'
						+ List.searchWord
						+ '" value="'
						+ page + '">'
			}
		}

		vedio1 += '<div class="boardfooter">'
		vedio1 += '<input type="button" value="◁◁" class="GrNext btn__page" data-currentPage="'
				+ currentPageGrBack
				+ '" data-searchItem="'
				+ List.searchItem
				+ '" data-searchWord="' + List.searchWord + '"></a>'
		vedio1 += '<input type="button" value="◀" class="back btn__page" data-currentPage="'
				+ currentPage
				+ '" data-searchItem="'
				+ List.searchItem
				+ '" data-searchWord="' + List.searchWord + '"></a>'
		vedio1 += number
		vedio1 += '<input type="button" value="▶" class="next btn__page" data-currentPage="'
				+ currentPage
				+ '" data-searchItem="'
				+ List.searchItem
				+ '" data-searchWord="' + List.searchWord + '"></a>'
		vedio1 += '<input type="button" value="▷▷" class="GrBack btn__page" data-currentPage="'
				+ currentPageGrNext
				+ '" data-searchItem="'
				+ List.searchItem
				+ '" data-searchWord="' + List.searchWord + '"></a>'
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

	}

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
	}

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

		function movieDetail(board) {

			var movieDetail = '';

			var userId = board.userId;
			var title = board.title;
			var content = board.content;
			var boardNum = board.boardNum;
			var regdate = board.regdate;

			movieDetail += '<div>'
			movieDetail += '<span class = "userId">' + userId + '</td><p>'
			movieDetail += '<span class = "title">' + title + '</td><p>'
			movieDetail += '<video controls src="download?boardNum='
					+ boardNum
					+ '">'
					+ "Your user agent does not support the HTML5 Video element."
					+ '</video></p>'
			movieDetail += '<span class = "content">' + content + '</td>'
			movieDetail += '</div></hr>'

			$('#result2').html(movieDetail);

		}
	}
}
// MovieBoardWrite 유효성 검사
function formCheck() {
	var title = document.getElementById("title");
	var content = document.getElementById("content");

	if (title.value == '' || content.value == '') {
		alert('제목과 내용을 입력하세요.');
		return false;
	}
	return true;
}
function boardList() {
	location.href = "boardList";
}
*/
// 전에꺼

