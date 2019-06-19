package com.lx.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.lx.model.choose;
import com.lx.model.course;
import com.lx.model.image;
import com.lx.model.media;
import com.lx.model.reply;
import com.lx.model.user;
import com.lx.model.words;
import com.lx.service.chooseServiceImpl;
import com.lx.service.courseServiceImpl;
import com.lx.service.mediaServiceImpl;
import com.lx.service.replyServiceImpl;
import com.lx.service.userServiceImpl;
import com.lx.service.wordsServiceImpl;

@Controller
public class mediaController {
	@Autowired
	private mediaServiceImpl ms;
	
	
	@Autowired
	private userServiceImpl us;
	
	@Autowired
	private wordsServiceImpl ws;
	
	@Autowired
	private chooseServiceImpl cs;
	
	@Autowired
	private courseServiceImpl ks;

	@Autowired
	private replyServiceImpl rs;
	
	@RequestMapping("/ToUploadFiles")
	@ResponseBody
	public Integer addUser(@RequestParam("files") MultipartFile[] files,HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession(false);
		String name="";
		int uno=0;
		if(session!=null){
			String str=session.getAttribute("name").toString();
			if(str!=null){
				name=str;
			}
		}
		System.out.println("进来了");
		String title=request.getParameter("title");
		String descript=request.getParameter("descript");
		String uptime=request.getParameter("uptime");
		String src[]=new String[files.length];
		System.out.println(files[0].getOriginalFilename());
		System.out.println(files[1].getOriginalFilename());
		if(files!=null&&files.length>0){
			for(int i=0;i<files.length;i++){
				MultipartFile file=files[i];
				try {
					request.setCharacterEncoding("utf-8");
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				response.setContentType("text/html;charset=utf-8");
				response.addHeader("Access-Control-Allow-Origin", "*");
				response.addHeader("Access-Control-Allow-Methods", "GET,POST");
				String originalFilename=null;
				try{
				if(file.isEmpty()){
					return 0;
					
				}else{
					originalFilename=file.getOriginalFilename();
					long size=file.getSize();
					String contentType=file.getContentType();
					System.out.println("原始文件全路径名："+originalFilename);
					System.out.println("文件大小："+size+"KB");
					System.out.println("文件类型："+contentType);
					System.out.println("=====================");
				}
				
				String root=request.getServletContext().getRealPath("/upload/media");
				String filename=file.getOriginalFilename();
				
				int index=filename.lastIndexOf("\\");
				if(index!=-1){
					filename=filename.substring(index+1);
					System.out.println(filename);
				}
				
				String savename= UUID.randomUUID() +"-"+filename;
				src[i]=savename;
				System.out.println(src[i]);
//				int hCode=filename.hashCode();
//				String hex=Integer.toHexString(hCode);
//				
//				File dirFile=new File(root,hex.charAt(0)+"/"+hex.charAt(1));
//				dirFile.mkdirs();
				
				File dirFile=new File(root);
				
				File destFile=new File(dirFile,savename);
				String courseFile=destFile.getCanonicalPath();
				
				file.transferTo(destFile);
				
				}catch(Exception e){
					e.printStackTrace();
					return 0;
				}
				
				
			}
			media media=new media(title,name,src[0],src[1],descript,uptime);
			ms.insertMedia(media);
		}
		return 1;
		
		
	}
	
	
	
	
	@RequestMapping("/playMedia")
	public ModelAndView showcourse(HttpServletRequest req) {
		ModelAndView mv = null;
		try {
			HttpSession session=req.getSession(false);
			media media=null;
			List<words> words_list=new ArrayList<words>();
			List<reply> reply_list=new ArrayList<reply>();
			String name="";
			if(session!=null){
				String str=session.getAttribute("uno").toString();
				if(str!=null){
					int uno=Integer.parseInt(str);
					
					user u=us.queryByUno(uno);
					
					String flag=u.getFlag();
					System.out.println(flag);
					if("2".equals(flag)){
						int cno=cs.queryByUno(uno).getCourse().getCno();
						name=ks.queryByNo(cno).getUser().getName();
						System.out.println(name);
					}else{
					
						name=us.queryByUno(uno).getName();
					}
					media=ms.selectByName(name);
					
					words_list=ws.selectByMedia(media.getId());
					
					reply_list=new ArrayList<reply>();
					for(words words: words_list){
						List<reply> reply_list_temp=rs.selectByWords(words.getId(), words.getMedia_id());
						reply_list.addAll(reply_list_temp);
					
					}
				}
			}
				
			mv = new ModelAndView("playMedia");
			mv.addObject("media", media);
			mv.addObject("words_list", words_list);
			mv.addObject("reply_list", reply_list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mv;
	}
	
	@RequestMapping("/saveWords")
	@ResponseBody
	public String saveWords(words words){
		System.out.println("进来了");
		System.out.println(words.getName()+" "+words.getContent()+" ");
		if(words!=null){
			ws.insertWords(words);
		}
		return "\""+"留言成功！"+"\"";
		
	}
	
	@RequestMapping("/saveReply")
	@ResponseBody
	public String saveReply(reply reply){
		System.out.println("进来了");
		System.out.println(reply.getName()+" "+reply.getContent()+" ");
		if(reply!=null){
			rs.insertReply(reply);
		}
		return "\""+"回复成功！"+"\"";
		
	}
	
}
