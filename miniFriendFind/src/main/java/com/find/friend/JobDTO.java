package com.find.friend;

public class JobDTO {
	private String jobnum;
	private String job;
	@Override
	public String toString() {
		return "JobDTO [jobnum=" + jobnum + ", job=" + job + "]";
	}
	public String getJobnum() {
		return jobnum;
	}
	public void setJobnum(String jobnum) {
		this.jobnum = jobnum;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
}
