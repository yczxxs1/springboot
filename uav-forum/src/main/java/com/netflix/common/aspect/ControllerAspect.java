package com.netflix.common.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.netflix.common.util.ControllerFileUtils;

@Aspect
@Order(1)
@Component
public class ControllerAspect {

	private final static Logger logger = LoggerFactory.getLogger(ControllerAspect.class);


	@Autowired
	private CounterService counterService;

	@Autowired
	private GaugeService gaugeService;

	@Pointcut("execution(public * com.netflix.business.controller..*.*(..))")
	public void controller() {
	}

	@Before("controller()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
        //记录访问次数
		counterService.increment(joinPoint.getSignature() + "");

		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// 记录下请求内容
		logger.debug("request url: {}", request.getRequestURL().toString());
		logger.debug("request method: {}", request.getMethod());
		logger.debug("request ip: {}", request.getRemoteAddr());
		logger.debug("class_method: {}",
				joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
		logger.debug("request args: {}", JSON.toJSONString(joinPoint.getArgs()));
	}

	
	@After("controller()")
	public void deleteFile() throws Throwable {

		ControllerFileUtils.deleteTempFiles();

	}

	@AfterReturning(returning = "ret", pointcut = "controller()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		logger.debug("response: {}", JSON.toJSONString(ret));
		
	}
	
	@Around("controller()")
	public Object latencyService(ProceedingJoinPoint pjp) throws Throwable{
		long start = System.currentTimeMillis();
		Object obj=pjp.proceed();
		long end = System.currentTimeMillis();
		long time=end-start;
		//记录访问时间
		logger.debug("spend time: {}", time + "ms");
		gaugeService.submit(pjp.getSignature().toString(), time);
		return obj;
	}

}
