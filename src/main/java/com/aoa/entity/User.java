package com.aoa.entity;

public class User {

	private Integer uNum;
	private Integer uId;
	private String uName;
	private String uPwd;
	private String uQ;
	private String uSex;
	private Integer uTel;

	public User() {
	}

	public Integer getuNum() {
		return uNum;
	}

	public void setuNum(Integer uNum) {
		this.uNum = uNum;
	}

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPwd() {
		return uPwd;
	}

	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}

	public String getuQ() {
		return uQ;
	}

	public void setuQ(String uQ) {
		this.uQ = uQ;
	}

	public String getuSex() {
		return uSex;
	}

	public void setuSex(String uSex) {
		this.uSex = uSex;
	}

	public Integer getuTel() {
		return uTel;
	}

	public void setuTel(Integer uTel) {
		this.uTel = uTel;
	}

	@Override
	public String toString() {
		return "User [uNum=" + uNum + ", uId=" + uId + ", uName=" + uName + ", uPwd=" + uPwd + ", uQ=" + uQ + ", uSex="
				+ uSex + ", uTel=" + uTel + "]";
	}




}
