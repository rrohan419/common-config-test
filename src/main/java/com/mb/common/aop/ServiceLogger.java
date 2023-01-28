package com.mb.common.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ServiceLogger {

	private Logger logger = LogManager.getLogger();

	@Before("execution(* com.startupos.user.service.*.*(..)) || execution(* com.startupos.company.service.*.*(..)) || execution(* com.startupos.file.service.*.*(..))")
	public void before(JoinPoint joinPoint) {
		logger.info("In service {} method", joinPoint);
	}

	@After(value = "execution(* com.startupos.user.service.*.*(..)) || execution(* com.startupos.company.service.*.*(..)) || execution(* com.startupos.file.service.*.*(..))")
	public void after(JoinPoint joinPoint) {
		logger.info("after execution of {} method", joinPoint);
	}

}
