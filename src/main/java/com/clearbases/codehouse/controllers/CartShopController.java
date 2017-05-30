package com.clearbases.codehouse.controllers;

import com.clearbases.codehouse.dao.ProductDAO;
import com.clearbases.codehouse.models.Cart;
import com.clearbases.codehouse.models.CartItem;
import com.clearbases.codehouse.models.PriceType;
import com.clearbases.codehouse.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by macair on 25/05/17.
 */

@Controller
@RequestMapping("/cart")
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CartShopController {

    @Autowired
    private ProductDAO produtoDAO;

    @Autowired
    private Cart cart;

    @RequestMapping("/add")
    public ModelAndView add(Long productId, PriceType priceType) {

        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        CartItem cartItem = createCartItem(productId, priceType);

        cart.add(cartItem);

        return modelAndView;

    }

    private CartItem createCartItem(Long productId, PriceType priceType) {
        Product product = produtoDAO.find(productId);
        return new CartItem(product, priceType);
    }

}
