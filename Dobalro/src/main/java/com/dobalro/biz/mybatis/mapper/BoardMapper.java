package com.dobalro.biz.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dobalro.biz.board.vo.BoardVO;

public interface BoardMapper {

	@Insert("insert into Board board_num,user_num,user_yn,bcontent,bdate) values((select nvl(max(board_num),0)+1 from board),#{user_num},#{user_yn},#{bcontent},#{bdate}")
	public int insertBoard(BoardVO vo);

	@Delete("delete from Board where board_num = #{board_num}")
	public int deleteboard(int board_num);

	@Update("update board set user_yn = #{user_yn}, bcontent = #{bcontent} where board_num = #{board_num}")
	public int updateboard(BoardVO vo);

	@Select("select * from board where user_num = #{user_num} order by board_num desc")
	public List<BoardVO> selectallboard(String user_num);

	@Select("select * from board where board_num = #{board_num}")
	public BoardVO findboard(int board_num);

	@Select("select * from board where ${condition} like '%'|| #{keyword} ||'%'")
	public List<BoardVO> searchboard(HashMap<String, String> map);

}
