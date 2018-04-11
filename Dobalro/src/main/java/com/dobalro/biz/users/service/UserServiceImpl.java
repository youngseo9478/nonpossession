package com.dobalro.biz.users.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dobalro.biz.board.dao.DobalroBoardDAO;
import com.dobalro.biz.board.vo.BoardVO;


@Service("usersservice")

public class UserServiceImpl implements UserService {

	@Resource(name="UserDAO")
	DobalroBoardDAO dao;
	
	
	@Override
	public int insertBoard(BoardVO vo) {
		return dao.inserBoard(vo); 
	}

	@Override
	public int deleteBoard(int num) {
		return dao.deleteBoard(num);
	}

	@Override
	public int updateBoard(BoardVO vo) {
			return dao.updateBoard(vo);
	}

	@Override
	public List<BoardVO> searchAllBoard(String id) {
		return dao.searchAllBoard(id);
	}

	@Override
	public BoardVO findBoard(int num) {

		return dao.findBoard(num);
	}

	@Override
	public List<BoardVO> searchBoard(String condition, String keyword) {
	
		return dao.searchBoard(condition, keyword);
	}
	


}
