package cs4240f13.hoowhatyouwearing.objects;

import java.util.List;

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
	
	
}
