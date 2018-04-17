package com.dobalro.biz.user.dao;

import com.dobalro.biz.users.vo.UsersVO;

public interface UsersDAO {
	
	int insertUser(UsersVO vo);
	UsersVO updateUser(UsersVO vo);
	UsersVO login(UsersVO vo);
	UsersVO logout(UsersVO vo);
	boolean pwFind(UsersVO vo);
	
	
}
