package com.qiheng.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ReceiveThread extends Thread {
	private DatagramSocket socket;
//	private int receivePort;

	public ReceiveThread(DatagramSocket socket) {
		super();
		this.socket = socket;
//		this.receivePort = receivePort;
	}

	@Override
	public void run() {
		while (true) {
			byte[] buffer = new byte[1024];
			try {
				DatagramPacket packet = new DatagramPacket(buffer, 1024);
				this.socket.receive(packet);
				System.out.println(new String(buffer, 0, packet.getLength()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
