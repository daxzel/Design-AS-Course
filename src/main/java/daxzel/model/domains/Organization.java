package daxzel.model.domains;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long key;

    @NotNull(message="Введите код организации")
    @Min(value = 0, message ="Код организаци должен быть больше 0")
    private Long NCEO;

    @NotNull(message="Введите название организации")
    @Size(min=3, max=30, message="Название организации должно быть от 3 до 30 символов")
    private String name;

    @NotNull(message="Введите адрес организации")
    @Size(min=3, max=60, message="Адрес организации должен быть от 3 до 60 символов")
    private String address;

    @NotNull(message="Введите ФИО директора организации")
    @Size(min=3, max=30, message="ФИО директора должно быть от 3 до 15 символов")
    private String fioOfDirector;

    @NotNull(message="Введите номер телефона организации")
    @Size(min=3, max=15, message="Телефон должен быть от 3 до 15 символов")
    private String telephoneOfDirector;

    @Size(min=3, max=15, message="Телефон должен быть от 3 до 15 символов")
    private String telephoneOfMarketing;

    public Long getNCEO() {
        return NCEO;
    }

    public void setNCEO(Long NCEO) {
        this.NCEO = NCEO;
    }

    public Long getKey()
    {
        return key;
    }

    public void setKey(Long key)
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
