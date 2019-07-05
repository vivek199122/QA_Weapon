package com.qa.configuration;

public class RestConfiguration {
	private RestConfiguration() {
	}

	private static String get(String key) {
		return System.getProperty(key);
	}

	public static String getRemoteURL() {
		return get("env.url");
	}

	public static String getBrowserName() {
		return get("env.serviceurl");
	}

	public static String getDriverEnvironment() {
		return get("app.env");
	}
	
	public static String getPlatform() {
		return get("app.platform");
	}
}
