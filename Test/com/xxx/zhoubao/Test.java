package com.xxx.zhoubao;

public class Test {
	public static void main(String[] args) {
	}
}

class cat {
	private String name ;
	private int age;
	private String color;
	
	public cat(String name,int age,String color){
		this.name = name;
		this.age = age;
		this.color = color;
	}
	
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(obj == null){
			return false;
		}
		if(getClass() != obj.getClass()){
			return false;
		}
		cat c = (cat)obj;
		return name.equals(c.name) && (age==c.age) && color.equals(c.color);
	}
	public int hashCode(){
		return 7*name.hashCode() + 11*(new Integer(age)).hashCode() + 13 * color.hashCode();
	}

}
