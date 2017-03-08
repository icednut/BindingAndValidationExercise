package org.springstudy.binding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springstudy.common.dto.Level;

/**
 * @author wangeun.lee@sk.com
 */
@Controller
public class ConverterExerciseController {
    @Autowired
    private ConversionService conversionService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setConversionService(this.conversionService);
    }

    @RequestMapping(value = "/converter", method = RequestMethod.GET)
    public String converter(@RequestParam Level level, Model model) {
        System.out.println("************* level: " + level);
        model.addAttribute("level", level);
        return "hello";
    }
}
