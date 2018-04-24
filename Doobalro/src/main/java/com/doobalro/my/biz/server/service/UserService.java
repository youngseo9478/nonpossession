package com.doobalro.my.biz.server.service;

import com.doobalro.my.biz.server.vo.UserVO;

public interface UserService {
	public String login(UserVO vo);//占싸깍옙占쏙옙

	public String addUser(UserVO vo);//회占쏙옙占쏙옙占쏙옙

	public String deleteUser(UserVO vo);//회占쏙옙탈占쏙옙

	public String updateUser(UserVO vo);//회占쏙옙占쏙옙占쏙옙	

	public String pwFind(UserVO vo);//占쏙옙橘占싫� 찾占쏙옙

	public UserVO getUser(UserVO vo);// 占쏙옙占쏙옙占싼뱄옙 찾占쏙옙

	public String changePw(UserVO vo);//회占쏙옙占쏙옙占쏙옙
}
