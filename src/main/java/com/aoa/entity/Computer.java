package com.aoa.entity;

import org.springframework.stereotype.Component;

@Component
public class Computer {
	private Integer cNum;
	private Integer cId;
	private String cName;
	private Integer cStatus;

	public Computer() {
	}

	public Integer getcNum() {
		return cNum;
	}

	public void setcNum(Integer cNum) {
		this.cNum = cNum;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Integer getcStatus() {
		return cStatus;
	}

	public void setcStatus(Integer cStatus) {
		this.cStatus = cStatus;
	}

	@Override
	public String toString() {
		return "Computer [cNum=" + cNum + ", cId=" + cId + ", cName=" + cName + ", cStatus=" + cStatus + "]";
	}



}
