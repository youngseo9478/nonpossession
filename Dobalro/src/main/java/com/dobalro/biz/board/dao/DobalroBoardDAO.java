package com.dobalro.biz.board.dao;

import java.util.List;

import com.dobalro.biz.board.vo.BoardVO;

public interface DobalroBoardDAO {

	public int inserBoard(BoardVO vo);
	public int updateBoard(BoardVO vo);
	public List<BoardVO> searchAllBoard(String id);
	public BoardVO findBoard(int num);
	public List<BoardVO> searchBoard(String condition, String keyword);
	public int deleteBoard(int num);
}
