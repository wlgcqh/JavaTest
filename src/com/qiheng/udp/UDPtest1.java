package com.qiheng.udp;

import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPtest1 {
	private static int port=5000;
	public static void main(String[] args) throws Exception {
		DatagramSocket socket =new DatagramSocket(port);
		new SendThread(socket,8000).start();
		new ReceiveThread(socket).start();
	}
}
