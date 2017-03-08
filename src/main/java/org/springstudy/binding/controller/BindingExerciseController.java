package org.springstudy.binding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springstudy.common.dto.HelloParams;

import java.nio.charset.Charset;

/**
 * @author wangeun.lee@sk.com
 */
@Controller
public class BindingExerciseController {
    @RequestMapping("/hello")
    public String hello(@ModelAttribute HelloParams params, Model model) {
        model.addAttribute("requestMessage", params.getRequestMessage());
        return "hello";
    }

    @RequestMapping("/helloBinding")
    public String helloBinding(@RequestParam Charset charset, Model model) {
        System.out.println("************ charset == " + charset);
        System.out.println("************ charset type == " + charset.getClass().getName());
        return "hello";
    }
}
