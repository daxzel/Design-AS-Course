package daxzel.model.domains;

import javax.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long key;

    @NotNull(message="Товар должен иметь код ОКП")
    @Max(value = 999, message ="Код ОКП должен содержать 3 цифры")
    @Min(value = 0, message ="Код ОКП должен содержать 3 цифры")
	private Long NCP;

    @NotNull(message="Товар должен иметь имя")
    @Size(min=6, max=50, message="Имя товара должно быть от 6 до 50 символов")
	private String name;

    @Size(min=6, max=20, message="Поле разработчик должно содержать от 6 до 20 символов")
	private String developer;

    @Size(min=6, max=20, message="Поле размер должно содержать от 6 до 20 символов")
	private String size;

    @Size(min=6, max=20, message="Поле производитель должно содержать от 6 до 20 символов")
	private String manufacturer;

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

    @Transient
    private List<Sale> sales = new ArrayList<Sale>();

    @Basic(fetch = FetchType.EAGER)
    private List<Long> keysSales = new ArrayList<Long>();

    @Transient
    private List<Production> production = new ArrayList<Production>();


    @Basic(fetch = FetchType.EAGER)
    private List<Long> keysProduction = new ArrayList<Long>();

    public List<Production> getProduction() {
        return production;
    }

    public void setProduction(List<Production> production) {
        this.production = production;
    }

    public List<Long> getKeysProduction() {
        return keysProduction;
    }

    public void setKeysProduction(List<Long> keysProduction) {
        this.keysProduction = keysProduction;
    }


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


    public List<Long> getKeysSales() {
        return keysSales;
    }

    public void setKeysSales(List<Long> keysSales) {
        this.keysSales = keysSales;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
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
