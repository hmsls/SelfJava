package CloneVSSerializable;

import java.io.Serializable;

public class Employee implements Cloneable,Serializable{
	private static final long serialVersionUID = 1965301858355367679L;
	private String name;
	private int age;
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}
	// 使用父类的clone()方法实现深克隆
	public Employee clone(){
		Employee employee = null;
		try {
			employee = (Employee)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return employee;
	}
}
