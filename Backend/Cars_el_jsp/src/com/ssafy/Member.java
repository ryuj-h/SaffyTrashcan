package com.ssafy;

public class Member {
	private String memberId;
	private String password;
	private String name;
	private String registerDate;
	
	public Member() {}
	public Member(String memberId, String password, String name, String registerDate) {
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.registerDate = registerDate;
	}
	
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", password=" + password + ", name=" + name + ", registerDate="
				+ registerDate + "]";
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	
	
	
}
