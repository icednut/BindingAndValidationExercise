package org.springstudy.validation.validator;

import org.springframework.util.StringUtils;
import org.springstudy.common.annotation.NotEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author wangeun.lee@sk.com
 */
public class NotEmailValidator implements ConstraintValidator<NotEmail, String> {
    @Override
    public void initialize(NotEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value)) {
            return false;
        }

        // value가 이메일 형식인지 정규식 비교
        return true;
    }
}
