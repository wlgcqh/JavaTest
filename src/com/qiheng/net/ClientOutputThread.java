package com.qiheng.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ClientOutputThread extends Thread{
	private Socket socket;

	public ClientOutputThread(Socket socket) {
		super();
		this.socket = socket;
	}
	@Override
	public void run() {

		try {
			OutputStream os = this.socket.getOutputStream();

			while (true) {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(System.in));

				String str = null;
				while (null != (str = reader.readLine())) {
					os.write(str.getBytes());
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
