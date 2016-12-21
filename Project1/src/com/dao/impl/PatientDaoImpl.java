package com.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.BaseData;
import com.model.Patient;
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
	
	
	public void insertPatient(BaseData model) throws SQLException{
		
		StringBuffer sql = new StringBuffer();
		sql.append("insert into drp_basedata(device_id,patient_id,bed_id,patient_name,drug_1,drug_1_cc,estimate_time,status,memo,insert_time) "); 
		sql.append("values (?,?,?,?,?,?,?,?,?,?)  ");
		PreparedStatement ps = null;
		Connection conn = Util.getConn();
		try{
	        ps = conn.prepareStatement(sql.toString());
	        ps.setString(1, model.getDeviceId());
	        ps.setString(2, model.getPatientId());
	        ps.setString(3, model.getBedId());
	        ps.setString(4, model.getPatientName());
	        ps.setString(5, model.getDrug1());
	        ps.setString(6, model.getDrug1cc());
	        
	        ps.setDate(6, (Date) model.getEstimateTime() );
	        ps.setString(6, model.getStatus());
	        ps.setString(6, model.getMemo());
	        ps.setDate(6, (Date) model.getInsertTime() );
	        
	        ps.addBatch();
	        
	        ps.executeBatch();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			ps.close();
			conn.close();
		}
        
		
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
		sql.append("update t_drp set  ibeacon_id = ? , bed_id = ? "); 
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
}
