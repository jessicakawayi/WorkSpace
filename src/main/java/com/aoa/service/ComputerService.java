package com.aoa.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aoa.entity.Computer;

public interface ComputerService {

	public List<Computer> findAll();

	public int insert(@Param("cname") String cname,@Param("status") int status);

	public int delete(@Param("id") int id);

	public int updateById(@Param("id") int id, @Param("cname") String cname,@Param("status") int status);
}
