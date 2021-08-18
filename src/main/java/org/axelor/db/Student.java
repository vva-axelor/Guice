package org.axelor.db;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private Date dob;
	
	private String phone;
	
	private String address;
	
	
	public Student() {}
	public Student(String name, Date dob, String phone, String address) {
		super();
		this.name = name;
		this.dob = dob;
		this.phone = phone;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBirthdate() {
		return dob;
	}

	public void setBirthdate(Date dob) {
		this.dob = dob;
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

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dob=" + dob + ", phone=" + phone + ", address="
				+ address + "]";
	}

	
	
}
