package com.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.MonitorModel;
import com.uilts.Log;
import com.uilts.Util;

public class MonitorDaoImpl {

	
	
	public List<MonitorModel> listAll() throws SQLException{
		
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select p_sub.ibeacon_id, 	p.patient_id,	p.name,  p_sub.bed_id, ");
		sql.append(" p_sub.drug_cc1+p_sub.drug_cc2 total,    p_sub.speed estSpeed,p_sub.start_time, ");
		sql.append(" max(log.drip) drip,  log.speed realSpeed,  log.insert_time last_insert_time, log.time_clock ");
		sql.append(" from t_drp_patient p,t_drp_patient_sub p_sub,t_drp_ibeacon_log log ");
		sql.append(" where p.patient_id=p_sub.patient_id and p_sub.ibeacon_id = log.ibeacon_id and p_sub.status='WORKING' and history_flag=0 ");
		sql.append(" group by  p_sub.ibeacon_id ");

		Statement ps = null;
		Connection conn = Util.getConn();
		List<MonitorModel> list = new ArrayList<MonitorModel>();
		try{
			ps = conn.createStatement();
			ResultSet result = ps.executeQuery(sql.toString());
			while(result.next()){
				MonitorModel model =new MonitorModel(); 
				model.setIbeaconId( result.getString("ibeacon_id") );
				model.setPatientId( result.getString("patient_id") );
				model.setPatientName( result.getString("name") );
				model.setBedId( result.getString("bed_id") );
				model.setTotal( result.getBigDecimal("total").setScale(2, BigDecimal.ROUND_HALF_UP).toString() );
				model.setEstSpeed( result.getBigDecimal("estSpeed").setScale(2, BigDecimal.ROUND_HALF_UP).toString() );
				model.setRealSpeed( result.getBigDecimal("realSpeed").setScale(2, BigDecimal.ROUND_HALF_UP).toString() );
				
				model.setDrip( result.getBigDecimal("drip").setScale(2, BigDecimal.ROUND_HALF_UP) );
				model.setLastInsertTime( result.getDate("last_insert_time") );
				model.setTimeClock( result.getString("time_clock") );
				model.setStartTime( result.getDate("start_time") );
				list.add(model);
				
			}
			return list;
		}catch(Exception e ){
			e.printStackTrace();
		}finally {
			ps.close();
			conn.close();
		}
		
		
		
		
		
		return null;
	}
	
	
	
}
