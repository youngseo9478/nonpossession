package com.dobalro.web.controller;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dobalro.biz.reply.service.ReplyService;
import com.dobalro.biz.reply.vo.ReplyVO;

@RestController
@RequestMapping("/reply/*")
public class ReplyController {
    
    @Inject
    ReplyService replyService;
    
    // 댓글 입력
    @RequestMapping("insert.do")
    public void insert(@ModelAttribute ReplyVO vo, HttpSession session){
        String nickname = (String) session.getAttribute("userId");
        vo.setReply_num(nickname);
        replyService.create(vo);
    }
    
    // 댓글 목록(@Controller방식 : veiw(화면)를 리턴)
    @RequestMapping("list.do")
    public ModelAndView list(@RequestParam int bno, ModelAndView mav){
        List<ReplyVO> list = replyService.list(bno);
        // 뷰이름 지정
        mav.setViewName("board/replyList");
        // 뷰에 전달할 데이터 지정
        mav.addObject("list", list);
        // replyList.jsp로 포워딩
        return mav;
    }
    
    // 댓글 목록(@RestController Json방식으로 처리 : 데이터를 리턴)
    @RequestMapping("listJson.do")
    @ResponseBody // 리턴데이터를 json으로 변환(생략가능)
    public List<ReplyVO> listJson(@RequestParam int bno){
        List<ReplyVO> list = replyService.list(bno);
        return list;
    }
}