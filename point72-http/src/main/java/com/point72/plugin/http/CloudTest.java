package com.point72.plugin.http;

import java.text.MessageFormat;
import java.util.Random;

public class CloudTest {

	static String countUri = "/count?value={0}";
	static String oddUri = "/odd?value={0}";
	static String one = "http://192.168.3.48:9003/one";
	static String two = "http://192.168.3.48:9003/two";
	static String three = "http://192.168.3.48:9003/three";
	static String four = "http://192.168.3.48:9003/four";
	static String error = "http://192.168.3.48:9003/one/error";

	static Random random = new Random();

	public static void main(String[] args) throws InterruptedException {

		while (true) {
			System.out.println("http://192.168.3.48:9003/one/count?value={0}  Result:"
					+ com.point72.plugin.http.HttpClient.get(one + MessageFormat.format(countUri, randomEven())));
			System.out.println("http://192.168.3.48:9003/two/count?value={0}  Result:"
					+ com.point72.plugin.http.HttpClient.get(two + MessageFormat.format(countUri, randomEven())));
			System.out.println("http://192.168.3.48:9003/three/count?value={0}  Result:"
					+ com.point72.plugin.http.HttpClient.get(three + MessageFormat.format(countUri, randomEven())));
			System.out.println("http://192.168.3.48:9003/four/odd?value={0}  Result:"
					+ com.point72.plugin.http.HttpClient.get(four + MessageFormat.format(oddUri, randomOdd())));
			System.out.println(
					"http://192.168.3.48:9003/one/error  Result:" + com.point72.plugin.http.HttpClient.get(error));
			Thread.sleep(1000);
		}

	}

	public static int randomOdd() {
		int value = random.nextInt(1000);
		if (value % 2 == 0) {
			return randomOdd();
		} else {
			return value;
		}
	}

	public static int randomEven() {
		int value = random.nextInt(1000);
		if (value % 2 != 0) {
			return randomEven();
		} else {
			return value;
		}
	}

}
