package com.dobalro.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dobalro.biz.board.service.BoardService;
import com.dobalro.biz.board.vo.BoardVO;
import com.dobalro.biz.users.vo.UsersVO;

@Controller

public class BoardController {

	@Resource(name = "boardService")
	BoardService service;

	@RequestMapping(value = "/addBoard.do")
	public String addBoardDo() {
		return "insertBoard";
	}

	@RequestMapping(value = "/insertBoard.do", method = RequestMethod.POST) // 게시물
																			// 등록
	public String insertBoardDo(String board_num, String user_num, String bcontent, String btitle, String user_yn,
		HttpServletRequest req, HttpSession session, Model model) {
		java.util.Date udate = new java.util.Date();

		BoardVO vo = new BoardVO(board_num, user_num, user_yn, bcontent, btitle, new Date(udate.getTime()));
		service.insertBoard(vo);
		// -------------세션유지------------------
		UsersVO login = (UsersVO) session.getAttribute("login");
		UsersVO host = (UsersVO) session.getAttribute("host");
		model.addAttribute("loginPhone", login.getPhone());
		model.addAttribute("hostPhone", host.getPw());
		model.addAttribute("num", 1);
		return "redirect:listBoard.do";
	}

	@RequestMapping(value = "/listBoard.do") // 게시판 출력
	public String listBoardDo(String loginPhone, String hostPhone, @RequestParam("num") int num, Model model) {
		List<BoardVO> list = service.searchAllBoard(hostPhone);
		List<BoardVO> clist = new ArrayList<BoardVO>();
		int count = 0;
		int pageNum = 0;
		for (int i = num + ((num - 1) * 7) - 1; i < list.size(); i++) {
			if (count == 8)
				break;
			clist.add(list.get(i));
			count++;
		}
		if (list.size() % 8 == 0)
			pageNum = list.size() / 8;
		else
			pageNum = list.size() / 8 + 1;
		model.addAttribute("list", clist);
		model.addAttribute("pageNum", pageNum);
		if (loginPhone.equals(hostPhone))
			return "board";
		else
			return "friendBoard";
	}

	@RequestMapping(value = "/searchBoard.do", method = RequestMethod.POST)
	public String searchBoardDo(String condition, String keyword, Model model) {
		List<BoardVO> list = service.searchBoard(condition, keyword);
		model.addAttribute("list", list);
		return "board";
	}

	@RequestMapping(value = "/findBoard.do")
	public String showBoardDo(int num, HttpSession session) {
		/*
		 * UsersVO user = (UsersVO) session.getAttribute("login"); UsersVO host
		 * = (UsersVO) session.getAttribute("host");
		 */
		BoardVO vo = service.findBoard(num);
		session.setAttribute("board", vo);
		return "board";

	}

	@RequestMapping(value = "/deleteBoard.do")
	public String deleteBoardDo(int num, Model model, HttpServletRequest req, HttpSession session) {
		BoardVO vo = service.findBoard(num);
		service.deleteBoard(num);
		/*
		 * UserVO login = (UserVO) session.getAttribute("login"); UserVO host =
		 * (UserVO) session.getAttribute("host"); model.addAttribute("loginId",
		 * login.getId()); model.addAttribute("hostId", host.getId());
		 * model.addAttribute("num", 1);
		 */
		return "redirect:listBoard.do";
	}

	@RequestMapping(value = "/deleteBoards.do")
	public ModelAndView deleteBoardDo(@RequestParam("num") int[] num, HttpServletRequest req) {
		int rows = 0;
		BoardVO vo = service.findBoard(num[0]);
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < num.length; i++) {
			BoardVO deleteBoard = service.findBoard(num[0]);
			rows += service.deleteBoard(num[i]);
		}
		if (rows >= 1) {
			map.put("result", "success");
			map.put("num", vo.getBcontent());
		} else
			map.put("result", "fail");
		return new ModelAndView("jsonView", map);
	}

	@RequestMapping(value = "/modifyBoardGo.do")
	public String modifyBoardGo(int num, Model model) {
		BoardVO vo = service.findBoard(num);
		model.addAttribute("board", vo);
		return "modifyBoard";
	}

	@RequestMapping(value = "/modifyBoard.do")
	public String modifyBoardDo(String board_num, String user_num, String bcontent, String btitle, String user_yn,
			HttpServletRequest req, HttpSession session, Model model)
{
		java.util.Date udate = new java.util.Date();
		BoardVO vo = new BoardVO(board_num, user_num, bcontent, btitle, user_yn,new Date(udate.getTime()));
		service.updateBoard(vo);
			model.addAttribute("board", null);
		model.addAttribute("board", vo);
		return "showBoard";
	}

}
