package com.sist.ex1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@RequestMapping("/t1")
	public ModelAndView test1(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		// 뷰 페이지에서 표현할 자원들을 mv에 저장하자.
		mv.addObject("str", "Spring MVC 테스트");
		mv.setViewName("test1");
		// WEB-INF/views/test1.jsp를 의미함
		
		
		return mv;
	}

	@RequestMapping("/login")
	public String test2() {
		return "test2";
	}
	
	/*
	 	스프링환경에서 MyBatis연결법
	 	필요한 라이브러리 목록 (MVN Repository)
	 	- spring jdbc
	 	- spring tx
	 	- commons dbcp
	 	- commons pool
	 	- commons logging
	 	- mybatis
	 	- mybatis spring
	 */
	
}
