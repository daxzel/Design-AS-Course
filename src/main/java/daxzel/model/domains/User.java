package daxzel.model.domains;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

import com.google.appengine.api.datastore.Key;

import com.google.appengine.api.datastore.KeyFactory;



@Entity
public class User 
{
	
	@Id
	@NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;
	
	@NotNull
	@Size(min=3, max=20)
	private String name;
	
	@NotNull
	@Size(min=5, max=20)
	private String password;
	
	@ManyToOne
	private Role role;
	
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
		if (key!=null)
		{
			return key.getId();
		}
		else
		{
			return null;
		}
	}
	
	public void setKey(Long id) 
	{
		key = KeyFactory.createKey(User.class.getSimpleName(), id);
	}
	
	public Role getRole() 
	{
		return role;
	}
	
	public void setRole(Role role) 
	{
		this.role=role;
	}
	
	public void setKey(Key key) 
	{
		this.key = key;
	}

}
