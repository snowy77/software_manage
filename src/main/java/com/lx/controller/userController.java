package com.lx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lx.model.user;
import com.lx.service.courseServiceImpl;
import com.lx.service.userServiceImpl;
import com.mysql.fabric.Response;

import net.sf.json.JSONObject;


@Controller
public class userController {
	@Autowired
	private userServiceImpl ss;
	
	@Autowired
	private courseServiceImpl cs;
	
	@RequestMapping("/record")
	@ResponseBody
	public String login( String name, String no,String password,HttpServletRequest req)
	        throws Exception {
		int r=ss.login(name, no,password);
		Map<String,String> data=new HashMap<String,String>();
		
		if(r==0){
	     data.put("result", "用户不存在");
		}else if(r==1){
			 user u=ss.queryByid(no, name);
			 HttpSession session=req.getSession();
			 session.setAttribute("uno",u.getUno() );
			 session.setAttribute("name", u.getName());
			
			 data.put("name", u.getName());
			 data.put("type", u.getFlag());
			 data.put("result", "登录成功");
		}else{
			data.put("result", "密码错误");
		}
		JSONObject json=JSONObject.fromObject(data);
		System.out.println(json);
		return json.toString();
		
	}
	
	
	@RequestMapping("/register")
	@ResponseBody
	public String login(user u)throws Exception{
		System.out.println(u.getEmail());
		System.out.println(u.getFlag());
		String result;
		if(ss.addUser(u)==1){
			result="注册成功";
			if("1".equals(u.getFlag())){
				System.out.println(u.getFlag());
				user temp=ss.queryByid(u.getNo(), u.getName());
				cs.insertCourse(temp);
				
			}
		}else{
			result="注册失败";
		}
		return "\""+result+"\"";
	}
	
}
