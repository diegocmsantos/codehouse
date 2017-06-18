package com.clearbases.codehouse.builder;

import com.clearbases.codehouse.models.Price;
import com.clearbases.codehouse.models.PriceType;
import com.clearbases.codehouse.models.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by diego on 6/17/17.
 */
public class ProductBuilder {

    private List<Product> products = new ArrayList<>();

    private ProductBuilder(Product product) {
        products.add(product);
    }

    public static ProductBuilder newProduct(PriceType priceType, BigDecimal value) {
        Product book = create("book 1", priceType, value);
        return new ProductBuilder(book);
    }

    public static ProductBuilder newProduct() {
        Product book = create("book 1", PriceType.COMBO, BigDecimal.TEN);
        return new ProductBuilder(book);
    }

    private static Product create(String nomeLivro, PriceType tipoPreco, BigDecimal valor) {
        Product book = new Product();
        book.setTitle(nomeLivro);
        book.setReleaseDate(Calendar.getInstance());
        book.setPages(150);
        book.setDescription("Best books about tests");

        Price preco = new Price();
        preco.setType(tipoPreco);
        preco.setValue(valor);
        book.getPrices().add(preco);

        return book;
    }

    public ProductBuilder more(int number) {
        Product base = products.get(0);
        Price price = base.getPrices().get(0);
        for (int i = 0; i < number; i++) {
            products.add(create("Book " + i, price.getType(), price.getValue()));
        }
        return this;
    }

    public Product buildOne() {
        return products.get(0);
    }

    public List<Product> buildAll() {
        return products;
    }

}
