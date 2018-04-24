package com.doobalro.my.biz.server.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.doobalro.my.biz.server.dao.ReplyDAO;
import com.doobalro.my.biz.server.vo.ReplyVO;

@Service("ReplyService")
public class ReplyServiceImpl implements ReplyService{
	@Resource(name = "ReplyDAO")
	ReplyDAO dao;

	@Override
	public void addReply(ReplyVO vo) {
		dao.addReply(vo);
	}

	@Override
	public void deleteReply(ReplyVO vo) {
		dao.deleteReply(vo);
	}

	@Override
	public void updateReply(ReplyVO vo) {
		dao.updateReply(vo);
	}

	@Override
	public ReplyVO getReply(int ReplyNum) {
		return dao.getReply(ReplyNum);
	}

	@Override
	public List<ReplyVO> getAllReply(ReplyVO vo) {
		return dao.getAllReply(vo);
	}

	@Override
	public void synchroReply(String afterName, String beforeName) {
		dao.synchroReply(afterName, beforeName);
	}
}
