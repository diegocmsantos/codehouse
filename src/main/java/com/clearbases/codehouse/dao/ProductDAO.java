package com.clearbases.codehouse.dao;

import com.clearbases.codehouse.models.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by diego on 5/11/17.
 */
@Repository
@Transactional
public class ProductDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Product product) {
        entityManager.persist(product);
    }

    public List<Product> list() {
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

}
