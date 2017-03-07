package com.dao.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.model.PatientSub;
import com.model.Patient;
import com.uilts.Log;
import com.uilts.Util;

public class PatientDaoImpl {
	
	public boolean addPatient(String patientId,String patientName,String iDCardNumber,String phoneNumber) throws SQLException{

		StringBuffer sql = new StringBuffer();
		sql.append("insert into t_drp_patient(patient_id,name,id_card,phone) "); 
		sql.append("values (?,?,?,?)  ");
		PreparedStatement ps = null;
		Connection conn = Util.getConn();
		try{
	        ps = conn.prepareStatement(sql.toString());
	        ps.setString(1, patientId );
	        ps.setString(2, patientName );
	        ps.setString(3, iDCardNumber );
	        ps.setString(4, phoneNumber );

	        
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
	
	
	public Patient searchPatient(String patientId,String patientName,String iDCardNumber,String phoneNumber) throws SQLException{
		
		StringBuffer sql = new StringBuffer();
		sql.append("select * from t_drp_patient t where 1=1  ");
		if(!patientId.equals("")){
			sql.append("and patient_id='"+patientId+"' ");
		}
		if(!patientName.equals("")){
			sql.append("and name='"+patientName+"' ");
		}
		if(!iDCardNumber.equals("")){
			sql.append("and id_card='"+iDCardNumber+"' ");
		}
		if(!phoneNumber.equals("")){
			sql.append("and phone='"+phoneNumber+"' ");
		}
		
		
		Statement ps = null;
		Connection conn = Util.getConn();
		try{
			ps = conn.createStatement();
			ResultSet result = ps.executeQuery(sql.toString());
			Patient model = null;
			
			while(result.next()){
				model = new Patient();
				model.setId( result.getInt("id"));
				model.setiDCardNumber( result.getString("id_card") );
				model.setPatientName( result.getString("name") );
				model.setPatientId( result.getString("patient_id") );
				model.setPhoneNumber( result.getString("phone") );
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
	


	public boolean editPatient(int id, String patientId, String patientName, String iDCardNumber, String phoneNumber) throws SQLException {
		
		
		StringBuffer sql = new StringBuffer();
		sql.append("update t_drp_patient set patient_id = ? , name = ? , id_card = ? , phone = ? "); 
		sql.append("where id= ? ");
		PreparedStatement ps = null;
		Connection conn = Util.getConn();
		try{
	        ps = conn.prepareStatement(sql.toString());
	        ps.setString(1, patientId );
	        ps.setString(2, patientName );
	        ps.setString(3, iDCardNumber );
	        ps.setString(4, phoneNumber );
	        ps.setInt(5, id );
	        
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


	public boolean updatePatientIbeaconAndBed(String patientId, String ibeaconId, String bedId,int runId) throws SQLException {
		
		
		StringBuffer sql = new StringBuffer();
		sql.append("update t_drp_patient_sub set  ibeacon_id = ? , bed_id = ? "); 
		sql.append("where patient_id = ? and run_id=? ");
		PreparedStatement ps = null;
		Connection conn = Util.getConn();
		try{
	        ps = conn.prepareStatement(sql.toString());
	        ps.setString(1, ibeaconId );
	        ps.setString(2, bedId );
	        ps.setString(3, patientId );
	        ps.setInt(4, runId );
	        
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
	
	
	
	public List<PatientSub> loadHistory(String patientId) throws SQLException{
			StringBuffer sql = new StringBuffer();
			sql.append("select * from t_drp_patient_sub t where 1=1  ");
			if(!patientId.equals("")){
				sql.append("and patient_id='"+patientId+"' ");
			}
			sql.append(" order by run_id asc");
			
			Statement ps = null;
			Connection conn = Util.getConn();
			try{
				ps = conn.createStatement();
				ResultSet result = ps.executeQuery(sql.toString());
				
				List<PatientSub> modelList = new ArrayList<PatientSub>();  
				PatientSub model = null;
				while(result.next()){
					model = new PatientSub();
					
					model.setRunId( result.getInt("run_id") );
					model.setPatientId( result.getString("patient_id") );
					model.setIbeaconId( result.getString("ibeacon_id"));
					model.setBedId( result.getString("bed_id") ); 
					model.setSpeed( result.getBigDecimal("speed") );
					model.setDrugId( result.getString("drug_id"));
					model.setDrugCc( result.getString("drug_cc"));
					model.setDrugQuantity(result.getInt("drug_quantity"));
					model.setInsertTime(result.getDate("insert_time"));
					model.setStatus(result.getString("status"));
					modelList.add(model);
					
				}
				return modelList;
			}catch(Exception e ){
				e.printStackTrace();
			}finally {
				ps.close();
				conn.close();
			}
			
			
			
			
			
			
			
			return null;
		}
	
	
	
	public boolean insertPatientSub(String patientId, String ibeaconId, String bedId, BigDecimal speed, ArrayList<String> drug,
			ArrayList<BigDecimal> drugCc) throws SQLException {
		
		
		int runId=0;
		try {
			runId = getRunId(patientId)+1;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		StringBuffer sql = new StringBuffer();
		sql.append("insert into t_drp_patient_sub(run_id,patient_id,ibeacon_id,bed_id,speed,"
				+ "drug_id1,drug_cc1,drug_id2,drug_cc2,insert_time,status) "); 
		sql.append("values (?,?,?,?,?,?,?,?,?,?,?)  ");
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
//	        ps.setDate(10, new Date(new java.util.Date().getTime()));
	        ps.setTimestamp(10, new java.sql.Timestamp(Calendar.getInstance().getTime().getTime())); 
	        ps.setString(11, "READY");
	        
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

	
public boolean updatePatientSubStatus(String ibeaconId, String oldStatus,String newStatus) throws SQLException {
		
		
		StringBuffer sql = new StringBuffer();
		sql.append("update t_drp_patient_sub set  status = ?  "); 
		sql.append("where ibeacon_id = ? and status=? ");
		PreparedStatement ps = null;
		Connection conn = Util.getConn();
		try{
	        ps = conn.prepareStatement(sql.toString());
	        ps.setString(1, newStatus );
	        ps.setString(2, ibeaconId );
	        ps.setString(3, oldStatus );
	        
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
		sql.append("select * from t_drp_patient_sub t where patient_id='"+patiendId+"' order by run_id desc ");
		
		
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
