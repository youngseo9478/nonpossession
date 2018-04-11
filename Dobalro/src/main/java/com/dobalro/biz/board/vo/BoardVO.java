package com.dobalro.biz.board.vo;
import java.util.Date;

public class BoardVO {

	private String board_num; // VARCHAR2(8)   NOT NULL, -- board_num
	private String user_num; //  VARCHAR2(8)   NOT NULL, -- user_num
	private String user_yn; //   VARCHAR2(1)   NOT NULL, -- user_yn
	private String btitle; //	  VARCHAR2(30)  NOT NULL, -- btitle
	private String bcontent; //  VARCHAR2(200) NOT NULL, -- bcontent
	private Date bdate;     // DATE          NOT NULL  -- bdate
	
	public BoardVO() {
	}

	public BoardVO(String board_num, String user_num, String user_yn, String btitle, String bcontent, Date bdate) {
		super();
		this.board_num = board_num;
		this.user_num = user_num;
		this.user_yn = user_yn;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate = bdate;
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

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	@Override
	public String toString() {
		return "BoardVO [board_num=" + board_num + ", user_num=" + user_num + ", user_yn=" + user_yn + ", btitle="
				+ btitle + ", bcontent=" + bcontent + ", bdate=" + bdate + "]";
	}
	
	
}
