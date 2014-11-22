package com.qiheng.xml.sax;
import java.io.File;
import java.util.Stack;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxTest1 {
	public static void main(String[] args) throws Exception {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser parser = spf.newSAXParser();
		parser.parse(new File("test.xml"), new MyHandler());
	}
}

class MyHandler extends DefaultHandler {
	private Stack<String> stack = new Stack<String>();
	private String name;
	private String age;
	private String tel;
	private String email;

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		stack.pop();
		if("PERSON".equals(qName)){
			System.out.println("NAME: "+name);
			System.out.println("AGE: "+age);
			System.out.println("TEL: "+tel);
			System.out.println("EMAIL: "+email);
			System.out.println();
		}
//		System.out.println();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		stack.push(qName);
		for(int i=0;i<attributes.getLength();i++){
			String attrName=attributes.getQName(i);
			String attrValue=attributes.getValue(i);
			System.out.println(attrName+"="+attrValue);
		}
		//System.out.println();
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String str=stack.peek();
		String temp=new String(ch,start,length);
		if("NAME".equals(str)){
			this.name=temp;
		}
		else if("AGE".equals(str)){
			this.age=temp;
		}
		else if("TEL".equals(str)){
			this.tel=temp;
		}
		else if("EMAIL".equals(str)){
			this.email=temp;
		}
		
		
		
		
	}
}