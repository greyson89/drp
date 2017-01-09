package com.service;

import java.sql.SQLException;

import com.dao.impl.IbeaconDaoImpl;
import com.dao.impl.PatientDaoImpl;
import com.model.Ibeacon;

public class IbeaconSerivce {
	
	public Ibeacon loadHistory(String patientId,int runId){
		
		PatientDaoImpl dao = new PatientDaoImpl();
		

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
			String ibeaconStatus = dao.checkIbeaconStatus(i);
			if(ibeaconStatus.equals("PENDING")){
				return true;
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public String updateIbeaconStatus(String ibeaconId,String oldStatus,String newStatus) {
		IbeaconDaoImpl dao = new IbeaconDaoImpl();
		try {
			boolean result = dao.updateIbeaconStatus(ibeaconId,oldStatus,newStatus);
			if(result){
				return "更新成功";
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "ERROR ibeacon狀態出現問題";
	}
	
}
