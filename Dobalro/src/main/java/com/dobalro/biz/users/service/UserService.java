package com.dobalro.biz.users.service;

import java.util.List;

import com.dobalro.biz.board.vo.BoardVO;


public interface UserService {
	
	public int insertBoard(BoardVO vo);

	public int deleteBoard(int num);

	public int updateBoard(BoardVO vo);

	public List<BoardVO> searchAllBoard(String id);

	public BoardVO findBoard(int num);

	public List<BoardVO> searchBoard(String condition, String keyword);

}
