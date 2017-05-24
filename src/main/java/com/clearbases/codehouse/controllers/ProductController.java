package com.clearbases.codehouse.controllers;

import com.clearbases.codehouse.dao.ProductDAO;
import com.clearbases.codehouse.models.PriceType;
import com.clearbases.codehouse.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by diego on 5/11/17.
 */
@Controller
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping("/form")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("products/form");
        modelAndView.addObject("types", PriceType.values());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(Product product, RedirectAttributes redirectAttributes) {
        System.out.println(product.toString());
        productDAO.save(product);
        redirectAttributes.addFlashAttribute("message", "Product saved successfully!");
        return new ModelAndView("redirect:products");
    }

    @RequestMapping()
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("products/list");
        modelAndView.addObject("products", productDAO.list());
        return modelAndView;
    }

}
