package daxzel.model.domains;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: daxzel
 * Date: 4/9/12
 * Time: 8:26 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Organization
{

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;
    
    private String name;

    private String address;

    private String fioOfDirector;
    
    private String telephoneOfDirector;

    private String telephoneOfMarketing;


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
        key = KeyFactory.createKey(Organization.class.getSimpleName(), id);
    }

    public void setKey(Key key)
    {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFioOfDirector() {
        return fioOfDirector;
    }

    public void setFioOfDirector(String fioOfDirector) {
        this.fioOfDirector = fioOfDirector;
    }

    public String getTelephoneOfDirector() {
        return telephoneOfDirector;
    }

    public void setTelephoneOfDirector(String telephoneOfDirector) {
        this.telephoneOfDirector = telephoneOfDirector;
    }

    public String getTelephoneOfMarketing() {
        return telephoneOfMarketing;
    }

    public void setTelephoneOfMarketing(String telephoneOfMarketing) {
        this.telephoneOfMarketing = telephoneOfMarketing;
    }
}
