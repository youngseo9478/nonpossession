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
			return "로그인 성공";
		}
		
		return "로그인 실패";
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
			return "가입 성공";
		}		
		return "휴대폰 번호 중복으로 인한 가입 실패";		
	}
	@Override
	public String deleteUser(UserVO vo) {
		mapper.deleteUser(vo);
		return "유저 탈퇴 성공";
	}
	@Override
	public String updateUser(UserVO vo) {
		if(mapper.updateUser(vo)==1) {
			return "변경 성공";
		}		
		return "휴대폰 번호 중복 또는 이름 중복으로 인한 변경 실패";
		
		
	}
	
	@Override
	public String pwFind(UserVO vo) {
		String result = mapper.pwFind(vo);
		if(result.isEmpty()) {
			return "해당 사항 유저 없음";
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
			return "변경 완료";
		}		
		return "휴대폰번호 또는 생년월일 불일치";
	}
	
}
