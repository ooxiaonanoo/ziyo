package com.wrc.ziyo.action.system;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.wrc.ziyo.pojo.Node;
import com.wrc.ziyo.pojo.UserPower;
import com.wrc.ziyo.pojo.Users;
import com.wrc.ziyo.service.system.NodeService;
import com.wrc.ziyo.service.system.UserPowerService;
import com.wrc.ziyo.service.users.UsersService;
import com.wrc.ziyo.util.MD5Util;
import com.wrc.ziyo.util.StringUtil;

@Namespace("/systemAction")
@Scope("prototype")
@Controller
@Component("systemAction")
public class SystemAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {
	private static final long serialVersionUID = 1L;

	@Autowired
	private NodeService nodeService;
	private HttpServletRequest request;
	private HttpServletResponse response;

	@Autowired
	private UsersService usersService;

	@Autowired
	private UserPowerService userPowerService;
	private Users users;
	private Node node;

	/**
	 * 用户登录
	 */
	@Action(value = "userLogin", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/jsp/system/mainframe.jsp", type = "redirect"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String userLogin() {
		try {
			// 加密后与数据库验证
			this.users.setUserPwd(new MD5Util().GetMD5Code(this.users
					.getUserPwd()));
			this.users = this.usersService.findUser(this.users);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (this.users == null) {
			this.request.setAttribute("msg", "用户名或密码错误!");
			return "error";
		} else if (this.users.getUserFlag().equals("N")) {
			this.request.setAttribute("msg", "该帐号已被锁定，请联系系统管理员!");
			return "error";
		}
		this.request.getSession().setAttribute("userLogin", this.users);
		try {
			List list = new ArrayList();
			// 默认0类型为管理员、查选所有栏目及功能。否则则查询用户相对应角色权限功能。
			if (this.users.getUserType().intValue() == 0) {
				list = this.nodeService.findAll();
				this.request.getSession().setAttribute("userTree",
						packageXml(list));
			} else {
				UserPower up = new UserPower();
				up.setUser(this.users);
				list = this.userPowerService.findByExample(up);
				this.request.getSession().setAttribute("userTree",
						packageXml2(list));
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.request.setAttribute("msg", "查询节点失败！");
			return "error";
		}
		return "success";
	}

	/**
	 * 用户注销
	 */
	@Action(value = "userLogOff", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/jsp/system/login.jsp", type = "redirect"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String userLogOff() {
		try {
			// 销毁HttpSession
			this.request.getSession().removeAttribute("userLogin");
			this.request.getSession().invalidate();
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 功能列表
	 */
	@Action(value = "nodeList", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/jsp/system/nodeList.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String nodeList() {
		if (this.node == null)
			this.node = new Node();
		try {
			List listAss = this.nodeService.findByExample(this.node, 1, 12);
			this.request.setAttribute("listAss", listAss);
			this.request.setAttribute("node", this.node);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("功能列表查询失败");
			this.request.setAttribute("msg", "功能列表查询失败");
		}
		return "error";
	}

	/**
	 * 查询单个栏目信息
	 */
	@Action(value = "getNodeById", results = {
			@org.apache.struts2.convention.annotation.Result(name = "update", location = "/jsp/system/nodeUpdate.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String getNodeById() {
		int id = Integer.parseInt(this.request.getParameter("id"));
		String returnType = this.request.getParameter("returnType");
		try {
			this.node = this.nodeService.get(Integer.valueOf(id));
			this.request.setAttribute("node", this.node);

			// 查询父级菜单name
			List listAss = this.nodeService.findAll();
			this.request.setAttribute("listAss", listAss);

		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("查询失败！");
			this.request.setAttribute("msg", "查询失败！");
			return "error";
		}
		return returnType;
	}

	/**
	 * 功能添加前加载父级菜单名称
	 */
	/**
	 * 查询单个栏目信息
	 */
	@Action(value = "getNodeAddShow", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/jsp/system/nodeAdd.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String getNodeAddShow() {
		try {
			// 查询父级菜单name
			List listAss = this.nodeService.findAll();
			this.request.setAttribute("listAss", listAss);

		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("查询失败！");
			this.request.setAttribute("msg", "查询失败！");
			return "error";
		}
		return "success";
	}

	/**
	 * 功能添加
	 */
	@Action(value = "nodeAdd", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/error.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String nodeAdd() {
		try {
			this.nodeService.save(this.node);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("功能信息录入失败！");
			this.request.setAttribute("msg", "功能信息录入失败！");
			return "error";
		}
		this.request.setAttribute("msg", "功能信息录入 成功");
		return "success";
	}

	/**
	 * 功能修改
	 */
	@Action(value = "nodeUpdate", results = {
			@org.apache.struts2.convention.annotation.Result(name = "success", location = "/error.jsp"),
			@org.apache.struts2.convention.annotation.Result(name = "error", location = "/error.jsp") })
	public String nodeUpdate() {
		try {
			this.nodeService.update(this.node);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.getLogger("功能信息修改失败！");
			this.request.setAttribute("msg", "功能信息修改失败！");
			return "error";
		}
		this.request.setAttribute("msg", "功能信息修改成功");
		return "success";
	}

	private String packageXml(List<Node> list) {
		Element Tree = new Element("Tree");
		if ((list != null) && (list.size() > 0)) {
			Element Levelup = null;
			Element fanodeid = null;
			Element nodeid = null;
			Element name = null;
			Element type = null;
			Element url = null;
			Element imgurl = null;
			Element rem = null;

			for (Node node : list) {
				if ((Levelup == null)
						|| (!String.valueOf("Levelup-" + node.getLevelup())
								.equals(Levelup.getName()))) {
					if (Levelup != null)
						Tree.addContent(Levelup);
					Levelup = new Element("Levelup-" + node.getLevelup());
				}
				fanodeid = new Element("fanodeid-" + node.getNodefid());
				nodeid = new Element("nodeid");
				nodeid.addContent(String.valueOf(node.getNodeid()));
				name = new Element("name");
				name.addContent(node.getNodename() == null ? "" : node
						.getNodename().toString());
				type = new Element("type");
				type.addContent(String.valueOf(node.getType()));
				url = new Element("url");
				url.addContent((node.getUrl() == null ? "" : node.getUrl())
						.toString());
				imgurl = new Element("imgurl");
				imgurl.addContent((node.getImgurl() == null ? "" : node
						.getImgurl()).toString());
				rem = new Element("rem");
				rem.addContent((node.getRem() == null ? "" : node.getRem())
						.toString());
				fanodeid.addContent(nodeid);
				fanodeid.addContent(name);
				fanodeid.addContent(type);
				fanodeid.addContent(url);
				fanodeid.addContent(imgurl);
				fanodeid.addContent(rem);
				Levelup.addContent(fanodeid);
			}
			if (Levelup != null)
				Tree.addContent(Levelup);
		}
		String treeStr = StringUtil.ElementToString(Tree, "GBK");
		System.out.println(treeStr);
		return treeStr;
	}

	private String packageXml2(List<UserPower> list) {
		Element Tree = new Element("Tree");
		if ((list != null) && (list.size() > 0)) {
			Element Levelup = null;
			Element fanodeid = null;
			Element nodeid = null;
			Element name = null;
			Element type = null;
			Element url = null;
			Element imgurl = null;
			Element rem = null;

			Node node = null;
			for (int i = 0; i < list.size(); i++) {
				node = list.get(i).getNode();
				if ((Levelup == null)
						|| (!String.valueOf("Levelup-" + node.getLevelup())
								.equals(Levelup.getName()))) {
					if (Levelup != null)
						Tree.addContent(Levelup);
					Levelup = new Element("Levelup-" + node.getLevelup());
				}
				fanodeid = new Element("fanodeid-" + node.getNodefid());
				nodeid = new Element("nodeid");
				nodeid.addContent(String.valueOf(node.getNodeid()));
				name = new Element("name");
				name.addContent(node.getNodename() == null ? "" : node
						.getNodename().toString());
				type = new Element("type");
				type.addContent(String.valueOf(node.getType()));
				url = new Element("url");
				url.addContent((node.getUrl() == null ? "" : node.getUrl())
						.toString());
				imgurl = new Element("imgurl");
				imgurl.addContent((node.getImgurl() == null ? "" : node
						.getImgurl()).toString());
				rem = new Element("rem");
				rem.addContent((node.getRem() == null ? "" : node.getRem())
						.toString());
				fanodeid.addContent(nodeid);
				fanodeid.addContent(name);
				fanodeid.addContent(type);
				fanodeid.addContent(url);
				fanodeid.addContent(imgurl);
				fanodeid.addContent(rem);
				Levelup.addContent(fanodeid);
			}
			if (Levelup != null)
				Tree.addContent(Levelup);
		}
		String treeStr = StringUtil.ElementToString(Tree, "GBK");
		System.out.println(treeStr);
		return treeStr;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

	public UsersService getUsersService() {
		return this.usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public NodeService getNodeService() {
		return this.nodeService;
	}

	public void setNodeService(NodeService nodeService) {
		this.nodeService = nodeService;
	}

	public UserPowerService getUserPowerService() {
		return this.userPowerService;
	}

	public void setUserPowerService(UserPowerService userPowerService) {
		this.userPowerService = userPowerService;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

}
