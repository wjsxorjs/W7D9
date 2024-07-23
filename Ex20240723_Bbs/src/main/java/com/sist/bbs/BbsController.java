package com.sist.bbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybatis.service.BbsService;
import mybatis.vo.BbsVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BbsController {
	
	@Autowired
	private BbsService mapper1;
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		
		BbsVO[] b_ar = (BbsVO[]) mapper1.total();
		
		mv.addObject("b_ar",b_ar);
		mv.setViewName("bbs");
		
		return mv;
	}
	
	@RequestMapping("/bbs")
	public ModelAndView bbs() {
		ModelAndView mv = new ModelAndView();
		
		BbsVO[] b_ar = (BbsVO[]) mapper1.total();

		mv.addObject("b_ar",b_ar);
		mv.setViewName("bbs");
		
		return mv;
	}
	
}
