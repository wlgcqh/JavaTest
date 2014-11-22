package com.qiheng.singleton;

public class Singleton {
	private static Singleton singleton;
	private Singleton(){
		
	}
	
	public synchronized static Singleton getInstance(){
		if(singleton==null){
			try {
				Thread.sleep((long) (Math.random()*1000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			singleton=new Singleton();
		}
		return singleton;
	}
	public static void main(String[] args) {
		
		ThreadTest t1=new ThreadTest();
		ThreadTest t2=new ThreadTest();
		t1.start();
		t2.start();
//		Singleton singleton1=Singleton.getInstance();
//		Singleton singleton2=Singleton.getInstance();
//		System.out.println(singleton1+" "+singleton2);
	}
}

class ThreadTest extends Thread
{
	private Singleton singleton;



	@Override
	public void run() {
		System.out.println(Singleton.getInstance());
	}
}
