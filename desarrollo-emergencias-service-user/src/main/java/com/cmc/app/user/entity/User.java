package com.cmc.app.user.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "tbluser")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 60)
	private String name;
	@Column(name = "second_name", length = 60)
	private String secondName;
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	private Boolean enabled;

	@ManyToAny(fetch = FetchType.LAZY, metaColumn = @Column)
	private List<Rol> roles;

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	private static final long serialVersionUID = 2737734430089542998L;

}
