package com.qiheng.xml.dom4j;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jTest2 {
	public static void main(String[] args) throws Exception {
		SAXReader reader=new SAXReader();
		Document doc=reader.read(new File("test.xml"));
		Element root=doc.getRootElement();
		List<Element> list=root.elements();
		for (Iterator<Element> iterator = root.elementIterator(); iterator.hasNext();) {
			Element e=iterator.next();
			System.out.println(e.getName());
			
		}
	}
}
