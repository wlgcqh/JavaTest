package com.qiheng.thread;

public class Test1 implements Runnable{
	int i;
	@Override
	public void run(){
//		int i=0;
		while(true){
		System.out.println("number:"+i++);
		try {
			Thread.sleep((long) (500*Math.random()));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i==50){
			break;
		}
		}
	}
	public static void main(String[] args) {
		Runnable r=new Test1();
		Thread t1=new Thread(r);
		Thread t2=new Thread(r);
	
		t1.start();
		t2.start();
	}
}
