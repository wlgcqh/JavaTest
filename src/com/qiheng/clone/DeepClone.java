package com.qiheng.clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DeepClone {
	public static void main(String[] args) throws Exception {
		Teacher3 teacher =new Teacher3();
		teacher.setAge(20);
		teacher.setName("Teacher zhang");
		
		Student3 student = new Student3();
		student.setAge(10);
		student.setName("zhang san");
		student.setTeacher(teacher);
		
		Student3 student2=(Student3) student.deepClone();
		
		student.getTeacher().setAge(50);
		student.getTeacher().setName("hello");
		
		System.out.println(student2.getAge());
		System.out.println(student2.getName());
		System.out.println(student2.getTeacher().getAge());
		System.out.println(student2.getTeacher().getName());
	}
}

class Teacher3 implements Serializable {
	private int age;
	private String name;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

class Student3 implements Serializable {
	private int age;
	private String name;
	private Teacher3 teacher;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher3 getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher3 teacher) {
		this.teacher = teacher;
	}

	public Object deepClone() throws Exception {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);

		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois=new ObjectInputStream(bis);
		
		
		return ois.readObject();
	}
}