package org.springstudy.validation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springstudy.common.dto.Member;
import org.springstudy.validation.validator.MemberValidator;

import javax.validation.Valid;

/**
 * @author wangeun.lee@sk.com
 */
@Controller
public class AutoValidationExerciseController {
    @Autowired
    private MemberValidator memberValidator;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(memberValidator);
    }

    @RequestMapping(value = "/validation/auto", method = RequestMethod.GET)
    public String validation(@ModelAttribute @Valid Member member, BindingResult bindingResult) throws BindException {
        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }
        return "hello";
    }
}

