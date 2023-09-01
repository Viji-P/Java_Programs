package XPath;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;



public class Reading_Xml {

	public static void main(String[] args) throws Exception{
		
		
		Reading_Xml read=new Reading_Xml();
		read.display();
		}
		
		
		public void display() throws Exception {
		Map<String,String> dm=new HashMap<>();
		
		String filePath="src//Movies.xml";
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document document=builder.parse(new File(filePath));
		
		//d.getDocumentElement().normalize();
		
		XPathFactory xPathFactory = XPathFactory.newInstance();
		
		XPath xpath = xPathFactory.newXPath();
		
		
		
		String expression = "//movie[1]/name";
		
        
        NodeList nl=(NodeList) xpath.compile(expression).evaluate(document, XPathConstants.NODESET);
        
        for(int i=0;i<nl.getLength();i++) {
        	String elementName=nl.item(i).getNodeName();
        	String elementValue=nl.item(i).getTextContent();
        	
            dm.put(elementName, elementValue);
        	
        }
		
		
        for (Map.Entry<String, String> entry : dm.entrySet()) 
    		System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
    
	
		}
}
	
	


