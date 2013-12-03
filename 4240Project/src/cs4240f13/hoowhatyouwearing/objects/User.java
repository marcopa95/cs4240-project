package cs4240f13.hoowhatyouwearing.objects;

import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import cs4240f13.hoowhatyouwearing.utility.ApiRequest;
import cs4240f13.hoowhatyouwearing.utility.OutputConverter;
import cs4240f13.hoowhatyouwearing.utility.TempUnit;
import cs4240f13.hoowhatyouwearing.utility.XmlBuilder;

public class User {
	private static final User CONTEXT = new User();
	private TempUnit temperature;
	private String location;
	private List clothes;
	
	private User() {
		
	}
	
	public static User getContext() {
		return CONTEXT;
	}
	
	private static void populate() {
		XmlBuilder.createIfMissing();
		// still building.
	}
	
	public static String getCurrentTemp(String url){
		JsonElement e = OutputConverter.jsonify(ApiRequest.get(url));
		//System.out.println(ApiRequest.get(url));
		return ((JsonObject)e).getAsJsonObject("main").get("temp").toString();
	}
	
	public String getLocation(){
		return location;
	}
	
	public void setLocation(String newLocation){
		location = newLocation;
	}
	
	public static String getCity(String url){
		JsonElement e = OutputConverter.jsonify(ApiRequest.get(url));
		//System.out.println(ApiRequest.get(url));
		return ((JsonObject)e).getAsJsonArray("list").get(0).getAsJsonObject().get("name").toString();
		
	}
	
	public static String getDescription (String url){
		JsonElement e = OutputConverter.jsonify(ApiRequest.get(url));
		//System.out.println(ApiRequest.get(url));
		return ((JsonObject)e).getAsJsonArray("weather").get(0).getAsJsonObject().get("description").toString();
	}
	
	public static String getCorF (String url){
		if(url.contains("imperial")){
			return "degrees F";
		} else {
			return "degrees C";
		}
	}
	
	public static String getLowHigh(int day, String lowOrHigh, String url){
		JsonElement e = OutputConverter.jsonify(ApiRequest.get(url));
		//System.out.println(ApiRequest.get(url));
		return ((JsonObject)e).getAsJsonArray("list").get(day-1).getAsJsonObject().getAsJsonObject("temp").get(lowOrHigh).toString();
		
	}
	
}
