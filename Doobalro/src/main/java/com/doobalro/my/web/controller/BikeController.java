package com.doobalro.my.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.doobalro.my.biz.server.service.BikeService;

@Controller
public class BikeController {
	
	@Resource(name="BikeService")
	BikeService BikeService;
	
	@RequestMapping("/Bike.do") //로그인 페이지로
	public String Bike(){
		//유저 체크 필요 없을 시 로그인폼으로~
		return "Bike";
	}
	
	@RequestMapping("/creAccident.do") //로그인 페이지로
	public String Accident(HttpServletRequest req){
		BikeService.Accident();
		req.getSession().getServletContext().getRealPath("./image/");
		return "redirect:AccidentTime.do";
	}
	
	@RequestMapping("/AccidentTime.do")
	public String AccidentTime() {
		return "AccidentTime";
	}
	@RequestMapping("/AccidentLoc.do")
	public String AccidentLoc(){
		return "AccidentLoc";
	}
	
}
