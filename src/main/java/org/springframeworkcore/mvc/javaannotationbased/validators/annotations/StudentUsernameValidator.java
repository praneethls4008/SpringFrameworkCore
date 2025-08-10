package org.springframeworkcore.mvc.javaannotationbased.validators.annotations;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface StudentUsernameValidator {
    String message() default "username ";
}
