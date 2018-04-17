package com.dobalro.biz.users.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dobalro.biz.board.dao.DobalroBoardDAO;
import com.dobalro.biz.users.vo.UsersVO;


@Service("usersservice")

public class UserServiceImpl implements UserService {

	@Resource(name="UserDAO")
	DobalroBoardDAO dao;

	@Override
	public int insertUser(UsersVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UsersVO updateUser(UsersVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsersVO login(UsersVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean pwFind(UsersVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UsersVO logout(UsersVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
