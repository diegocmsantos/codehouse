package com.clearbases.codehouse.models;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Cart
 * Created by macair on 25/05/17.
 */
@Component
public class Cart {

    private Map<CartItem, Integer> items = new LinkedHashMap<>();

    public void add(CartItem cartItem) {

        items.put(cartItem, getQuantity(cartItem));
    }

    private int getQuantity(CartItem cartItem) {
        if(!items.containsKey(cartItem)){
            items.put(cartItem, 0);
        }
        return items.get(cartItem);
    }

    public int getQuantity() {
        return items.values().stream().reduce(0, (next, accumulator) -> (next + accumulator));
    }

}
