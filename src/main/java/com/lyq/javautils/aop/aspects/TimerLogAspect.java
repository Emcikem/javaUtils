package com.lyq.javautils.aop.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * 时间计算切面
 */

@Component
@Aspect
@Slf4j
public class TimerLogAspect {

    /**
     * Service层切点  增加时间日志
     */
    @Pointcut("@annotation(com.lyq.javautils.aop.anno.TimerLog)")
    public void ServiceAspect() {
    }


    @Around("ServiceAspect()")
    public  Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取方法名称
        String methodName = joinPoint.getSignature().getName();
        //获取类名
        String name = joinPoint.getTarget().getClass().getName();
        //开启计时
        long start = System.currentTimeMillis();
        //执行方法
        Object obj = joinPoint.proceed();
        log.info("【@TimerLog】{}.{} - 结束计时，用时：{} 。", name, methodName, System.currentTimeMillis() - start);
        return obj;
    }
}
