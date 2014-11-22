package com.qiheng.concurrent;

public class MainTest {
	public static void main(String[] args) {
		Sample sample = new Sample();
		IncreaseThread t1=new IncreaseThread(sample,"A");
		DecreaseThread t2=new DecreaseThread(sample,"B");
		
		IncreaseThread t3=new IncreaseThread(sample,"C");
		DecreaseThread t4=new DecreaseThread(sample,"D");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
