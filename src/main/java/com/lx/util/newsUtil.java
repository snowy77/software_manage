package com.lx.util;

import java.sql.Date;
import java.text.SimpleDateFormat;


public class newsUtil {
	public Date strToDate(String strDate) { 
		 String str = strDate; 
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		 java.util.Date d = null; 
		 try { 
		  d = format.parse(str); 
		 } catch (Exception e) { 
		  e.printStackTrace(); 
		 } 
		 java.sql.Date date = new java.sql.Date(d.getTime()); 
		 return date; 
		}
	public String DateTostr(Date date){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String str=format.format(date);
		return str;
	}
	

}
