package com.lx.controller;




import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lx.model.choose;
import com.lx.model.course;
import com.lx.model.grade;
import com.lx.model.grade1;
import com.lx.model.image;
import com.lx.model.user;
import com.lx.service.chooseServiceImpl;
import com.lx.service.courseServiceImpl;
import com.lx.service.userServiceImpl;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@Scope("session")
public class chooseController {
	private List<grade1> Grade;
	
	@PostConstruct  
	   public void init(){  
	    Grade = new ArrayList<grade1>();  
	   }  
	
	@Autowired
	private chooseServiceImpl csi;
	@Autowired
	private courseServiceImpl cs;
	@Autowired
	private userServiceImpl us;
	@RequestMapping("/choose")
	public ModelAndView showcourse(HttpServletRequest req) {
		ModelAndView mv = null;
		try {
			HttpSession session=req.getSession(false);
			choose mychoose=null;
			user teacher=null;
			if(session!=null){
				String str=session.getAttribute("uno").toString();
				if(str!=null){
					int uno=Integer.parseInt(str);
					mychoose=csi.queryByUno(uno);
					course k=cs.queryByNo(mychoose.getCourse().getCno());
					teacher=us.queryByUno(k.getUser().getUno());
				}
			}
				
			mv = new ModelAndView("choose");
			mv.addObject("data", mychoose);
			mv.addObject("teacher", teacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
		
	}
	@RequestMapping("/grade1")
	public ModelAndView teacher_choose(HttpServletRequest req) throws Exception{
		ModelAndView mv = null;
		
			HttpSession session=req.getSession(false);
			ArrayList<choose> myteach=new ArrayList<choose> ();
			if(session!=null){
				String str=session.getAttribute("uno").toString();
				
				if(str!=null){
					int uno=Integer.parseUnsignedInt(str);

					course c=cs.queryByUno(uno);
					myteach=csi.queryByCno(c.getCno());

				}
			}
				
			mv = new ModelAndView("grade1");
			mv.addObject("data", myteach);
			
	
		return mv;
		
	}
	
	
//	@RequestMapping("/AddGrade")
//	@ResponseBody
//	public JSONArray toUpdateGrade(@RequestBody List<grade> students) {
//		int len=students.size();
//		for(int i=0;i<len;i++){
//			System.out.println(students.get(i).getNo()+" "+students.get(i).getGrade());
//			csi.updateChoose_teacher(students.get(i).getNo(),students.get(i).getGrade());
//		}
//		List<choose> grade=new ArrayList<choose>();
//		grade=csi.queryAll();
//		JSONArray array = new JSONArray();
//		if(grade!= null && grade.size()>0) {
//			for (choose dept : grade) {
//				JSONObject obj = new JSONObject();
//				obj.put("grade", dept.getGrade());
//				array.add(obj);
//			}
//		}
//		return array;//直接返回json数组对象
//	}
	
	
	@RequestMapping("/controller1")
	@ResponseBody
	public String toUpdateGrade(@RequestBody String data) {
		System.out.println(data);
		JSONArray jsonArr=JSONArray.fromObject(data);
		System.out.println(jsonArr);
		for(int i=0;i<jsonArr.size();i++){
			String temp=jsonArr.get(i).toString();
			int no=Integer.parseInt(temp);
			csi.deleteChooseNo(no);
		}
		return "\""+"操作成功"+"\"";//直接返回json数组对象
	}

	@RequestMapping("/grade2")
	public ModelAndView grade1(HttpServletRequest req) throws Exception{
		ModelAndView mv = null;
		
			HttpSession session=req.getSession(false);
			ArrayList<choose> myteach=new ArrayList<choose> ();
			if(session!=null){
				String str=session.getAttribute("uno").toString();
				
				if(str!=null){
					int uno=Integer.parseUnsignedInt(str);

					course c=cs.queryByUno(uno);
					myteach=csi.queryByCno(c.getCno());

				}
			}
				
			mv = new ModelAndView("grade2");
			mv.addObject("data", myteach);
			
	
		return mv;
		
	}
	
	@RequestMapping("/Controller2")
	@ResponseBody
	public  String gradeOne(@RequestBody List<grade1> gradeAll) {
		int len=gradeAll.size();
		int result[]=new int[len];
		for(int i=0;i<len;i++){
			result[i]=gradeAll.get(i).getGrade1()+gradeAll.get(i).getGrade2()+gradeAll.get(i).getGrade3();
			grade1 g=new grade1(gradeAll.get(i).getGrade1(),gradeAll.get(i).getGrade2(),gradeAll.get(i).getGrade3());
			Grade.add(g);
		}
//		JSONObject obj=new JSONObject();
//		obj.put("result", result);
		//直接返回json数组对象
		return "\""+"操作成功"+"\"";
	}
	
	
	@RequestMapping("/grade3")
	public ModelAndView Controller3(HttpServletRequest req) {
			ModelAndView mv = null;
			
				HttpSession session=req.getSession(false);
				ArrayList<choose> myteach=new ArrayList<choose> ();
				ArrayList<choose> myteach1=new ArrayList<choose> ();
				if(session!=null){
					String str=session.getAttribute("uno").toString();
					
					if(str!=null){
						int uno=Integer.parseUnsignedInt(str);

						course c=cs.queryByUno(uno);
						myteach=csi.queryByCno(c.getCno());
						for(int i=0;i<myteach.size();i++){
							int temp= Grade.get(i).getGrade1()+Grade.get(i).getGrade2()+Grade.get(i).getGrade3();
							csi.updateChoose_teacher(myteach.get(i).getNo(), temp);
						}
						myteach1=csi.queryByCno(c.getCno());

					}
				}
					
				mv = new ModelAndView("grade3");
				mv.addObject("data", myteach1);
				mv.addObject("grade", Grade);
			return mv;
			
		}
	
	@RequestMapping("/grade4")
	public ModelAndView Controller4(HttpServletRequest req) {
			ModelAndView mv = null;
			
				HttpSession session=req.getSession(false);
				ArrayList<choose> myteach=new ArrayList<choose> ();
				if(session!=null){
					String str=session.getAttribute("uno").toString();
					
					if(str!=null){
						int uno=Integer.parseUnsignedInt(str);

						course c=cs.queryByUno(uno);
						myteach=csi.queryByGrade(c.getCno());

					}
				}
					
				mv = new ModelAndView("grade4");
				mv.addObject("data", myteach);
			return mv;
			
		}
	
		
//	
//	@RequestMapping("/choose")
//	public ModelAndView showAllcourse() {
//		ModelAndView mv = null;
//		try {
//			ArrayList<choose> choose=csi.queryAll();
//			ArrayList<user> teacher=new ArrayList<user> ();
//			for(choose c:choose){
//				course k=cs.queryByNo(c.getCourse().getCno());
//				user u=us.queryByUno(k.getUser().getUno());
//				teacher.add(u);
//				System.out.println(u.getName());
//			}
//			mv = new ModelAndView("choose");
//			mv.addObject("data", choose);
//			mv.addObject("teacher", teacher);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return mv;
//		
//	}
	
	
}
