package com.action;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.uilts.Log;

public class MainAction extends ActionSupport {

	private String actionType;

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}



	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		if(actionType.equals("main")){
			return "main";
		}else if(actionType.equals("monitor")){
			return "monitor";
		}else if(actionType.equals("patient")){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("pageType", "新增");
			return "patient";
		}else if(actionType.equals("ibeacon")){
			return "ibeacon";
		}else if(actionType.equals("upload")){
			return "upload";
		}else{
			return "main";
		}
		
	}
	
	
	
	
}
