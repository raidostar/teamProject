<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="css/map.css" />
<!-- /container -->
<input type="hidden" id="coord0" value="${coord0}">
<input type="hidden" id="coord1" value="${coord1}">
<div id="container-5" class="container theme-1">
	<header class="intro">
		<div class="intro__content">

			<!-- <기성>Map1 지도 띄우기 code here -->
			<div id="map__changebtn">
				<!-- <button id="market" class="changeBtn map__changebtn btn_change button button--sacnite button--round-l" value="スーパーマーケット">슈퍼</button> -->
			</div>
			<div id="map1"></div>

			<div id="right-panel">
				<ul id="places"></ul>
				<button id="more" class="changeBtn map__changebtn btn_change button button--sacnite button--round-l">更新</button>
				<button id="market" class="changeBtn map__changebtn btn_change button button--sacnite button--round-l" value="スーパーマーケット">スーパー</button>
			</div>
		</div>
	</header>

	<script src="resources/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		var findType = "convenience_store";

		$(function() {
			$(".map__changebtn").on("click", function() {
				if ($(this).val() == "スーパーマーケット") {
					$(this).text("コンビニ");
					$(this).val("コンビニ");
					findType = "supermarket";
					init1Map();
				} else if ($(this).val() == "コンビニ") {
					$(this).text("スーパー");
					$(this).val("スーパーマーケット");
					findType = "convenience_store";
					init1Map();
				}
			});

		});

		var map2, infowindow;
		function init1Map() {
			// Create the map.
			var coord0 = document.getElementById("coord0").value;
			var coord1 = document.getElementById("coord1").value;

			var myCenter = new google.maps.LatLng(coord0, coord1);
			var mapCanvas = document.getElementById("map1");
			var mapOptions = {
				center : myCenter,
				zoom : 16,
				zoomControlOptions : {
					position : google.maps.ControlPosition.RIGHT_TOP
				// 오른쪽 상단으로 기느올리기
				}
			};

			map2 = new google.maps.Map(mapCanvas, mapOptions);
			infowindow = new google.maps.InfoWindow();

			var markerHome = new google.maps.Marker({
				position : myCenter,
				animation : google.maps.Animation.BOUNCE // 마커 애니매이션 설정
				,
				icon : "img/userHome.png"
			});

			markerHome.setMap(map2);

			var myCity = new google.maps.Circle({
				center : myCenter,
				radius : 1000,
				strokeColor : "#0000FF",
				strokeWeight : 0.8,
				fillColor : "#0000FF",
				fillOpacity : 0.2
			});
			myCity.setMap(map2);
			// Create the places service.
			var service = new google.maps.places.PlacesService(map2);
			var getNextPage = null;
			var moreButton = document.getElementById('more');
			moreButton.onclick = function() {
				moreButton.disabled = true;
				if (getNextPage)
					getNextPage();
			};

			// Perform a nearby search.
			service.nearbySearch({
				location : myCenter,
				radius : 1000,
				types : [ findType ]
			}, function(results, status, pagination) {
				if (status !== 'OK')
					return;

				createMarkers(results);
				moreButton.disabled = !pagination.hasNextPage;
				getNextPage = pagination.hasNextPage && function() {
					pagination.nextPage();
				};
			});
			google.maps.event.addDomListener(window, "load", init1Map);
		}// initmap

		function createMarkers(places) {
			var bounds = new google.maps.LatLngBounds();
			var placesList = document.getElementById('places');

			var placeListLi = "";

			for (var i = 0, place; place = places[i]; i++) {
				var image = "img/store.png"
				/*
				 * { url: place.icon, size: new google.maps.Size(71, 71), origin: new
				 * google.maps.Point(0, 0), anchor: new google.maps.Point(17, 34),
				 * scaledSize: new google.maps.Size(25, 25) };
				 */

				var marker2 = new google.maps.Marker({
					map : map2,
					icon : image,
					title : place.name,
					position : place.geometry.location
				});
				google.maps.event.addListener(marker2, 'click', function() {
					var content = '<div id="infocontents">';
					content += $(this)[0].title;
					content += '</div>';
					infowindow.setContent(content);
					infowindow.open(map2, this);
					console.log($(this)[0].title);
					map2.setZoom(18);
					map2.setCenter($(this)[0].position);
				});

				placeListLi += '<li>' + place.name + '</li>';

				bounds.extend(place.geometry.location);
			}
			$('ul#places').on("click", 'li', function() {
				for (var i = 0, place; place = places[i]; i++) {
					if ($(this)[0].innerHTML == place.name) {
						console.log("성공");
						map2.setZoom(18);
						map2.setCenter(place.geometry.location);

						break;
					}
				}
			});

			$('#places').html(placeListLi);
		}
	</script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBoOSuCh6Iieh-S2kZGwIwJv41evV2lclo&libraries=places&language=ja&callback=init1Map"></script>
</div>