package com.bitacademy.myportal.InterCeptors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//	인터페이스 구현 방식의 인터셉터
public class Myinterceptor implements HandlerInterceptor {
	private static Logger
		logger = LoggerFactory.getLogger(Myinterceptor.class);

	//	Controller 호출 이전에 요청과 응답을 처리
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler) //	실제 URL 처리할 컨트롤러의 메서드 참조 정보
			throws Exception {
		logger.debug("MyInterceptor.preHandle()");
		// true 반환 -> 다음번 인터셉터 or 컨틀롤러를 실행
		// false 반환 -> 다음번 인터셉터 or 커트롤러를 실행하지 않음
//		return HandlerInterceptor.super.preHandle(request, response, handler);
		return true;
	}

	//	Controller 호출 이후에 요청과 응답을 처리
	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("MyInterceptor.postHandle()");
//		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	//	모든 처리가 끝났을 때 요청과 응답을 처리
	@Override
	public void afterCompletion(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler, 
			Exception ex)
			throws Exception {
		logger.debug("MyInterceptor.afterCompletion()");
//		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}


}