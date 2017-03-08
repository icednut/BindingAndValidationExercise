package org.springstudy.binding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springstudy.binding.binder.LevelPropertyEditor;
import org.springstudy.binding.binder.MinMaxAgePropertyEditor;
import org.springstudy.common.dto.Level;
import org.springstudy.common.dto.Member;

/**
 * @author wangeun.lee@sk.com
 */
@Controller
public class InitBinderExerciseController {
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Level.class, new LevelPropertyEditor());
        dataBinder.registerCustomEditor(int.class, "age", new MinMaxAgePropertyEditor(0, 200));
    }

    @RequestMapping(value = "/level", method = RequestMethod.GET)
    public String level(@RequestParam Level level, Model model) {
        System.out.println("************* level: " + level);
        model.addAttribute("level", level);
        return "hello";
    }

    @RequestMapping(value = "/minMax", method = RequestMethod.GET)
    public String minMax(@ModelAttribute Member member, Model model) {
        System.out.println("************* " + member.toString());
        model.addAttribute("member", member);
        return "hello";
    }
}
