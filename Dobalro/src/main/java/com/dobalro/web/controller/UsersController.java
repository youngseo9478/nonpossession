package com.dobalro.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dobalro.biz.board.vo.BoardVO;
import com.dobalro.biz.users.service.UserService;
import com.dobalro.biz.users.vo.UsersVO;

@Controller

public class UsersController {

	@Resource(name = "UserService")
	UserService service;

	@RequestMapping(value = "./insertUser.do")
	public String addUsers() {
		return "insertUser";
	}

	@RequestMapping(value = "/insertUser.do", method = RequestMethod.POST) // 게시물
																			// 등록
	public String insertUsers(String user_num, String phone, String pw, String nickname
		, HttpServletRequest req, HttpSession session, Model model) {
		
		UsersVO vo = new UsersVO(user_num, phone, pw, nickname);
		service.insertUser(vo);
		// -------------세션유지------------------
		return "redirect:insertUser.do";
	}

	@RequestMapping("/login.do")
	public String loginProcess(UsersVO vo, HttpServletRequest req,
			HttpSession session,HttpServletResponse response) throws IOException {
		
	/*	response.setHeader("Content-Type", "application/xml");*/
		response.setContentType("text/xml;charset=UTF-8");
		response.setCharacterEncoding("utf-8"); 

		//Gson
		
		UsersVO user = service.login(vo);
		
		if(user == null) {
			req.getSession().setAttribute("phone, pw", vo);
			return "redirect:login.do";
		}else {			
			req.setAttribute("phone, pw", vo);
			req.setAttribute("errorMsg", "아이디 비밀번호 확인해주세요.");
		}
		return "index.do";
	}
	
	@RequestMapping("/logout.do")
		public String logoutProcess(HttpSession session) {
				session.invalidate();
				return "index.do";
	}
		
		@RequestMapping("/gomain.do")
		public String gomain() {
			return "index";
		}
		@RequestMapping("/gosignup.do")
		public String gosignup() {
			return "insertUser";	
		}
		/*@RequestMapping("/signup.do")
		public String signup(UsersVO vo,HttpServletRequest request,HttpServletResponse response) {
			UsersVO temp = service.insertUser();
			if(temp == null) {
			service.insertUsers(vo);
			return "login";	
			}else {
				return "register";
			}
		}*/
		
}
