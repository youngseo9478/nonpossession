package com.dobalro.biz.reply.dao;

import java.util.List;

import com.dobalro.biz.reply.vo.ReplyVO;

public interface DobalroReplyDAO {
	// 댓글 목록
    public List<ReplyVO> list(Integer board_num);
    // 댓글 입력
    public void create(ReplyVO vo);
    // 댓글 수정
    public void update(ReplyVO vo);
    // 댓글 삭제
    public void delete(Integer rno);
	

}
