package com.find.friend;

public class Addr1DTO {
	private String addr1num;
	private String addr1;
	@Override
	public String toString() {
		return "Addr1DTO [addr1num=" + addr1num + ", addr1=" + addr1 + "]";
	}
	public String getAddr1num() {
		return addr1num;
	}
	public void setAddr1num(String addr1num) {
		this.addr1num = addr1num;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
}
