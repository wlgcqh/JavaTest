package com.qiheng.thread;

public class Test2 {
	public static void main(String[] args) {
		Mytest1 test1 = new Mytest1();
		Thread t1 = new MyThread1(test1);
	//	test1=new Mytest1();
		Thread t2 = new MyThread1(test1);
		t1.start();
		t2.start();
	}
}

class Mytest1 {

	private  Object obj = new Object();

	public void exec1() {
		System.out.println("start");
		synchronized (obj) {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep((long) (Math.random() * 500));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("hello:" + i);
			}
			System.out.println("over");
		}

	}

	public void exec2() {
		synchronized (obj) {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep((long) (Math.random() * 500));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("world:" + i);
			}
		}

	}
}

class MyThread1 extends Thread {
	private Mytest1 test;

	public MyThread1(Mytest1 test) {
		super();
		this.test = test;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		test.exec1();
	}
}

class MyThread2 extends Thread {
	private Mytest1 test;

	public MyThread2(Mytest1 test) {
		super();
		this.test = test;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		test.exec2();
	}
}