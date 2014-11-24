package com.qiheng.Proxy;

import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) {
		RealSubject realSubject = new RealSubject();
		DynamicSubject dynamicSubject = new DynamicSubject(realSubject);

		Subject sub = (Subject) Proxy.newProxyInstance(dynamicSubject.getClass().getClassLoader(),
				realSubject.getClass().getInterfaces(), dynamicSubject);
		
		sub.speak("haha");
		System.out.println(sub.getClass().getSimpleName());
	}
}
