package com.xxx.zhoubao.testDeepClone;

public class Employee implements Cloneable{
	private String name;
	private int age;
	private Address addr ;
	public Employee(String name, int age, Address addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
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
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
	
	public Employee clone(){
		Employee e = null;
		try {
			e = (Employee)super.clone();
			e.addr = (Address)addr.clone();
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}
		return e; 
	}
}
