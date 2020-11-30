package com.study.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author pengwei.tan
 */
@Component
@Slf4j
public class LogIntercept implements HandlerInterceptor {
    private ThreadLocal threadLocal = new ThreadLocal();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("请求地址：{},请求参数：{}",request.getRequestURI(), JSONObject.toJSONString(request.getParameterMap()));
        threadLocal.set(System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("交易共耗时：{}毫秒",System.currentTimeMillis()-Long.valueOf(threadLocal.get().toString()));
    }
}

