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

<title>게시판</title>

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

</head>
<body>
	<div class="wrapper">
		<div class="sidebar" data-background-color="white"
			data-active-color="danger">

			<!--
		Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
		Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
	-->
			<div class="sidebar-wrapper">
				<div class="logo">
					<a href="http://www.creative-tim.com" class="simple-text">
						Doobalro </a>
				</div>

				<ul class="nav">
					<li><a href="weather.jsp"> <i class="ti-shine"></i>
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
					<li class="active"><a href="./listBoard.do"> <i
							class="ti-comment"></i>
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
					<a class="navbar-brand" href="#">Board List</a>
				</div>
			</div>
			</nav>

			<!-- 본문 내용 삽입 구간 -->
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-11">
							<div class="card">
								<div class="header">
									<h4 class="title">게시판</h4>
									<p class="category">대리 대여/반납 커뮤니티 입니다.</p>
									<br>
									<form action="searchBoard.do" method="post">
										<table  align="center">
											<tr>
												<td ><select name="condition">
														<option value="boardTitle">제목</option>
														<option value="boardContent">내용</option>
														<option value="boardWriter">작성자</option>
												</select> <input name="keyword" type="text"> <input
													type="submit" value="검색"></td>
											</tr>
										</table>
									</form>
								</div>
								<div class="content table-responsive table-full-width">
									<table class="table table-striped">
										<thead>
											<th>#</th>
											<th>제목</th>
											<th>글쓴이</th>
											<th>조회수</th>
											<th>날짜</th>
											<!-- <th>Country</th>
											<th>City</th> -->
										</thead>
										<tbody>
											<c:forEach var="data" items="${boardList}" varStatus="status">
												<tr>
													<td>${status.count }</td>
													<td><a href="./getBoard.do?boardNum=${data.boardNum}">
															${data.boardTitle } [${data.boardRCnt}] </a></td>
													<td>${data.boardWriter }</td>
													<td>${data.boardCnt}</td>
													<td>${data.boardDate}</td>
												</tr>
											</c:forEach>
										</tbody>
										<tfoot>
											<tr>
												<td colspan="5" align="right"><input type="button"
													class="btn btn-info btn-fill btn-wd" value="새글 작성"
													onclick="location.href='addBoardForm.do'"></td>
											</tr>
										</tfoot>
									</table>
								</div>
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