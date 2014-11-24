package com.qiheng.Proxy;

public class RealSubject implements Subject{

	@Override
	public void speak() {
		System.out.println("I wanna say!!!");
	}
	public void speak(String str) {
		System.out.println("I wanna say!!!"+str);
	}
}
