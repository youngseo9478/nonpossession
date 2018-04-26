<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="apple-touch-icon" sizes="76x76"
	href="assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />

<!-- Animation library for notifications   -->
<link href="assets/css/animate.min.css" rel="stylesheet" />

<!-- Bootstrap core CSS     -->
<link href="css/bootstrap.min.css" rel="stylesheet" />

<!--  Paper Dashboard core CSS    -->
<link href="css/paper-dashboard.css" rel="stylesheet" />

<!--  Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css"
	rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Muli:400,300'
	rel='stylesheet' type='text/css'>
<link href="css/themify-icons.css" rel="stylesheet">

<!-- JQuery 사용하기 위해 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!--  Google Maps Plugin    -->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCXHAz-sDb9rPjKRcDHTtMwmlpmAXAfdqc"></script>

<script type="text/javascript">
	$(function() {
		var beaches;
		$.ajax({
			url : "weatherList.do",
			method : "POST",
			type : "JSON",
			success : function(data) {
				beaches = data.list;
				google.maps.event.addDomListener(window, 'load', initMap);
			}
		})

		function initMap() {
			var map = new google.maps.Map(document.getElementById('map'), {
				zoom : 10,
				center : {
					lat : 37.5653133,
					lng : 126.7093668
				}
			});

			setMarkers(map);
		}

		// Data for the markers consisting of a name, a LatLng and a zIndex for the
		// order in which these markers should display on top of each other.

		function setMarkers(map) {
			// Adds markers to the map.

			// Marker sizes are expressed as a Size of X,Y where the origin of the image
			// (0,0) is located in the top left of the image.

			// Origins, anchor positions and coordinates of the marker increase in the X
			// direction to the right and in the Y direction down.
			var image = {
				url : 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
				// This marker is 20 pixels wide by 32 pixels high.
				size : new google.maps.Size(20, 32),
				// The origin for this image is (0, 0).
				origin : new google.maps.Point(0, 0),
				// The anchor for this image is the base of the flagpole at (0, 32).
				anchor : new google.maps.Point(0, 32)
			};
			// Shapes define the clickable region of the icon. The type defines an HTML
			// <area> element 'poly' which traces out a polygon as a series of X,Y points.
			// The final coordinate closes the poly by connecting to the first coordinate.
			var shape = {
				coords : [ 1, 1, 1, 20, 18, 20, 18, 1 ],
				type : 'poly'
			};
			for (var i = 0; i < beaches.length; i++) {
				var beach = beaches[i];
				var marker = new google.maps.Marker({
					position : {
						lat : beach.lat,
						lng : beach.lon
					},
					map : map,
					icon : image,
					shape : shape,
					title : beach.name,
					zIndex : (i + 1)
				});
			}
		}
	})
</script>

<title>날씨</title>

</head>
<body>
	<div class="wrapper">
		<div class="sidebar" data-background-color="white"
			data-active-color="danger">
			<div class="sidebar-wrapper">
				<div class="logo">
					<a href="http://www.creative-tim.com" class="simple-text">
						Doobalro </a>
				</div>

				<ul class="nav">
					<li class="active"><a href="weatherList.do"> <i
							class="ti-shine"></i>
							<p>날씨</p>
					</a></li>
					<li><a href="air.jsp"> <i class="ti-cloud"></i>
							<p>대기질</p>
					</a></li>
					<li><a href="accident.jsp"> <i class="ti-bar-chart "></i>
							<p>자전거 사고</p>
					</a></li>
					<li><a href="Bike.do"> <i class="ti-direction "></i>
							<p>전국 거치소 현황</p>
					</a></li>
					<li><a href="./listBoard.do"> <i class="ti-comment"></i>
							<p>게시판</p>
					</a></li>
					<li><a href="maps.html"> <i class="ti-map"></i>
							<p>지도</p>
					</a></li>
				</ul>
			</div>
		</div>

		<div class="main-panel">
			<!-- 우측 상단 내비게이션 바 -->
			<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar bar1"></span> <span class="icon-bar bar2"></span>
						<span class="icon-bar bar3"></span>
					</button>
					<a class="navbar-brand" href="#">Weather</a>
				</div>
			</div>
			</nav>

			<!-- 본문 내용 삽입 구간 -->
			<div class="content">
				<div class="container-fluid">
					<div class="card card-map">
						<div class="header">
							<h4 class="title">Google Maps</h4>
						</div>
						<div class="map">
							<div id="map"></div>
						</div>
					</div>
				</div>
			</div>
			<footer class="footer">
			<div class="container-fluid">
				<nav class="pull-left">
				<ul>
					<li><a href="http://www.google.com"> Google </a></li>
					<li><a href="http://www.naver.com"> Naver </a></li>
					<li><a href="http://www.naver.com"> 차재민 </a></li>
				</ul>
				</nav>
			</div>
			</footer>

		</div>
	</div>
</body>


</html>