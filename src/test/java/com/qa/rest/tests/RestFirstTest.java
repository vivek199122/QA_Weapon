package com.qa.rest.tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.BaseTest;
import com.qa.request_body.UserRequest;
import com.qa.response_body.UserResponse;
import com.rest.coreclasses.Constant;

public class RestFirstTest extends BaseTest {

	CloseableHttpResponse closeableHttpResponse;
	HashMap<String, String> headers;

	@Test(description = "This get call", priority = 1)
	public void getAPITest() throws ClientProtocolException, IOException {
		
		 test = extent.createTest("Test Case 1", "PASSED test case");

		closeableHttpResponse = restClient.get(requestURL);

		// a. status Code
		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(Constant.RESPONSE_STATUS_CODE_200, statusCode);

		System.out.println(statusCode);

		// b. response String json
		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		System.out.println(responseString);

		JSONObject responseJson = new JSONObject(responseString);
		System.out.println(responseJson);

		// c. All Headers
		Header[] headersArray = closeableHttpResponse.getAllHeaders();

		HashMap<String, Object> allHeader = new HashMap<String, Object>();
		for (Header header : headersArray) {

			allHeader.put(header.getName(), header.getValue());
		}

		System.out.println(allHeader);

	}

	@Test(priority = 2)
	public void postAPITest() throws ClientProtocolException, IOException {

		headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");

		ObjectMapper mapper = new ObjectMapper();

		UserRequest userrequest = new UserRequest();
		userrequest.setName("sumit");
		userrequest.setJob("ios");

		// java object to json => marshalling
		// mapper.writeValue(new
		// File("D:\\Vivek\\Project\\Essentials_Demo\\src\\main\\java\\com\\qa\\data\\user.json"),userrequest
		// );

		String userjsonreqeustbody = mapper.writeValueAsString(userrequest);
		System.out.println(userjsonreqeustbody);

		closeableHttpResponse = restClient.post(requestURL, userjsonreqeustbody, headers);

		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		Assert.assertEquals(statusCode, Constant.RESPONSE_STATUS_CODE_201);

		String userresponseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		System.out.println(userresponseString);

//		JSONObject responsejson = new JSONObject(userjsonreqeustbody);

		// json to java object => unmarshalling
		UserResponse userresponse = mapper.readValue(userresponseString, UserResponse.class);

		Assert.assertEquals(userresponse.getName(), userrequest.getName());

		System.out.println(userresponse.getId());
		System.out.println(userresponse.getJob());
		System.out.println(userresponse.getName());
		System.out.println(userresponse.getCreatedAt());
	}
}
