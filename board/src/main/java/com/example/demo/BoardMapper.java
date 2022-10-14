package com.example.demo;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface BoardMapper {

	@Insert("insert into board(name,title,content,pwd,writeday) values(#{name},#{title},#{content},#{pwd},now())")
	public void write_ok(BoardVO bvo);
	
	@Select("select * from board order by id desc")
	public ArrayList<BoardVO> list();
	
	@Select("select * from board where id=#{id}")
	public BoardVO content(String id);
	
	@Select("select count(*) from board where id=#{param1} and pwd=#{param2}")
	public int getpwd(int id,String pwd);
	
	@Delete("delete from board where id=#{id}")
	public void delete(int id);
	
	@Select("select * from board where id=#{param1}")
	public BoardVO update(String id);
	
	@Update("update board set title=#{title},userid=#{userid},pwd=#{pwd},content=#{content} where id=#{id}")
	public void update_ok(BoardVO bvo);
}
