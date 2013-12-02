package cs4240f13.hoowhatyouwearing.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import cs4240f13.hoowhatyouwearing.objects.User;

public class XmlReader {
	
	/**
	 * Retrieve the inner text for "unit" or "location" 
	 * @param tag select between "unit" and "location"
	 * @return the inner text (on success only)
	 */
	public static String retrieveTextElement(String tag) {
		Document doc = getDocument();
		Node node = doc.getElementsByTagName(tag).item(0);
		return node.getTextContent();
	}
	
	/**
	 * Retrieve the inner text for articles in "clothes"
	 * @param parentTag enter "clothes"
	 * @param childTag enter "article"
	 * @return a list of articles
	 */
	public static ArrayList<String> retrieveTextElements(String parentTag, String childTag) {
		ArrayList<String> elementList = new ArrayList<String>();
		Document doc = getDocument();
		NodeList nodeList = doc.getElementsByTagName(parentTag).item(0).getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			elementList.add(nodeList.item(i).getTextContent());
		}
		return elementList;
	}
	
	private static Document getDocument() {
		try {
			File fXmlFile = new File("./settings.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
			
			return doc;
		}
		catch (SAXException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*public static void main(String[] args) {
		XmlBuilder.createIfMissing();
		XmlBuilder.addElement("location", null, "London");
		XmlBuilder.removeElement("location", null, "London");
		XmlBuilder.addElement("location", null, "Obama, Japan");
		XmlBuilder.addElement("location", null, "Obama, Japan");
		XmlBuilder.addElement("unit", null, "fahrenheit");
		XmlBuilder.addElement("clothes", "article", "shirt");
		XmlBuilder.addElement("clothes", "article", "athletic shorts");
		XmlBuilder.addElement("clothes", "article", "timberlands");
		XmlBuilder.addElement("clothes", "article", "timberlands");
		XmlBuilder.removeElement("clothes", "article", "athletic shorts");
		User currentUser = User.getContext();
		JsonElement e = OutputConverter.jsonify(ApiRequest.get("http://api.openweathermap.org/data/2.5/weather?q=" + currentUser.getLocation() + "&mode=json&units=" + currentUser.getTemperatureUnit().getApiKeyword()));
		System.out.println(((JsonObject)e).getAsJsonObject("main").get("temp").toString());
	}*/ // Tests I ran. - Jordan
	
}
