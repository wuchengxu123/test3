package com.httpclient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.Test;
//该类从config.properties中读取url
public class ReadConfig {
	@Test
	public  static String getHostOrUrl(String key) throws IOException {
		InputStream in=new FileInputStream("E:\\eclipse\\testdome2\\src\\test\\java\\config.properties");
		Properties pr=new Properties();
		pr.load(in);
		String url=pr.getProperty(key);
		in.close();
		return url;

	}

}
