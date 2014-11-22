package com.qiheng.udp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendThread extends Thread {
	private DatagramSocket socket;
	private int sendPort;

	public SendThread(DatagramSocket socket,int sendPort) {
		super();
		this.socket = socket;
		this.sendPort = sendPort;
	}

	@Override
	public void run() {
		while(true){
		BufferedInputStream bis = new BufferedInputStream(System.in);
		byte[] buffer = new byte[1024];
		int temp=0;
		try {
			while (-1 != (temp = bis.read(buffer, 0, buffer.length))) {
				DatagramPacket packet = new DatagramPacket(buffer,
						temp, InetAddress.getByName("127.0.0.1"),
						this.sendPort);
				this.socket.send(packet);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}}
}
