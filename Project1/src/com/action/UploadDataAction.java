package com.action;

import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.service.UploadService;
import com.uilts.Log;

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
		Log.info(getClass().getSimpleName(),id +" 是否已是WORKING = "+status);
		if(status==true){
			service.insertIbeaconLog(id,drip,time,rssi,ip);
		}
				
		Log.info(getClass().getSimpleName(),"status = "+status );
		Log.info(getClass().getSimpleName(),"id = "+id );
		Log.info(getClass().getSimpleName(),"time = "+time );
		Log.info(getClass().getSimpleName(),"drip = "+drip );
		Log.info(getClass().getSimpleName(),"rssi = "+rssi );
		Log.info(getClass().getSimpleName(),"ip = "+ip );
		
		
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
		Log.info(getClass().getSimpleName(), ibeaconId+ " 是否已在READY狀態 = "+status);
		if(status==true){
			service.updateIbeaconStatus(ibeaconId,"READY","WORKING");
			service.updatePatientSubStatus(ibeaconId, "READY", "WORKING");
		}
		
		return "confirmSuccess";
	}
	
	public String uploadTestPage(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String,String[]> param = request.getParameterMap();
		for(String key : param.keySet()){
			for(String val : param.get(key)){
				Log.info(getClass(), key+" "+val);
				Log.info(getClass(), key+" "+val);
			}
		}
		
		Log.info(getClass(), "android connect success "+(new Date()).toString());
		return "success";
	}
	
}
