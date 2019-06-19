package com.lx.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.lx.model.image;
import com.lx.service.imageServiceImpl;

@Controller
public class imageController {
	@Autowired
	private imageServiceImpl ss;
	@RequestMapping("/m_addImage")
	public String index(ModelMap map) {
		List<image> img = ss.selectAll();
		map.addAttribute("userList",img);
		return "m_addImage";
	}
	
	@RequestMapping("/addUser")
	public String addUser(image img,MultipartFile file,HttpServletRequest request) throws IOException {
		System.out.println("提交的用户："+img);
		String filePath = request.getSession().getServletContext().getRealPath("/upload");; //定义图片上传后的路径
		String newFileName = fileOperate(file,filePath);
		
		
		String name=request.getParameter("name");
		img =new image(name,newFileName);
		System.out.println("最后的user:"+img);
		ss.insertImage(img);
		System.out.println("操作成功！");
		return "redirect:/m_addImage";
	}
	
	
	/**
	 * 跳转到修改用户信息页面
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("/toUpdateUser")
	public String toUpdateUserPage(Integer id,ModelMap map) {
		System.out.println("id:"+id);
		image img = ss.selectById(id);
		System.out.println("修改后获取的user："+img);
		map.addAttribute("user",img);
		return "updateUser";
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(image img,MultipartFile file,HttpServletRequest request) throws Exception{
		System.out.println("修改提交的用户："+img);
		String filePath = request.getSession().getServletContext().getRealPath("/upload");; //定义图片上传后的路径
		String newFileName = fileOperate(file,filePath);
		img.setImg(newFileName);
		System.out.println("修改最后的user:"+img);
		ss.updateImage(img);
		return "redirect:/m_addImage";
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(Integer id) {
		ss.deleteImage(id);
		return "redirect:/m_addImage";
	}
	
	/**
	 * 封装操作文件方法， 添加用户 和修改用户都会用到
	 * @param file
	 * @param filePath
	 * @return
	 */
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
