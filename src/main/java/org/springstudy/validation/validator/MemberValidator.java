package org.springstudy.validation.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springstudy.common.dto.Member;

/**
 * @author wangeun.lee@sk.com
 */
@Component
public class MemberValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Member.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Member member = (Member) target;
        String name = member.getName();

        if (name == null || name.length() == 0) {
            ValidationUtils.rejectIfEmpty(errors, "name", "field.required");
//            errors.rejectValue("name", "field.required");
        }

    }
}
