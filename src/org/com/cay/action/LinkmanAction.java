package org.com.cay.action;

import org.com.cay.entity.Linkman;
import org.com.cay.entity.PageBean;
import org.com.cay.service.ILinkmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class LinkmanAction extends BaseAction implements ModelDriven<Linkman> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Linkman model = new Linkman();
	
	@Autowired
	private ILinkmanService linkmanService;
	
	@Override
	public Linkman getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	public String list(){
		PageBean<Linkman> page = linkmanService.findByPage(model, this.getPageCode(), this.getPageSize());
		this.setVS("page", page);
		
		return "list";
	}
	
	public String initUpdate(){
		model = linkmanService.findById(model.getLkmId());
		return "initUpdate";
	}
	
	public String update(){
		linkmanService.update(model);
		return "relist";
	}
	
	public String delete(){
		linkmanService.delete(model);
		return "relist";
	}

}
