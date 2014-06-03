package com.finna.be.octo.avenger.core.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "USER_ROLES")
@SequenceGenerator(name = "ROLES_SEQ", initialValue = 1, allocationSize = 100)
public class DBRole {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLES_SEQ")
	private long id;

	@Column(name = "USER_NAME", unique = true)
	private String userName;

	@Column(name = "ROLE_NAME")
	private String roleName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
