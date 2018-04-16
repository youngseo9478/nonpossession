package com.dobalro.biz.reply.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dobalro.biz.reply.dao.DobalroReplyDAO;
import com.dobalro.biz.reply.dao.ReplyDAO;
import com.dobalro.biz.reply.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Inject
	DobalroReplyDAO replyDao;
	
	@Override
	public List<ReplyVO> list(Integer board_num) {
		// TODO Auto-generated method stub
		return replyDao.list(board_num);
	}

	@Override
	public void create(ReplyVO vo) {
		// TODO Auto-generated method stub
		  replyDao.create(vo);
	}

	@Override
	public void update(ReplyVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer reply_num) {
		// TODO Auto-generated method stub
		
	}

}
