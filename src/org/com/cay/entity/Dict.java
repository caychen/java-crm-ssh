package org.com.cay.entity;

import java.io.Serializable;

//字典表
public class Dict implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 数据字典id
	private String id;
	// 数据字典类别代码,001，002，006
	private String typeCode;
	// 数据字典类别名称,001：客户行业，002：客户信息来源，006：客户级别
	private String typeName;
	// 数据字典项目名称，即行业中具体项目名称
	private String itemName;
	// 数据字典项目码（可为空）
	private String itemCode;
	// 排序字段
	private Integer sort;
	// 1：使用，0：暂停
	private String enable;
	// 备注
	private String remark;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
