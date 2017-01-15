package com.action;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.model.MonitorModel;
import com.opensymphony.xwork2.ActionSupport;
import com.service.MonitorService;
import com.uilts.Log;

public class MonitorAction extends ActionSupport {

	private Map map = new HashMap();
	List<MonitorModel> list = new ArrayList<MonitorModel>();
	String nowTime = "";
	
	
	@Override
	public String execute() throws SQLException{
		Log.info(getClass(), "json!!!!!!!!!!!"+new Date().toString());
//		Map<String,MonitorModel> model = new HashMap<String,MonitorModel>();
//		MonitorModel a = new MonitorModel();
//		MonitorModel b = new MonitorModel();
//		a.setIbeaconId("i1");
//		b.setIbeaconId("i2");
//		a.setPatientId("p1");
//		a.setPatientId("p2");
//		map.put("1",a );
//		map.put("2",b );
		
//		Map<String,String> map = new HashMap<String,String>();
//		map.put("1", "a");
//		map.put("2", "b");
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		nowTime = sdf.format(d);
		
		
		MonitorService service = new MonitorService();
		list.addAll(service.listAll() );
		

		
//		MonitorModel a = new MonitorModel();
//		a.setIbeaconId("ibeacon 1");
//		a.setBedId("bed 1");
//		a.setEstEndTime("2020-01-01");
//		a.setEstSpeed("10");
//		a.setPatientId("P1");
//		a.setPatientName("PNaMe1");
//		a.setRealEndTime("2019-01-01");
//		a.setRealSpeed("5");
//		a.setRemain("50");
//		a.setTotal("100");
//		
//		MonitorModel b = new MonitorModel();
//		b.setIbeaconId("ibeacon 2");
//		b.setBedId("bed 2");
//		b.setEstEndTime("2020-01-01");
//		b.setEstSpeed("15");
//		b.setPatientId("P2");
//		b.setPatientName("PNaMe2");
//		b.setRealEndTime("2018-01-01");
//		b.setRealSpeed("3");
//		b.setRemain("25");
//		b.setTotal("75");
//		
//		list.add(a);
//		list.add(b);
		
		return SUCCESS;
	}


	public Map getMap() {
		return map;
	}


	public void setMap(Map map) {
		this.map = map;
	}


	public List<MonitorModel> getList() {
		return list;
	}


	public void setList(List<MonitorModel> list) {
		this.list = list;
	}


	public String getNowTime() {
		return nowTime;
	}


	public void setNowTime(String nowTime) {
		this.nowTime = nowTime;
	}
	
	
	
	
}
