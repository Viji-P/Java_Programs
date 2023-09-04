package XPath;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		List<Map<String,String>> result=read.display();
		System.out.println(result);
		
		
		}
		
		
		public List<Map<String,String>> display() throws Exception {
		List<Map<String,String>> dm=new ArrayList<>();
		
		String filePath="src//Movies.xml";
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		Document document=builder.parse(new File(filePath));
		
		document.getDocumentElement().normalize();
		
		XPathFactory xPathFactory = XPathFactory.newInstance();
		
		XPath xpath = xPathFactory.newXPath();
		
		
		
		String expression = "//movies";
		
        
        NodeList nl=(NodeList) xpath.compile(expression).evaluate(document, XPathConstants.NODESET);
        
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
	
	


