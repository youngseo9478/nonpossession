package com.doobalro.my.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doobalro.my.biz.server.service.BoardService;
import com.doobalro.my.biz.server.service.ReplyService;
import com.doobalro.my.biz.server.service.UserService;
import com.doobalro.my.biz.server.vo.BoardVO;
import com.doobalro.my.biz.server.vo.ReplyVO;
import com.doobalro.my.biz.server.vo.UserVO;

@Controller
public class UBRController {
	/*
	 * 1. 蹂대뱶 delete update 由ы뵆 delete update ====> 而⑦듃濡ㅻ윭 �뵶�뿉�꽌 �쑀�� 泥댄겕 2. �쑀��
	 * �뾽�뜲�씠�듃 �떆(�씠由�) �뿰愿��맂 蹂대뱶 諛� �뙎湲� �옉�꽦�옄 �씠由� �닔�젙 �븘�슂
	 */
	// Reply
	SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd-HH-mm", Locale.KOREA);
	Date Time = new Date();
	String nowTime = fm.format(Time);

	@Resource(name = "ReplyService")
	ReplyService ReplyService;
	@Resource(name = "BoardService")
	BoardService BoardService;
	@Resource(name = "UserService")
	UserService UserService;

	@RequestMapping("introduction.do")
	public String introductionForm() {
		return "introduction";
	}

	@RequestMapping("/loginForm.do") // 濡쒓렇�씤 �럹�씠吏�濡�
	public String loginForm() {
		return "login";
	}

	@RequestMapping("/adduserForm.do") // �쉶�썝媛��엯 �럹�씠吏�濡�
	public String adduserForm() {
		return "adduser";
	}

	@RequestMapping("/updateUserForm.do") // 嚥≪뮄�젃占쎌뵥 占쎈읂占쎌뵠筌욑옙嚥∽옙
	public String updateUser() {
		return "updateUserForm";
	}

	@RequestMapping("/userUpdateForm.do") // �쉶�썝�닔�젙 �럹�씠吏�濡�
	public String userUpdateForm() {
		return "redirect:userUpdateForm.jsp";
	}

	@RequestMapping("/pwFindForm.do") // 鍮꾨�踰덊샇李얘린 �럹�씠吏�濡�
	public String pwFindForm() {
		return "pwFindForm";
	}

	@RequestMapping("/addBoardForm.do") // 寃뚯떆臾� �옉�꽦 �럹�씠吏�濡�
	public String addBoardForm() {
		return "addBoardForm";
	}

