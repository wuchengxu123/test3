package com.httpclient;

import java.net.URI;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public class MyHttpGet extends HttpEntityEnclosingRequestBase {

	public static final String METHOD_NAME = "GET";
	@Override
    public String getMethod() {
        return METHOD_NAME;
    }
    public MyHttpGet( String uri) {
        super();
        setURI(URI.create(uri));
    }

    public MyHttpGet( URI uri) {
        super();
        setURI(uri);
    }

    public MyHttpGet() {
        super();
    }

}
