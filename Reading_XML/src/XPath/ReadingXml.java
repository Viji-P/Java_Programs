package XPath;

import java.io.File;
import java.io.FileReader;
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
		
		File xmlFile=new File("src/xml_Files/Movies.xml");
				
		//String xmlString=xmlFile.getPath();
		
		//System.out.println(xmlString);
		
		String xmlToString=read.convertToString(xmlFile);
		System.out.println(xmlToString);
		

		List<Map<String,String>> result=read.readXmlFiles(xmlToString);
		
		System.out.println(result);
		
		
		}
		
		public String convertToString(File xmlFile) throws Exception {
			
			 try (FileReader fileReader = new FileReader(xmlFile)) {
				StringBuilder stringBuilder = new StringBuilder();
		        int ch;
		        while ((ch = fileReader.read()) != -1) {
		            stringBuilder.append((char) ch);
		        }
		        return stringBuilder.toString();
			}
		}
	
		
		public List<Map<String,String>> readXmlFiles(String xmlStrings) throws Exception {
		List<Map<String,String>> dm=new ArrayList<>();
		
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		
	
		
		Document document=builder.parse(new InputSource(new StringReader(xmlStrings)));
		
		document.getDocumentElement().normalize();
		
        NodeList nl=(NodeList) document.getElementsByTagName("movie");
        
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
	
	


