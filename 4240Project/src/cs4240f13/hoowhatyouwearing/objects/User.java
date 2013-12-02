package cs4240f13.hoowhatyouwearing.objects;

import java.util.List;

import cs4240f13.hoowhatyouwearing.utility.TempUnit;
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
		location = XmlReader.retrieveTextElement("location").replaceAll("\\s+","");
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
	
}
