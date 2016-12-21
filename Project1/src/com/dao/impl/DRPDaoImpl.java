package com.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.uilts.Util;

public class DRPDaoImpl {

	public boolean insert(String patientId, String ibeaconId, String bedId, BigDecimal speed, ArrayList<String> drug,
			ArrayList<BigDecimal> drugCc) throws SQLException {
		
		
		int runId=0;
		try {
			runId = getRunId(patientId)+1;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		StringBuffer sql = new StringBuffer();
		sql.append("insert into t_drp(run_id,patient_id,ibeacon_id,bed_id,speed,drug_id1,drug_cc1,drug_id2,drug_cc2) "); 
		sql.append("values (?,?,?,?,?,?,?,?,?)  ");
		PreparedStatement ps = null;
		Connection conn = Util.getConn();
		try{
	        ps = conn.prepareStatement(sql.toString());
	        ps.setInt(1, runId);
	        ps.setString(2, patientId );
	        ps.setString(3, ibeaconId );
	        ps.setString(4, bedId );
	        ps.setBigDecimal(5, speed );
	        ps.setString(6, drug.get(0));
	        ps.setBigDecimal(7,drugCc.get(0));
	        ps.setString(8,drug.get(1));
	        ps.setBigDecimal(9,drugCc.get(1));

	        
	        ps.addBatch();
	        
	        ps.executeBatch();
	        return true;
	        
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			ps.close();
			conn.close();
		}
		
		
		return false;
	}

	public int getRunId(String patiendId) throws SQLException{
		
		
		
		StringBuffer sql = new StringBuffer();
		sql.append("select * from t_drp t where patient_id='"+patiendId+"' order by run_id desc ");
		
		
		Statement ps = null;
		Connection conn = Util.getConn();
		try{
			ps = conn.createStatement();
			ResultSet result = ps.executeQuery(sql.toString());
			int runId =0;
			while(result.next()){
				runId = result.getInt("run_id");
				return runId;
			}
			return 0;
		}catch(Exception e ){
			e.printStackTrace();
		}finally {
			ps.close();
			conn.close();
		}
		
		
		
		
		return 0;
	}
	
	
}
