package com.filter.filterDemo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.filter.filterDemo.headerContext.RequestHeaderContext;

public class RequestHeaderContextInterceptor extends HandlerInterceptorAdapter{  
	  
    private static final String HEAD_USER_ID = "User-Id";  
    private static final String HEAD_TOKEN = "Token";  
  
    @Override  
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {  
        initHeaderContext(request);  
        return super.preHandle(request, response, handler);  
    }  
  
    private void initHeaderContext(HttpServletRequest request){  
        new RequestHeaderContext.RequestHeaderContextBuild()  
                .token(request.getHeader(HEAD_TOKEN))  
                .userId(request.getHeader(HEAD_USER_ID))  
                .bulid();  
    }  
  
    @Override  
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {  
        RequestHeaderContext.clean();  
        super.postHandle(request, response, handler, modelAndView);  
    }  
}  	