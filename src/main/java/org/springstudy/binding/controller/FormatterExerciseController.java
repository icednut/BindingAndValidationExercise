package org.springstudy.binding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springstudy.common.dto.Product;

/**
 * @author wangeun.lee@sk.com
 */
@Controller
public class FormatterExerciseController {
    @RequestMapping(value = "/formatter/number", method = RequestMethod.GET)
    public String formatterNumber(@ModelAttribute Product product, Model model) {
        System.out.println("************* " + product.toString());
        model.addAttribute("price", product.getPrice());
        return "hello";
    }

    @RequestMapping(value = "/formatter/date", method = RequestMethod.GET)
    public String formatterDate(@ModelAttribute Product product, Model model) {
        System.out.println("************* " + product.toString());
        model.addAttribute("date", product.getOrderDate());
        return "hello";
    }
}
