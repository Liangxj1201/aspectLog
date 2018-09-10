package com.xjliang.aspect.config;

import com.xjliang.aspect.utils.CommUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerAspect {

    private static final Log LOG = LogFactory.getLog(ControllerAspect.class);

    @Before(value = "controllerPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        LOG.info("==" + CommUtils.getTimeStr() + " 开始请求" + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName() + "==");
    }

    @After(value = "controllerPointCut()")
    public void doAfter(JoinPoint joinPoint) throws Throwable {
        LOG.info("==" + CommUtils.getTimeStr() + " 请求" + joinPoint.getSignature().getDeclaringTypeName() + "."
                + joinPoint.getSignature().getName() + "结束==");
    }

    @Pointcut("execution(* com.xjliang.aspect.controller..*.*(..))")
    private void controllerPointCut() {
    }
}
