package com.tang.bugger.intercept;

import com.alibaba.druid.support.json.JSONUtils;
import com.tang.bugger.util.ResultMessage;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * 拦截器：记录用户操作日志，检查用户是否登录…… 
 * @author XuJijun 
 */  
@Aspect
@Component
public class ControllerInterceptor {  
    private static final Logger logger = LoggerFactory.getLogger(ControllerInterceptor.class);


    // 切入点表达式按需配置
    @Pointcut("execution(* com.tang.bugger.controller..*(..)) || execution(* com.tang.bugger.service..*(..)) && execution(* com.tang.bugger.dao..*(..))")
    private void myPointcut() {
    }

    @Before("execution(* com.tang.bugger.controller..*(..)) || execution(* com.tang.bugger.service..*(..)) && execution(* com.tang.bugger.dao..*(..))")
    public void before(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        logger.warn(className + "的" + methodName + "执行了");
        Object[] args = joinPoint.getArgs();
        StringBuilder log = new StringBuilder("入参为");
        for (Object arg : args) {
            log.append(arg + " ");
        }
        logger.warn(log.toString());
    }

    @AfterReturning(value = "execution(* com.tang.bugger.controller..*(..)) || execution(* com.tang.bugger.service..*(..)) && execution(* com.tang.bugger.dao..*(..))", returning = "returnVal")
    public void afterReturin(Object returnVal) {
        logger.warn("方法正常结束了,方法的返回值:" + returnVal);
    }


    @AfterThrowing(value = "myPointcut()", throwing = "e")
    public void afterThrowing(Throwable e) {
        logger.error("通知中发现未知异常", e);
    }
      
    /** 
     * 拦截器具体实现 
     * @param pjp 
     * @return JsonResult（被拦截方法的执行结果，或需要登录的错误提示。） 
     */  
    @Around("myPointcut()") //指定拦截器规则；也可以直接把“execution(* com.xjj.........)”写进这里
    public Object interceptor(ProceedingJoinPoint pjp){
        long beginTime = System.currentTimeMillis();  
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod(); //获取被拦截的方法
        String methodName = method.getName(); //获取被拦截的方法名  

        Set<Object> allParams = new LinkedHashSet<>(); //保存所有请求参数，用于输出到日志中
          
        logger.info("请求开始，方法：{}", methodName);  
        Object result = null;
  
        Object[] args = pjp.getArgs();  
        for(Object arg : args){  
            //logger.debug("arg: {}", arg);  
            if (arg instanceof Map<?, ?>) {
                //提取方法中的MAP参数，用于记录进日志中  
                @SuppressWarnings("unchecked")  
                Map<String, Object> map = (Map<String, Object>) arg;  
  
                allParams.add(map);  
            }else if(arg instanceof HttpServletRequest){
                HttpServletRequest request = (HttpServletRequest) arg;
                  
                //获取query string 或 posted form data参数  
                Map<String, String[]> paramMap = request.getParameterMap();  
                if(paramMap!=null && paramMap.size()>0){  
                    allParams.add(paramMap);  
                }  
            }else if(arg instanceof HttpServletResponse){
                //do nothing...  
            }else{  
                //allParams.add(arg);  
            }  
        }  
          
        try {

            if(result == null){  
                // 一切正常的情况下，继续执行被拦截的方法  
                result = pjp.proceed();  
            }  
        } catch (Throwable e) {  
            logger.info("exception: ", e);
            result = new ResultMessage(10001, "发生异常："+e.getMessage(), null);
        }  
          
        if(result instanceof ResultMessage){
            long costMs = System.currentTimeMillis() - beginTime;
            logger.info("{}请求结束，耗时：{}ms", methodName, costMs);
        } else if (result instanceof Exception) {
            result = new ResultMessage<>(10001,"失败", JSONUtils.toJSONString(result));

        } else {

            result = new ResultMessage<>(10001,"失败", null);
        }

        return result;  
    }  

}  

