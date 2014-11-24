package com.qiheng.ReflectionTest;

import java.lang.reflect.Field;

public class ThirdReflection {
	public static void main(String[] args) throws Exception {
		PrivateTest privateTest=new PrivateTest();
		Class<?> classType = privateTest.getClass();
		Field field=classType.getDeclaredField("name");
		field.setAccessible(true);
		field.set(privateTest, "zhangsan");
		System.out.println(privateTest.getName());
		
	}
}
