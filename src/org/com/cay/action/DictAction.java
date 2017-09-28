package org.com.cay.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.com.cay.entity.Dict;
import org.com.cay.service.IDictService;
import org.com.cay.utils.FastJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class DictAction extends ActionSupport implements ModelDriven<Dict> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IDictService dictService;

	private Dict model = new Dict();

	@Override
	public Dict getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	public String list() {
		String hql = "from Dict where typeCode = ?";
		List<Dict> dicts = dictService.findAll(hql, model.getTypeCode());
		String jsonString = FastJsonUtil.toJSONString(dicts);
		// 将json字符串写到浏览器
		FastJsonUtil.writeJson(ServletActionContext.getResponse(), jsonString);

		return NONE;
	}

}
