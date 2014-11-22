package com.qiheng.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("127.0.0.1",5000);
		
		new ClientInputThread(socket).start();
		new ClientOutputThread(socket).start();
	}
}
