package com.xxx.zhoubao.testDeepClone;

public class Address implements Cloneable{
	private String state;
	private String province;
	private String city;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [state=" + state + ", province=" + province + ", city=" + city + "]";
	}
	public Address(String state, String province, String city) {
		super();
		this.state = state;
		this.province = province;
		this.city = city;
	}
	
	public Address clone(){
		Address addr = null;
		try {
			addr = (Address)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return addr;
	}
}
