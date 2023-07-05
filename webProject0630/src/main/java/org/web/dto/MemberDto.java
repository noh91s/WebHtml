package org.web.dto;

import java.sql.Timestamp;


public class MemberDto {
	private Long member_id;
	private String member_name;
	private String member_password;
	private String email;
	private Timestamp creat_time;
	
	
	public MemberDto() {
		super();
	}


	public MemberDto(Long member_id, String member_name, String member_password, String email,
			Timestamp creat_time) {
		super();
		this.member_id = member_id;
		this.member_name = member_name;
		this.member_password = member_password;
		this.email = email;
		this.creat_time = creat_time;
	}


	public Long getMember_id() {
		return member_id;
	}


	public void setMember_id(Long member_id) {
		this.member_id = member_id;
	}


	public String getMember_name() {
		return member_name;
	}


	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}


	public String getMember_password() {
		return member_password;
	}


	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Timestamp getCreat_time() {
		return creat_time;
	}


	public void setCreat_time(Timestamp creat_time) {
		this.creat_time = creat_time;
	}


	@Override
	public String toString() {
		return "MemberDto [member_id=" + member_id + ", member_name=" + member_name + ", member_password="
				+ member_password + ", email=" + email + ", creat_time=" + creat_time + "]";
	}
	
	
}
