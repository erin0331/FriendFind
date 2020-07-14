package com.find.friend;

public class ReplyDTO {

	private int id;
	private int upId;
	private int seq;
	private int depth;
	private String owner;
	private String content;
	private String writer;
	private String writeDate;
	private String path;
	
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getId() {
		return id;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUpId() {
		return upId;
	}
	public void setUpId(int upId) {
		this.upId = upId;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	@Override
	public String toString() {
		return "ReplyDTO [id=" + id + ", upId=" + upId + ", seq=" + seq + ", depth=" + depth + ", owner=" + owner
				+ ", content=" + content + ", writer=" + writer + ", writeDate=" + writeDate + ", path=" + path + "]";
	}
	
	
}
