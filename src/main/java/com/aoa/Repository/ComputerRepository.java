package com.aoa.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.aoa.entity.Computer;

@Mapper
public interface ComputerRepository {

	/**
	 * 查询所有电脑信息
	 * @return
	 */
	@Select("select * from computer")
	@Results({
			@Result(property = "cNum", column = "c_num"),
			@Result(property = "cId", column = "c_id"), //id=true表示id为主键
			@Result(property = "cName", column = "c_name"),
			@Result(property = "cStatus", column = "c_status"),
	})
	public List<Computer> findAll();

	/**
	 * 插入电脑记录
	 */
	@Insert("insert into computer(c_name,c_status)values(#{cname},#{status})")
	public int insert(@Param("cname") String cname,@Param("status") int status);

	/**
	 * 删除一条电脑记录
	 * @param id
	 * @return
	 */
	@Delete("delete from computer where c_id=#{id} ")
	public int delete(@Param("id") int id);
	/**
	 * 修改信息
	 * @param id
	 * @param cname
	 * @return
	 */
	@Update({
	"update computer set c_name = #{cname},c_stauts = #{status} where c_id = #{id}}" })
	public int updateById(@Param("id") int id, @Param("cname") String cname ,@Param("status") int status);
}
