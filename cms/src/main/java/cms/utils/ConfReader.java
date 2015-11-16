package cms.utils;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document ;

public class ConfReader {
	
	public static String getConf(String prop){
	
		String ret = null;
	try {
		 
		File fXmlFile = new File(System.getProperty("user.dir")+"/WEB-INF/dispatcher-servlet.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		org.w3c.dom.Document doc = dBuilder.parse(fXmlFile);
	 
		doc.getDocumentElement().normalize();
	 
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	 
		// Create XPathFactory object
        XPathFactory xpathFactory = XPathFactory.newInstance();

        // Create XPath object
        XPath xpath = xpathFactory.newXPath();
       
        ret = propValue(doc, xpath, prop);
		
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	
	   return ret;
  }
  
	private static String propValue(Document doc, XPath xpath, String prop) {
	    String name = null;
	    try {
	        XPathExpression expr =
	            xpath.compile("//prop[@key='"+prop+"']/prop/text()");
	        name = (String) expr.evaluate(doc, XPathConstants.STRING);
	    } catch (XPathExpressionException e) {
	        e.printStackTrace();
	    }

	    return name;
	}



}

