package com.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadDataAction extends ActionSupport {

	
	
	@Override
	public String execute() throws Exception {
	
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		String time = request.getParameter("time");
		String drip = request.getParameter("drip");
		String rssi = request.getParameter("rssi");
		String ip = request.getParameter("ip");
		Map<String, String[]> m = request.getParameterMap();
		for(String s :m.keySet()){
			System.out.println("get all parameter name =>"+s);
		}
		
		
		
		
		System.out.println("upload test");
		System.out.println("id = "+id);
		System.out.println("time = "+time);
		System.out.println("drip = "+drip);
		System.out.println("rssi = "+rssi);
		System.out.println("ip = "+ip);
		
		request.setAttribute("id", id);
		request.setAttribute("time", time);
		request.setAttribute("drip", drip);
		request.setAttribute("rssi", rssi);
		request.setAttribute("ip", ip);
		
		
		return "success";
	}

	
	
	
	
}
