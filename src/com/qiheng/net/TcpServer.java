package com.qiheng.net;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class TcpServer {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(5000);
		Vector<Socket> vector=new Vector<Socket>();
		while(true){
		Socket socket = server.accept();
		vector.add(socket);
		System.out.println(vector);
		
		new ServerInputThread(vector).start();
		new ServerOutputThread(vector).start();
		}
	}
}
