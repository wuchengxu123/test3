package getandpost;

import org.apache.http.Header;

import lombok.Data;

/**
 * @program: base-parent
 * @description: http返回
 * @author: yarm
 * @create: 2019-11-18 10:51

 */
//.返回封装HttpClientResult
@Data
public class HttpClientResult {
	 
    /**
     * 响应状态码
     */
    private int code;
    
    /**
     * 响应头部(header)
     */
    private Header[] headers;
    
    /**
     * 响应数据
     */
    private String content;
 
    public HttpClientResult() {
    }
 
    public HttpClientResult(int code) {
        this.code = code;
    }
 
    public HttpClientResult(String content) {
        this.content = content;
    }
 
    public HttpClientResult(int code, String content) {
        this.code = code;
        this.content = content;
    }
    public HttpClientResult(int code, String content,Header[] headers) {
        this.code = code;
        this.content = content;
        this.headers = headers;
    }
}

