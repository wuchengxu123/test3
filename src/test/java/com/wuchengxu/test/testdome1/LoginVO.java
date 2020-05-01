package com.wuchengxu.test.testdome1;

import lombok.AllArgsConstructor;
import lombok.Getter;

//封装登录信息
	@AllArgsConstructor
	@Getter
public class LoginVO {
	private String username;
	private String password;
}
