package com.service;

import java.math.BigDecimal;
import java.sql.SQLException;

import com.dao.impl.IbeaconDaoImpl;

public class UploadService {

	public boolean checkIbeaconStatus(String ibeaconId,String status) throws SQLException{
		
		IbeaconDaoImpl dao = new IbeaconDaoImpl();
		String temp = dao.checkIbeaconStatus(ibeaconId);
		System.out.println("status = "+status);
		System.out.println("temp = "+temp);
		if(temp.equals(status)){
			System.out.println("checkIbeaconStatus = true");
			return true;
		}
		
		return false;
	}
	
	
	public void insertIbeaconLog(String ibeaconId, String drip, String time, String rssi, String ip) throws SQLException{
		BigDecimal newDrip = new BigDecimal(drip);
		int timeClock = Integer.parseInt(time);
		BigDecimal newRssi = new BigDecimal(rssi);
		
		IbeaconDaoImpl dao = new IbeaconDaoImpl();
		//TODO 取得DB內上次的紀錄，用來計算流速
		dao.insertIbeaconLog(ibeaconId,newDrip,timeClock,newRssi,ip);
		
		
		
	}


	public void updateIbeaconStatus(String ibeaconId, String oldStatus,String newStatus) throws SQLException {
		IbeaconDaoImpl dao = new IbeaconDaoImpl();
		boolean result = dao.updateIbeaconStatus(ibeaconId,oldStatus,newStatus);
		
		
	}
	
	
}
