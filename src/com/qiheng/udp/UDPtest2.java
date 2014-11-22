package com.qiheng.udp;

import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPtest2 {
	private static int port=8000;
	public static void main(String[] args) throws Exception {
		DatagramSocket socket =new DatagramSocket(port);
		new SendThread(socket,5000).start();
		new ReceiveThread(socket).start();
	}
}
