package com.hfjy.student.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hsx
 * create at 2019-06-21
 */
@Slf4j
public class MainInterceptor implements HandlerInterceptor {

    /**
     * 请求开始时间key
     */
    private static final String BEGIN_TIME_KEY="$req_begin";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute(BEGIN_TIME_KEY, System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Long beginTime = (Long) request.getAttribute(BEGIN_TIME_KEY);
        log.warn("request:{},执行时长:{}毫秒",request.getRequestURI(),System.currentTimeMillis()-beginTime);
    }
}
