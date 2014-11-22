package com.qiheng.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientInputThread extends Thread {
	private Socket socket;

	public ClientInputThread(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			InputStream in = this.socket.getInputStream();
			while (true) {
				byte[] buffer = new byte[1024];
				int length = 0;
				while ((length = in.read(buffer, 0, buffer.length)) != -1) {
					System.out.println(new String(buffer, 0, length));
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
