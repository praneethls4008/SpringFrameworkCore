package org.springframeworkcore.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* org.springframework.aop.business.*.*(..))")
    private void selectAll(){

    }

    @After("selectAll()")
    public void after(){
        System.out.println("!!!! After method !!!");
    }

    @Around("selectAll()")
//@Around("execution(* org.springframework.aop.business.*.*(..))")
public Object logger(ProceedingJoinPoint jointPoint) throws Throwable {
    Logger logger = LoggerFactory.getLogger(jointPoint.getSignature().getDeclaringType());

    String methodName = jointPoint.getSignature().getName();
    Object[] args = jointPoint.getArgs();

    logger.info("Entering method: {} with arguments: {}", methodName, Arrays.toString(args));
    Object methodResult = null;

    try {
        methodResult = jointPoint.proceed();
        logger.info("Method returned: {}", methodResult != null ? methodResult : "null");
    } catch (Throwable e) {
        logger.error("Method threw exception: {}", e.getMessage(), e);
        throw e;
    }

    logger.info("Exiting method: {}", methodName);
    return methodResult;
}
}
