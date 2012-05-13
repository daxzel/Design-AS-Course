package daxzel.model.domains;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

import com.google.appengine.api.datastore.Key;

import com.google.appengine.api.datastore.KeyFactory;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Product 
{
	
	@Id
	@NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long key;
	
	private Long NCP;
	
	private String name;
	
	private String developer;
	
	private String size;
	
	private String manufacturer;

//    @OneToMany(cascade = CascadeType.ALL,mappedBy="product")
//    private List<Production> productions = new ArrayList<Production>();

    @Transient
    private Group group;

    @Basic(fetch = FetchType.EAGER)
    private Long groupKey;

    @Transient
    private List<Ad> ads = new ArrayList<Ad>();

    @Basic(fetch = FetchType.EAGER)
    private List<Long> adsKeys = new ArrayList<Long>();


    @Transient
    private List<Order> orders = new ArrayList<Order>();


    @Basic(fetch = FetchType.EAGER)
    private List<Long> keysOrders = new ArrayList<Long>();

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Long getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(Long groupKey) {
        this.groupKey = groupKey;
    }

    public List<Long> getAdsKeys() {
        return adsKeys;
    }

    public void setAdsKeys(List<Long> adsKeys) {
        this.adsKeys = adsKeys;
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


//    public List<Production> getProductions() {
//        return productions;
//    }
//
//    public void setProductions(List<Production> productions) {
//        this.productions = productions;
//    }
	
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
        return key;
    }
	
	public void setKey(Long key)
	{
		this.key = key;
	}

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Long> getKeysOrders() {
        return keysOrders;
    }

    public void setKeysOrders(List<Long> keysOrders) {
        this.keysOrders = keysOrders;
    }

}
