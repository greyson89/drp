package com.service;

import java.sql.SQLException;

import com.dao.impl.IbeaconDaoImpl;
import com.model.Ibeacon;

public class IbeaconSerivce {
	
	public Ibeacon loadHistory(String patientId,int runId){
		
		IbeaconDaoImpl dao = new IbeaconDaoImpl();

		try {
			return dao.loadHistory(patientId,runId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public boolean checkIbeaconStatus(String i) {
		IbeaconDaoImpl dao = new IbeaconDaoImpl();
		try {
			int ibeaconStatus = dao.checkIbeaconStatus(i);
			if(ibeaconStatus==0){
				return true;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public String updateIbeaconStatus(String ibeaconId) {
		IbeaconDaoImpl dao = new IbeaconDaoImpl();
		try {
			boolean result = dao.updateIbeaconStatus(ibeaconId);
			if(result){
				return "更新成功";
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "ERROR ibeacon狀態出現問題";
	}
	
}
