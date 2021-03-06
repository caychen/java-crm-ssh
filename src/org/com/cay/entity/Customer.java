package org.com.cay.entity;

import java.io.Serializable;

public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * `cust_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
	 * `cust_name` varchar(32) NOT NULL COMMENT '客户名称(公司名称)', `cust_user_id`
	 * bigint(32) DEFAULT NULL COMMENT '负责人id', `cust_create_id` bigint(32)
	 * DEFAULT NULL COMMENT '创建人id', `cust_source` varchar(32) DEFAULT NULL
	 * COMMENT '客户信息来源', `cust_industry` varchar(32) DEFAULT NULL COMMENT
	 * '客户所属行业', `cust_level` varchar(32) DEFAULT NULL COMMENT '客户级别',
	 * `cust_linkman` varchar(64) DEFAULT NULL COMMENT '联系人', `cust_phone`
	 * varchar(64) DEFAULT NULL COMMENT '固定电话', `cust_mobile` varchar(16)
	 * DEFAULT NULL COMMENT '移动电话',
	 */

	private Long custId;
	// 客户名称
	private String custName;

	private Long custUserId;
	private Long custCreateId;

	// // 客户的来源
	// private String custSource;
	// // 所属于行业
	// private String custIndustry;
	// // 客户的级别
	// private String custLevel;

	// 联系人名称
	private String custLinkman;
	// 固定电话
	private String custPhone;
	// 移动电话
	private String custMobile;

	// 描述的是 一客户的来源，多是客户
	private Dict source;
	// 一客户的行业 多是客户
	private Dict industry;
	// 一客户级别 多是客户
	private Dict level;

	private String filePath;

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Long getCustUserId() {
		return custUserId;
	}

	public void setCustUserId(Long custUserId) {
		this.custUserId = custUserId;
	}

	public Long getCustCreateId() {
		return custCreateId;
	}

	public void setCustCreateId(Long custCreateId) {
		this.custCreateId = custCreateId;
	}

	public String getCustLinkman() {
		return custLinkman;
	}

	public void setCustLinkman(String custLinkman) {
		this.custLinkman = custLinkman;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	public Dict getSource() {
		return source;
	}

	public void setSource(Dict source) {
		this.source = source;
	}

	public Dict getIndustry() {
		return industry;
	}

	public void setIndustry(Dict industry) {
		this.industry = industry;
	}

	public Dict getLevel() {
		return level;
	}

	public void setLevel(Dict level) {
		this.level = level;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
