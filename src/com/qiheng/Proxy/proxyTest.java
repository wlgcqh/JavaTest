package com.qiheng.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class proxyTest implements InvocationHandler {
	private Object proxyobj;

	public proxyTest(Object obj) {
		this.proxyobj = obj;
	}

	public static Object proxyFactory(Object obj) {
		Class<?> classType = obj.getClass();
		Object obj1=Proxy.newProxyInstance(classType.getClassLoader(),
				classType.getInterfaces(), new proxyTest(obj));
		return obj1;
	}

	@Override
	public Object invoke(Object obj, Method method, Object[] arg)
			throws Throwable {
		System.out.println("before");
		Object object=method.invoke(this.proxyobj, arg);
		System.out.println("after");
		return object;
		
		
		
	}
	public static void main(String[] args) {
		List list=(List)proxyFactory(new Vector());
		
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		
		list.clear();
	}
	

}
