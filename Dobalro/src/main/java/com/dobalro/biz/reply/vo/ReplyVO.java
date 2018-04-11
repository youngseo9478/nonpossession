package com.dobalro.biz.reply.vo;

public class ReplyVO {
	private String reply_num; // VARCHAR2(8)   NOT NULL, -- reply_num
	private String board_num; // VARCHAR2(8)   NOT NULL, -- board_num
	private String user_num; //  VARCHAR2(8)   NOT NULL, -- user_num
	private String user_yn; //   VARCHAR2(1)   NOT NULL, -- user_yn
	private String rcontent; //  VARCHAR2(200) NOT NULL, -- rcontent
	private String rdate; //     DATE          NOT NULL  -- rdate
	
	public ReplyVO() {
		super();
	}

	public ReplyVO(String reply_num, String board_num, String user_num, String user_yn, String rcontent, String rdate) {
		super();
		this.reply_num = reply_num;
		this.board_num = board_num;
		this.user_num = user_num;
		this.user_yn = user_yn;
		this.rcontent = rcontent;
		this.rdate = rdate;
	}

	public String getReply_num() {
		return reply_num;
	}

	public void setReply_num(String reply_num) {
		this.reply_num = reply_num;
	}

	public String getBoard_num() {
		return board_num;
	}

	public void setBoard_num(String board_num) {
		this.board_num = board_num;
	}

	public String getUser_num() {
		return user_num;
	}

	public void setUser_num(String user_num) {
		this.user_num = user_num;
	}

	public String getUser_yn() {
		return user_yn;
	}

	public void setUser_yn(String user_yn) {
		this.user_yn = user_yn;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	@Override
	public String toString() {
		return "ReplyVO [reply_num=" + reply_num + ", board_num=" + board_num + ", user_num=" + user_num + ", user_yn="
				+ user_yn + ", rcontent=" + rcontent + ", rdate=" + rdate + "]";
	}
	
	
}
