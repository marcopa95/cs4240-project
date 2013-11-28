package cs4240f13.hoowhatyouwearing.utility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;

public class ApiRequest {
	
	// HTTP Get Method
	public static String get(String url) {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		HttpResponse response = null;
		try {
			response = client.execute(request);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return stringify(response);
	}
	
	// HTTP Post Method
	public static String post(String url, List<NameValuePair> bodyParams) {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(url);
		HttpResponse response = null;
		try {
			response = client.execute(request);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return stringify(response);
	}
	
	// HTTP Put Method
	public static String put(String url, List<NameValuePair> bodyParams) {
		HttpClient client = HttpClientBuilder.create().build();
		HttpPut request = new HttpPut(url);
		HttpResponse response = null;
		try {
			response = client.execute(request);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return stringify(response);
	}
	
	// HTTP Delete Method
	public static String delete(String url) {
		HttpClient client = HttpClientBuilder.create().build();
		HttpDelete request = new HttpDelete(url);
		HttpResponse response = null;
		try {
			response = client.execute(request);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return stringify(response);
	}
	
	// Convert HttpResponse to String (implemented in the HTTP request methods)
	private static String stringify(HttpResponse response) {
		BufferedReader rd;
		StringBuilder retString = new StringBuilder();
		try {
			rd = new BufferedReader
			  (new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
			  retString.append(line);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return retString.toString();
	}

}