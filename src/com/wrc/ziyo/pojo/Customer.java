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
@Table(name = "T_CUSTOMER")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "TC_ID", unique = true, nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_SEQ")
	@SequenceGenerator(name = "CUSTOMER_SEQ", allocationSize = 1, initialValue = 1, sequenceName = "CUSTOMER_SEQ")
	private Integer id;

	@Column(name = "khbh")
	private String khbh;

	@Column(name = "khmc")
	private String khmc;

	@Column(name = "dz")
	private String dz;

	@Column(name = "lxr")
	private Integer lxr;

	@Column(name = "lxdh")
	private String lxdh;

	@Column(name = "qy")
	private String qy;

	@Column(name = "ywy")
	private String ywy;

	@Column(name = "fhfs")
	private String fhfs;

	@Column(name = "bz")
	private String bz;

	@Column(name = "hkfs")
	private String hkfs;

	@Column(name = "jc")
	private String jc;

	@Column(name = "last_time")
	private Date lastTime;

	@Column(name = "user_id")
	private Integer userid;

	@OneToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private Users users;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKhbh() {
		return khbh;
	}

	public void setKhbh(String khbh) {
		this.khbh = khbh;
	}

	public String getKhmc() {
		return khmc;
	}

	public void setKhmc(String khmc) {
		this.khmc = khmc;
	}

	public String getDz() {
		return dz;
	}

	public void setDz(String dz) {
		this.dz = dz;
	}

	public Integer getLxr() {
		return lxr;
	}

	public void setLxr(Integer lxr) {
		this.lxr = lxr;
	}

	public String getLxdh() {
		return lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getQy() {
		return qy;
	}

	public void setQy(String qy) {
		this.qy = qy;
	}

	public String getYwy() {
		return ywy;
	}

	public void setYwy(String ywy) {
		this.ywy = ywy;
	}

	public String getFhfs() {
		return fhfs;
	}

	public void setFhfs(String fhfs) {
		this.fhfs = fhfs;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getHkfs() {
		return hkfs;
	}

	public void setHkfs(String hkfs) {
		this.hkfs = hkfs;
	}

	public String getJc() {
		return jc;
	}

	public void setJc(String jc) {
		this.jc = jc;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}
}