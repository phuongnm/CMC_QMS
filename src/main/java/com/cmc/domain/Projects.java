package com.cmc.domain;
import java.util.Date;

import javax.persistence.Column;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;

@RooJavaBean
@RooToString
@RooJpaEntity(table = "projects")
public class Projects {
	
	@Column(name="name")
	private String name;
	
	
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="status") 
	private int status;
	
	@Column(name="description")
	private String description;
	
	@Column(name="identifier")
	private String identifier;
	
	
}
