package com.doobalro.my.biz.server.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.doobalro.my.biz.mapper.WeatherMapper;
import com.doobalro.my.biz.server.vo.WeatherVO;

@Component("weatherDAO")
public class WeatherDAO implements WeatherDaoFrame{

	@Autowired
	SqlSession mybatis;
	WeatherMapper mapper;
	
	public WeatherDAO() {
	}
	public WeatherDAO(SqlSession mybatis, WeatherMapper mapper) {
		this.mybatis = mybatis;
		this.mapper = mapper;
	}

	public SqlSession getMybatis() {
		return mybatis;
	}
	public void setMybatis(SqlSession mybatis) {
		this.mybatis = mybatis;
	}
	public WeatherMapper getMapper() {
		return mapper;
	}
	public void setMapper(WeatherMapper mapper) {
		this.mapper = mapper;
	}
	
	@PostConstruct
    public void init() {
    	mapper = mybatis.getMapper(WeatherMapper.class);
    }
	
	@Override
	public List<WeatherVO> getAllData() {
		return mapper.getAllData();
	}

}
