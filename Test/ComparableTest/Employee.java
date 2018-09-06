package ComparableTest;

public class Employee implements Comparable<Employee>{
	private String name;
	private int age;
	private int id;
	
	
	public Employee(String name, int age, int id) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}

	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", id=" + id + "]";
	}

	/*
	 * 从写排序方法时，通过对象的id的大小来排序
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Employee o) {
		if(id > o.id){
			return 1;
		}else if(id < o.id){
			return -1;
		}
		return 0;
	}
	
	
}
