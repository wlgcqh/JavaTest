package com.qiheng.concurrent;

public class IncreaseThread extends Thread {
	private Sample sample = new Sample();

	public IncreaseThread(Sample sample,String name) {
		super(name);
		this.sample = sample;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {

			try {
				Thread.sleep((long) (Math.random() * 500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.sample.increase();

		}

	}
}
