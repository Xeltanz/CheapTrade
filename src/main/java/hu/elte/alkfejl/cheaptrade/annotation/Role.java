package hu.elte.alkfejl.cheaptrade.annotation;

import hu.elte.alkfejl.cheaptrade.domain.user.User;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Role {

    User.Role[] value() default {User.Role.GUEST};
}