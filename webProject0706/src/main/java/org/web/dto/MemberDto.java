package org.web.dto;

import java.time.LocalDateTime;


public class MemberDto {
	private Long member_id;
	private String name;
	private String password;
	private String email;
	private String phone;
	private String address;
	private String grade;
	private String city;
	private LocalDateTime create_time;
	
	public MemberDto() {
		super();
	}
	public MemberDto(Long member_id, String name, String password, String email, String phone, String address,
			String grade, String city, LocalDateTime create_time) {
		super();
		this.member_id = member_id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.grade = grade;
		this.city = city;
		this.create_time = create_time;
	}
	public Long getMember_id() {
		return member_id;
	}
	public void setMember_id(Long member_id) {
		this.member_id = member_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAdress(String address) {
		this.address = address;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public LocalDateTime getCreate_time() {
		return create_time;
	}
	public void setCreate_time(LocalDateTime create_time) {
		this.create_time = create_time;
	}
	
	
	
}
