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
		
		String filePath="src//xml_Files";
		List<Map<String,String>> result=read.readXmlFiles(filePath);
		
		System.out.println(result);
		
		
		}
		
		
		public List<Map<String,String>> readXmlFiles(String filePath) throws Exception {
		List<Map<String,String>> dm=new ArrayList<>();
		
		File directory=new File(filePath);
		File[] files=directory.listFiles((dir,name) -> name.toLowerCase().endsWith(".xml"));
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		for(File file:files) {
		
		Document document=builder.parse(file);
		
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
		}
		return  dm;
		
		}
}
	
	


