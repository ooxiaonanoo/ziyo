package com.wrc.ziyo.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_USERS")
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "user_id", unique = true, nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
	@SequenceGenerator(name = "users_seq", allocationSize = 1, initialValue = 1, sequenceName = "users_seq")
	private Integer id;

	// 用户账号
	@Column(name = "USER_ACCOUNT")
	private String userAccount;

	@Column(name = "USER_EMAIL")
	private String userEmail;

	// 启用标志 Y:启用 N：不启用
	@Column(name = "USER_FLAG")
	private String userFlag;

	// 用户名称
	@Column(name = "USER_NAME")
	private String userName;

	// 联系电话
	@Column(name = "USER_PHONE")
	private String userPhone;

	// 用户密码 MD5加密
	@Column(name = "USER_PWD")
	private String userPwd;

	// 用户备注
	@Column(name = "USER_REM")
	private String userRem;

	// 用户类型
	@Column(name = "USER_TYPE")
	private Integer userType;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserFlag() {
		return userFlag;
	}

	public void setUserFlag(String userFlag) {
		this.userFlag = userFlag;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserRem() {
		return userRem;
	}

	public void setUserRem(String userRem) {
		this.userRem = userRem;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

}

/*
 * Location: C:\Users\asus\Desktop\sshFrame\WebContent\WEB-INF\classes\
 * Qualified Name: com.wrc.sshFrame.pojo.Users JD-Core Version: 0.6.0
 */