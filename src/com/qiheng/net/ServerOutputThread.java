package com.qiheng.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

public class ServerOutputThread extends Thread {
	private Vector<Socket> socket;

	public ServerOutputThread(Vector<Socket> vector) {
		super();
		this.socket = vector;
	}

	@Override
	public void run() {

		try {
			Vector<OutputStream> os = new Vector<OutputStream>();
			for (Socket s : socket) {
				os.add(s.getOutputStream());
			}
			

			while (true) {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(System.in));

				String str = null;
				while (null != (str = reader.readLine())) {
					for(OutputStream out:os){
					out.write(str.getBytes());
					}
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
