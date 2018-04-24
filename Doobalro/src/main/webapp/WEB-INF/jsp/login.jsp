<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <!-- Required meta tags -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>로그인 페이지</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="./css/style.css">
   <script type="text/javascript" src="js/login.js"></script>
</head>

<body>

<body>
<form name="f" method="post" action="login.do">
  <div class="container-scroller" style="background: gray;">
    <div class="container-fluid page-body-wrapper">
      <div class="row">
        <div class="content-wrapper full-page-wrapper d-flex align-items-center auth-pages">
          <div class="card col-lg-4 mx-auto">
            <div class="card-body px-5 py-5">
              <h3 class="card-title text-left mb-3">Login</h3>
            
                <div class="form-group">
                  <label>phone number</label>
                  <input type="text" class="form-control p_input" name="userPhone">
                </div>
                <div class="form-group">
                  <label>Password</label>
                  <input type="password" class="form-control p_input" name="userPw">
                </div>
                <div class="form-group d-flex align-items-center justify-content-between">
                                 <a href="adduserForm.do"> 회원가입 </a>
                                 <a href="pwFindForm.do" class="forgot-pass">비밀번호 찾기</a>
                </div>
                <div class="text-center">
					<input type="submit" value="로그인" class="btn btn-primary btn-block enter-btn"/>
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

</body>
</html>