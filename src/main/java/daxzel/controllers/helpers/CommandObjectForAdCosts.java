package daxzel.controllers.helpers;

import daxzel.model.domains.Product;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: daxzel
 * Date: 5/13/12
 * Time: 4:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommandObjectForAdCosts {

    private Product product;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date dateBegin  = new Date(System.currentTimeMillis());

    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date dateEnd  = new Date(System.currentTimeMillis());

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

}
