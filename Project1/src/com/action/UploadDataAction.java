package com.action;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.service.UploadService;

public class UploadDataAction extends ActionSupport {

	
	
	@Override
	public String execute() throws Exception {
	
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		String drip = request.getParameter("drip");
		String time = request.getParameter("time");
		String rssi = request.getParameter("rssi");
		String ip = request.getParameter("ip");
		//TODO 有問題
		UploadService service = new UploadService();
		boolean status = service.checkIbeaconStatus(id,"WORKING");
		System.out.println("boolean ="+status);
		if(status==true){
			service.insertIbeaconLog(id,drip,time,rssi,ip);
		}
				
		System.out.println("status = "+status);
		System.out.println("id = "+id);
		System.out.println("time = "+time);
		System.out.println("drip = "+drip);
		System.out.println("rssi = "+rssi);
		System.out.println("ip = "+ip);
		
		request.setAttribute("status", status);
		request.setAttribute("id", id);
		request.setAttribute("time", time);
		request.setAttribute("drip", drip);
		request.setAttribute("rssi", rssi);
		request.setAttribute("ip", ip);
		
		
		return "success";
	}

	
	public String uploadConfirm() throws SQLException{
		//手機確認配對
		//TODO 取得手機送來的patient id and ibeacon 號碼?
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String ibeaconId = request.getParameter("ibeaconId");
		
		UploadService service = new UploadService();
		boolean status = service.checkIbeaconStatus(ibeaconId,"READY");
		System.out.println("boolean = "+status);
		if(status==true){
			service.updateIbeaconStatus(ibeaconId,"READY","WORKING");
		}
		
		
		return "confirmSuccess";
	}
	
	
}
