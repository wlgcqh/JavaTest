package com.qiheng.xml.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomTest2 {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();

		Document doc = db.parse(new File("test.xml"));

		Element element = doc.getDocumentElement();
		parsexml(element);

	}

	private static void parsexml(Element element) {
		String tagName = element.getNodeName();
		System.out.print("<" + tagName);
		NodeList list = element.getChildNodes();
		NamedNodeMap attrs = element.getAttributes();
		if (attrs != null) {
			for (int i = 0; i < attrs.getLength(); i++) {
				Attr attr = (Attr) attrs.item(i);
				String name = attr.getName();
				String value = attr.getValue();
				System.out.print(" " + name + "=" + "\"" + value + "\"");

			}

		}
		System.out.print(">");

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			short nodeType = node.getNodeType();
			if (nodeType == Node.ELEMENT_NODE) {
				parsexml((Element) node);
			} else if (nodeType == node.TEXT_NODE) {
				System.out.print(node.getNodeValue());
			}

		}
		System.out.print("</" + tagName + ">");

	}
}
