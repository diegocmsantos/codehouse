package com.clearbases.codehouse.models;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Cart
 * Created by macair on 25/05/17.
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

    private Map<CartItem, Integer> items = new LinkedHashMap<>();

    public void add(CartItem cartItem) {

        items.put(cartItem, getQuantity(cartItem) + 1);
    }

    public int getQuantity(CartItem cartItem) {
        if (!items.containsKey(cartItem)) {
            items.put(cartItem, 0);
        }
        return items.get(cartItem);
    }

    public int getQuantity() {
        return items.values().stream().reduce(0, (next, accumulator) -> (next + accumulator));
    }

    public Collection<CartItem> getItems() {
        return items.keySet();
    }

    public BigDecimal getTotal(CartItem cartItem) {
        return cartItem.getTotal(getQuantity(cartItem));
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (CartItem item : items.keySet()) {
            total = total.add(getTotal(item));
        }
        return total;
    }

    public void remove(Integer produtoId, PriceType priceType) {
        Product product = new Product();
        product.setId(produtoId);
        items.remove(new CartItem(product, priceType));
    }
}
