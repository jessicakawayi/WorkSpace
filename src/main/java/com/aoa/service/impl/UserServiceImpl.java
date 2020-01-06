package com.aoa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aoa.Repository.UserRepository;
import com.aoa.entity.User;
import com.aoa.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	List<User> users;

	@Override
	public List<User> findLogin(String username, String password, String q) {
		// TODO 自動生成されたメソッド・スタブ

		users = userRepository.findLogin(username, password, q);
		return users;
	}

	@Override
	public int findInsert(String username, String password,
			 String q,String sex, int tel	){
		// TODO 自動生成されたメソッド・スタブ
		int i=0;
		i=userRepository.findInsert(username, password, q, sex, tel);
		return i;
	}

	@Override
	public List<User> findAll() {
		// TODO 自動生成されたメソッド・スタブ

		users=userRepository.findAll();
		return users;
	}

	@Override
	public int deleteById(int id) {
		// TODO 自動生成されたメソッド・スタブ
		int i=0;
		i=userRepository.deleteById(id);
		return i;
	}

	@Override
	public int updateById(int id,String username, String password,
			String q,String sex,int tel) {
		// TODO 自動生成されたメソッド・スタブ
		int i=0;
		i=userRepository.updateById(id, username, password, q, sex, tel);
		return i;
	}

	@Override
	public List<User> fingById(int id) {
		// TODO 自動生成されたメソッド・スタブ

		users=userRepository.fingById(id);
		return users;
	}



}
