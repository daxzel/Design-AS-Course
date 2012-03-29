package daxzel.model.domains;

import javax.persistence.Entity;

import javax.persistence.Table;

import javax.persistence.Id;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;



@Entity
public class User 
{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long key;
	
	private String name;
	
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
