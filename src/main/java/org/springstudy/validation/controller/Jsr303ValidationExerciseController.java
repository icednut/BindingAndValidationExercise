package org.springstudy.validation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springstudy.common.dto.HelloImpl;
import org.springstudy.common.dto.Jsr303Member;

/**
 * @author wangeun.lee@sk.com
 */
@Controller
public class Jsr303ValidationExerciseController {
    @RequestMapping(value = "/validation/jsr303", method = RequestMethod.GET)
    public String validationJsr(@ModelAttribute @Validated(HelloImpl.class) Jsr303Member member) {
        // helloService.service(member);
        return "hello";
    }

    @RequestMapping(value = "/validation2/jsr303", method = RequestMethod.GET)
    public String validationJsr2(@ModelAttribute @Validated Jsr303Member member) {
        // helloService.service(member);
        return "hello";
    }
}
