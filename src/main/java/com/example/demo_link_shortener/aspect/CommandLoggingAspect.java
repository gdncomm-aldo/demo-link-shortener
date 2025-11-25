package com.example.demo_link_shortener.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class CommandLoggingAspect {
  //  semua method bernama execute
  //  @Pointcut("execution(* com.example.demo_link_shortener.command..*.execute(..))")

  //  semua method dari semua class di package
  @Pointcut("within(com.example.demo_link_shortener.controller..*)")

  //  semua method di controller yang namanya dimulai "get"
  //  @Pointcut("execution(* com.example.demo_link_shortener.controller..*.get*(..))")

  // semua method yang menggunakan anotasi Logging
  //  @Pointcut("@annotation(com.example.demo_link_shortener.annotation.Logging)")
  public void executeCommandPointcut() {
  }

  @Before("executeCommandPointcut()")
  public void logBeforeExecute(JoinPoint joinPoint) {
    log.info("{} executing {}", getCommandName(joinPoint), joinPoint.getSignature().getName());
  }

  @After("executeCommandPointcut()")
  public void logAfterExecute(JoinPoint joinPoint) {
    log.info("{} done executing {}", getCommandName(joinPoint), joinPoint.getSignature().getName());
  }

  @AfterReturning(pointcut = "executeCommandPointcut()", returning = "result")
  public void logAfterExecute(JoinPoint joinPoint, Object result) {
    log.info("{} successfully executed {} with result: {}",
        getCommandName(joinPoint),
        joinPoint.getSignature().getName(),
        result);
  }

  @AfterThrowing(pointcut = "executeCommandPointcut()", throwing = "throwable")
  public void logAfterExecuteThrow(JoinPoint joinPoint, Throwable throwable) {
    log.error("{} failed to execute with error: {}",
        getCommandName(joinPoint),
        throwable.getMessage());
  }

  @Around("executeCommandPointcut()")
  public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
    String commandName = "#" + pjp.getTarget().getClass().getSimpleName();
    String method = pjp.getSignature().getName();

    long start = System.currentTimeMillis();
    log.info("{} starting {}", commandName, method);

    try {
      Object result = pjp.proceed();

      long timeTaken = System.currentTimeMillis() - start;
      log.info("{} successfully executed {} in {} ms with result: {}",
          commandName, method, timeTaken, result);

      return result;
    } catch (Throwable ex) {
      long timeTaken = System.currentTimeMillis() - start;
      log.error("{} failed executing {} in {} ms with error: {}",
          commandName, method, timeTaken, ex.getMessage());

      throw ex;
    }
  }

  private String getCommandName(JoinPoint joinPoint) {
    return "#" + joinPoint.getTarget().getClass().getSimpleName();
  }
}

