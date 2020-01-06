package com.aoa.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Cj {
	private Integer cjId;
	private String cName;
	private Date cjChdate;
	private Date cjCjdate;
	private Integer cjDay;
	private Boolean cjStatus;
	private String uName;

	public Cj() {
	}

	public Integer getCjId() {
		return cjId;
	}

	public void setCjId(Integer cjId) {
		this.cjId = cjId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Date getCjChdate() {
		return cjChdate;
	}

	public void setCjChdate(Date cjChdate) {
		this.cjChdate = cjChdate;
	}

	public Date getCjCjdate() {
		return cjCjdate;
	}

	public void setCjCjdate(Date cjCjdate) {
		this.cjCjdate = cjCjdate;
	}

	public Integer getCjDay() {
		return cjDay;
	}

	public void setCjDay(Integer cjDay) {
		this.cjDay = cjDay;
	}

	public Boolean getCjStatus() {
		return cjStatus;
	}

	public void setCjStatus(Boolean cjStatus) {
		this.cjStatus = cjStatus;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	@Override
	public String toString() {
		return "Cj [cjId=" + cjId + ", cName=" + cName + ", cjChdate=" + cjChdate + ", cjCjdate=" + cjCjdate
				+ ", cjDay=" + cjDay + ", cjStatus=" + cjStatus + ", uName=" + uName + "]";
	}

}
