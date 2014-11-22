package com.qiheng.concurrent;

public class Sample {
	private int number;
	public synchronized void increase(){
		while(number!=0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		number++;
		notify();
		System.out.println(Thread.currentThread().getName()+":"+number);
	}
	public synchronized void decrease(){
		while(number==0){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		number--;
		notify();
		System.out.println(Thread.currentThread().getName()+":"+number);
	}
}
