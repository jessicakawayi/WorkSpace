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

import com.aoa.entity.User;

@Mapper

public interface UserRepository {

	/**
	 * 登录
	 * @param username
	 * @param password
	 * @param q
	 * @return
	 */
	@Select("select * from users where u_name=#{username} and u_pwd=#{password} and u_q=#{q}")
	@Results({
			@Result(id = true, property = "uId", column = "u_id"), //id=true表示id为主键
			@Result(property = "uNum", column = "u_num"),
			@Result(property = "uName", column = "u_name"),
			@Result(property = "uPwd", column = "u_pwd"),
			@Result(property = "uQ", column = "u_q"),
			@Result(property = "uSex", column = "u_sex"),
			@Result(property = "uTel", column = "u_tel"),

	})

	public List<User> findLogin(@Param("username") String username, @Param("password") String password,
			@Param("q") String q);

	/**
	 * 注册
	 * @param user
	 * @return
	 */
	@Insert({
			"insert into users(u_name, u_pwd, u_q, u_sex,u_tel) values(#{username}, #{password}, #{q}, #{sex}, #{tel})" })
	public int findInsert(@Param("username") String username, @Param("password") String password,
			@Param("q") String q, @Param("sex") String sex, @Param("tel") int tel);

	/**
	 * 查询所有
	 * @return
	 */
	@Select("select * from users")
	@Results({
			@Result(property = "uId", column = "u_id"), //id=true表示id为主键
			@Result(property = "uNum", column = "u_num"),
			@Result(property = "uName", column = "u_name"),
			@Result(property = "uPwd", column = "u_pwd"),
			@Result(property = "uQ", column = "u_q"),
			@Result(property = "uSex", column = "u_sex"),
			@Result(property = "uTel", column = "u_tel"),

	})
	public List<User> findAll();

	/**
	 * 删除一条信息
	 * @param id
	 * @return
	 */
	@Delete(value = { "delete from users where u_id=#{id}" })
	public int deleteById(@Param("id") int id);

	/**
	 * 修改信息
	 * @param id
	 * @return
	 */
	@Update({
			"update users set u_name = #{username},u_pwd= #{password},u_q = #{q},u_sex = #{sex}, u_tel=#{tel} where u_id = #{id}" })
	public int updateById(@Param("id") int id, @Param("username") String username, @Param("password") String password,
			@Param("q") String q, @Param("sex") String sex, @Param("tel") int tel);

	/**
	 * 按照id查询
	 * @param id
	 * @return
	 */
	@Select("select * from users where u_id=#{id}")
	@Results({
			@Result(property = "uId", column = "u_id"), //id=true表示id为主键
			@Result(property = "uNum", column = "u_num"),
			@Result(property = "uName", column = "u_name"),
			@Result(property = "uPwd", column = "u_pwd"),
			@Result(property = "uQ", column = "u_q"),
			@Result(property = "uSex", column = "u_sex"),
			@Result(property = "uTel", column = "u_tel"),

	})
	public List<User> fingById(@Param("id") int id);
}
