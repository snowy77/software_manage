package com.lx.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lx.model.image;
import com.lx.model.news;
import com.lx.service.imageServiceImpl;
import com.lx.service.newsServiceImpl;
import com.lx.util.newsUtil;

@Controller
public class newsController {
	
	@Autowired
	private newsServiceImpl ss;
	private newsUtil nu;
	
	//进入新闻网站首页
//		@RequestMapping("/index")
//		public ModelAndView getModelAndView() {
//			ModelAndView mv = null;
//
//			try {
//				mv = new ModelAndView("index");
//				ArrayList<news> news = ss.getAllNews();
//				
//				mv.addObject("data1",news);
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			return mv;
//			
//		}
		@RequestMapping("/index")
		public ModelAndView showNews() {
			ModelAndView mv = null;
			
			try {
				mv = new ModelAndView("index");
				ArrayList<news> data1 = ss.getByType("课程介绍");
				ArrayList<news> data2 = ss.getByType("课程内容");
				ArrayList<news> data3 = ss.getByType("课程实践");
				ArrayList<news> data4 = ss.getByType("教学团队");
			
				
				
				mv.addObject("data1",data1);
				mv.addObject("data2",data2);
				mv.addObject("data3",data3);
				mv.addObject("data4",data4);
				
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return mv;
			
		}
		
		
		
		
		@RequestMapping("/news1")
		public ModelAndView showNews1() {
			ModelAndView mv = null;
			
			try {
				mv = new ModelAndView("showNews");
				ArrayList<news> data = ss.getByType("课程介绍");

				mv.addObject("data",data);	
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return mv;
			
		}
		
		
		
		@RequestMapping("/news2")
		public ModelAndView showNews2() {
			ModelAndView mv = null;
			
			try {
				mv = new ModelAndView("showNews");
				
				ArrayList<news> data = ss.getByType("课程内容");

				mv.addObject("data",data);
	
			} catch (Exception e) {
				e.printStackTrace();
			}
			return mv;
			
		}
		
		
		
		
		@RequestMapping("/news3")
		public ModelAndView showNews3() {
			ModelAndView mv = null;
			
			try {
				mv = new ModelAndView("showNews");
				
				ArrayList<news> data = ss.getByType("课程实践");

				mv.addObject("data",data);
	
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return mv;
			
		}
		
		
		
		@RequestMapping("/news4")
		public ModelAndView showNews4() {
			ModelAndView mv = null;
			
			try {
				mv = new ModelAndView("showNews");
				
				ArrayList<news> data = ss.getByType("教学团队");
		
				mv.addObject("data",data);
	
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return mv;
			
		}
		
//		//进入管理员登录界面
//		@RequestMapping("/login")
//		public String addNews(String news_user,String news_password) {
//			if("sqroot".equals(news_user)&&"dyr2015".equals(news_password)) {
//				isLogined = true;
//				return "addNews";
//			}
//			else {
//				return "login";
//			}
//		}
//		
//		//进入发布新闻界面
//		@RequestMapping(value="/add")
//		public String returAaddNews() {
//			if(isLogined) {
//				return "addNews";
//			}
//			else {
//				return "login";
//			}
//		}
//		
//		//进入更新新闻界面
//		@RequestMapping("/update")
//		public String updateNews() {
//			if(isLogined) {
//				return "updateNews";
//			}
//			else {
//				return "login";
//			}
//		}
//		
//		//进入删除新闻界面
//		@RequestMapping("/delete")
//		public String deleteNews() {
//			if(isLogined) {
//				return "deleteNews";
//			}
//			else {
//				return "login";
//			}
//		}
//		
//		//点击退出登录按钮后，将登录状态置为假
//		@RequestMapping("/exit")
//		public String exitLogin() {
//			isLogined = false;
//			return "login";
//		}
//		
		//向数据库添加记录
		@RequestMapping("/addNews")
		public String addData(news ni,MultipartFile file,HttpServletRequest request) {
			String filePath = request.getSession().getServletContext().getRealPath("/upload");; //定义图片上传后的路径
			String newFileName = fileOperate(file,filePath);
			String head=request.getParameter("head");
			String summary=request.getParameter("summary");
			String body=request.getParameter("body");
			newsUtil nu=new newsUtil();
			Date date=nu.strToDate(request.getParameter("date"));
			String type=request.getParameter("type");
			ni=new news(head,summary,body,date,newFileName,type);
			ni.setImg(newFileName);
			ss.addNews(ni);
			System.out.println("操作成功");
			return "redirect:/addNews.jsp";
			
		}
//		
		//根据新闻id删除数据库中的某个记录
		@RequestMapping("/deleteNews")
		public String deleteData(int id) {
			ss.deleteNews(id);
			System.out.println("操作成功");
			return "redirect:/deleteNews.jsp";
			
		}
//		
		//根据新闻id更新数据库中的记录
		@RequestMapping("/updateNews")
		public String updateData(news ni,MultipartFile file,HttpServletRequest request) {
			String filePath = request.getSession().getServletContext().getRealPath("/upload");; //定义图片上传后的路径
			String newFileName = fileOperate(file,filePath);
			ni.setImg(newFileName);
			int id=Integer.valueOf(request.getParameter("id"));
			ni.setId(id);
			ss.updateNews(ni);
			System.out.println(filePath);
			System.out.println("操作成功");
			return "redirect:/updateNews.jsp";
			
		}
//		
		//点击某个新闻的链接后根据id获得该条新闻的内容等
		@RequestMapping("/read")
		public ModelAndView getContent(int id) {
			ModelAndView mv = null;

			try {
				mv = new ModelAndView("concent");
				news news = ss.getContent(id);
				
				mv.addObject("data",news);
				System.out.println(news.getImg());
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return mv;
		}
		
		
		
		private String fileOperate(MultipartFile file,String filePath) {
			String originalFileName = file.getOriginalFilename();//获取原始图片的扩展名
			System.out.println("图片原始名称："+originalFileName);
			String newFileName = UUID.randomUUID()+originalFileName;  //新的文件名称
			System.out.println("新的文件名称："+newFileName);
			File targetFile = new File(filePath,newFileName); //创建新文件
			try {
				file.transferTo(targetFile); //把本地文件上传到文件位置 , transferTo()是springmvc封装的方法，用于图片上传时，把内存中图片写入磁盘
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}   
			return newFileName;
		}
}
