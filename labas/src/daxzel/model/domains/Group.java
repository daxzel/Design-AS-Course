package daxzel.model.domains;

import javax.persistence.Entity;

import javax.validation.constraints.NotNull;

import javax.persistence.ManyToOne;

import javax.persistence.OneToMany;

import javax.persistence.CascadeType;

import javax.persistence.JoinColumn;

import javax.persistence.FetchType;

import javax.validation.constraints.Size;

import javax.persistence.Id;

import javax.persistence.GeneratedValue;

import javax.persistence.Column;

import java.util.Collection;

import java.util.ArrayList;

import javax.persistence.GenerationType;

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
	
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="group",fetch=FetchType.LAZY)
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
	
	public void setKey(Key key) 
	{
		this.key = key;
	}
}
