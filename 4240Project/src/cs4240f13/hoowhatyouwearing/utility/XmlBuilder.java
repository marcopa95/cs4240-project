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

import org.w3c.dom.DOMException;
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
		root.appendChild(unit);
		
		Element location = doc.createElement("location");
		root.appendChild(location);
		
		Element clothes = doc.createElement("clothes");
		root.appendChild(clothes);
		
		// write the content into xml file
		writeToFile(doc, file);
		
		return true;
	}
	
	public static boolean addElement(String parent, String tag, String value) {
		String filePath = "./settings.xml";
		Document doc = generateDoc(filePath);
		
		Node parentNode = doc.getElementsByTagName(parent).item(0);
		Element childNode = doc.createElement(tag);
		childNode.appendChild(doc.createTextNode(value));
		parentNode.appendChild(childNode);
		
		writeToFile(doc, new File(filePath));
		return true;
	}
	
	public static boolean removeElement(String parent, String tag, String value) {
		String filePath = "./settings.xml";
		Document doc = generateDoc(filePath);
		
		Node parentNode = doc.getElementsByTagName(parent).item(0);
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
	
}
