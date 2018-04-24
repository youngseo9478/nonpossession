package com.doobalro.my.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BikeController {
	
	@RequestMapping("/Bike.do") //로그인 페이지로
	public String Bike(){
		//유저 체크 필요 없을 시 로그인폼으로~
		return "Bike";
	}
}
