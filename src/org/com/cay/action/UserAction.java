package org.com.cay.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.com.cay.entity.User;
import org.com.cay.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String LOGIN = "login";

	private User model = new User();

	@Autowired
	private IUserService userService;

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return model;
	}

	public String register() {
		userService.save(model);

		return LOGIN;
	}

	public String checkCode() throws IOException {
		User user = userService.checkCode(model.getUserCode());

		// 获取response对象
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");

		response.getWriter().write(user != null ? "no" : "yes");
		return NONE;
	}

	public String login() {
		User existUser = userService.login(model);
		if (existUser == null) {
			// 登录失败
			return LOGIN;
		} else {
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			// 登录成功
			return "loginOk";
		}
	}

	public String logout() {
		ServletActionContext.getRequest().getSession().removeAttribute("existUser");
		return LOGIN;
	}
}
