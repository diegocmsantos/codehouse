package com.clearbases.codehouse.controllers;

import com.clearbases.codehouse.models.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by macair on 30/05/17.
 */
@RequestMapping("/payment")
@Controller
public class PaymentController {

    @Autowired
    Cart cart;

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public ModelAndView pay(RedirectAttributes model) {
        System.out.println(cart.getTotal());
        model.addFlashAttribute("message", "Paid successfully");
        return new ModelAndView("redirect:/products");
    }

}
