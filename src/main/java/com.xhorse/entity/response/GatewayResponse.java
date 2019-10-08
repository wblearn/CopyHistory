package com.xhorse.entity.response;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GatewayResponse  {

    private String body;
    private Map<String, String> headers;
    private  int statusCode;

    public GatewayResponse(){

    }

    public GatewayResponse( final String body, final Map<String, String> headers, final int statusCode) {
        this.statusCode = statusCode;
        this.body = body;
        this.headers = Collections.unmodifiableMap(new HashMap<>(headers));
    }

    public String getBody() {
        return body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setBody( String body ) {
        this.body = body;
    }

    public void setHeaders( Map<String, String> headers ) {
        this.headers = headers;
    }

    public void setStatusCode( int statusCode ) {
        this.statusCode = statusCode;
    }

}
