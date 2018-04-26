package com.doobalro.my.web.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.doobalro.my.biz.server.service.WeatherService;
import com.doobalro.my.biz.server.vo.WeatherVO;

@Controller
public class WeatherController {
	@Resource(name = "WeatherService")
	WeatherService WeatherService;
	
	@RequestMapping(value="weatherList.do", method = RequestMethod.GET)
	public String weatherListGo() {
		return "weather";
	}
	
	@RequestMapping(value="weatherList.do", method = RequestMethod.POST)
	public ModelAndView weatherList() {
		List<WeatherVO> list = WeatherService.getAllData();
		HashMap<String, Object> map = new HashMap<>();
		System.out.println(list);
		map.put("list", list);
		return new ModelAndView("jsonView",map);
	}
}
