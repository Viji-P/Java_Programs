package XPath;

import javax.xml.parsers.*;

import org.w3c.dom.*;

import javax.xml.xpath.*;

public class Reading_Xml {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Reading_Xml rx=new Reading_Xml();
		rx.display();
		
		
		

	}
	public void display() throws Exception {
		DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
		
		DocumentBuilder db=dbf.newDocumentBuilder();
		
		Document d=db.parse("src//Movies.xml");
		
		d.getDocumentElement().normalize();
		
		XPathFactory xp=XPathFactory.newInstance();
		
		XPath x=xp.newXPath();
		
		String expression="//movie/name";
		
		NodeList nl=(NodeList) x.compile(expression).evaluate(d, XPathConstants.NODESET);
		
		for(int i=0;i<nl.getLength();i++) {
			Node n=nl.item(i);
			System.out.println("Title  :"+n.getTextContent());
		}
		
		
		
	}

}
