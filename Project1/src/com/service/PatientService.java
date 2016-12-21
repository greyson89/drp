package com.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.dao.impl.PatientDaoImpl;
import com.model.Patient;

public class PatientService {

	public Patient searchPatient( String patientId,String patientName,String iDCardNumber,String phoneNumber){
		
		if(patientId.equals("") && patientName.equals("") && iDCardNumber.equals("") && phoneNumber.equals("")){
			return null;
		}
		
		PatientDaoImpl pDao = new PatientDaoImpl();
		Patient model = null;
		try {
			model = pDao.searchPatient(patientId,patientName,iDCardNumber,phoneNumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return model;
	}
	
	public String addPatient( String patientId,String patientName,String iDCardNumber,String phoneNumber ){
		if(patientId.equals("") && patientName.equals("") && iDCardNumber.equals("") && phoneNumber.equals("")){
			return "ERROR 病患資料不全";
		}
		
		PatientDaoImpl pDao = new PatientDaoImpl();
		Patient model = null;
		Patient model2 = null;
		try {
			
			model = pDao.searchPatient(patientId,"","","");
			model2 = pDao.searchPatient("","",iDCardNumber,"");
			//檢查是否已經有資料
			if(model==null && model2==null){
				boolean result = pDao.addPatient(patientId,patientName,iDCardNumber,phoneNumber);
				if(result){
					return "新增病患完成";
				}
			}else{
				return "ERROR 已有該病患資料";
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return "ERROR 未知錯誤";
	}
	
	
	
	public String editPatient(int id , String patientId,String patientName,String iDCardNumber,String phoneNumber){
		
		if(patientId.equals("") && patientName.equals("") && iDCardNumber.equals("") && phoneNumber.equals("")){
			return "ERROR 病患資料不全";
		}
		
		PatientDaoImpl pDao = new PatientDaoImpl();
		Patient model = null;
		try {
			boolean result = pDao.editPatient(id,patientId,patientName,iDCardNumber,phoneNumber);
			if(result){
				return "修改病患完成";
			}else{
				return "ERROR 未知錯誤";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return "ERROR 未知錯誤";
	}

	
	
	
}
