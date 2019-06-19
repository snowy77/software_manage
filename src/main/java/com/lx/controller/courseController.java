package com.lx.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lx.model.course;
import com.lx.service.chooseServiceImpl;
import com.lx.service.courseServiceImpl;

@Controller
public class courseController {
	@Autowired
	private courseServiceImpl cs;
	@Autowired
	private chooseServiceImpl choose;
	
	@RequestMapping("/course")
	public ModelAndView showcourse() {
		ModelAndView mv = null;
		
		try {
			mv = new ModelAndView("course");
			ArrayList<course> course=cs.queryAll();
			
			mv.addObject("data", course);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
		
	}
	
	@RequestMapping("/choose0")
	public String selectCourse(int cno,ModelMap map,HttpServletRequest req){
		HttpSession session=req.getSession(false);
		if(session!=null){
			String str=session.getAttribute("uno").toString();
			if(str!=null){
				int uno=Integer.parseInt(str);
				choose.addChoose(cno, uno);
			}
		}
		return "redirect:/choose";
	}
	
}

