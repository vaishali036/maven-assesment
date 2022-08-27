package com.locationweb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="location")
public class Locations {
	@Id
	private long id;
	
	@Column(name="name",nullable=false, length=45)
	private String name;
	
	@Column(name="code",nullable=false, length=45)
	private String codes;
	
	@Column(name="type",nullable=false, length=45)
	private String type;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCodes() {
		return codes;
	}
	public void setCodes(String codes) {
		this.codes = codes;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
