package com.sist.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mybatis.service.EmpService;
import mybatis.vo.EmpVO;

@Controller
public class EmpController {
	@Autowired
	private EmpService mapper1; // 자료형을 MyMapper로 변경해도 된다.
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		
		EmpVO[] e_ar = mapper1.getList();
		
		mv.addObject("e_ar",e_ar);
		mv.setViewName("emp_list");
		
		return mv;
	}

	@RequestMapping("emp_list")
	public ModelAndView empList() {
		ModelAndView mv = new ModelAndView();
		
		EmpVO[] e_ar = mapper1.getList();
		
		mv.addObject("e_ar",e_ar);
		mv.setViewName("emp_list");
		
		return mv;
	}
	
	@RequestMapping("search")
	@ResponseBody
	public Map<String, Object> search(String searchType, String searchValue) {
		
		EmpVO[] e_ar = mapper1.search(searchType, searchValue);
		
		Map<String, Object> e_map = new HashMap<String, Object>();
		
		e_map.put("e_ar",e_ar);
		e_map.put("len",e_ar.length);
		
		return e_map;
	}
	
	
}
