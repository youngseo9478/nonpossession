-- users
CREATE TABLE users (
	user_num VARCHAR(8)  NOT NULL, -- user_num
	nickname VARCHAR(10) NOT NULL, -- nickname
	phone    VARCHAR(11) NOT NULL, -- phone
	pw       VARCHAR(15) NOT NULL  -- pw
);

-- reply
CREATE TABLE reply (
	reply_num  VARCHAR(4)   NOT NULL, -- reply_num
	board_num  VARCHAR(4)   NOT NULL, -- board_num
	reply_text VARCHAR(200) NOT NULL, -- reply_text
	replyer    VARCHAR(8)   NOT NULL, -- replyer
	rdate      DATE         NOT NULL  -- rdate
);

-- board
CREATE TABLE board (
	board_num     VARCHAR(8)   NOT NULL, -- board_num
	user_num      VARCHAR(8)   NOT NULL, -- user_num
	board_title   VARCHAR(30)  NOT NULL, -- board_title
	board_content VARCHAR(200) NOT NULL, -- board_content
	board_date    DATE         NOT NULL, -- board_date
	viewcnt       INTEGER      NOT NULL  -- viewcnt
);