package cs4240f13.hoowhatyouwearing.utility;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class XmlBuilder {
	
	/**
	 * Creates a new XML file with the settings params if not already in application files.
	 * @return true if no exception
	 */
	public static boolean createIfMissing() {
		File file = new File("./settings.xml"); // config file URL info goes here
		if (file.isFile()) return true; // check to see if there is a config file
		
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			// root elements
			Document doc = docBuilder.newDocument();
			Element root = doc.createElement("settings");
			doc.appendChild(root);
			
			// second level elements
			Element unit = doc.createElement("unit");
			root.appendChild(unit);
			
			Element location = doc.createElement("location");
			root.appendChild(location);
			
			Element clothes = doc.createElement("clothes");
			root.appendChild(clothes);
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);
	 
			transformer.transform(source, result);
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
			return false;
		}
		catch (TransformerException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		File file = new File("src/ApiRequest.java");
		System.out.println(file.isFile());
		createIfMissing();
	}
	
}
