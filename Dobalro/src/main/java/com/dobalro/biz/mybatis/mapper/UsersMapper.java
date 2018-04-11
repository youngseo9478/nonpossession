package com.dobalro.biz.mybatis.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dobalro.biz.users.vo.UsersVO;

public interface UsersMapper {
	
	@Insert("insert into users (user_num, phone, pw, nickname) values(#{user_num}, #{phone}, #{pw}, #{nickname})")
	public int insertUser(UsersVO vo);

	@Delete("delete from users where user_num = #{user_num}")
	public int deleteUser(String user_num);

	@Update("update users set pw = #{pw}, nickname = #{nickname} where phone = #{phone}")
	public int updateUser(UsersVO vo);

	@Select("select * from users where user_num = #{user_num}")
	public UsersVO login(UsersVO vo);

	@Select("select pw from users where phone = #{phone} and nickname = #{nickname}")
	public String pwFind(UsersVO vo);


}
