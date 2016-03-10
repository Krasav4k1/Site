package com.controller;

public class Person {

	private int age;
	private String name;
	private String lastName;
	
	public Person(int age, String name, String lastName) {
		super();
		this.age = age;
		this.name = name;
		this.lastName = lastName;
	}
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
	public String getLastName() {return lastName;}
	public void setLastName(String lastName) {this.lastName = lastName;}

	@Override
	public String toString() {
		return "Person{" +
				"age=" + age +
				", name='" + name + '\'' +
				", lastName='" + lastName + '\'' +
				'}';
	}
}
