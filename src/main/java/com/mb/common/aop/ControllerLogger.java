package com.mb.common.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class ControllerLogger {

	private Logger logger = LogManager.getLogger();

	@Before("execution(* com.startupos.user.controller.*.*(..)) || execution(* com.startupos.company.controller.*.*(..)) || execution(* com.startupos.file.controller.*.*(..))")
	public void before(JoinPoint joinPoint) {
		logger.info("In controller {} method", joinPoint);
	}

	@AfterReturning(value = "execution(* com.startupos.user.controller.*.*(..)) || execution(* com.startupos.company.controller.*.*(..)) || execution(* com.startupos.file.controller.*.*(..))", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("returned with value {}", result);
	}

	@AfterThrowing(pointcut = "execution(* com.startupos.user.controller.*.*(..)) || execution(* com.startupos.company.controller.*.*(..)) || execution(* com.startupos.file.controller.*.*(..))", throwing = "e")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
		logger.error("An exception has been thrown in {} method", joinPoint.getSignature().getName());
		if (e.getCause() != null) {
			logger.error("Cause: {}", e.getCause().getMessage());
		}
		logger.error("Exception Message : {}", e.getMessage());
	}

	@Around("execution(* com.startupos.user.controller.*.*(..)) || execution(* com.startupos.company.controller.*.*(..)) || execution(* com.startupos.file.controller.*.*(..))")
	public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();

		final StopWatch stopWatch = new StopWatch();

		stopWatch.start();
		Object result = proceedingJoinPoint.proceed();
		stopWatch.stop();

		logger.info("Execution time of {}.{} :: {} ms", className, methodName, stopWatch.getTotalTimeMillis());

		return result;
	}
}
