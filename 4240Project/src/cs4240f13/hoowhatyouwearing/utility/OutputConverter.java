package cs4240f13.hoowhatyouwearing.utility;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class OutputConverter {
	
	private static JsonParser parser = new JsonParser();

/// This can be done by toString()
//	public static String stringify(JsonElement json) {
//		return parser.toString();
//	}
	
	// Converts json string to JsonObject
	public static JsonElement jsonify(String json) {
		return parser.parse(json);
	}
	
}