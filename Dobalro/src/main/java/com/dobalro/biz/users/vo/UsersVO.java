package com.dobalro.biz.users.vo;

public class UsersVO {

	private String user_num; // VARCHAR2(8)  NOT NULL, -- user_num
	private String phone; //   VARCHAR2(11) NOT NULL, -- phone
	private String pw; //      VARCHAR2(15) NOT NULL, -- pw
	private String nickname; // VARCHAR2(10) NOT NULL  -- nickname
	
	public UsersVO() {
		super();
	}

	public UsersVO(String user_num, String phone, String pw, String nickname) {
		super();
		this.user_num = user_num;
		this.phone = phone;
		this.pw = pw;
		this.nickname = nickname;
	}

	public String getUser_num() {
		return user_num;
	}

	public void setUser_num(String user_num) {
		this.user_num = user_num;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "UsersVO [user_num=" + user_num + ", phone=" + phone + ", pw=" + pw + ", nickname=" + nickname + "]";
	}

	

}