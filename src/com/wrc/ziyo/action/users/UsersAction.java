package com.wrc.ziyo.action.users;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.wrc.ziyo.pojo.Users;
import com.wrc.ziyo.service.users.UsersService;
import com.wrc.ziyo.util.MD5Util;

@Namespace("/usersAction")
@Scope("prototype")
@Controller
@Component("usersAction")
public class UsersAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {
	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	private HttpServletResponse response;

	@Autowired
	private UsersService usersService;
	private Users users;

	@Action(value = "list", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/jsp/users/list.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String list() {
		if (this.users == null)
			this.users = new Users();
		try {
			List listAss = this.usersService.findByExample(this.users, 0, 20);
			this.request.setAttribute("listAss", listAss);
			this.request.setAttribute("users", this.users);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("用户查询失败");
			this.request.setAttribute("msg", "用户查询失败");
		}
		return "error";
	}

	@Action(value = "add", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/error.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String add() {
		try {
			// userPwd 进行 MD5加密
			this.users.setUserPwd(new MD5Util().GetMD5Code(this.users
					.getUserPwd()));
			this.usersService.save(this.users);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("用户信息录入失败！");
			this.request.setAttribute("msg", "用户信息录入失败！");
			return "error";
		}
		this.request.setAttribute("msg", "用户信息录入 成功");
		return "success";
	}

	@Action(value = "getById", results = {
			@org.apache.struts2.convention.annotation.Result(name = "update", location = "/jsp/users/update.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "detail", location = "/jsp/users/detail.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String getById() {
		int id = Integer.parseInt(this.request.getParameter("id"));
		String returnType = this.request.getParameter("returnType");
		try {
			this.users = this.usersService.get(Integer.valueOf(id));
			this.request.setAttribute("users", this.users);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("查询失败！");
			this.request.setAttribute("msg", "查询失败！");
			return "error";
		}
		return returnType;
	}

	@Action(value = "update", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/error.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String update() {
		try {
			this.usersService.update(this.users);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("用户信息修改失败！");
			this.request.setAttribute("msg", "用户信息修改失败！");
			return "error";
		}
		this.request.setAttribute("msg", "用户信息修改成功");
		return "success";
	}

	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
}
