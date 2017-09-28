package org.com.cay.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 每页显示的数据的条数
	private Integer pageSize = 2;
	// 当前页，默认值就是1
	private Integer pageCode = 1;
	
	

	public Integer getPageSize() {
		return pageSize;
	}

	public Integer getPageCode() {
		return pageCode;
	}

	public void setPageCode(Integer pageCode) {
		if (pageCode == null) {
			pageCode = 1;
		}
		this.pageCode = pageCode;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public void setVS(String key, Object obj){
		ServletActionContext.getContext().getValueStack().set(key, obj);
	}

	public void pushVS(Object obj){
		ServletActionContext.getContext().getValueStack().push(obj);
	}
}
