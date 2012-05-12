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
    private Long key;
	
	private String name;

    @Transient
    private List<Product> products = new ArrayList<Product>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Long> getProductKeys() {
        return productKeys;
    }

    public void setProductKeys(List<Long> productKeys) {
        this.productKeys = productKeys;
    }

    @Basic(fetch = FetchType.EAGER)
    private List<Long> productKeys = new ArrayList<Long>();


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public Long getKey()
    {
        return key;
    }
	
	public void setKey(Long key)
	{
		this.key = key;
	}
}
