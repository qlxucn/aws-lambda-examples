package de.ozzc.lambda.model;

import java.util.Map;

/**
 * Created by xiaolongxu on 4/4/17.
 */
public class ApiGatewayRequest {
    private String resource;
    private String path;
    private Map<String, String> headers;
    private Map<String, String> queryStringParameters;
    private String pathParameters;
    private String stageVariables;
    private ApiGatewayRequestContext requestContext;
    private String body;
    private boolean isBase64Encoded;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getQueryStringParameters() {
        return queryStringParameters;
    }

    public void setQueryStringParameters(Map<String, String> queryStringParameters) {
        this.queryStringParameters = queryStringParameters;
    }

    public String getPathParameters() {
        return pathParameters;
    }

    public void setPathParameters(String pathParameters) {
        this.pathParameters = pathParameters;
    }

    public String getStageVariables() {
        return stageVariables;
    }

    public void setStageVariables(String stageVariables) {
        this.stageVariables = stageVariables;
    }

    public ApiGatewayRequestContext getRequestContext() {
        return requestContext;
    }

    public void setRequestContext(ApiGatewayRequestContext requestContext) {
        this.requestContext = requestContext;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isBase64Encoded() {
        return isBase64Encoded;
    }

    public void setIsBase64Encoded(boolean isBase64Encoded) {
        this.isBase64Encoded = isBase64Encoded;
    }

    public class ApiGatewayRequestContext {
        private String resource;
        private String resourceId;
        private String stage;
        private Map<String, String> identity;
        private String resourcePath;
        private String httpMethod;
        private String apiId;

        public String getResource() {
            return resource;
        }

        public void setResource(String resource) {
            this.resource = resource;
        }

        public String getResourceId() {
            return resourceId;
        }

        public void setResourceId(String resourceId) {
            this.resourceId = resourceId;
        }

        public String getStage() {
            return stage;
        }

        public void setStage(String stage) {
            this.stage = stage;
        }

        public Map<String, String> getIdentity() {
            return identity;
        }

        public void setIdentity(Map<String, String> identity) {
            this.identity = identity;
        }

        public String getResourcePath() {
            return resourcePath;
        }

        public void setResourcePath(String resourcePath) {
            this.resourcePath = resourcePath;
        }

        public String getHttpMethod() {
            return httpMethod;
        }

        public void setHttpMethod(String httpMethod) {
            this.httpMethod = httpMethod;
        }

        public String getApiId() {
            return apiId;
        }

        public void setApiId(String apiId) {
            this.apiId = apiId;
        }
    }
}




