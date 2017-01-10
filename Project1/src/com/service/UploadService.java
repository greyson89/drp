package com.service;

import java.math.BigDecimal;
import java.sql.SQLException;

import com.dao.impl.IbeaconDaoImpl;
import com.dao.impl.PatientDaoImpl;
import com.model.IbeaconLog;
import com.uilts.Log;

public class UploadService {

	public boolean checkIbeaconStatus(String ibeaconId,String status) throws SQLException{
		
		IbeaconDaoImpl dao = new IbeaconDaoImpl();
		String temp = dao.checkIbeaconStatus(ibeaconId);
		Log.info(getClass(), "status = "+status +"equal test   temp = "+temp );
		System.out.println("temp = "+temp);
		if(temp.equals(status)){
			return true;
		}
		
		return false;
	}
	
	
	public void insertIbeaconLog(String ibeaconId, String tDrip, String time, String tRssi, String ip) throws SQLException{
		BigDecimal drip = new BigDecimal(tDrip);
		int timeClock = Integer.parseInt(time);
		BigDecimal rssi = new BigDecimal(tRssi);
		
		IbeaconDaoImpl dao = new IbeaconDaoImpl();

		//TODO 取得DB內上次的紀錄，用來計算流速
		IbeaconLog preData = dao.loadPreIbeaconLog(ibeaconId,drip,timeClock,0);
		BigDecimal preDrip ;
		int preTimeClock ;
		//TODO 01/10檢查重複資料
		
		
		if(preData==null){
			Log.info(getClass(), "無前次 ibeacon log 資料");
			preDrip = BigDecimal.ZERO;
			preTimeClock = 0;
		}else{
			Log.info(getClass(), "有前次 ibeacon log 資料");
			preDrip =  preData.getDrip() ;
			preTimeClock = preData.getTimeClock();
		}
		
		BigDecimal speed = drip.subtract(preDrip).divide(new BigDecimal( new Integer(timeClock-preTimeClock).toString() ) );
		dao.insertIbeaconLog(ibeaconId,drip,timeClock,speed,rssi,ip);
		
		
		
	}


	public void updateIbeaconStatus(String ibeaconId, String oldStatus,String newStatus) throws SQLException {
		IbeaconDaoImpl dao = new IbeaconDaoImpl();
		boolean result = dao.updateIbeaconStatus(ibeaconId,oldStatus,newStatus);
		
		
	}

	public void updatePatientSubStatus(String ibeaconId, String oldStatus,String newStatus) throws SQLException {
		PatientDaoImpl dao = new PatientDaoImpl();
		boolean result = dao.updatePatientSubStatus(ibeaconId,oldStatus,newStatus);
		
		
	}
	
	
}
