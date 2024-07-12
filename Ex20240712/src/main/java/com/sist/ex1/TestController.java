package com.sist.ex1;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mybatis.dao.EmpDAO;
import mybatis.dao.MemDAO;
import mybatis.vo.EmpVO;
import mybatis.vo.MemVO;

@Controller
public class TestController {
	
	// DAO들은 tomcat이 구동될 때 미리 생성되므로 현재 객체가
	// 만들어질때는 이미 생성되어있기 때문에 여기서 Autowired로 자동주입이 된다.
	@Autowired
	private MemDAO m_dao;
	@Autowired
	private EmpDAO e_dao;

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
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView test3(String id, String pw) {
		// 사용자가 jsp에서 입력한 아이디와 비밀번호를 인자로 받는다.
		// DAO를 활용하여 DB로부터 검증하자!
		MemVO mvo = m_dao.login(id, pw);
		
		ModelAndView mv = new ModelAndView();
		if(mvo != null) {
			mv.addObject("mvo", mvo);
		}
		
		mv.setViewName("login_result");
		
		return mv;
	}
	
	@RequestMapping("/emp")
	public ModelAndView emp() {
		// 사용자가 jsp에서 입력한 아이디와 비밀번호를 인자로 받는다.
		// DAO를 활용하여 DB로부터 검증하자!
		List<EmpVO> e_list = e_dao.getAll();
		
		ModelAndView mv = new ModelAndView();
		if(e_list != null) {
			mv.addObject("e_list", e_list);
		}
		
		mv.setViewName("emp");
		
		return mv;
	}
	
	@RequestMapping(value = "/emp", method = RequestMethod.POST)
	public ModelAndView emp(String empno) {
		// 사용자가 jsp에서 입력한 아이디와 비밀번호를 인자로 받는다.
		// DAO를 활용하여 DB로부터 검증하자!
		List<EmpVO> e_list = e_dao.searchEmp(empno);
		
		if(e_list.size()==0) {
			e_list = null;
		}
		
		ModelAndView mv = new ModelAndView();
		if(e_list != null) {
			mv.addObject("e_list", e_list);
		}
		
		mv.setViewName("emp");
		
		return mv;
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
	 	
	 	위의 라이브러리들을 모두 pom.xml에 명시한 후 root-context.xml에
	 	빈들을 추가해야 한다. (root-context.xml 문서 참조)
	 */
	
}
