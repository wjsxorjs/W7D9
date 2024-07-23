package com.sist.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mybatis.service.DeptService;
import mybatis.vo.DeptVO;

@Controller
public class DeptController {
	@Autowired
	private DeptService mapper1; // 자료형을 MyMapper로 변경해도 된다.
	
	@RequestMapping("dept_list")
	public ModelAndView deptList() {
		ModelAndView mv = new ModelAndView();
		
		DeptVO[] d_ar = mapper1.getList();
		
		mv.addObject("d_ar",d_ar);
		mv.setViewName("dept_list");
		
		return mv;
	}
	
	@RequestMapping("dept_search")
	@ResponseBody
	public Map<String, Object> search(String searchType, String searchValue) {
		
		DeptVO[] d_ar = mapper1.search(searchType, searchValue);
		
		Map<String, Object> d_map = new HashMap<String, Object>();
		
		d_map.put("d_ar",d_ar);
		d_map.put("len",d_ar.length);
		
		return d_map;
	}
	
	
}
