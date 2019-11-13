package com.qa.rest.coreclasses;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {

	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();

		HttpGet httpget = new HttpGet(url);

		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpget);

		return closeableHttpResponse;
	}

	public CloseableHttpResponse post(String url, String entityString, HashMap<String, String> headers)
			throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();

		HttpPost httppost = new HttpPost(url);

		for (Map.Entry<String, String> entry : headers.entrySet()) {

			httppost.addHeader(entry.getKey(), entry.getValue());
		}

		httppost.setEntity(new StringEntity(entityString));

		return httpClient.execute(httppost);
	}
}
