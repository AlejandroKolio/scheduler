package com.alexandershakhov.dev.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * @author alexander.shakhov on 29.05.2018 15:08
 * @project scheduler
 * @description
 */

@Entity
@ToString
@Getter @Setter
@NoArgsConstructor
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_profile_id")
	private EmployeeProfile employeeProfile;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Company company;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "employee_team", joinColumns = @JoinColumn(name = "employee_id"), inverseJoinColumns = @JoinColumn(name = "team_id"))
	private List<Team> team;

	public Employee(String firstName, String lastName, String email, EmployeeProfile employeeProfile, Company company, List<Team> team) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.employeeProfile = employeeProfile;
		this.company = company;
		this.team = team;
	}


}
