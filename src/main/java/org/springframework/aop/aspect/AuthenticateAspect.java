package org.springframework.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AuthenticateAspect {

    //@Before("execution(* MyService.*(..))")
    //@Before("execution(* org.springframework.aop.business.CheckoutService.payment(boolean, String)) && args(isDone, username)")
//    @Before("execution(* org.springframework.aop.business.CheckoutService.payment(boolean, String)) && args(isDone, username)")
    @Before("execution(* org.springframework.aop.business.CheckoutService.payment(boolean, String))")
    public void authenticateAdvice(org.aspectj.lang.JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        boolean isDone = (boolean) args[0];
        String username = (String) args[1];
        System.out.println(isDone ? "authenticated as "+username : "please login "+ username);
    }
}
