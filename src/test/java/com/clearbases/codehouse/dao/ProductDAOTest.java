package com.clearbases.codehouse.dao;

import com.clearbases.codehouse.builder.ProductBuilder;
import com.clearbases.codehouse.conf.JPAConfiguration;
import com.clearbases.codehouse.confs.DataSourceConfigurationTest;
import com.clearbases.codehouse.models.PriceType;
import com.clearbases.codehouse.models.Product;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by diego on 6/17/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        JPAConfiguration.class,
        ProductDAO.class,
        DataSourceConfigurationTest.class}
)
@ActiveProfiles("test")
public class ProductDAOTest {

    @Autowired
    private ProductDAO productDAO;

    @Test
    @Transactional
    public void shouldSumAllPricesByPriceType() {

        List<Product> pressBooks = ProductBuilder.newProduct(PriceType.PRESS, BigDecimal.TEN).more(3).buildAll();
        List<Product> ebookBooks = ProductBuilder.newProduct(PriceType.EBOOK, BigDecimal.TEN).more(3).buildAll();

        pressBooks.forEach(productDAO::save);
        ebookBooks.forEach(productDAO::save);

        BigDecimal valor = productDAO.sumPricesByType(PriceType.EBOOK);
        Assert.assertEquals(new BigDecimal(40).setScale(2), valor);
    }

}
