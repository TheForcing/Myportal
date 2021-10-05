package com.bitacademy.myportal.InterCeptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//	클래스 상속 방식의 인터셉터
//	필요한 메서드만 오버라이드 해서 구현하면 된다
public class Myinterceptor2 extends HandlerInterceptorAdapter {
	private Logger logger = LoggerFactory.getLogger(Myinterceptor2.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("MyInterceptor2.preHandle()");
//		return super.preHandle(request, response, handler);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("MyInterceptor2.postHandle()");
//		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug("MyInterceptor2.afterCompletion()");
//		super.afterCompletion(request, response, handler, ex);
	}

}