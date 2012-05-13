package daxzel.model.DAO.impl;


import com.google.appengine.api.datastore.Key;
import daxzel.model.DAO.ProductDAO;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

import daxzel.model.domains.*;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

	public void remove(Long id) {
        EntityManager em = emf.createEntityManager();
		Product product = getByID(id);
		if (product != null) {
            Group group = product.getGroup();
            group.getProductKeys().remove(product.getKey());
            em.remove(product);
            em.merge(group);
		}
        em.close();
	}


	public Product getByID(Long id) {
        EntityManager em = emf.createEntityManager();
		Product product = em.find(Product.class, id);

        List<Ad> ads = new ArrayList<Ad>();

        for(Long key : product.getAdsKeys())
        {
            Ad ad = em.find(Ad.class, key);
            ad.setOrganization(em.find(Organization.class,ad.getOrganizationKey()));
            ad.setKindAd(em.find(KindAd.class,ad.getKeyToKindAd()));
            ads.add(ad);
        }

        product.setAds(ads);


        List<Order> orders = new ArrayList<Order>();

        for(Long key : product.getKeysOrders())
        {
            orders.add(em.find(Order.class, key));
        }

        product.setOrders(orders);


        List<Sale> sales = new ArrayList<Sale>();

        for(Long key : product.getKeysSales())
        {
            Sale sale = em.find(Sale.class, key);
            sale.setOrganization(em.find(Organization.class, sale.getOrganizationKey()));
            sale.setProduction(em.find(Production.class, sale.getProductionKey()));
            sales.add(sale);
        }

        product.setSales(sales);


        em.close();
        return product;
	}


	public List<Product> getAll() {
        EntityManager em = emf.createEntityManager();
               
		List<Product> lr = em.createQuery("Select From Product").getResultList();
        for(Product product : lr)
        {
            List<Ad> ads = new ArrayList<Ad>();

            for(Long key : product.getAdsKeys())
            {
                Ad ad = em.find(Ad.class, key);
                ad.setOrganization(em.find(Organization.class,ad.getOrganizationKey()));
                ad.setKindAd(em.find(KindAd.class,ad.getKeyToKindAd()));
                ads.add(ad);
            }

            product.setAds(ads);


            List<Order> orders = new ArrayList<Order>();

            for(Long key : product.getKeysOrders())
            {
                Order order = em.find(Order.class, key);
                order.setOrganization(em.find(Organization.class, order.getOrganizationKey()));
                order.setProduction(em.find(Production.class, order.getProductionKey()));
                orders.add(order);
            }

            product.setOrders(orders);

            List<Sale> sales = new ArrayList<Sale>();

            for(Long key : product.getKeysSales())
            {
                Sale sale = em.find(Sale.class, key);
                sale.setOrganization(em.find(Organization.class, sale.getOrganizationKey()));
                sale.setProduction(em.find(Production.class, sale.getProductionKey()));
                sales.add(sale);
            }

            product.setSales(sales);


        }

        em.close();
		return lr;
	}

	public void addOrUpdate(Product product) {
        EntityManager em = emf.createEntityManager();
        if (product.getKey()==null)
        {
            em.getTransaction().begin();
		    em.persist(product);
            em.getTransaction().commit();
            if (product.getGroup()!=null)
            {
                Group group = product.getGroup();
                List<Long> keys = group.getProductKeys();
                if (keys==null)
                {
                    keys = new ArrayList<Long>();    
                }
                keys.add(product.getKey());
                group.setProductKeys(keys);
                em.merge(group);
            }
        }
        else
        {
            
        }
        em.close();

	}
	
	public Product findProductByNCP(Long NCP)
	{
        EntityManager em = emf.createEntityManager();
		Product product = (Product)em.createQuery("Select p From Product p Where p.NCP="+NCP).getSingleResult();
        List<Ad> ads = new ArrayList<Ad>();

        for(Long key : product.getAdsKeys())
        {
            Ad ad = em.find(Ad.class, key);
            ad.setOrganization(em.find(Organization.class,ad.getOrganizationKey()));
            ad.setKindAd(em.find(KindAd.class,ad.getKeyToKindAd()));
            ads.add(ad);
        }

        product.setAds(ads);


        List<Order> orders = new ArrayList<Order>();

        for(Long key : product.getKeysOrders())
        {
            Order order = em.find(Order.class, key);
            order.setOrganization(em.find(Organization.class, order.getOrganizationKey()));
            order.setProduction(em.find(Production.class, order.getProductionKey()));
            orders.add(order);
        }

        product.setOrders(orders);


        List<Sale> sales = new ArrayList<Sale>();

        for(Long key : product.getKeysSales())
        {
            Sale sale = em.find(Sale.class, key);
            sale.setOrganization(em.find(Organization.class, sale.getOrganizationKey()));
            sale.setProduction(em.find(Production.class, sale.getProductionKey()));
            sales.add(sale);
        }

        product.setSales(sales);



        em.close();
        return product;
	}

	public void removeProductByNCP(Long NCP)
	{
        EntityManager em = emf.createEntityManager();
		em.createQuery("Delete From Product p Where p.NCP="+NCP).executeUpdate();
        em.close();
	}

    public Product getProductByName(String name)
    {
        EntityManager em = emf.createEntityManager();
        Product product = (Product) em.createQuery(
                "Select From Product Where name='" + name + "'")
                .getSingleResult();
        List<Ad> ads = new ArrayList<Ad>();

        for(Long key : product.getAdsKeys())
        {
            Ad ad = em.find(Ad.class, key);
            ad.setOrganization(em.find(Organization.class,ad.getOrganizationKey()));
            ad.setKindAd(em.find(KindAd.class,ad.getKeyToKindAd()));
            ads.add(ad);
        }

        product.setAds(ads);


        List<Order> orders = new ArrayList<Order>();

        for(Long key : product.getKeysOrders())
        {
            Order order = em.find(Order.class, key);
            order.setOrganization(em.find(Organization.class, order.getOrganizationKey()));
            order.setProduction(em.find(Production.class, order.getProductionKey()));
            orders.add(order);
        }

        List<Sale> sales = new ArrayList<Sale>();

        for(Long key : product.getKeysSales())
        {
            Sale sale = em.find(Sale.class, key);
            sale.setOrganization(em.find(Organization.class, sale.getOrganizationKey()));
            sale.setProduction(em.find(Production.class, sale.getProductionKey()));
            sales.add(sale);
        }

        product.setSales(sales);


        product.setOrders(orders);
        em.close();
        return product;
    }

	
	
}