package com.birbalv2.utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class NetworkUtils {
	public static int MAX_RETRIES = 10;
	static {
		/*
		 * fix for Exception in thread "main"
		 * javax.net.ssl.SSLHandshakeException:
		 * sun.security.validator.ValidatorException: PKIX path building failed:
		 * sun.security.provider.certpath.SunCertPathBuilderException: unable to
		 * find valid certification path to requested target
		 */
	    TrustManager[] trustAllCerts = new TrustManager[] {
	       new X509TrustManager() {
	          public java.security.cert.X509Certificate[] getAcceptedIssuers() {
	            return null;
	          }

	          public void checkClientTrusted(X509Certificate[] certs, String authType) {  }

	          public void checkServerTrusted(X509Certificate[] certs, String authType) {  }

	       }
	    };

	    SSLContext sc;
		try {
			sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
		    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    // Create all-trusting host name verifier
	    HostnameVerifier allHostsValid = new HostnameVerifier() {
	        public boolean verify(String hostname, SSLSession session) {
	          return true;
	        }
	    };
	    // Install the all-trusting host verifier
	    HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	    /*
	     * end of the fix
	     */
	}

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
		HttpGet httpGet = new HttpGet(url);
		return responseContent(httpGet);
	}

	public static String responseContent(HttpGet httpGet) throws Exception {
		boolean success = false;
		int retries = 0;
		String output = null;

		while (retries < MAX_RETRIES && !success) {
			// Create an instance of HttpClient.
			CloseableHttpClient httpclient = HttpClients.createDefault();
			CloseableHttpResponse response = httpclient.execute(httpGet);

			// Provide custom retry handler is necessary
			try {
				// Execute the method.
				int statusCode = response.getStatusLine().getStatusCode();

				if (statusCode != HttpStatus.SC_OK) {
					success = false;
					retries++;
					System.err.println("Method failed: "
							+ response.getStatusLine());
					Thread.sleep(2000);
				} else {
					retries++;
					success = true;
				}

				// Deal with the response.
				// Use caution: ensure correct character encoding and is not
				// binary
				// data
				output = EntityUtils.toString(response.getEntity());

			} catch (IOException e) {
				System.err.println("Fatal transport error: " + e.getMessage());
				e.printStackTrace();
			} finally {
				response.close();
				httpclient.close();
			}
		}
		return output;
	}
}

class TrustAllX509TrustManager implements X509TrustManager {
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }

    public void checkClientTrusted(java.security.cert.X509Certificate[] certs,
            String authType) {
    }

    public void checkServerTrusted(java.security.cert.X509Certificate[] certs,
            String authType) {
    }

}