package com.qiheng.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicSubject implements InvocationHandler {
	
	private Object obj;
	
	public DynamicSubject(Object obj) {
		super();
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//System.out.println(proxy);
		System.out.println(method);
		System.out.println(args);
		
		method.invoke(obj, args);
		
		return null;
	}

}
