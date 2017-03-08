package org.springstudy.common.annotation;

import org.springstudy.validation.validator.NotEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by 1002371 on 15. 6. 27..
 */
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {NotEmailValidator.class})
public @interface NotEmail {
    String message() default "{not.email}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
