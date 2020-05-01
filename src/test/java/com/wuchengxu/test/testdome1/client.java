package com.wuchengxu.test.testdome1;

import java.math.BigDecimal;

public class client {
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "client [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private Long id;
	private String username;
	private String password ;
}
