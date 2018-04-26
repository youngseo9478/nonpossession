package com.doobalro.my.biz.server.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doobalro.my.biz.mapper.UserMapper;
import com.doobalro.my.biz.server.vo.UserVO;

@Component("userDAO")
public class UserDAO implements UserDaoFrame{
	@Autowired
	SqlSession mybatis;
	UserMapper mapper;
	
	public  UserDAO(){}
	public UserDAO (SqlSession mybatis) {
		this.mybatis = mybatis;
	}
	
	public SqlSession getMybatis() {
		return mybatis;
	}
	public void setMybatis(SqlSession mybatis) {
		this.mybatis = mybatis;
	}
	public UserMapper getMapper() {
		return mapper;
	}
	public void setMapper(UserMapper mapper) {
		this.mapper = mapper;
	}
	
	@PostConstruct
    public void init() {
    	mapper = mybatis.getMapper(UserMapper.class);
    }
	
	
	@Override
	public String login(UserVO vo) {
		List<UserVO> li = this.getAllUser();
		Iterator<UserVO> iter = li.iterator();
		boolean flag = false;
		
		while(iter.hasNext()) {
			UserVO uv = iter.next();
			if(uv.getUserPhone().equals(vo.getUserPhone())&&uv.getUserPw().equals(vo.getUserPw())) {
				flag = true;
			}
		}
		
		if(flag) {
			mapper.login(vo);
			return "濡쒓렇�씤 �꽦怨�";
		}
		
		return "濡쒓렇�씤 �떎�뙣";
	}
	
	@Override
	public String addUser(UserVO vo) {
		List<UserVO> li = this.getAllUser();
		Iterator<UserVO> iter = li.iterator();
		boolean flag = true;
		
		while(iter.hasNext()) {
			if(iter.next().getUserPhone().equals(vo.getUserPhone())) {
				flag = false;
			}
		}
		
		if(flag) {
			mapper.addUser(vo);
			return "媛��엯 �꽦怨�";
		}		
		return "�쑕���룿 踰덊샇 以묐났�쑝濡� �씤�븳 媛��엯 �떎�뙣";		
	}
	@Override
	public String deleteUser(UserVO vo) {
		mapper.deleteUser(vo);
		return "�쑀�� �깉�눜 �꽦怨�";
	}
	@Override
	public String updateUser(UserVO vo) {
		if(mapper.updateUser(vo)==1) {
			return "蹂�寃� �꽦怨�";
		}		
		return "�쑕���룿 踰덊샇 以묐났 �삉�뒗 �씠由� 以묐났�쑝濡� �씤�븳 蹂�寃� �떎�뙣";
		
		
	}
	
	@Override
	public String pwFind(UserVO vo) {
		String result = mapper.pwFind(vo);
		if(result.isEmpty()) {
			return "�빐�떦 �궗�빆 �쑀�� �뾾�쓬";
		}
		return result;
	}
	
	@Override
	public UserVO getUser(UserVO vo) {
		return mapper.getUser(vo);
	}
	
	public List<UserVO> getAllUser(){
		return mapper.getAllUser();
	}
	@Override
	public String changePw(UserVO vo) {
		if(mapper.changePw(vo)==1) {
			return "蹂�寃� �셿猷�";
		}		
		return "�쑕���룿踰덊샇 �삉�뒗 �깮�뀈�썡�씪 遺덉씪移�";
	}
	@Override
	public boolean checkId(UserVO vo) {
		
		String user = mapper.idcheck(vo);
		if(user != null) {
			return false;
	}
		else {
			return true;
		}
	
	}	
}
