package com.aoa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aoa.Repository.ComputerRepository;
import com.aoa.entity.Computer;
import com.aoa.service.ComputerService;

@Service("computerService")
public class ComputerServiceImpl implements ComputerService {
	@Autowired
	private ComputerRepository cr;
	List<Computer> computers;

	@Override
	public List<Computer> findAll() {
		// TODO 自動生成されたメソッド・スタブ

		computers = cr.findAll();
		return computers;
	}

	@Override
	public int insert(String cname,int status) {
		// TODO 自動生成されたメソッド・スタブ
		int i = 0;
		i = cr.insert(cname,status);
		return i;
	}

	@Override
	public int delete(int id) {
		// TODO 自動生成されたメソッド・スタブ
		int i = 0;
		i = cr.delete(id);
		return i;
	}

	@Override
	public int updateById(int id, String cname,int status) {
		// TODO 自動生成されたメソッド・スタブ
		int i = 0;
		i = cr.updateById(id, cname,status);
		return i;
	}

}
