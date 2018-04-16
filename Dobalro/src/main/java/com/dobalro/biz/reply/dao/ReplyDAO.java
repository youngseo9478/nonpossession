package com.dobalro.biz.reply.dao;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.dobalro.biz.reply.vo.ReplyVO;
import org.apache.ibatis.session.SqlSession;

@Repository
public class ReplyDAO implements DobalroReplyDAO{

	@Inject
	SqlSession mybatis;
	
	@Override
	public List<ReplyVO> list(Integer board_num) {
		return mybatis.selectList("reply.listReply",board_num);
	}

	@Override
	public void create(ReplyVO vo) {
		// TODO Auto-generated method stub
		mybatis.insert("reply.insertReply",vo);
	}

	@Override
	public void update(ReplyVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer rno) {
		// TODO Auto-generated method stub
		
	}

	
	
}
