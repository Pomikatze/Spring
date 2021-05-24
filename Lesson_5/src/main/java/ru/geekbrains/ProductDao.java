package ru.geekbrains;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import ru.geekbrains.entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class ProductDao {
    public static void main(String[] args) {
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        EntityManager em = factory.createEntityManager();
    }

    static Product findById (EntityManager em, long id){
        List<Product> products;
        Query query = em.createQuery("select p from Product p where p.id = :id");
        query.setParameter("id", id);
        products = (List<Product>) query.getResultList();
        return products.get(0);
    }

    static List<Product> findAll(EntityManager em){
        Query query = em.createQuery("select p from Product p");
        return  (List<Product>) query.getResultList();
    }

    static void deleteById (EntityManager em, long id){
        em.getTransaction().begin();
        em.createQuery("delete Product p where p.id = :id").setParameter("id", id).executeUpdate();
        em.getTransaction().commit();
    }

    static Product saveOrUpdate (EntityManager em, Product product){
        em.getTransaction().begin();
        Query query = em.createQuery("select p from Product p where p.id = :id");
        query.setParameter("id", product.getId());
        Product oldProduct = (Product) query.getResultList().get(0);
        if (oldProduct.getPrice() != product.getPrice()){
            em.createQuery("update product p set price = :price where p.price = :oldprice")
                    .setParameter("price", product.getPrice())
                    .setParameter("oldprice", oldProduct.getPrice())
                    .executeUpdate();
        } else if (!oldProduct.getTitle().toLowerCase().equals(product.getTitle().toLowerCase())){
            em.createQuery("update product p set title = :title where p.title = :oldtitle")
                    .setParameter("title", product.getPrice())
                    .setParameter("oldtitle", oldProduct.getPrice())
                    .executeUpdate();
        }
        em.getTransaction().commit();
        return (Product) query.getResultList().get(0);
    }
}
