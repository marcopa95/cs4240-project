package cs4240f13.hoowhatyouwearing.utility;
import java.io.File;
import java.io.IOException;

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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XmlBuilder { 
	
	/* Public Methods */
	/**
	 * Creates a new XML file with the settings params if not already in application files.
	 * @return true if no exception
	 */
	public static boolean createIfMissing() {
		File file = new File("./settings.xml"); // config file URL info goes here
		if (file.isFile()) return true; // check to see if there is a config file
		
		// root elements
		Document doc = generateDoc(null);
		Element root = doc.createElement("settings");
		doc.appendChild(root);
		
		// second level elements
		Element unit = doc.createElement("unit");
		unit.appendChild(doc.createTextNode("fahrenheit"));
		root.appendChild(unit);
		
		Element location = doc.createElement("location");
		location.appendChild(doc.createTextNode("London"));
		root.appendChild(location);
		
		Element clothes = doc.createElement("clothes");
		root.appendChild(clothes);
		
		// write the content into xml file
		writeToFile(doc, file);
		
		return true;
	}
	
	/**
	 * Adds an element to the XML doc
	 * @param tag select between "unit", "location", and "clothes"
	 * @param childTag if tag = "clothes", put "article"; otherwise, put null or empty string
	 * @param value the inner text value you would like to add
	 * @return returns true if element isn't already in xml doc
	 */
	public static boolean addElement(String tag, String childTag, String value) {
		String filePath = "./settings.xml";
		Document doc = generateDoc(filePath);
		
		Node parentNode = doc.getElementsByTagName(tag).item(0);
		
		if (!doesExist(parentNode, childTag, value)) {
			if (childTag != null && !childTag.equals("")) {
				Element childNode = doc.createElement(childTag);
				childNode.appendChild(doc.createTextNode(value));
				parentNode.appendChild(childNode);
			}
			else {
				parentNode.appendChild(doc.createTextNode(value));
			}
			
			writeToFile(doc, new File(filePath));
			return true;
		}
		return false;
	}
	
	/**
	 * Removes an element or text from the XML doc
	 * @param tag select between "unit", "location", and "clothes"
	 * @param childTag if tag = "clothes", put "article"; otherwise, put null or empty string
	 * @param value the inner text value of the node you would like to remove
	 * @return true on successful removal, else false
	 */
	public static boolean removeElement(String tag, String childTag, String value) {
		String filePath = "./settings.xml";
		Document doc = generateDoc(filePath);
		
		Node parentNode = doc.getElementsByTagName(tag).item(0);
		
		if (childTag != null && !childTag.equals("")) {
			NodeList children = parentNode.getChildNodes();
			Node removedNode = null;
			
			for (int i = 0; i < children.getLength(); i++) {
				Node tempNode = children.item(i);
				if (tempNode.getTextContent().equals(value)) {
					removedNode = tempNode;
					break;
				}
			}
			
			if (removedNode == null) {
				return false;
			}
			
			parentNode.removeChild(removedNode);
		}
		else {
			if (parentNode.getTextContent().equals(value)) {
				Node root = parentNode.getParentNode();
				root.replaceChild(doc.createElement(tag), parentNode);
			}
			else {
				return false;
			}
		}
		writeToFile(doc, new File(filePath));
		return true;
	}
	
	/* Helper Methods */
	private static Document generateDoc(String filePath) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			return (filePath == null) ? docBuilder.newDocument() : docBuilder.parse(filePath);
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
	
	private static void writeToFile(Document doc, File file) {
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);
		}
		catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	private static boolean doesExist(Node parentNode, String childTag, String value) {
		if (childTag != null && !childTag.equals("")) {
			NodeList nodeList = parentNode.getChildNodes();
			if (nodeList.getLength() > 0) {
				for (int i = 0; i < nodeList.getLength(); i++) {
					if (nodeList.item(i).getTextContent().equals(value)) {
						return true;
					}
				}
			}
		}
		else if (parentNode.getTextContent().equals(value)) {
			return true;
		}
		return false;
	}
}
