package com.find.friend;

public class HangleDTO {
	private String haddr1;
	private String haddr2;
	private String hjob;
	private String hsubjob;
	@Override
	public String toString() {
		return "HangleDTO [haddr1=" + haddr1 + ", haddr2=" + haddr2 + ", hjob=" + hjob + ", hsubjob=" + hsubjob + "]";
	}
	public String getHaddr1() {
		return haddr1;
	}
	public void setHaddr1(String haddr1) {
		this.haddr1 = haddr1;
	}
	public String getHaddr2() {
		return haddr2;
	}
	public void setHaddr2(String haddr2) {
		this.haddr2 = haddr2;
	}
	public String getHjob() {
		return hjob;
	}
	public void setHjob(String hjob) {
		this.hjob = hjob;
	}
	public String getHsubjob() {
		return hsubjob;
	}
	public void setHsubjob(String hsubjob) {
		this.hsubjob = hsubjob;
	}
}
