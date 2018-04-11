package com.dobalro.biz.users.service;

import java.util.List;

import com.dobalro.biz.board.vo.BoardVO;
import com.dobalro.biz.users.vo.UsersVO;


public interface UserService {
	
	int insertUser(UsersVO vo);
	UsersVO updateUser(UsersVO vo);
	UsersVO login(UsersVO vo);
	boolean pwFind(UsersVO vo);
	
}
