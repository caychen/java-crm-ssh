package org.com.cay.entity;

import java.io.Serializable;

public class Visitor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 主键
	private String visitId;
	// 拜访时间
	private String visitTime;
	// 被拜访的人
	private String visitInterviewee;
	// 拜访地点
	private String visitAddr;
	// 拜访详情
	private String visitDetail;
	// 下一次的拜访时间
	private String visitNextTime;

	// 外键，和客户
	private Customer customer;
	// 外键，和用户
	private User user;

	public String getVisitId() {
		return visitId;
	}

	public void setVisitId(String visitId) {
		this.visitId = visitId;
	}

	public String getVisitTime() {
		return visitTime;
	}

	public void setVisitTime(String visitTime) {
		this.visitTime = visitTime;
	}

	public String getVisitInterviewee() {
		return visitInterviewee;
	}

	public void setVisitInterviewee(String visitInterviewee) {
		this.visitInterviewee = visitInterviewee;
	}

	public String getVisitAddr() {
		return visitAddr;
	}

	public void setVisitAddr(String visitAddr) {
		this.visitAddr = visitAddr;
	}

	public String getVisitDetail() {
		return visitDetail;
	}

	public void setVisitDetail(String visitDetail) {
		this.visitDetail = visitDetail;
	}

	public String getVisitNextTime() {
		return visitNextTime;
	}

	public void setVisitNextTime(String visitNextTime) {
		this.visitNextTime = visitNextTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
