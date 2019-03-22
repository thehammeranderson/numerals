package com.thehammer.numerals;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

/**
 * Hello world!
 *
 */
public class RomanNumeralConversion
		implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
	private String numeralInput;

	public String getNumeralInput() {
		return numeralInput;
	}

	public void setNumeralInput(String numeralInput) {
		this.numeralInput = numeralInput;
	}

	static Map<String, Integer> numeralMap = new HashMap<String, Integer>();
	static {
		numeralMap.put("I", 1);
		numeralMap.put("V", 5);
		numeralMap.put("X", 10);
		numeralMap.put("L", 50);
		numeralMap.put("C", 100);
		numeralMap.put("D", 500);
		numeralMap.put("M", 1000);
	}

	public RomanNumeralConversion() {
		super();
	}

	public RomanNumeralConversion(String input) {
		super();
		numeralInput = input;
	}

	public RomanNumeralConversion(APIGatewayProxyRequestEvent input) {
		super();
		if (input.getBody() != null) {
			numeralInput = input.getBody();
		}
		
		Map<String,String> queryParams = input.getQueryStringParameters();
		if (queryParams != null && queryParams.containsKey("numeral")) {
			numeralInput = queryParams.get("numeral");
		}

		Map<String,String> pathParams = input.getPathParameters();
		if (pathParams != null && pathParams.containsKey("numerals")) {
			numeralInput = pathParams.get("numerals");
		}
	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	public int calculateNumeral() throws InvalidCharacterException, InvalidSequenceException {
		String[] characters = numeralInput.split("");

		validate(characters);

		int sum = 0;
		for (int pos = 0; pos < characters.length; pos++) {
			String numeralChar = characters[pos];

			if (pos + 1 < characters.length && numeralMap.get(numeralChar) < numeralMap.get(characters[pos + 1])) {
				sum += numeralMap.get(characters[pos + 1]) - numeralMap.get(numeralChar);
				pos++;
			} else {
				sum += numeralMap.get(characters[pos]);
			}
		}
		return sum;
	}

	private void validate(String[] characters) throws InvalidSequenceException, InvalidCharacterException {
		int upTimes = 0;

		for (int pos = 0; pos < characters.length; pos++) {
			String numeralChar = characters[pos];

			if (numeralMap.get(numeralChar) == null) {
				throw new InvalidCharacterException("invalid character input " + numeralChar);
			}

			if (pos + 1 < characters.length) {
				if (numeralMap.get(numeralChar) < numeralMap.get(characters[pos + 1])) {
					upTimes++;
					if (upTimes > 1) {
						throw new InvalidSequenceException(
							"invalid roman numeral.  numeral characters can increase in value one time when preceeded by a subractor numeral (ie. IV)");
					}
//				} else if (upTimes == 1 && numeralChar.equals(characters[pos + 1]) ) {
//					throw new InvalidSequenceException("invalid roman numeral. same numeral character cannot follow a subractor sequence of that numeral character (ie. IVV should be VIV or IXX should be XIX)");
				} else {
					upTimes = 0;
				}
			}
		}
	}

	@Override
	public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
		APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
		try {
			RomanNumeralConversion newApp = new RomanNumeralConversion((APIGatewayProxyRequestEvent) input);
			Integer value = newApp.calculateNumeral();

			response.setHeaders(Collections.singletonMap("x-custom-header", "my custom header value"));
			response.setStatusCode(200);

			Map<String, String> responseBody = new HashMap<String, String>();
			responseBody.put("input", input.toString());
			responseBody.put("value", value.toString());
			String responseBodyString = new JSONObject(responseBody).toString();

			response.setBody(responseBodyString);
			return response;
		} catch (Exception pex) {
			response.setStatusCode(400);

			Map<String, String> responseBody = Collections.singletonMap("message", pex.toString());
			String responseBodyString = new JSONObject(responseBody).toString();
			response.setBody(responseBodyString);
		}
		return response;
	}	
}
