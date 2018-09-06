package com.xxx.zhoubao.testShallowCopy;

public class TestObject {
	private String name;
	private int age;
	
	public TestObject(String name,int age){
		this.name = name;
		this.age = age;
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
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("name:"+name);
		sb.append("age:"+age);
		return sb.toString();
	}
}
