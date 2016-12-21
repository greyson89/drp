package com.service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.impl.DRPDaoImpl;
import com.dao.impl.PatientDaoImpl;
import com.model.Patient;

public class DRPService {

	
	public String insertDRP(String patientId,String ibeaconId,String bedId,BigDecimal speed,ArrayList drug,ArrayList drugCc) {
			
			if(patientId.equals("") && ibeaconId.equals("")){
				return "ERROR 病患與ibeacon輸入資料不全";
			}
			
			
			DRPDaoImpl drpDao = new DRPDaoImpl();
			Patient model = null;
			try {
				boolean result = drpDao.insert(patientId,ibeaconId,bedId,speed,drug,drugCc);
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
