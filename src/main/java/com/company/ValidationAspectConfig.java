package com.company;

import com.company.validation.CustomValidation;
import com.company.validation.ValidatorBase;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author abbas
 */
@Aspect
@Configuration
public class ValidationAspectConfig {

    @Before("@annotation(com.company.validation.CustomValidation)")
    public void getNameAdvice(JoinPoint joinPoint) throws InstantiationException, IllegalAccessException {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Class clazz = methodSignature.getMethod().getAnnotation(CustomValidation.class).value();
        Object object = clazz.newInstance();
        if (object instanceof ValidatorBase) {
            ValidatorBase validator = (ValidatorBase) object;
            Object arg = joinPoint.getArgs()[0];
            validator.isValid(arg);
        }
    }

}
