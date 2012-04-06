package daxzel.model.domains;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.validation.constraints.NotNull;

import javax.persistence.ManyToOne;

import javax.persistence.JoinColumn;

import javax.validation.constraints.Size;

import javax.persistence.Id;

import javax.persistence.CascadeType;

import javax.persistence.GeneratedValue;

import javax.persistence.Column;

import javax.persistence.GenerationType;

import com.google.appengine.api.datastore.Key;

import com.google.appengine.api.datastore.KeyFactory;

@Entity
public class Product 
{
	
	@Id
	@NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;	
	
	private Long NCP;
	
	private String name;
	
	private String developer;
	
	private String size;
	
	private String manufacturer;
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
    @JoinColumn(nullable=false)
	private Group group;
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	private String features;
	
	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	
	
	
	public Long getNCP() {
		return NCP;
	}

	public void setNCP(Long nCP) {
		NCP = nCP;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
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
		key = KeyFactory.createKey(Product.class.getSimpleName(), id);
	}
	
	public void setKey(Key key) 
	{
		this.key = key;
	}
	
}
