package com.bitacademy.myportal.InterCeptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import com.bitacademy.myportal.repository.UserVo;

//컨트롤러에서 요청을 가로채서
//필요한 경우, 로그인 페이지로 전송
public class AuthInterceptor implements HandlerInterceptor {
     private Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.debug("AuthInterceptor");
		
		//세션 체크
		HttpSession session = request.getSession();
		
		//로그인 사용자 체크
		UserVo authUser = null;
		
		if(session != null) {
			authUser =(UserVo)session.getAttribute("authUser");	
		}
	    
		if(authUser == null) {
			//로그인 사용자 아님
			// 로그인 페이지로 리다이렉트
			response.sendRedirect(request.getContextPath() + "/users/login");
		    return false; //요청을 뒤로 전달하지 않음
		}
		//로그인 사용자
		return true; //컨트롤러로 요청을 전달 
	}


}
