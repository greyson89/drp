package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.impl.IbeaconDaoImpl;
import com.dao.impl.PatientDaoImpl;
import com.model.PatientSub;
import com.uilts.Log;

public class IbeaconSerivce {
	
	public List<PatientSub> loadHistory(String patientId){
		
		PatientDaoImpl dao = new PatientDaoImpl();
		

		try {
			List<PatientSub> modelList = dao.loadHistory(patientId);
			for(PatientSub model : modelList){
				String[] drugIdArray = model.getDrugId().split(",");
				String[] drugCcArray = model.getDrugCc().split(",");
				for(int i=0;i<model.getDrugQuantity();i++){
					model.getDrugIdList().add(drugIdArray[i]);
					model.getDrugCcList().add(drugCcArray[i]);
				}
			}
			
			return modelList;
			
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
