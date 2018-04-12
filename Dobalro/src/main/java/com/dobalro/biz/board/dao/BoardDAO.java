package com.dobalro.biz.board.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dobalro.biz.board.vo.BoardVO;
import com.dobalro.biz.mybatis.mapper.BoardMapper;

@Component("boardDAO")
public class BoardDAO implements DobalroBoardDAO {
	@Autowired
	SqlSession mybatis;
	BoardMapper mapper;
	
	@PostConstruct
	
	public void init(){
		mapper = (BoardMapper) mybatis.getMapper(BoardMapper.class);
	}
	
	@Override
	public int inserBoard(BoardVO vo) {
		
		return mapper.insertBoard(vo);
	}

	@Override
	public int updateBoard(BoardVO vo) {
		return mapper.updateboard(vo);
	}

	@Override
	public List<BoardVO> searchAllBoard(String id) {
		return mapper.selectallboard(id);
	}

	@Override
	public BoardVO findBoard(int num) {
		return mapper.findboard(num);
	}

	@Override
	public List<BoardVO> searchBoard(String condition, String keyword) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("condition", condition);
		map.put("keyword", keyword);
		return mapper.searchboard(map);
	}

	@Override
	public int deleteBoard(int num) {
		// TODO Auto-generated method stub
		return mapper.deleteboard(num);
	}


}
