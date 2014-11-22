package com.qiheng.net;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

public class Test {
	public static void main(String[] args) throws IOException {
//		try {
//			URL url = new URL("http://www.qq.com");
//			URLConnection conn=url.openConnection();
//			
//			InputStream is=conn.getInputStream();
//			
//			String file="d:"+File.separator+"123.txt";
//			OutputStream os=new FileOutputStream(file);
//			
//			byte[] b=new byte[1024];
//			int length=0;
//			while((length=is.read(b,0,b.length))!=-1){
//				System.out.println(new String(b));
//				os.write(b,0,length);
//			}
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println("---------------");
		InetAddress address = InetAddress.getLocalHost();
		String clientAddress = address.toString();
		System.out.println(clientAddress);
		int l=clientAddress.indexOf("/");
		clientAddress=clientAddress.substring(l+1);
		System.out.println(clientAddress);
		

	}
}
