package org.com.cay.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.com.cay.entity.Customer;
import org.com.cay.entity.PageBean;
import org.com.cay.service.ICustomerService;
import org.com.cay.utils.FastJsonUtil;
import org.com.cay.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

/**
 * 客户的控制层
 * 
 * @author Administrator
 */
@Controller
@Scope("prototype")
public class CustomerAction extends BaseAction implements ModelDriven<Customer> {

	private static final long serialVersionUID = 113695314694166436L;
	String path = "F:\\Code\\webapps\\file\\";

	// 不要忘记手动new
	private Customer model = new Customer();
	// 属性驱动的方式

	/*
	 * Struts2文件上传命名规则 
	 * private File upload; upload对应html文档中的上传组件的name属性 
	 * private String uploadFileName; 该命名为upload + FileName 
	 * private String uploadContentType;该命名为upload + ContentType
	 */
	private File upload;
	private String uploadFileName;
	private String uploadContentType;

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public Customer getModel() {
		return model;
	}

	// 提供service的成员属性，提供set方法
	@Autowired
	private ICustomerService customerService;

	/**
	 * 分页的查询方法
	 * 
	 * @return
	 */
	public String list() {
		// 查询
		PageBean<Customer> page = customerService.findByPage(model, this.getPageCode(), this.getPageSize());
		// 栈顶是map<"page",page对象>
		super.setVS("page", page);
		return "page";
	}

	public String initAddUI() {
		return "initAddUI";
	}

	public String save() throws IOException {
		// 文件上传
		if (uploadFileName != null) {
			// 修改文件名
			String uuidName = FileUtils.getUUIDName(uploadFileName);

			// 模拟图片服务器

			File file = new File(path + uuidName);

			// 拷贝
			org.apache.commons.io.FileUtils.copyFile(upload, file);

			// 把上传的文件的路径保存到客户表中
			model.setFilePath(path + uuidName);
		}

		customerService.save(model);
		return "relist";
	}

	public String delete() {
		// 删除客户，先获取该客户上传文件的路径，去删除文件，再删除该客户对象
		// 获取上传文件的路径
		String filePath = customerService.delete(model);

		// 删除文件
		File file = new File(filePath);
		if (file.exists()) {
			file.delete();
		}

		return "relist";
	}

	public String initUpdate() {
		model = customerService.findById(model.getCustId());
		return "initUpdate";
	}

	public String update() throws IOException {
		if (uploadFileName != null) {
			// 先删除旧文件
			String oldFilePath = model.getFilePath();
			if (oldFilePath != null && !oldFilePath.trim().isEmpty()) {
				// 删除
				File file = new File(oldFilePath);
				file.delete();
			}

			// 上传新文件
			String uuidName = FileUtils.getUUIDName(uploadFileName);
			File newFile = new File(path + uuidName);
			org.apache.commons.io.FileUtils.copyFile(upload, newFile);

			// 把新文件更新到数据库
			model.setFilePath(path + uuidName);
		}

		// 更新客户信息
		customerService.update(model);

		return "relist";
	}
	
	//查询所有的客户
	public String listAll(){
		List<Customer> customers = customerService.listAll();
		
		FastJsonUtil.writeJson(ServletActionContext.getResponse(), FastJsonUtil.toJSONString(customers));
		return NONE;
	}

}
