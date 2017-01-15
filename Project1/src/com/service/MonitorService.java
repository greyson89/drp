package com.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.dao.impl.MonitorDaoImpl;
import com.model.MonitorModel;
import com.uilts.Log;

public class MonitorService {
	
	private Date calNeedTime(BigDecimal drip,BigDecimal speed,Date startTime){
//		以一分鐘幾CC計算		總量(cc)除以速度(cc/min) = 所需時間(min)		
		long startTimeL = startTime.getTime();
		long timeSpend = drip.divide(speed).multiply(new BigDecimal("60")).multiply(new BigDecimal("1000")).longValue();
		Date result = new Date(startTimeL+timeSpend); 
		
		return result;
	}
	
	private String formatTime2Show(Date date){
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd hh:mm:ss");
		return sdf.format(date);
	}
private String formatTimeDifference(Date date,Date date2){
		StringBuffer result = new StringBuffer();
		//後大 前小
		long differenceAll ;
		
		if(date2.getTime()>=date.getTime()){
			differenceAll = (date2.getTime()-date.getTime())/1000;
		}else{
			differenceAll = (date.getTime()-date2.getTime())/1000;
			result.append("快了 ");
		}
			long day = differenceAll/86400;
			long difference2 = differenceAll%86400;
			long hour = difference2/3600;
			long difference3 = difference2%3600;
			long min = difference3/60;
			long sec = difference3%60;
			
			if(day>0){
				result.append(day+"天 ");
			}
			if(hour>0){
				result.append(hour+"小時 ");
			}
			if(min>0){
				result.append(min+"分 ");
			}
			if(sec>0){
				result.append(sec+"秒");
			}
		
		return result.toString();
	}
	
	public List<MonitorModel> listAll() throws SQLException{
		
		MonitorDaoImpl dao = new MonitorDaoImpl();
		List<MonitorModel>  modelList = dao.listAll();
		
		for(MonitorModel model :modelList){
			

			BigDecimal total = new BigDecimal(model.getTotal());
			BigDecimal estSpeed = new BigDecimal(model.getEstSpeed() );
			
			Date result = calNeedTime(total, estSpeed, model.getStartTime());
			model.setEstEndTime( formatTime2Show(result) );

			BigDecimal remain = total.subtract(model.getDrip());
			BigDecimal realSpeed =  new BigDecimal( model.getRealSpeed() );
			
			Date result2 = calNeedTime(remain, realSpeed, new Date());
			model.setRealEndTime( formatTime2Show(result2) );
			model.setRemain("<font color='red'>"+remain.setScale(2, BigDecimal.ROUND_HALF_UP).toString()+"</font>");
			
			
			model.setDifference( formatTimeDifference(result,result2) );
			
			
		}
		
//		Log.info(getClass(), "list size="+modelList.size());
		
		return modelList;
		
		
		
	}
	
}
