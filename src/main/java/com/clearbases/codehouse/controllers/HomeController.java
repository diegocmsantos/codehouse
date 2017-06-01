package com.clearbases.codehouse.controllers;

import com.clearbases.codehouse.dao.ProductDAO;
import com.clearbases.codehouse.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/**
 * Created by diego on 5/10/17.
 */
@Controller
public class HomeController {

    @Autowired
    private ProductDAO productDAO;

    @Cacheable(value = "productsHome")
    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("home");
        Collection<Product> products = productDAO.list();
        modelAndView.addObject("products", products);
        return modelAndView;
    }
}
