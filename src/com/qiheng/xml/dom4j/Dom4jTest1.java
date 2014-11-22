package com.qiheng.xml.dom4j;

import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Dom4jTest1 {
	public static void main(String[] args) throws Exception {
		Document document = DocumentHelper.createDocument();
		Element root =  DocumentHelper.createElement("root");
		document.setRootElement(root);
		Element hello=root.addElement("hello");
		Element world=root.addElement("world");
		hello.addAttribute("id", "1");
		world.addAttribute("id", "2");
		
		XMLWriter writer = new XMLWriter(new OutputFormat("  ",true));
		writer.write(document);
		
	}
}
