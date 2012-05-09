package daxzel.model.domains;



import javax.persistence.*;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

import com.google.appengine.api.datastore.Key;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Role {
	
	@Id
	@NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;

	@NotNull
	@Size(min=3, max=20)
	private String name;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy="role")
    private List<User> users = new ArrayList<User>();

	public Long getKey() {
		return key.getId();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
