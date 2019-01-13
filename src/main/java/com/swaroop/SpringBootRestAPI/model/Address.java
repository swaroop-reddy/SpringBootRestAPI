package com.swaroop.SpringBootRestAPI.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

//import org.springframework.data.annotation.Id;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@Table(name="address")
public class Address{
	@Id
	@Column(name="empl_id",unique=true,nullable=false)
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen",strategy="foreign",parameters={@Parameter(name="property",value="empl")})
	private Long id;
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="empl_id")
	@MapsId("id")
	//@PrimaryKeyJoinColumn(name="empl_id")
	private Employee empl;
	
	@Column
	private String add1;
	@Column
	private String add2;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long emplId) {
		this.id = emplId;
	}
	public String getAdd1() {
		return add1;
	}
	public void setAdd1(String add1) {
		this.add1 = add1;
	}
	public String getAdd2() {
		return add2;
	}
	public void setAdd2(String add2) {
		this.add2 = add2;
	}
	public Employee getEmpl() {
		return empl;
	}
	public void setEmpl(Employee empl) {
		this.empl = empl;
	}

}
