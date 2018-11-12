$(function(){
	$('#streaming').on('click', openStreaming);
})

function openStreaming(){		
	window.open("streaming", "child", "width=800, height=800, resizable=no");
}