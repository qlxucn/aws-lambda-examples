package de.ozzc.lambda.model;

import java.util.Map;

/**
 * Created by xiaolongxu on 4/5/17.
 */
public class ApiGatewayResponse {
    private String statusCode;
    private String body;
    private Map<String, String> headers;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
