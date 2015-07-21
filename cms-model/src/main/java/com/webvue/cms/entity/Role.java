package com.webvue.cms.entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import ca.webvue.common.entity.BaseEntity;

public class Role extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private RoleType roleType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Enumerated(EnumType.STRING)
	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

}
