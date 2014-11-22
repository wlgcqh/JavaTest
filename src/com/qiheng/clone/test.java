package com.qiheng.clone;

public class test {
	public static void main(String[] args) throws Exception {
		Teacher teacher = new Teacher();
		teacher.setAge(40);
		teacher.setName("kongzi");
		
		Student student = new Student();
		student.setAge(21);
		student.setName("qh");
		student.setTeacher(teacher);
		
		Student student2=(Student) student.clone();
		student2.getTeacher().setName("mengzi");
		System.out.println(student2.getTeacher().getAge());
		System.out.println(student2.getTeacher().getName());
		
		System.out.println(student.getTeacher().getAge());
		System.out.println(student.getTeacher().getName());
		
	}
	
	
}
class Teacher implements Cloneable{
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
	@Override
	public  Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
class Student implements Cloneable{
	private int age;
	private String name;
	private Teacher teacher;
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
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		Student object =(Student) super.clone();
		object.setTeacher((Teacher) object.getTeacher().clone());
		return object;
	}
}