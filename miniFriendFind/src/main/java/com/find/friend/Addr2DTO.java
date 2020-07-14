package com.find.friend;

public class Addr2DTO {
	private String addr2num;
	private String addr1Num;
	private String addr2;
	@Override
	public String toString() {
		return "Addr2DTO [addr2num=" + addr2num + ", addr1Num=" + addr1Num + ", addr2=" + addr2 + "]";
	}
	public String getAddr2num() {
		return addr2num;
	}
	public void setAddr2num(String addr2num) {
		this.addr2num = addr2num;
	}
	public String getAddr1Num() {
		return addr1Num;
	}
	public void setAddr1Num(String addr1Num) {
		this.addr1Num = addr1Num;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
}
