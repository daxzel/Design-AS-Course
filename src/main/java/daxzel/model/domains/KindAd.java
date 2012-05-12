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
	private Long key;

	private String name;

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

	public void setKey(Long key) {
		this.key = key;
	}

}
