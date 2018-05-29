package com.alexandershakhov.dev.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author alexander.shakhov on 29.05.2018 15:18
 * @project scheduler
 * @description
 */

@Entity
@ToString
@Getter @Setter
@NoArgsConstructor
@Table(name = "employee_profile")
public class EmployeeProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "country")
	private String country;

	@Column(name = "post_code")
	private String postalCode;

	@Column(name = "dob")
	private String dob;

	public EmployeeProfile(String address, String city, String country, String postalCode, String dob) {
		this.address = address;
		this.city = city;
		this.country = country;
		this.postalCode = postalCode;
		this.dob = dob;
	}
}
