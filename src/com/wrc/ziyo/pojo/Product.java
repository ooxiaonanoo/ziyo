package com.wrc.ziyo.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "T_PRODUCT")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "TP_ID", unique = true, nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Suppliers_seq")
	@SequenceGenerator(name = "Suppliers_seq", allocationSize = 1, initialValue = 1, sequenceName = "Suppliers_seq")
	private Integer id;

	@Column(name = "CPBM")
	private String cpbm;

	@Column(name = "CPMC")
	private String cpmc;

	@Column(name = "CPGG")
	private String cpgg;

	@Column(name = "LXR")
	private String lxr;

	@Column(name = "CPLX")
	private Integer cplx;

	@Column(name = "TS_ID")
	private String tsid;

	@OneToOne
	@JoinColumn(name = "TS_ID", insertable = false, updatable = false)
	private Suppliers suppliers;

	@Column(name = "USER_ID")
	private Integer userid;

	@OneToOne
	@JoinColumn(name = "USER_ID", insertable = false, updatable = false)
	private Users users;

	@Column(name = "LAST_TIME")
	private Date lastTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpbm() {
		return cpbm;
	}

	public void setCpbm(String cpbm) {
		this.cpbm = cpbm;
	}

	public String getCpmc() {
		return cpmc;
	}

	public void setCpmc(String cpmc) {
		this.cpmc = cpmc;
	}

	public String getCpgg() {
		return cpgg;
	}

	public void setCpgg(String cpgg) {
		this.cpgg = cpgg;
	}

	public String getLxr() {
		return lxr;
	}

	public void setLxr(String lxr) {
		this.lxr = lxr;
	}

	public Integer getCplx() {
		return cplx;
	}

	public void setCplx(Integer cplx) {
		this.cplx = cplx;
	}

	public String getTsid() {
		return tsid;
	}

	public void setTsid(String tsid) {
		this.tsid = tsid;
	}

	public Suppliers getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(Suppliers suppliers) {
		this.suppliers = suppliers;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

}
