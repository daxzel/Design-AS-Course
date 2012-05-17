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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long key;

	@NotNull
	@Size(min=3, max=20)
	private String name;

    public Long getKey()
    {
        return key;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
