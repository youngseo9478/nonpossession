<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>회원가입</title>
<link rel="stylesheet" href="./css/style.css">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="js/adduser.js?ver=2"></script>
</head>
<form name = "f" action="addUser.do" method="post">
	<div class="container-scroller" style="background: gray;">
		<div class="container-fluid page-body-wrapper" style="width: 80em; align-content: center;">
			<div class="row">
				<div class="content-wrapper full-page-wrapper d-flex align-items-center auth-pages">
					<div class="card col-lg-4 mx-auto">
						<div class="card-body px-5 py-5">
							<h3 class="card-title text-left mb-3">회원가입</h3>
							<div class="form-group">
							
								<label>phone number *</label> <input type="text"
									class="form-control p_input" id="userPhone" name="userPhone">
								 <input type="button" class="btn btn-primary" value="중복체크" onclick="cheakid()">
								 ${idck}

							</div>
							<div class="form-group">
								<label>이름</label>
								<input type="text" 	class="form-control p_input" id="userName" name="userName"> 
							</div> 
			
							<div class="form-group">
								<label>Password *</label> <input type="password"
									class="form-control p_input" name="userPw">
							</div>
							<div class="form-group">
								<label>birth *</label> <input type="text"
									class="form-control p_input"  name="userBirth">
							</div>

							<div class="text-center">
						<input type="submit" value="회원가입"	class="btn btn-primary btn-block enter-btn"	onclick="if(!adduserSubmit(this.form)){return false;}">
						<input type="button" value="취소" class="btn btn-primary btn-block enter-btn"	 onclick="loginpage()">
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
</body>
</html>