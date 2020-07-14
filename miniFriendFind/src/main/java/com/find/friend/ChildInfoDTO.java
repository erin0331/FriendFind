package com.find.friend;

public class ChildInfoDTO {
	private int num;
	private int root;
	private int depth;
	private String owner;
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getRoot() {
		return root;
	}
	public void setRoot(int root) {
		this.root = root;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	@Override
	public String toString() {
		return "ChildInfoDTO [num=" + num + ", root=" + root + ", depth=" + depth + ", owner=" + owner + "]";
	}
	
	
}
