package getandpost;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.httpclient.LoginParameBean;
import com.httpclient.ReadConfig;

import util.MybatisUtil;

public class LoginApiTest {
	//带参数的get请求
	
	public void test1() throws Exception {
		//添加请求参数
		HashMap<String, String> map=new HashMap<String, String>();
		LoginParameBean bean=MybatisUtil.getSqlSession().selectOne("login", 1);
		
		bean.getStart();
		bean.getValue();
		bean.getEnd();
		bean.getValue2();
		
		System.out.println("bean---"+bean);
		map.put(bean.getStart(), "1");
		map.put(bean.getEnd(), "20");
		//获取url
		String url=ReadConfig.getHostOrUrl("login.url");
		HttpClientResult result= HttpClientUtil.doGet(url,map);
		//获取响应的body
		String ent= result.getContent();
		System.out.println(ent);
		//获取响应的headers
		Header[] headers=result.getHeaders();
		for (Header header : headers) {
			System.out.println(header);
			
		}
		System.out.println(headers);
		
		//获得响应码
		int code=result.getCode();
		//断言
		assertEquals(code, 200);
		
	}
	
	public void test2() {
		LoginParameBean a=new LoginParameBean();
		a.setEnd("wuhan");
		a.setStart("wuhan");
		a.setValue(2147483647);
		a.setValue2(5000000);
		a.setId(3);
		SqlSession SqlSession=MybatisUtil.getSqlSession();
		SqlSession.insert("login1", a);
		SqlSession.commit();
		
		
		
	
		
	}
	@Test
	public void test3() throws ClientProtocolException, IOException {
		String url=
				"https://api.apishop.net/communication/phone/"
				+ "getLocationByPhoneNum?apiKey=158954752&phoneNum=13421804856";
		CloseableHttpClient httpclient=HttpClients.createDefault();
		HttpGet get =new HttpGet(url);
		HttpResponse response=httpclient.execute(get);
		//判断响应head中是否有对应字段
		Boolean bo= response.containsHeader("Content-Type");
		System.out.println("bo为:"+bo);
		
		
		
		//获取响应吗
		StatusLine a=response.getStatusLine();
		int b=a.getStatusCode();
		System.out.println(b);
		System.out.println(response);
		HttpEntity entity=response.getEntity();
		String abc=EntityUtils.toString(entity);
		JSONObject json=JSON.parseObject(abc);
		System.out.println("abc为:"+abc);
		System.out.println("-----------------------");
		System.out.println(json);
		System.out.println("-----------------------");
		System.out.println(json.getString("desc"));
		
		
		
	}
	
	

}
