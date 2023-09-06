package XPath;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class ReadingXml {
	

	public static void main(String[] args) throws Exception{
		
		ReadingXml read=new ReadingXml();
		
		String xmlStrings= "<bookstore><book><title>The Hobbit</title>"
				+ "<price>12.99</price></book></bookstore>";
				
		
		List<Map<String,String>> result=read.readXmlFiles(xmlStrings);
		
		System.out.println(result);
		
		
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
	
	


