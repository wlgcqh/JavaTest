package com.qiheng.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Vector;

public class ServerInputThread extends Thread {
	private Vector<Socket> socket;

	public ServerInputThread(Vector<Socket> vector) {
		super();
		this.socket = vector;
	}

	@Override
	public void run() {

		try {
			Vector<InputStream> is = new Vector<InputStream>();
			for (Socket s : socket) {
				is.add(s.getInputStream());
			}
			while (true) {

				for (InputStream in : is) {
					byte[] buffer = new byte[1024];
					int length = 0;
					while ((length = in.read(buffer, 0, buffer.length)) != -1) {
						System.out.println(new String(buffer, 0, length));
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
