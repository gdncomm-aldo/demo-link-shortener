package com.example.demo_link_shortener.aspect;

import com.example.demo_link_shortener.command.model.GetAllLinkCommandResponse;
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

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Aspect
@Slf4j
@Component
public class CommandLoggingAspect {
  // menargetkan method execute pada GetAllLinkCommandImpl
  @Pointcut("execution(* com.example.demo_link_shortener.command.GetAllLinkCommandImpl.execute(..))")

  // menargetkan semua class di package controller
  // @Pointcut("within(com.example.demo_link_shortener.controller..*)")

  // semua method di controller yang namanya dimulai "get"
  // @Pointcut("execution(* com.example.demo_link_shortener.controller..*.get*(..))")

  // semua method yang menggunakan anotasi Logging
  // @Pointcut("@annotation(com.example.demo_link_shortener.annotation.Logging)")
  public void executeCommandPointcut() {}

//  @Before("executeCommandPointcut()")
//  public void logBeforeExecute(JoinPoint joinPoint) {
//    log.info("@Before {} executing {}", getCommandName(joinPoint),
//        joinPoint.getSignature().getName());
//  }
//
//  @After("executeCommandPointcut()")
//  public void logAfterExecute(JoinPoint joinPoint) {
//    log.info("@After {} done executing {}", getCommandName(joinPoint),
//        joinPoint.getSignature().getName());
//  }
//
//  @AfterReturning(pointcut = "executeCommandPointcut()", returning = "result")
//  public void logAfterReturningExecute(JoinPoint joinPoint, Object result) {
//    log.info("@AfterReturning {} successfully executed {} with result: {}",
//        getCommandName(joinPoint), joinPoint.getSignature().getName(), result);
//  }
//
//  @AfterThrowing(pointcut = "executeCommandPointcut()", throwing = "throwable")
//  public void logAfterThrowingExecute(JoinPoint joinPoint, Throwable throwable) {
//    log.error("@AfterThrowing {} failed to execute with error: {}", getCommandName(joinPoint),
//        throwable.getMessage());
//  }
//
//  @Around("executeCommandPointcut()")
//  public Object logAroundExecute(ProceedingJoinPoint pjp) throws Throwable {
//    String commandName = "#" + pjp.getTarget().getClass().getSimpleName();
//    String method = pjp.getSignature().getName();
//
//    long start = System.currentTimeMillis();
//    log.info("@Around {} starting {}", commandName, method);
//
//    try {
//      Object result = pjp.proceed();
//      Object finalResult = result;
//
//      if (result instanceof GetAllLinkCommandResponse response) {
//        response.setData(new ArrayList<>());
//        log.info("@Around Result modified before return: {}", response);
//        finalResult =  response;
//      }
//
//      long timeTaken = System.currentTimeMillis() - start;
//      log.info("@Around {} successfully executed {} in {} ms with result: {}", commandName, method,
//          timeTaken, finalResult);
//
//      return finalResult;
//    } catch (Throwable ex) {
//      long timeTaken = System.currentTimeMillis() - start;
//      log.error("@Around {} failed executing {} in {} ms with error: {}", commandName, method,
//          timeTaken, ex.getMessage());
//
//      throw ex;
//    }
//  }

  private String getCommandName(JoinPoint joinPoint) {
    return "#" + joinPoint.getTarget().getClass().getSimpleName();
  }
}

