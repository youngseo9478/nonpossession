function adduserSubmit(check){
			if(check.userName.value=="")
				{
				alert("이름을 입력 입력하지 않았습니다.")
				check.userName.focus()
				return false;
				}
				
/*			var userNamepattern = /([^가-힣\x20])/;
			 if(!userNamepattern.test(check.userName.value)){
				 alert("이름은 한글만 입력 가능합니다.")
					check.userPhone.focus()
					return false;
			 }
			 */
			 
				if(check.userPhone.value=="")
				{
				alert("핸드폰번호를 입력하지 않았습니다.")
				check.userPhone.focus()
				return false;
				}
				
				if(check.userPw.value=="")
				{
				alert("비밀번호를 입력하지 않았습니다.")
				check.userPw.focus()
				return false;
				}
				
				if(check.userBirth.value=="")
				{
				alert("생년월일을 입력하지 않았습니다.")
				check.userBirth.focus()
				return false;
				}
				document.f.submit()
			}


	function cheakid(){
		f.action = "checkphone.do";
		f.submit();
	}


	function loginpage() {
		f.action = "loginForm.do";
		f.submit();
	}
	
	
	
	