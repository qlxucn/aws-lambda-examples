package de.ozzc.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import de.ozzc.lambda.model.ApiGatewayRequest;
import de.ozzc.lambda.model.ApiGatewayResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Check API gateway input event sample at "src/main/resources/api_gateway_input_sample.json"
 * */
public class ApiGatewayRequestHandler implements RequestHandler<ApiGatewayRequest, ApiGatewayResponse> {

    @Override
    public ApiGatewayResponse handleRequest(ApiGatewayRequest request, Context context) {
        LambdaLogger logger = context.getLogger();
        String body = request.getBody();
        logger.log("Body = "+body);

        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        ApiGatewayResponse response = new ApiGatewayResponse();
        response.setStatusCode("200");
        response.setHeaders(headers);
        response.setBody(body);


        return response;
    }
}
