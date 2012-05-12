package daxzel.model.domains;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

import java.util.Collection;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.Key;

import com.google.appengine.api.datastore.KeyFactory;

@Entity
public class Group 
{
	
	@Id
	@NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;
	
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "group", fetch=FetchType.LAZY)
	private Collection<Product> products = new ArrayList();


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Collection<Product> getProducts() {
		return products;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

    public Key getKey()
    {
        return key;
    }
	
	public void setKey(Key key) 
	{
		this.key = key;
	}
}
