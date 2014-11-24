package com.qiheng.ReflectionTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SecondReflection {
	public Object copy(Object obj) throws Exception {
		Class<?> classType = obj.getClass();
		Object objcopy = classType.getConstructor(new Class[] {}).newInstance(
				new Object[] {});

		Field[] fields = classType.getDeclaredFields();
		for (Field field : fields) {
//			System.out.println(field.getType());
//			System.out.println(field.getClass());
			
			String name = field.getName();
			String firstLetter = name.substring(0, 1).toUpperCase();
			String getMethodName = "get" + firstLetter + name.substring(1);
			String setMethodName = "set" + firstLetter + name.substring(1);
			Method getMethod = classType.getMethod(getMethodName,
					new Class[] {});
			Method setMethod = classType.getMethod(setMethodName,
					new Class[] { field.getType() });

			Object result = getMethod.invoke(obj, new Object[] {});
			setMethod.invoke(objcopy, new Object[] { result });
		}

		return objcopy;
	}

	public static void main(String[] args) throws Exception {
		SecondReflection secondReflection = new SecondReflection();

		Customer customer = new Customer("qiheng", 21);
		customer.setId(1L);
		
		Customer customer2 = (Customer) secondReflection.copy(customer);
		System.out.println(customer2);
	}
}

class Customer {
	private Long id;
	private String name;
	private int age;

	public Customer() {
	}

	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}