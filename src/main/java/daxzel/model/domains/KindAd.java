package daxzel.model.domains;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;

import com.google.appengine.api.datastore.Key;

import com.google.appengine.api.datastore.KeyFactory;

import java.util.ArrayList;
import java.util.List;

@Entity
public class KindAd {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;

	private String name;

    @OneToMany( mappedBy = "kindAd", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Ad> adList = new ArrayList<Ad>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getKey() {
		if (key != null) {
			return key.getId();
		} else {
			return null;
		}
	}

	public void setKey(Long id) {
		key = KeyFactory.createKey(KindAd.class.getSimpleName(), id);
	}

	public void setKey(Key key) {
		this.key = key;
	}

    public List<Ad> getAdList() {
        return adList;
    }

    public void setAdList(List<Ad> adList) {
        this.adList = adList;
    }

}
