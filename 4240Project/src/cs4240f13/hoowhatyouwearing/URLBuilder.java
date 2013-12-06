package cs4240f13.hoowhatyouwearing;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class URLBuilder {
	
	private static int NUM_DAYS_FORECAST = 3;
	private static String DATA_FORMAT = "json";
	
	public static String buildForecastURL(String city, String tempUnits) throws UnsupportedEncodingException{
		String a = city;
		a = URLEncoder.encode(city,"utf-8");
		return "http://api.openweathermap.org/data/2.5/forecast/daily?q=" + URLEncoder.encode(city,"utf-8").replace("+", "%20") + "&mode="+ DATA_FORMAT + "&units=" + tempUnits + "&cnt=" + NUM_DAYS_FORECAST;
	}
	
	public static String buildTodayURL(String city, String tempUnits) throws UnsupportedEncodingException{
		return "http://api.openweathermap.org/data/2.5/weather?q=" + URLEncoder.encode(city,"utf-8").replace("+", "%20") + "&mode="+ DATA_FORMAT + "&units=" + tempUnits;
	}
	
}
