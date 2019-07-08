package com.qa.configuration;

public class RestConfiguration {
	private RestConfiguration() {
	}

	private static String get(String key) {
		return System.getProperty(key);
	}

	public static String getBaseURL() {
		return get("env.baseurl");
	}

	public static String getApiURL() {
		return get("env.apiurl");
	}

	public static String getDriverEnvironment() {
		return get("app.env");
	}
	
	public static String getPlatform() {
		return get("app.platform");
	}
}
