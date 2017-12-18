package lab.model;

import java.sql.Date;

public class Student {
	private Integer kod;
	private String firstName;
	private String lastName;
	private Date bDay;
	private Sex sex;

	public Student() {
	}

	public Student(Integer kod, String firstName, String lastName, Date bDay, Sex sex) {
		this.kod = kod;
		this.firstName = firstName;
		this.lastName = lastName;
		this.bDay = bDay;
		this.sex = sex;
	}

	public enum Sex{
		male, female;
	}

	public Integer getKod() {
		return kod;
	}

	public void setKod(Integer kod) {
		this.kod = kod;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getbDay() {
		return bDay;
	}

	public void setbDay(Date bDay) {
		this.bDay = bDay;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return kod + ", " + firstName + ", " + lastName + ", " + bDay
				+ ", " + sex;
	}
	
	
	
}
