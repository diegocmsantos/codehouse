package com.clearbases.codehouse.controllers;

import com.clearbases.codehouse.dao.ProductDAO;
import com.clearbases.codehouse.infra.FileManager;
import com.clearbases.codehouse.models.Cart;
import com.clearbases.codehouse.models.PriceType;
import com.clearbases.codehouse.models.Product;
import com.clearbases.codehouse.validations.ProductValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * Created by diego on 5/11/17.
 */
@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private FileManager fileManager;

//    @Autowired
//    private Cart cart;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.addValidators(new ProductValidation());
    }

    @RequestMapping("/form")
    public ModelAndView form(Product product) {
        ModelAndView modelAndView = new ModelAndView("products/form");
        modelAndView.addObject("types", PriceType.values());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView save(MultipartFile summary, @Valid Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return form(product);
        }

        product.setSummaryPath(fileManager.create("summaryFolder", summary));

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

    @RequestMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("products/detail");
        Product product = productDAO.find(id);
        modelAndView.addObject("product", product);
//        modelAndView.addObject("cart", cart);
        return modelAndView;
    }

}
