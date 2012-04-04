package daxzel.model.domains;



import javax.persistence.Entity;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

import javax.persistence.Id;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import com.google.appengine.api.datastore.Key;

@Entity
public class Role {
	
	@Id
	@NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;

	@NotNull
	@Size(min=3, max=20)
	private String name;

	public Key getKey() {
		return key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
