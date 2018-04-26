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

	@RequestMapping("/loginForm.do") // 嚥≪뮄�젃占쎌뵥 占쎈읂占쎌뵠筌욑옙嚥∽옙
	public String loginForm() {
		return "login";
	}

	@RequestMapping("/adduserForm.do") // 占쎌돳占쎌뜚揶쏉옙占쎌뿯 占쎈읂占쎌뵠筌욑옙嚥∽옙
	public String adduserForm() {
		return "adduser";
	}

	@RequestMapping("/myinformation.do") // �슖�돦裕꾬옙�쟽�뜝�럩逾� �뜝�럥�쓡�뜝�럩逾좂춯�쉻�삕�슖�댙�삕
	public String updateUser() {
		return "myinformation";
	}

	@RequestMapping("/userUpdateForm.do") // 占쎌돳占쎌뜚占쎈땾占쎌젟 占쎈읂占쎌뵠筌욑옙嚥∽옙
	public String userUpdateForm() {
		return "updateUser";
	}

	@RequestMapping("/pwFindForm.do") // �뜮袁⑨옙甕곕뜇�깈筌≪뼐由� 占쎈읂占쎌뵠筌욑옙嚥∽옙
	public String pwFindForm() {
		return "pwFindForm";
	}

	@RequestMapping("/addBoardForm.do") // 野껊슣�뻻�눧占� 占쎌삂占쎄쉐 占쎈읂占쎌뵠筌욑옙嚥∽옙
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

	@RequestMapping(value = "/login.do", method = RequestMethod.POST) // �슖�돦裕꾬옙�쟽�뜝�럩逾�
	public ModelAndView login(HttpServletRequest req, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		UserVO uvo = new UserVO();
		uvo.setUserPhone(req.getParameter("userPhone"));
		uvo.setUserPw(req.getParameter("userPw"));

		String result = UserService.login(uvo);
		if (result.equals("濡쒓렇�씤 �꽦怨�")) {
			uvo = UserService.getUser(uvo);
			session.setAttribute("user", uvo); // �씠嫄� 瑗� �닔�젙
			System.out.println(uvo);
			mav.setViewName("Bike");

		} else {
			mav.setViewName("login");
		}

		mav.addObject("result", result);

		return mav;
	}

	@RequestMapping("/logout.do") // �슖�돦裕꾬옙�쟽�뜝�럥�닡�뜝�럩�쐨
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		session.removeAttribute("user");

		mav.setViewName("login");

		return mav;
	}
	
	@RequestMapping(value="/checkphone.do", method=RequestMethod.POST)
	public ModelAndView checkId(String id, HttpSession session, HttpServletRequest req) {
		System.out.println("체크아이디 컨트롤");
		ModelAndView mav = new ModelAndView();
		UserVO uvo = new UserVO();
		uvo.setUserPhone(req.getParameter("userPhone"));
		
		System.out.println("유버폰:"+req.getParameter("userPhone"));
			
		boolean result=UserService.checkId(uvo);
		
		System.out.println("result값:"+result);
		if(result) {
			mav.addObject("idck","가입가능한 아이디입니다.");
			
		}
		else {
			mav.addObject("idck","가입불가능한 아이디입니다.");			
		}	
		mav.setViewName("adduser");
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


	@RequestMapping(value = "/updateUser.do") 
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
		if (result.equals("�닔�젙�릺�뿀�뒿�땲�떎.")) {
			BoardService.synchroBoard(bvo);
			ReplyService.synchroReply(uvo.getUserName(), beforeName);
		}

		mav.addObject("result", result);
		mav.setViewName("updateUser");
		return mav;
	}

	@RequestMapping(value = "/findPw.do") // �뜮袁⑨옙甕곕뜇�깈 筌≪뼐由�
	public ModelAndView pwFind(HttpServletRequest req) {
		System.out.println("+++++++++++++鍮꾨�踰덊샇李얘린");
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

	@RequestMapping(value = "/changePw.do") // �뜮袁⑨옙甕곕뜇�깈 筌≪뼐由�
	public String pwChange(HttpServletRequest req) {
		System.out.println("+++++++++++++鍮꾨�踰덊샇 蹂�寃�");
		ModelAndView mav = new ModelAndView();
		UserVO uvo = new UserVO();

		String userPw = req.getParameter("userPw");
		String userPw2 = req.getParameter("userPw2");
		String userName = req.getParameter("userName");
		System.out.println("username" + userName);
		System.out.println(userPw + userPw2);

		if (!(userPw.equals(userPw2))) {
			System.out.println("鍮꾨�踰덊샇 遺덉씪移�");
			return "pwFindForm";
		} else {
			System.out.println("鍮꾨�踰덊샇 蹂�寃쏀븯湲�");
			uvo.setUserPw(userPw);
			uvo.setUserName(userName);
			System.out.println("uvo 媛믫솗�씤" + uvo);
			UserService.changePw(uvo);
			System.out.println("uvo 媛믫솗�씤2�슌�슑");
			return "login";
		}
	}

	@RequestMapping(value = "/deleteUser.do") // �뜝�럩�뤂�뜝�럩�쐸 �뜝�럡�돮�뜝�럥�떄
	public ModelAndView deleteUser(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		UserVO uvo = (UserVO) req.getAttribute("user");
		String result = UserService.deleteUser(uvo);
		mav.addObject("result", result);
		mav.setViewName("redirect:index.jsp");
		return mav;
	}
///////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/addReply.do", method = RequestMethod.POST)
	public ModelAndView addReply(HttpServletRequest req) {
		System.out.println("addreply");
		ReplyVO rvo = new ReplyVO();

		rvo.setBoardNum(Integer.parseInt(req.getParameter("boardNum")));
		rvo.setReplyContent(req.getParameter("replyContent"));
		rvo.setReplyDate(nowTime);
		rvo.setReplyWriter(req.getParameter("userName"));
		
		
		System.out.println("rvo :"+rvo);
		ReplyService.addReply(rvo);
		System.out.println("인설트 성공");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoard.do?boardNum="+req.getParameter("boardNum")); // 占쎈퉸占쎈뼣 野껓옙 癰귣�諭뜻에占�~

		return mav;
	}
	
	
	@RequestMapping(value = "/deleteReply.do", method = RequestMethod.GET)
	public ModelAndView deleteReply(HttpServletRequest req) {
		System.out.println("딜리트 컨트롤러");
		ReplyVO rvo = this.getReply((Integer.parseInt(req.getParameter("replyNum"))));

		
		rvo.setBoardNum(Integer.parseInt(req.getParameter("boardNum")));
		rvo.setReplyContent(req.getParameter("replyContent"));
		rvo.setReplyDate(nowTime);
		rvo.setReplyWriter(req.getParameter("userName"));
		
		ReplyService.deleteReply(rvo);

		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoard.do?boardNum="+req.getParameter("boardNum")); // 占쎈퉸占쎈뼣 野껓옙 癰귣�諭뜻에占�~

		return mav;
	}

	@RequestMapping(value = "/updateReply.do", method = RequestMethod.POST)
	public ModelAndView updateReply(HttpServletRequest req) {
		ReplyVO rvo = new ReplyVO();
		System.out.println("업데이트 컨트롤");
		rvo=ReplyService.getReply(Integer.parseInt(req.getParameter("replyNum1")));
		System.out.println("num"+req.getParameter("replyNum1") );
		rvo.setReplyContent(req.getParameter("updatereplyContent"));
		rvo.setReplyDate(nowTime);
		System.out.println(rvo);
		
		ReplyService.updateReply(rvo);		

		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoard.do?boardNum="+req.getParameter("boardNum"));

		return mav;
	}

	public ReplyVO getReply(int replyNum) {
		return ReplyService.getReply(replyNum);
	}
	
	
	@RequestMapping("/listBoard.do")
	public ModelAndView getAllBoard(HttpServletRequest req) {
		
		ModelAndView mav = new ModelAndView();
		if (req.getSession().getAttribute("user") == null) {
			mav.setViewName("redirect:loginForm.do");
		}else {
			mav.addObject("boardList", BoardService.getAllBoard()); // 占쎈막占쎈뱜�뵳�됰윮占쎈뱜占쎄퐬占쎌뿫 board嚥∽옙 占쎈퉸占쎈튊占쎈릭占쎄돌 ?
			mav.setViewName("boardList");
		}
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
		mav.addObject("replys", ReplyService.getAllReply(boardNum));
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
