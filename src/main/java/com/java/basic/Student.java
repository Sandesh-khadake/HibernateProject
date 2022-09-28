package com.java.basic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Std_info")
public class Student {
	@Id
	private int stdId;
	private String stdName;
	private double stdFees;
	private int stdAge;
	private String stdAddress;
	private SkillType stdSkill;
	private GendorType stdGendor;
	
	public Student(int stdId, String stdName, double stdFees, int stdAge, String stdAddress, SkillType stdSkill,
			GendorType stdGendor) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.stdFees = stdFees;
		this.stdAge = stdAge;
		this.stdAddress = stdAddress;
		this.stdSkill = stdSkill;
		this.stdGendor = stdGendor;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "\n Student [stdId=" + stdId + ", stdName=" + stdName + ", stdFees=" + stdFees + ", stdAge=" + stdAge
				+ ", stdAddress=" + stdAddress + ", stdSkill=" + stdSkill + ", stdGendor=" + stdGendor + "]";
	}
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public double getStdFees() {
		return stdFees;
	}
	public void setStdFees(double stdFees) {
		this.stdFees = stdFees;
	}
	public int getStdAge() {
		return stdAge;
	}
	public void setStdAge(int stdAge) {
		this.stdAge = stdAge;
	}
	public String getStdAddress() {
		return stdAddress;
	}
	public void setStdAddress(String stdAddress) {
		this.stdAddress = stdAddress;
	}
	public SkillType getStdSkill() {
		return stdSkill;
	}
	public void setStdSkill(SkillType stdSkill) {
		this.stdSkill = stdSkill;
	}
	public GendorType getStdGendor() {
		return stdGendor;
	}
	public void setStdGendor(GendorType stdGendor) {
		this.stdGendor = stdGendor;
	}
	
	 

}


enum GendorType{
	MALE,
	FEMALE
	
}
