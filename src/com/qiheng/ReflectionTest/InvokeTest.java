package com.qiheng.ReflectionTest;

import java.lang.reflect.Method;

public class InvokeTest {
	public int add(int a, int b) {
		return a + b;
	}

	public String echo(String msg) {
		return "hello:" + msg;
	}

	public static void main(String[] args) throws Exception {
		Class<?> classType = InvokeTest.class;
		Object invokeTest = classType.newInstance();
		Method addMethod = classType.getMethod("add", new Class[] { int.class,
				int.class });
		Object obj = addMethod.invoke(invokeTest, new Object[] { 2, 4 });
		System.out.println((Integer) obj);

	}
}
