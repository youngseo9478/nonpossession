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
<title>�ð��뺰 ������</title>
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
		} else {
			f.action = "AccidentLoc.do";
			f.submit();
		}
	}
</script>

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
					<li><a href="weatherList.do"> <i class="ti-shine"></i>
							<p>����</p>
					</a></li>
					<li><a href="air.jsp"> <i class="ti-cloud"></i>
							<p>�����</p>
					</a></li>
					<li class="active"><a href="creAccident.do"> <i
							class="ti-bar-chart "></i>
							<p>������ ���</p>
					</a></li>
					<li><a href="Bike.do"> <i class="ti-direction "></i>
							<p>���� ��ġ�� ��Ȳ</p>
					</a></li>
					<li><a href="./listBoard.do"> <i class="ti-comment"></i>
							<p>�Խ���</p>
					</a></li>
					<li><a href="maps.html"> <i class="ti-map"></i>
							<p>����</p>
					</a></li>
				</ul>
			</div>
		</div>
		<div class="main-panel"">
			<!-- ���� ��� ������̼� �� -->
			<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar bar1"></span> <span class="icon-bar bar2"></span>
						<span class="icon-bar bar3"></span>
					</button>
					<a class="navbar-brand" href="#">Accident</a>
				</div>
			</div>
			</nav>
			<div style="padding-top: 8em;">
				<div style="padding-left: 1em;">
					<form action="" name="f">
						<input type="radio" name="accident" checked="checked" value="�ð�" />�ð�
						<input type="radio" name="accident" value="����" />���� <input
							type="button" class="btn btn-info btn-fill btn-sm" value="��ȸ"
							onclick="checkit(this.form)" />
					</form>
				</div>
				<!-- ���� ���� ���� ���� -->
				<table width="50%" height="50%" cellspacing="0" cellpadding="0"
					border="1" align="center">
					<tr align="center">
						<th style="text-align: center;" colspan=2 align="center">�ð��뺰
							��� ���</th>
					</tr>
					<tr height="20px">
						<td align="center">�ð��뺰 ��� �����</td>
						<td align="center">�ð��뺰 ��� �Ǽ�</td>
					</tr>
					<tr height="360px">
						<td width="25%" height="360" align="center"><img
							src="./image/time01_accident.jpg" width="500px" height="500px">
						</td>
						<td width="25%" height="360" align="center"><img
							src="./image/time02_accident.jpg" width="500px" height="500px">
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>

</body>
</html>