package com.omega.platform.core.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Controller层切面(主要用于设置用户信息等公用切面处理)
 *
 * @Author: TommyYang
 * @Date: Created in 2019/9/11 15:29
 */
@Aspect
@Configuration
@Slf4j
public class ControllerAspect {
    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com..*Controller.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void executeBefore(JoinPoint joinPoint) {
        executeMethod(joinPoint);
    }

    @AfterReturning(returning = "o", pointcut = "webLog()")
    public void executeAfterReturning(Object o) {
        executeMethod();
    }

    private void executeMethod(JoinPoint joinPoint) {
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (!ObjectUtils.isEmpty(servletRequestAttributes)) {
            HttpServletRequest request = servletRequestAttributes.getRequest();
            log.info("请求地址 :".concat(request.getRequestURL().toString()));
            log.info("请求方式 : ".concat(request.getMethod()));
            log.info("IP : ".concat(request.getRemoteAddr()));
            log.info("匹配方法 : ".concat(joinPoint.getSignature().getDeclaringTypeName()).concat(joinPoint.getSignature().getName()));
            log.info("方法参数 : ".concat(Arrays.toString(joinPoint.getArgs())));
        }
    }

    private void executeMethod() {
        log.info("接口耗时: " + (System.currentTimeMillis() - startTime.get()) + "ms.");
        startTime.remove();
    }
}
