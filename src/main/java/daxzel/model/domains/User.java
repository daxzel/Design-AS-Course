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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long key;

    @NotNull(message="Имя пользователя должно быть указано")
    @Size(min=3, max=20, message="Имя пользователя должно быть от 3 до 20 символов")
	private String name;

    @NotNull(message="Пользователь должен иметь пароль")
    @Size(min=3, max=20, message="Пароль пользователя должен быть от 3 до 20 символов")
	private String password;

    @Transient
	private Role role;

    public Long getKeyToRole() {
        return keyToRole;
    }

    public void setKeyToRole(Long keyToRole) {
        this.keyToRole = keyToRole;
    }

    private Long keyToRole;
	
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

	public Role getRole() 
	{
		return role;
	}
	
	public void setRole(Role role) 
	{
		this.role=role;
        if (role!=null)
        {
            keyToRole = role.getKey();
        }
	}
	
	public void setKey(Long key) 
	{
		this.key = key;
	}

}
