package cs4240f13.hoowhatyouwearing.objects;

import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import cs4240f13.hoowhatyouwearing.utility.ApiRequest;
import cs4240f13.hoowhatyouwearing.utility.OutputConverter;
import cs4240f13.hoowhatyouwearing.utility.XmlBuilder;
import cs4240f13.hoowhatyouwearing.utility.XmlReader;

public class User {
	private static final User CONTEXT = new User();
    private static TempUnit temperature;
    private static String location;
    private static List<String> clothes;
    
    private User() {
        XmlBuilder.createIfMissing();
        update();
    }
    
    public static User getContext() {
        return CONTEXT;
    }
    
    public void update() {
        temperature = TempUnit.convert(XmlReader.retrieveTextElement("unit"));
        location = XmlReader.retrieveTextElement("location");
        clothes = XmlReader.retrieveTextElements("clothes", "article");
    }
    
    public TempUnit getTemperatureUnit() {
        return temperature;
    }
    
    public String getLocation() {
        return location;
    }
    
    public List<String> getClothes() {
        return clothes;
    }
    
    public void setTemperatureUnit(String unit) {
    	XmlBuilder.removeElement("unit", null, temperature.toString().toLowerCase());
    	XmlBuilder.addElement("unit", null, unit);
    	temperature = TempUnit.convert(unit);
    }
    
    public void setLocation(String city) {
    	XmlBuilder.removeElement("location", null, location);
    	XmlBuilder.addElement("location", null, city);
    	location = city;
    }
	
}
