package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.Ibeacon;
import com.uilts.Util;

public class IbeaconDaoImpl {

	public Ibeacon loadHistory(String patientId,int runId) throws SQLException{
		
		StringBuffer sql = new StringBuffer();
		sql.append("select * from t_drp t where 1=1  ");
		if(!patientId.equals("")){
			sql.append("and patient_id='"+patientId+"' ");
		}
		if(runId!=0){
			sql.append("and run_id='"+runId+"' ");
		}
		sql.append(" order by run_id asc");
		
		Statement ps = null;
		Connection conn = Util.getConn();
		try{
			ps = conn.createStatement();
			ResultSet result = ps.executeQuery(sql.toString());
			Ibeacon model = null;
			
			while(result.next()){
				model = new Ibeacon();
				
				model.setRunId( result.getInt("run_id") );
				model.setPatientId( result.getString("patient_id") );
//				model.setIbeaconId();
				model.setDrugId1( result.getString("drug_id1") );
				model.setDrugCc1( result.getBigDecimal("drug_cc1") );
				model.setDrugId2( result.getString("drug_id2") );
				model.setDrugCc2( result.getBigDecimal("drug_cc2") );
				model.setSpeed( result.getBigDecimal("speed") );
				
			}
			return model;
		}catch(Exception e ){
			e.printStackTrace();
		}finally {
			ps.close();
			conn.close();
		}
		
		
		
		
		
		
		
		return null;
	}

	public int checkIbeaconStatus(String ibeaconId) throws SQLException {
		
		
		StringBuffer sql = new StringBuffer();
		sql.append("select status from t_drp_ibeacon_status   ");
		sql.append(" where ibeacon_id = '"+ibeaconId+"'  ");
		Statement ps = null;
		Connection conn = Util.getConn();
		try{
			ps = conn.createStatement();
			ResultSet result = ps.executeQuery(sql.toString());
			int ibeaconStatus = 9;
			while(result.next()){
				ibeaconStatus = result.getInt("status");
			}
			return ibeaconStatus;
		}catch(Exception e ){
			e.printStackTrace();
		}finally {
			ps.close();
			conn.close();
		}
		
		
		
		
		
		
		
		return 9;
		
		
	}

	public boolean updateIbeaconStatus(String ibeaconId) throws SQLException {
		
		StringBuffer sql = new StringBuffer();
		sql.append("update t_drp_ibeacon_status  set status=1 where    ibeacon_id ='"+ibeaconId+"'   and  status=0  ");
		
		Statement ps = null;
		Connection conn = Util.getConn();
		try{
			
			//TODO 異常 暫時不理會
			System.out.println(sql.toString());
			System.out.println("ibeacon_id="+ibeaconId);
			ps = conn.createStatement(); 
			ps.executeUpdate(sql.toString());
			ps.executeBatch();
			return true;
		}catch(Exception e ){
			e.printStackTrace();
		}finally {
			ps.close();
			conn.close();
		}
		
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
