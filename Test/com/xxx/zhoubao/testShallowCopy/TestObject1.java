package com.xxx.zhoubao.testShallowCopy;

public class TestObject1 implements Cloneable{
	private int id;
	private String addr;
	private String color;
	
	public TestObject1(int id,String addr,String color){
		this.id = id;
		this.addr = addr;
		this.color = color;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("id:"+id);
		sb.append("addr:"+addr);
		sb.append("color:"+color);
		return sb.toString();
	}
	
	public TestObject1 clone(){
		TestObject1 to = null;
		try {
			to = (TestObject1)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return to;
	}
}
