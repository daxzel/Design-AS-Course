package daxzel.model.domains;

import javax.persistence.Entity;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

import javax.persistence.Id;

import javax.persistence.GeneratedValue;

import javax.persistence.Column;

import javax.persistence.GenerationType;



@Entity
public class User 
{
	
	@Id
	@NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long key;
	
	@NotNull
	@Size(min=3, max=20)
	@Column(unique=true) 
	private String name;
	
	@NotNull
	@Size(min=5, max=20)
	private String password;
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public Long getKey() 
	{
		return key;
	}

}
