package com.alexandershakhov.dev.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author alexander.shakhov on 29.05.2018 15:10
 * @project scheduler
 * @description
 */

@Entity
@ToString
@Getter @Setter
@NoArgsConstructor
@Table(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	public Company(String name) {
		this.name = name;
	}
}