	@RequestMapping("/updateBoardForm.do") // 寃뚯떆臾� �닔�젙 �럹�씠吏�濡�
	public ModelAndView updateBoardForm(int boardNum) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", BoardService.getBoard(boardNum));
		// mav.addObject("board", req.getAttribute("board"));
		mav.setViewName("updateBoardForm"); // 0425
		return mav;
	}

	////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/login.do", method = RequestMethod.POST) // 嚥≪뮄�젃占쎌뵥
	public ModelAndView login(HttpServletRequest req, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		UserVO uvo = new UserVO();
		uvo.setUserPhone(req.getParameter("userPhone"));
		uvo.setUserPw(req.getParameter("userPw"));

		String result = UserService.login(uvo);
		if (result.equals("로그인 성공")) {
			uvo = UserService.getUser(uvo);
			session.setAttribute("user", uvo); // 이거 꼭 수정
			System.out.println(uvo);
			mav.setViewName("Bike");

		} else {
			mav.setViewName("login");
		}

		mav.addObject("result", result);

		return mav;
	}

	@RequestMapping("/logout.do") // 嚥≪뮄�젃占쎈툡占쎌뜍
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		session.removeAttribute("user");

		mav.setViewName("login");

		return mav;
	}

	@RequestMapping(value = "/addUser.do", method = RequestMethod.POST) // 占쎌돳占쎌뜚揶쏉옙占쎌뿯
	public ModelAndView addUser(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		UserVO uvo = new UserVO();

		uvo.setUserName(req.getParameter("userName"));
		uvo.setUserPhone(req.getParameter("userPhone"));
		uvo.setUserPw(req.getParameter("userPw"));
		uvo.setUserBirth(req.getParameter("userBirth"));

		System.out.println(uvo);

		String result = UserService.addUser(uvo);
		System.out.println(result);
		mav.addObject("result", result);
		mav.setViewName("redirect:loginForm.do");
		return mav;
	}

	@RequestMapping(value = "/updateUser.do") // 占쎌돳占쎌뜚 占쎈땾占쎌젟 !!!!
	public ModelAndView updateUser(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		UserVO uvo = (UserVO) req.getAttribute("user");
		String beforeName = uvo.getUserName();
		BoardVO bvo = new BoardVO();
		bvo.setUserNum(uvo.getUserNum());
		bvo.setBoardWriter(req.getParameter("userName"));
		uvo.setUserPw(req.getParameter("userPw"));
		uvo.setUserName(req.getParameter("userName"));
		uvo.setUserPhone(req.getParameter("userPhone"));

		String result = UserService.updateUser(uvo);
		if (result.equals("수정되었습니다.")) {
			BoardService.synchroBoard(bvo);
			ReplyService.synchroReply(uvo.getUserName(), beforeName);
		}

		mav.addObject("result", result);
		mav.setViewName("updateUser");
		return mav;
	}

	@RequestMapping(value = "/findPw.do") // 鍮꾨�踰덊샇 李얘린
	public ModelAndView pwFind(HttpServletRequest req) {
		System.out.println("+++++++++++++비밀번호찾기");
		ModelAndView mav = new ModelAndView();
		UserVO uvo = new UserVO();
		uvo.setUserPhone(req.getParameter("userPhone"));
		uvo.setUserBirth(req.getParameter("userBirth"));
		System.out.println(uvo);

		String result = UserService.pwFind(uvo);
		System.out.println("result" + result);
		if (result != null) {
			mav.addObject("userName", result);
			mav.setViewName("pwChange");
			return mav;
		}
		System.out.println(result);
		mav.addObject("result", result);
		mav.setViewName("redirect:login");
		return mav;
	}

	@RequestMapping(value = "/changePw.do") // 鍮꾨�踰덊샇 李얘린
	public String pwChange(HttpServletRequest req) {
		System.out.println("+++++++++++++비밀번호 변경");
		ModelAndView mav = new ModelAndView();
		UserVO uvo = new UserVO();

		String userPw = req.getParameter("userPw");
		String userPw2 = req.getParameter("userPw2");
		String userName = req.getParameter("userName");
		System.out.println("username" + userName);
		System.out.println(userPw + userPw2);

		if (!(userPw.equals(userPw2))) {
			System.out.println("비밀번호 불일치");
			return "pwFindForm";
		} else {
			System.out.println("비밀번호 변경하기");
			uvo.setUserPw(userPw);
			uvo.setUserName(userName);
			System.out.println("uvo 값확인" + uvo);
			UserService.changePw(uvo);
			System.out.println("uvo 값확인2뚜뚠");
			return "login";
		}
	}

	@RequestMapping(value = "/deleteUser.do") // 占쎌돳占쎌뜚 占쎄퉱占쎈닚
	public ModelAndView deleteUser(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		UserVO uvo = (UserVO) req.getAttribute("user");
		String result = UserService.deleteUser(uvo);
		mav.addObject("result", result);
		mav.setViewName("redirect:index.jsp");
		return mav;
	}

	@RequestMapping(value = "/addReply.do", method = RequestMethod.POST)
	public ModelAndView addReply(HttpServletRequest req) {
		ReplyVO rvo = new ReplyVO();
		BoardVO bvo = (BoardVO) req.getAttribute("board");
		UserVO uvo = (UserVO) req.getAttribute("user");
		rvo.setBoardNum(bvo.getBoardNum());
		rvo.setReplyWriter(uvo.getUserName());
		rvo.setReplyContent(req.getParameter("replyContent"));
		rvo.setReplyDate(nowTime); // �떆媛� 泥댄겕
		ReplyService.addReply(rvo);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoard.do"); // �빐�떦 寃� 蹂대뱶濡�~

		return mav;
	}

	@RequestMapping(value = "/deleteReply.do", method = RequestMethod.POST)
	public ModelAndView deleteReply(HttpServletRequest req) {
		ReplyVO rvo = this.getReply((Integer.parseInt(req.getParameter("replyNum"))));

		if (rvo.getReplyWriter().equals(((UserVO) req.getAttribute("user")).getUserName())) {
			ReplyService.deleteReply(rvo);
			req.setAttribute("result", "�궘�젣 �꽦怨�");
		} else {
			req.setAttribute("result", "�궘�젣 �떎�뙣");
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoard.do"); // �빐�떦 寃� 蹂대뱶濡�~

		return mav;
	}

	@RequestMapping(value = "/updateReply.do", method = RequestMethod.POST)
	public ModelAndView updateReply(HttpServletRequest req) {
		ReplyVO rvo = this.getReply((Integer.parseInt(req.getParameter("replyNum"))));
		UserVO uvo = (UserVO) req.getAttribute("user");

		if (rvo.getReplyWriter().equals(uvo.getUserName())) {
			rvo.setReplyNum(Integer.parseInt(req.getParameter("replyNum")));
			rvo.setReplyContent(req.getParameter("replyContent"));
			rvo.setReplyWriter(uvo.getUserName());
			rvo.setReplyDate(nowTime); // �떆媛�
			ReplyService.updateReply(rvo);
			req.setAttribute("result", "�닔�젙 �꽦怨�");
		} else {
			req.setAttribute("result", "�닔�젙 �떎�뙣");
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName(""); // �빐�떦 寃� 蹂대뱶濡�~

		return mav;
	}

	public List<ReplyVO> getAllReply(int boardNum) {
		ReplyVO rvo = new ReplyVO();
		rvo.setBoardNum(boardNum);
		return ReplyService.getAllReply(rvo);
	}

	public ReplyVO getReply(int replyNum) {
		return ReplyService.getReply(replyNum);
	}

	@RequestMapping("/listBoard.do")
	public ModelAndView getAllBoard() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", BoardService.getAllBoard()); // �븷�듃由щ럭�듃�꽕�엫 board濡� �빐�빞�븯�굹 ?
		mav.setViewName("boardList");
		return mav;
	}

	@RequestMapping(value = "/searchBoard.do", method = RequestMethod.POST)
	public ModelAndView searchBoard(String condition, String keyword) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", BoardService.searchBoard(condition, keyword));
		mav.setViewName("boardList");
		return mav;
	}

	@RequestMapping("/getBoard.do")
	public ModelAndView getboard(int boardNum) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", BoardService.getBoard(boardNum));
		mav.addObject("replys", this.getAllReply(boardNum));
		mav.setViewName("board");
		return mav;
	}

	@RequestMapping(value = "/addBoard.do")
	public ModelAndView addboard(HttpServletRequest req, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		BoardVO bvo = new BoardVO();
		UserVO uvo = (UserVO) session.getAttribute("user");
		bvo.setBoardContent(req.getParameter("boardContent"));
		bvo.setBoardDate(nowTime);
		bvo.setBoardTitle(req.getParameter("boardTitle"));
		bvo.setBoardWriter(req.getParameter("boardWriter"));
		bvo.setUserNum(uvo.getUserNum());
		BoardService.addBoard(bvo);
		mav.setViewName("redirect:listBoard.do");
		return mav;
	}

	@RequestMapping(value = "/updateBoard.do", method = RequestMethod.POST)
	public ModelAndView updateboard(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		BoardVO bvo = new BoardVO();
		bvo.setBoardContent(req.getParameter("boardContent"));
		bvo.setBoardTitle(req.getParameter("boardTitle"));
		bvo.setBoardDate(nowTime);
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		bvo.setBoardNum(boardNum);
		BoardService.updateBoard(bvo);
		mav.addObject("board", BoardService.getBoard(boardNum));
		mav.setViewName("board");
		// mav.setViewName("redirect:listBoard.do");
		return mav;// �닔�젙�쓣 �솗�씤�븯�젮硫� �떎�떆 �겢由��빐 �뱾�뼱媛��빞�빐�꽌 踰덇굅濡�湲댄븳�뜲..萸�..�뀕
	}

	@RequestMapping(value = "/deleteBoard.do")
	public ModelAndView deleteboard(int boardNum) {
		ModelAndView mav = new ModelAndView();
		BoardService.deleteBoard(boardNum);
		mav.setViewName("redirect:listBoard.do");
		return mav;
	}

}
