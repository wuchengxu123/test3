package com.wuchengxu.test.testdome1;

import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import mymapperinterface.ClientMapper;
import util.MybatisUtil;

public class App{
	
	public void testLogin() {
		LoginVO vo=new LoginVO("lucy", "111111");
		SqlSession session=MybatisUtil.getSqlSession();
		ClientMapper clientMapper=session.getMapper(ClientMapper.class);
		client cli=clientMapper.login1(vo);
		session.close();
		System.out.println(cli);
	}
	
	public void testLogin1() {
		SqlSession session=MybatisUtil.getSqlSession();
		ClientMapper clientMapper=session.getMapper(ClientMapper.class);
		client cli=clientMapper.login2("will","1111");
		session.close();
		System.out.println(cli);
	}
	
}
