package com.httpclient;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class GetRequestDome {
	//发送get请求(body中带json参数)
	
	public void get() throws IOException {
	//创建httpget请求对象
	MyHttpGet get=new MyHttpGet(ReadConfig.getHostOrUrl("getlist.url"));
	get.addHeader("Cookie", "login=true");
	get.addHeader("Content-Type", "application/json");
	//String params=null;
	JSONObject json=new JSONObject();
	json.put("name","zhangsan");
	json.put("password","123456");
	     
	StringEntity entity = new StringEntity(json.toJSONString(), ContentType.APPLICATION_JSON); 
	get.setEntity(entity);
	System.out.println(entity);
	System.out.println("JSON是"+json);
	
	//创建Httpclient对象
	DefaultHttpClient client=new DefaultHttpClient();
	
	//执行get请求
	HttpResponse response1 = null;
	JSONObject response=null;
	String result=null;
	
	try {	
			response1=client.execute(get);
		     result = EntityUtils.toString(response1.getEntity());
		     System.out.println(response1.getEntity());
	} catch (ClientProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(result);
	System.out.println(response1);
	System.out.println(response);
	System.out.println("------------------------------------------------");
	}
	//演示get请求(参数拼接在url后)
	
	public void get1() throws URISyntaxException, ClientProtocolException, IOException {
		String url="http://localhost:8889/loginlist?start=12&end=24";
		HttpGet get=new HttpGet(url);
		HttpClient client=new DefaultHttpClient();
		HttpResponse response= client.execute(get);
		HttpEntity entity=response.getEntity();
		String result=EntityUtils.toString(entity);
		System.out.println("result123:"+result);
		System.out.println("------------------------------------------------");
	}
	//演示发送post请求
	
	public void post() throws Exception, IOException {
		//定义请求的url
		String url="http://localhost:8889/login";
		//创建httppost请求对象
		HttpPost post=new HttpPost(url);
		//添加cookie
		post.setHeader("Cookie", "login=true");
		//创建存储参数的list
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("username", "zhangsan"));
		list.add(new BasicNameValuePair("password", "123456"));
		//设置url格式编码
		UrlEncodedFormEntity urlentity=new UrlEncodedFormEntity(list,"UTF-8");
		post.setEntity(urlentity);
		System.out.println("POST请求----"+post.getURI());
		//执行请求
		HttpClient client=new DefaultHttpClient();
		//获得响应结果
			HttpResponse response= client.execute(post);
			Header[] header=response.getAllHeaders();
			for (Header header2 : header) {
				System.out.println("header是"+header2);
			}
			HttpEntity entity=response.getEntity();
			String result =EntityUtils.toString(entity);
			System.out.println(entity);
			System.out.println("response:"+response);
			System.out.println("result:"+result);
	}

}
