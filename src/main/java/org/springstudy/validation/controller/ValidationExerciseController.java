package org.springstudy.validation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springstudy.common.dto.Member;
import org.springstudy.validation.validator.MemberValidator;

/**
 * @author wangeun.lee@sk.com
 */
@Controller
public class ValidationExerciseController {
    @Autowired
    private MemberValidator memberValidator;

    @RequestMapping(value = "/validation", method = RequestMethod.GET)
    public String validation(@ModelAttribute Member member, BindingResult bindingResult) throws BindException {
        memberValidator.validate(member, bindingResult);

        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }
        return "hello";
    }
}

