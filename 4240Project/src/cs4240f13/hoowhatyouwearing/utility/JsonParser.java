package cs4240f13.hoowhatyouwearing.utility;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class JsonParser {
	
	public static String getCurrentTemp(String url){
		JsonElement e = OutputConverter.jsonify(ApiRequest.get(url));
		return ((JsonObject)e).getAsJsonObject("main").get("temp").toString();
	}
	
	public static String getCity(String url){
		JsonElement e = OutputConverter.jsonify(ApiRequest.get(url));
		return ((JsonObject)e).getAsJsonArray("list").get(0).getAsJsonObject().get("name").toString();
		
	}
	
	public static String getCurrentDescription (String url){
		JsonElement e = OutputConverter.jsonify(ApiRequest.get(url));
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
		return ((JsonObject)e).getAsJsonArray("list").get(day-1).getAsJsonObject().getAsJsonObject("temp").get(lowOrHigh).toString();
		
	}
	
	public static String getForecastDescriptions(int day, String url){
		JsonElement e = OutputConverter.jsonify(ApiRequest.get(url));
		return ((JsonObject)e).getAsJsonArray("list").get(day-1).getAsJsonObject().getAsJsonArray("weather").get(0).getAsJsonObject().get("description").toString();
	}
	
}
