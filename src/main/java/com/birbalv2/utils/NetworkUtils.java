package com.birbalv2.utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import org.apache.http.HttpException;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class NetworkUtils {
	public static String localIPAddress() {
		try {
			for (Enumeration<NetworkInterface> en = NetworkInterface
					.getNetworkInterfaces(); en.hasMoreElements();) {
				NetworkInterface intf = en.nextElement();
				for (Enumeration<InetAddress> enumIpAddr = intf
						.getInetAddresses(); enumIpAddr.hasMoreElements();) {
					InetAddress inetAddress = enumIpAddr.nextElement();
					if (!inetAddress.isLoopbackAddress()) {
						String ipAddress = inetAddress.getHostAddress()
								.toString();
						int p = ipAddress.indexOf("%");
						if (p > 0)
							ipAddress = ipAddress.substring(0, p);
						return ipAddress;
					}
				}
			}
		} catch (SocketException ex) {
			ex.printStackTrace();
		}
		return "127.0.0.1";
	}

	public static String responseContent(String url) throws Exception {
		// Create an instance of HttpClient.
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response = httpclient.execute(httpGet);
		
		String output = null;
		// Provide custom retry handler is necessary
		try {
			// Execute the method.
			int statusCode = response.getStatusLine().getStatusCode();

			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method failed: " + response.getStatusLine());
			}

			// Deal with the response.
			// Use caution: ensure correct character encoding and is not binary
			// data
			output = EntityUtils.toString(response.getEntity());

		} catch (IOException e) {
			System.err.println("Fatal transport error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			response.close();
			httpclient.close();
		}
		return output;
	}
}
