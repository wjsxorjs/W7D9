package com.sist.bbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybatis.service.MemoService;
import mybatis.vo.MemoVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemoController {
	
	@Autowired
	private MemoService mapper1;
	
	@RequestMapping("/memo")
	public ModelAndView bbs() {
		ModelAndView mv = new ModelAndView();
		
		MemoVO[] m_ar = (MemoVO[]) mapper1.total();

		mv.addObject("m_ar",m_ar);
		mv.setViewName("memo");
		
		return mv;
	}
	
}
