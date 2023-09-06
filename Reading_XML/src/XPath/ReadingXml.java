package XPath;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


public class ReadingXml {
	

	public static void main(String[] args) throws Exception{
		
		ReadingXml read=new ReadingXml();
		
		String xmlStrings= "<bookstore><book><title>The Hobbit</title>"
				+ "<price>12.99</price></book></bookstore>";
		
		String xmlToString=read.convertToString(xmlStrings);
		System.out.println(xmlToString);
		
		
		}
		
		public String convertToString(String xmlStrings) throws Exception {
			
			TransformerFactory transformFactory=TransformerFactory.newInstance();
			Transformer transformer=transformFactory.newTransformer();
			StringWriter writer=new StringWriter();
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			
		    Document doc=builder.parse(new InputSource(new StringReader(xmlStrings)));	
		    
		    transformer.transform(new DOMSource(doc), new StreamResult(writer));
			return writer.toString();
		}
	
		
		public List<Map<String,String>> readXmlFiles(String xmlStrings) throws Exception {
		List<Map<String,String>> dm=new ArrayList<>();
		
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		
	
		
		Document document=builder.parse(new InputSource(new StringReader(xmlStrings)));
		
		document.getDocumentElement().normalize();
		
        NodeList nl=(NodeList) document.getElementsByTagName("price");
        
        for(int i=0;i<nl.getLength();i++) {
        	
        	String elementName=nl.item(i).getNodeName();
        	String elementValue=nl.item(i).getTextContent();
        	
        	Map<String,String> xmlData=new HashMap<>();
            xmlData.put(elementName, elementValue);
            dm.add(xmlData);
        	
        }
		
		return  dm;
		
		}
}
	
	


