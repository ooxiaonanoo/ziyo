package com.wrc.ziyo.action.customer;

import java.util.Date;
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
import com.wrc.ziyo.pojo.Customer;
import com.wrc.ziyo.pojo.Users;
import com.wrc.ziyo.service.customer.CustomerService;

@Namespace("/customerAction")
@Scope("prototype")
@Controller
@Component("customerAction")
public class CustomerAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {

	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	private HttpServletResponse response;

	@Autowired
	private CustomerService customerService;
	private Customer customer;

	@Action(value = "list", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/jsp/customer/list.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String list() {
		Users user = (Users) this.request.getSession()
				.getAttribute("userLogin");
		if (this.customer == null)
			this.customer = new Customer();
		this.customer.setUsers(user);
		try {
			List listAss = this.customerService.findByExample(this.customer, 0,
					20);
			this.request.setAttribute("listAss", listAss);
			this.request.setAttribute("customer", this.customer);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("客户查询失败");
			this.request.setAttribute("msg", "客户查询失败");
		}
		return "error";
	}

	@Action(value = "findBySql", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/jsp/customer/list.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String findBySql() {
		String sql = "select * from T_CUSTOMER where 1=1 ";
		if (this.customer != null) {
			if (this.customer.getKhmc() != "") {
				sql += "and khmc like '%" + this.customer.getKhmc().trim()
						+ "%'";
			}
			if (this.customer.getDz() != "") {
				sql += "and dz like '%" + this.customer.getDz().trim() + "%'";
			}
			if (this.customer.getYwy() != "") {
				sql += "and ywy like '%" + this.customer.getYwy().trim() + "%'";
			}
		}
		List listAss = this.customerService.findBySql(sql, null);
		this.request.setAttribute("listAss", listAss);
		return "success";
	}

	@Action(value = "add", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/error.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String add() {
		Users user = (Users) this.request.getSession()
				.getAttribute("userLogin");
		this.customer.setUserid(user.getId());
		this.customer.setLastTime(new Date());
		try {
			this.customerService.save(this.customer);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("客户信息录入失败！");
			this.request.setAttribute("msg", "客户信息录入失败！");
			return "error";
		}
		this.request.setAttribute("msg", "客户信息录入 成功");
		return "success";
	}

	@Action(value = "getById", results = {
			@org.apache.struts2.convention.annotation.Result(name = "update", location = "/jsp/customer/update.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "detail", location = "/jsp/customer/detail.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String getById() {
		int id = Integer.parseInt(this.request.getParameter("id"));
		String returnType = this.request.getParameter("returnType");
		try {
			this.customer = this.customerService.get(Integer.valueOf(id));
			this.request.setAttribute("customer", this.customer);
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
		Users user = (Users) this.request.getSession()
				.getAttribute("userLogin");
		this.customer.setUserid(user.getId());
		this.customer.setLastTime(new Date());
		try {
			this.customerService.update(this.customer);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("客户信息修改失败！");
			this.request.setAttribute("msg", "客户信息修改失败！");
			return "error";
		}
		this.request.setAttribute("msg", "客户信息修改成功");
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

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
