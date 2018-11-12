<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="css/streaming.css" />
<script
	src="https://rtcmulticonnection.herokuapp.com/dist/RTCMultiConnection.min.js"></script>
<script
	src="https://rtcmulticonnection.herokuapp.com/socket.io/socket.io.js"></script>
<script src="https://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script>
	console.log("<c:url value='/echo'/>");
	var sock = new SockJS("<c:url value='/echo'/>");
	sock.onmessage = onMessage;
	sock.onclose = onClose;

	$(function() {
		$("#sendBtn").click(function() {
			console.log('send message...');
			sendMessage();
		});

		$('input').keyup(function(e) {
			if (e.keyCode == 13) {
				console.log('send message...');
				sendMessage();
			}
		});

		refresh();
	});

	function sendMessage() {//websocket으로 메세지 전송
		var userId = "${sessionScope.loginId}";
		var message = $("#message").val();
		var dataForm = {
			"userId" : userId,
			"message" : message
		};

		$.ajax({
			url : "insert",
			type : "post",
			data : JSON.stringify(dataForm),
			dataType : 'text',
			contentType : 'application/json; charset:utf-8;',
			success : function(a) {
				/* sock.send($("#message").val()); */
				sock.send(a);
				$('#message').val("");
			},
			error : function() {
				console.log('insert error');
			}
		});
	}

	function onMessage(evt) {//evt 파라메터는 웹소켓이 보내준 데이터
		var data = evt.data;
		var sessionid = null;
		var message = null;

		var strArray = data.split('|');

		/* var currentuser_session =$('#sessionuserid').val(); */
		var currentuser_session = "${sessionScope.loginId}";

		sessionid = strArray[0];//메세지 보낸사람 세션저장
		message = strArray[1];//현재 메세지 저장

		var strArray2 = message.split(',');
		$("#chatdata").text("");
		for (var i = 0; i < strArray2.length; i++) {
			var printHTML = "<input type='text' class='form-control input-sm' readonly='readonly'";
		printHTML += "value='"+strArray2[i]+"'/>";
			$("#chatdata").append(printHTML);

			/* var printHTML = "<div class='well'>";
			printHTML += "<div class='arrow_box'>";
			printHTML += strArray2[i];
			printHTML += "</div>";
			printHTML += "</div>";
			$("#chatdata").append(printHTML);	 */
		}
	}
	function onClose(evt) {
		$('#data').append("채팅 연결이 끊어졌어요 다시 접속 해 주세요 ㅜㅜ");
	}

	function refresh() {
		$
				.ajax({
					url : "refresh",
					type : 'post',
					success : function(list) {
						$("#chatdata").text("");
						for (var i = 0; i < list.length; i++) {
							var printHTML = "<input type='text' class='form-control input-sm' readonly='readonly'";
				printHTML += "value='"+list[i]+"'/>";
							$("#chatdata").append(printHTML);
						}
					},
					error : function() {
						console.log('refresh error');
					}
				});
	}
	var connection = new RTCMultiConnection();
	var localVideoContainer;
	var remoteVideoContainer;
	// this line is VERY_important
	connection.socketURL = 'https://rtcmulticonnection.herokuapp.com:443/';
	//connection.socketURL = 'ws://localhost:8085/video/pong-ws/';

	// if you want audio+video conferencing
	connection.session = {
		audio : true,
		video : true,
		oneway : true
	};

	connection.sdpConstraints.mandatory = {
		OfferToReceiveAudio : false,
		OfferToReceiveVideo : false
	};

	connection.onstream = function(event) {
		console.log(event.mediaElement);
		var video = event.mediaElement;
		console.log(event.type);
		if (event.type === 'local') {
			console.log("local");
			localVideoContainer.appendChild(video);
			//$('div#local-videos-container>video').attr('controls',false);
		}
		if (event.type === 'remote') {
			console.log("remote");
			remoteVideoContainer.appendChild(video);
			$('div#remote-videos-container>video').attr('controls', false);
		}
	}

	var predefinedRoomId = '${roomid}';

	$(function() {
		localVideoContainer = document.getElementById("local-videos-container");
		remoteVideoContainer = document
				.getElementById("remote-videos-container");
		//connection.openOrJoin( predefinedRoomId );
	});

	$(function() {
		$('#qlist').click(function() {
			var link = '${pageContext.request.contextPath}' + '/viewQuestions'
			window.open(link, "Qlist", "width=1200, height=500, resizable=yes");
		});
	});

	$(function() {
		$('#open-room').on(
				'click',
				function() {
					console.log("sdf");
					//disableInputButtons();
					connection.open(document.getElementById('room-id').value,
							function() {
							});
				});
		$('#join-room').on('click', function() {
			//disableInputButtons();
			connection.sdpConstraints.mandatory = {
				OfferToReceiveAudio : true,
				OfferToReceiveVideo : true
			};
			connection.join(document.getElementById('room-id').value);
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Real-Time_Service</title>
</head>
<body id="body__back">
	<div id="streaming_login">
		<input type="text" id="room-id" value="" autocorrect=off autocapitalize=off size=40>
			<c:if test="${sessionScope.loginId eq 'gatas2' or sessionScope.loginId eq 'gatas1'}">
		<button id="open-room">Open Room</button></c:if>
 		<c:if test="${sessionScope.loginId ne 'gatas2' and sessionScope.loginId ne 'gatas1'}">
		<button id="join-room">Join Room</button></c:if>
	</div>

	<div class="container">
		<div class="raw">
			<div class="md">
				<br /> <span class="border rounded">${sessionScope.loginId}</span>
				<br /> <br />
				<div>
					<div id="local-videos-container" class="screen"
						style="margin-left: 141px;"></div>
					<div id="remote-videos-container" style="margin-right: 131px;"></div>
				</div>
			</div>
		</div>
		<br /> <br />
		<div class="md" align="center"></div>
	</div>

	<input type="text" class='form-control' id="message" />
	<button id="sendBtn" class="btn btn-secondary">보내기</button>

	<div id="data"></div>
	<div id="chatdata" class="form-group"></div>
</body>
</html>