package com.tr.ozaytunctan.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.tr.ozaytunctan.common.enums.Gender;
import com.tr.ozaytunctan.entity.base.BaseEntity;

@Entity
@Table(name = "USER_")
@SequenceGenerator(name = "idGenerator", sequenceName = "SQ_USER", initialValue = 1)
public class User extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3408090492429463631L;

	@Column(name = "FIRST_NAME" )
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL", unique = true)
	private String email;

	@Column(name = "GENDER")
	@Enumerated(EnumType.ORDINAL)
	private Gender gender;

	public User() {
		// TODO Auto-generated constructor stub
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "User { id:" + this.getId()//
				+ ",firstName:" + this.firstName//
				+ ",lastName:" + this.lastName//
				+ ",email:" + this.email//
				+ ",gender:" + this.gender + "}";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null || this.getClass() != obj.getClass())
			return false;

		User user = (User) obj;
		return Objects.equals(user.getId(), this.getId());
	}

}
