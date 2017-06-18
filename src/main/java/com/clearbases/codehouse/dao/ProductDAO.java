package com.clearbases.codehouse.dao;

import com.clearbases.codehouse.models.PriceType;
import com.clearbases.codehouse.models.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
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
        return entityManager.createQuery("select distinct(p) from Product p join fetch p.prices", Product.class).getResultList();
    }

    public Product find(Integer id) {
        return entityManager.createQuery("SELECT p FROM Product p join fetch p.prices WHERE p.id = :id", Product.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public BigDecimal sumPricesByType(PriceType priceType) {

        TypedQuery<BigDecimal> query = entityManager
                .createQuery("select sum(price.value) from Product p join p.prices price where price.type = :priceType", BigDecimal.class);
        query.setParameter("priceType", priceType);
        return query.getSingleResult();

    }

    @ExceptionHandler(NoResultException.class)
    public String handleDetailNotFound(){
        return "error";
    }
}
