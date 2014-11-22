package com.qiheng.xml.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DomTest1 {
	public static void main(String[] args) throws Exception {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilder db = dbf.newDocumentBuilder();

		Document document = db.parse(new File("test.xml"));

		NodeList list = document.getElementsByTagName("PERSON");
		for (int i = 0; i < list.getLength(); i++) {
			Element element = (Element) list.item(i);

			String str = element.getElementsByTagName("NAME").item(0)
					.getFirstChild().getTextContent();
			System.out.println(str);

			str = element.getElementsByTagName("AGE").item(0).getFirstChild()
					.getTextContent();
			System.out.println(str);

			str = element.getElementsByTagName("TEL").item(0).getFirstChild()
					.getTextContent();
			System.out.println(str);

			str = element.getElementsByTagName("EMAIL").item(0).getFirstChild()
					.getTextContent();
			System.out.println(str);
			System.out.println("-----------------");
		}

	}
}
