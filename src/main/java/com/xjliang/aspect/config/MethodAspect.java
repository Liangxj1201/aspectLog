package com.xjliang.aspect.config;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MethodAspect {

    private static final Log LOG = LogFactory.getLog(MethodAspect.class);

    @Pointcut("execution(public * com.xjliang.aspect.service..*.*(..))")
    public void methodPointcut() {
    }

    @Around("methodPointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            long end = System.currentTimeMillis();
            LOG.info("执行" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()
                    + "方法," + parseParames(joinPoint.getArgs()) + ",耗时:" + (end - start) + " ms!");
            return result;
        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            LOG.error(joinPoint + ",耗时:" + (end - start) + " ms,抛出异常 :" + e.getMessage());
            throw e;
        }
    }

    @AfterReturning(returning = "ret", pointcut = "methodPointcut()")
    public void doAfterReturning(Object ret) throws Throwable {
        LOG.info("返回值:" + ret);
    }

    private String parseParames(Object[] parames) {

        if (null == parames || parames.length <= 0) {
            return "该方法没有参数";

        }
        StringBuffer param = new StringBuffer("请求参数 # 个:[ ");
        int i = 0;
        for (Object obj : parames) {
            i++;
            if (i == 1) {
                param.append(obj.toString());
                continue;
            }
            param.append(" ,").append(obj.toString());
        }
        return param.append(" ]").toString().replace("#", String.valueOf(i));
    }
}
