package testSerializable;

import java.io.Serializable;

public class Employee implements Serializable{
	private static final long serialVersionUID = -4025897270164904153L;
	private String name;
	private int age;
	private Address addresss;
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
	public Address getAddresss() {
		return addresss;
	}
	public void setAddresss(Address addresss) {
		this.addresss = addresss;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", addresss=" + addresss + "]";
	}
	public Employee(String name, int age, Address addresss) {
		super();
		this.name = name;
		this.age = age;
		this.addresss = addresss;
	}
	
	
}
