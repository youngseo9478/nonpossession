package com.dobalro.biz.board.service;

import java.util.List;

import com.dobalro.biz.board.vo.BoardVO;


public interface BoardService {
	
	public int insertBoard(BoardVO vo);

	public int deleteBoard(int num);

	public int updateBoard(BoardVO vo);

	public List<BoardVO> searchAllBoard(String id);

	public BoardVO findBoard(int num);

	public List<BoardVO> searchBoard(String condition, String keyword);

}
