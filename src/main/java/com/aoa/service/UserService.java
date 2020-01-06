package com.aoa.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aoa.entity.User;

public interface UserService {
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @param q
	 * @return
	 */
	public List<User> findLogin(@Param("username")String username, @Param("password")String password, @Param("q")String q);

	/**
	 * 注册
	 * @param user
	 * @return
	 */
	public int findInsert(String username,String password,
			String q, String sex,  int tel);

	public List<User> findAll();

	public int deleteById( int id);

	public int updateById(int id,  String username, String password,
			String q,String sex, int tel);

	public List<User> fingById(int id);

}
