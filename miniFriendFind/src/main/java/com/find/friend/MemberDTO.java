package com.find.friend;

public class MemberDTO {

	private String id;
	private String pw;
	private String name;
	private String nickName;
	private String profil;
	private String addr1;
	private String addr2;
	private String gender;
	private String birth;
	private String hobby;
	private String job;
	private String subJob;
	private int message;
	
	
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getSubJob() {
		return subJob;
	}
	public void setSubJob(String subJob) {
		this.subJob = subJob;
	}
	public int getMessage() {
		return message;
	}
	public void setMessage(int message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", nickName=" + nickName + ", profil=" + profil
				+ ", addr1=" + addr1 + ", addr2=" + addr2 + ", gender=" + gender + ", birth=" + birth + ", hobby="
				+ hobby + ", subJob=" + subJob + ", message=" + message + "]";
	}
	
	
}
