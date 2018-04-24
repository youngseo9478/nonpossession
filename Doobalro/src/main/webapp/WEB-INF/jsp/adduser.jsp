<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>회원가입</title>
<link rel="stylesheet" href="./css/style.css">
<script language="JavaScript">
	//post방식
	function userCreate() {
	 	f.action = "addUser.do";
		f.submit();
	}

	function loginpage() {
		f.action = "loginForm.do";
		f.submit();
	}
</script>
</head>
<form name="f" action="" method="post">
<div class="container-scroller" style="background: gray;">
	<div class="container-fluid page-body-wrapper">
		<div class="row">
			<div
				class="content-wrapper full-page-wrapper d-flex align-items-center auth-pages">
				<div class="card col-lg-4 mx-auto">
					<div class="card-body px-5 py-5">
						<h3 class="card-title text-left mb-3">회원가입</h3>
					
							<div class="form-group">
								<label>이름</label> <input type="text"
									class="form-control p_input" name="userName">
							</div>
							<div class="form-group">
								<label>phone number *</label> <input type="text"
									class="form-control p_input" name="userPhone">
							</div>
							<div class="form-group">
								<label>Password *</label> <input type="password"
									class="form-control p_input" name="userPw">
							</div>
							<div class="form-group">
								<label>birth *</label> <input type="text"
									class="form-control p_input" name="userBirth">
							</div>
							
							      <div class="text-center">
				<input type="button" value="회원가입"  class="btn btn-primary btn-block enter-btn" onclick="userCreate()">
                <input type="button" value="취소"  class="btn btn-primary btn-block enter-btn" onclick="loginpage()">
                        
                </div>
            
					</div>
				</div>
			</div>
			<!-- content-wrapper ends -->
		</div>
		<!-- row ends -->
	</div>
	<!-- page-body-wrapper ends -->
</div>
</form>
</body>
</html>