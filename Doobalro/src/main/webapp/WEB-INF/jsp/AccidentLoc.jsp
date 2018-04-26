<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="apple-touch-icon" sizes="76x76"
	href="assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96"
	href="assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>시간대별 사고통계</title>

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
<script type="text/javascript">
function checkit(form) {
    if (form.accident[0].checked == true) {
    	f.action = "AccidentTime.do";
    	f.submit();
    }else{
    	f.action = "AccidentLoc.do";
    	f.submit();
    }
}
</script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="menu.jsp" />
		<div class="main-panel" ">
			<!-- 우측 상단 내비게이션 바 -->
			<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header" >
					<button type="button" class="navbar-toggle">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar bar1"></span> <span class="icon-bar bar2"></span>
						<span class="icon-bar bar3"></span>
					
				</div>
			</div>
			</nav>
		<div style="padding-top: 8em;">
		<form action="" name="f">
		<input type="radio" name="accident" value="시간" />시간
		<input type="radio" name="accident" checked="checked" value="지역" />지역
		<input type="button" value="조회" onclick="checkit(this.form)"/>
		</form>
			<!-- 본문 내용 삽입 구간 -->
			<table width="90%" height="85%" cellspacing="0" cellpadding="0" border="1"  align="center" >
				<tr align="center">
					<th style="text-align: center;" colspan=2  align="center">시간대별 사고 통계</th>
				</tr>
				<tr height="20px">
					<td  align="center">시간대별 사고 백분율</td>
				</tr>
				<tr height="360px" >
					<td width="25%" height="360"  align="center">
						<img src="./image/loc_accident.jpg" width="800px" height="600px">
					</td>
					</tr>
			</table>
			</div>
		</div>
	</div>
	
</body>
</html>