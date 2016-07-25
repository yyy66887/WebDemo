package app4Utils;

import java.io.FileOutputStream;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jUtils {
	private static String dbFilePath="";
	static{
		ClassLoader c1 = Dom4jUtils.class.getClassLoader();
		URL url = c1.getResource("users.xml");
		dbFilePath = url.getPath();
		System.out.println(dbFilePath);
	}
	
	public static Document getDocument() throws Exception{
		SAXReader reader = new SAXReader();
		return reader.read(dbFilePath);
	}
	public static void write2xml(Document document) throws Exception{
		XMLWriter writer = new XMLWriter(new FileOutputStream(dbFilePath), OutputFormat.createPrettyPrint()); 
 		writer.write(document);
 		writer.close();
	}
}
