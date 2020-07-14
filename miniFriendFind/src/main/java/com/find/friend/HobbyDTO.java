package com.find.friend;

public class HobbyDTO {
	private String hobbyNum;
	private String hobby;
	
	public String getHobbyNum() {
		return hobbyNum;
	}
	public void setHobbyNum(String hobbyNum) {
		this.hobbyNum = hobbyNum;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "HobbyDTO [hobbyNum=" + hobbyNum + ", hobby=" + hobby + "]";
	}
	
	
}
