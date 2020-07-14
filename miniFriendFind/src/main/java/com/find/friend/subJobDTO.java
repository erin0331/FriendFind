package com.find.friend;

public class subJobDTO {
	private String subjobnum;
	private String jobNum;
	private String subjob;
	@Override
	public String toString() {
		return "subJobDTO [subjobnum=" + subjobnum + ", jobNum=" + jobNum + ", subjob=" + subjob + "]";
	}
	public String getSubjobnum() {
		return subjobnum;
	}
	public void setSubjobnum(String subjobnum) {
		this.subjobnum = subjobnum;
	}
	public String getJobNum() {
		return jobNum;
	}
	public void setJobNum(String jobNum) {
		this.jobNum = jobNum;
	}
	public String getSubjob() {
		return subjob;
	}
	public void setSubjob(String subjob) {
		this.subjob = subjob;
	}
}
