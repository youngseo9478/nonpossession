<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script language="JavaScript">
	//post방식
	function updateReply() {
	 	f1.action = "updateReply.do";
		f1.submit();
			
	}


</script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="apple-touch-icon" sizes="76x76"
	href="assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>게시물 작성</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />

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
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="js/board.js"></script> -->
</head>
<body>
	<div class="wrapper">
		<jsp:include page="menu.jsp" />

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
					<a class="navbar-brand" href="#">Board</a>
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
									<h4 class="title">게시물 상세보기</h4>
									<br>
								</div>
								<div class="content table-responsive">
									<input id="boardNum" type="hidden" name="boardNum"
										value="${board.boardNum }"> <input id="UserName"
										type="hidden" name="userName" value="${user.userName }">
									<input id="boardWriter" type="hidden" name="boardWriter"
										value="${board.boardWriter }">
									<form action="updateBoardForm.do">
										<table class="table table-striped">
											<tr>
												<td width="10%" bgcolor="E6FFEF">제목</td>
												<td id="title" colspan="3">${board.boardTitle }</td>

											</tr>
											<tr>
												<td width="10%" bgcolor="E6FFEF">작성자</td>
												<td width="40%">${board.boardWriter}</td>
												<td width="10%" bgcolor="E6FFEF">작성일</td>
												<td width="40%">${board.boardDate}</td>
											</tr>
											<tr>
												<td bgcolor="E6FFEF">내용</td>
												<td colspan="3">${board.boardContent}</td>
											</tr>
											<tr>
												<td colspan="4" align="center"><a type="button"
													href="./listBoard.do" class="btn btn-info btn-fill btn-wd">뒤로</a>
													<c:set var="userName" value="${user.userName }"/>
													<c:choose>
														<c:when test="${board.boardWriter eq userName}">
															<a type='button' class='btn btn-info btn-fill btn-wd'
																href="./updateBoardForm.do?boardNum=${board.boardNum }">수정</a>
															<a type='button' class='btn btn-info btn-fill btn-wd'
																href="./deleteBoard.do?boardNum=${board.boardNum }" >삭제</a>
														</c:when>
													</c:choose>
													
												</td>
											</tr>
										</table>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--댓글  -->

				
			
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-11">
							<div class="card">
								<div class="header">
									<h4 class="title">댓글</h4>
									<br>
								</div>
								
								<div class="content table-responsive">
									<input id="boardNum" type="hidden" name="boardNum"
										value="${board.boardNum }"> <input id="UserName"
										type="hidden" name="userName" value="${user.userName }">
									<input id="boardWriter" type="hidden" name="boardWriter"
										value="${board.boardWriter }">
										
											
																		
										<!-- <table class="table table-striped"> -->
										<table>
											<tr>
													<td width="10%" bgcolor="E6FFEF">작성자</td>
													<td width="50%" bgcolor="E6FFEF">내  용</td>
													<td width="25%" bgcolor="E6FFEF">날  짜</td>
													<td width="10%" bgcolor="E6FFEF">수정</td>
													<td width="10%" bgcolor="E6FFEF">삭제</td>
												
											</tr>
											<%-- <td>${replys}</td> --%>
												
											 <c:forEach items="${replys}" var="reply">
										
										
											<tr>																							
												 
													<td width="10%">${reply.replyWriter} </td>
													
													<!--자기댓글 -->
													<c:if test="${reply.replyWriter == user.userName}">
														<td width="50%">
													<form action="updateReply.do" method="post">
														<input id="updatereplyContent" name="updatereplyContent" type="text" value="${reply.replyContent}" > </td>
																									
														</c:if>
														<!-- 상대댓글 -->
														<c:if test="${reply.replyWriter != user.userName}">
															<td width="50%">${reply.replyContent}</td>
														</c:if>
														<td width="25%">${reply.replyDate} </td>
														<c:if test="${reply.replyWriter == user.userName}">													
																				
																																						
														 <input type="hidden"  name="replyNum1" value="${reply.replyNum}">
														 <input id="boardNum" type="hidden" name="boardNum"	value="${board.boardNum }">
																							
		 												<td width="10%"> 		
		 																						 
		 												<input type="submit" class="btn btn-info btn-fill btn-sm" value="수정" ></td>
	 												</form>
													<td width="10%">
													<input type="button" class="btn btn-info btn-fill btn-sm" value="삭제" onclick="location.href='deleteReply.do?replyNum=${reply.replyNum}&boardNum=${board.boardNum}'"></td>													
																										
													</c:if>
													
											</c:forEach>
											</tr>
											 
											
										</table> 
										
										<br><br><hr>
										<form action="addReply.do" method="POST">
										<input id="boardNum" type="hidden" name="boardNum"
										value="${board.boardNum }"> <input id="UserName"
										type="hidden" name="userName" value="${user.userName}">
										
										<table>	
											<tr>
												<td width="40%" bgcolor="E6FFEF">작성자</td>
												<td width="40%" bgcolor="E6FFEF">내  용</td>
												<td width="20%" bgcolor="E6FFEF"></td>
												
											</tr>
											<tr>
												<td width="10%"><label>${user.userName}</label></td>
												<td width="40%"><input type="text" name="replyContent"></td>										
												<td><input type="submit" class="btn btn-info btn-fill btn-sm" value="등록"></td>			
											</tr>							
										</table>
										
									</div>
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