package org.com.cay.action;

import org.com.cay.entity.PageBean;
import org.com.cay.entity.Visitor;
import org.com.cay.service.IVisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class VisitorAction extends BaseAction implements ModelDriven<Visitor>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IVisitorService visitorService;
	
	private Visitor model = new Visitor();
	@Override
	public Visitor getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	public String list(){
		PageBean<Visitor> page = visitorService.findByPage(model, this.getPageCode(), this.getPageSize());
		this.setVS("page", page);
		return "list";
	}

}
