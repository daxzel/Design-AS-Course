package daxzel.model.domains;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

import com.google.appengine.api.datastore.Key;

import com.google.appengine.api.datastore.KeyFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class KindAd {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	private String name;

    @OneToMany( mappedBy = "kindAd", cascade = CascadeType.ALL)
    private Collection<Ad> adList = new ArrayList<Ad>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public Key getKey()
    {
        return key;
    }

	public void setKey(Key key) {
		this.key = key;
	}

    public Collection<Ad> getAdList() {
        return adList;
    }

    public void setAdList(Collection<Ad> adList) {
        this.adList = adList;
    }

}
