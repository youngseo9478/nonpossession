DROP TABLE replys;
DROP TABLE boards;
DROP TABLE users;

-- user
CREATE TABLE users (
	userNum		NUMBER(8)			PRIMARY KEY,					-- 유저번호
	userName	VARCHAR(40)			UNIQUE,							-- 유저 닉네임
	userPhone	VARCHAR(40)			NOT NULL UNIQUE,				-- 유저 폰번호(id대용)
	userPw		VARCHAR(40)			NOT NULL						-- 유저 비밀번호
);

-- board
CREATE TABLE boards (
	boardNum		NUMBER(8)		PRIMARY KEY,					-- 게시판 번호
	userNum			NUMBER(8)		REFERENCES users(userNum),		-- 게시판 글 쓴 유저의 번호
	boardWriter		VARCHAR(40),									-- 게시판 작성자
	boardTitle		VARCHAR(200),									-- 게시판 제목
	boardContent	VARCHAR(2000),									-- 게시판 내용
	boardDate		VARCHAR(40),									-- 게시판 작성일
	boardCnt		NUMBER(6)		default 0,						-- 게시판 조회수
	boardRCnt		NUMBER(6)		default 0						-- 댓글 수
);

-- reply
CREATE TABLE replys (
	replyNum		NUMBER(8)	PRIMARY KEY,						-- 댓글 번호
	boardNum		NUMBER(8)	REFERENCES boards(boardNum),		-- 댓글이 달린 게시판의 번호
	replyContent	VARCHAR(500),									-- 댓글 내용
	replyWriter		VARCHAR(40),									-- 댓글 작성자
	replyDate		VARCHAR(40)										-- 댓글 작성일
);

