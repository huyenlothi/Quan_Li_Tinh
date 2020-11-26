package com.quanli.aspect;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.event.spi.SaveOrUpdateEvent;

@Aspect
public class MyLogger {
    @AfterReturning(pointcut = "within(com.quanli.controller.CustomerController.*)",returning = "result")
    public void log(JoinPoint joinPoint, Object result){
        System.out.println("Demo");
        System.out.println("Start log");
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName= joinPoint.getSignature().getName();
        System.out.println(className+"."+methodName);
        if (result==null){
            System.out.println("null");
        }else {
            System.out.println(result.hashCode());
        }
    }
}
