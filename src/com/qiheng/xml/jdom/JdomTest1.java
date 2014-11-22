package com.qiheng.xml.jdom;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JdomTest1 {
	public static void main(String[] args) throws Exception {
		Document document = new Document();

		Element root = new Element("root");
		document.addContent(root);
		root.addContent(new Element("student1").setAttribute("id","1"));
		root.addContent(new Element("student2").setAttribute("id","2"));
		
		
		
		XMLOutputter out = new XMLOutputter();
		out.setFormat(Format.getPrettyFormat());
		out.output(document, System.out);
	}
}
